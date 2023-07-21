package com.cyberhack.jwt.service;

import com.cyberhack.jwt.dao.UserDao;
import com.cyberhack.jwt.entity.JwtRequest;
import com.cyberhack.jwt.entity.JwtResponse;
import com.cyberhack.jwt.entity.Users;
import com.cyberhack.jwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        String userName = jwtRequest.getUserName();
        String userPassword = jwtRequest.getUserPassword();
        authenticate(userName, userPassword);

        final UserDetails userDetails = loadUserByUsername(userName);

        String newGeneratedToken = jwtUtil.generateToken(userDetails);

        Users user = userDao.findById(userName)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found."));

        return new JwtResponse(user, newGeneratedToken);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userDao.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found."));

        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getUserRole()));

        return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getUserPassword(),
                authorities
        );
    }

    private void authenticate(String userName, String userPassword) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
        } catch (DisabledException e) {
            throw new Exception("User is disabled");
        } catch (BadCredentialsException e) {
            throw new Exception("Bad Credentials from User.");
        }
    }
}