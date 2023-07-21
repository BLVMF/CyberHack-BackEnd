package com.cyberhack.jwt.controller;
import com.cyberhack.jwt.exceptions.NotFoundException;
import com.cyberhack.jwt.exceptions.UserAlreadyRegisteredException;
import com.cyberhack.jwt.entity.Users;
import com.cyberhack.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;
import com.cyberhack.jwt.dao.UserDao;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    UserDao userDao;

    @PostConstruct
    public void initUser() {
        userService.initUser();
    }

    @GetMapping("/{userName}")
    public Users getUserByUserName(@PathVariable String userName) {
        return userDao.findByUserName(userName);
    }

    @PutMapping({"/{userName}"})
    public Users updateByUserName(@PathVariable String userName, @RequestBody Users updatedUser) {
        Users existingUser = userDao.findByUserName(userName);
        if (existingUser == null) {
            // User not found, handle the error accordingly
            throw new NotFoundException("User not found");
        }

        existingUser.setUserFirstName(updatedUser.getUserFirstName());
        existingUser.setUserLastName(updatedUser.getUserLastName());
        existingUser.setUserEmail(updatedUser.getUserEmail());
        existingUser.setUserPhone(updatedUser.getUserPhone());
        existingUser.setVolInterests(updatedUser.getVolInterests());
        existingUser.setLinkedIn(updatedUser.getLinkedIn());
        existingUser.setAvNow(updatedUser.getAvNow());

        userDao.save(existingUser);
        return existingUser;
    }

    @PostMapping("/registerNewUser")
    public Users registerNewUser(@RequestBody Users user) {
        // Check if the user is already registered
        Users existingUser = userService.findByUserName(user.getUserName());
        if (existingUser != null) {
            throw new UserAlreadyRegisteredException("User already registered");
        }

        // Proceed with user registration logic
        return userService.registerNewUser(user);
    }

    @Transactional
    @DeleteMapping("/{userName}")
    public ResponseEntity<DeleteResponse> deleteUser(@PathVariable String userName){
        userDao.deleteByUserName(userName);
        DeleteResponse deleteResponse = new DeleteResponse("User deleted Successfully.");
        return ResponseEntity.ok(deleteResponse);
    }

    private static class DeleteResponse {
        private String message;

        public DeleteResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    @GetMapping
    public ResponseEntity<List<Users>> getNGOsOrVols(@RequestParam("userRole") String userRole) {
        List<Users> users = new ArrayList<>();
        if (userRole.equals("ngo")) {
            List<Users> ngos = userDao.findByUserRole("ngo");
            return ResponseEntity.ok(ngos);
        } else if (userRole.equals("volunteer")) {
            List<Users> volunteers = userDao.findByUserRole("volunteer");
            return ResponseEntity.ok(volunteers);
        } else if (userRole.equals("admin")) {
            List<Users> admins = userDao.findByUserRole("admin");
            return ResponseEntity.ok(admins);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    @PutMapping("/{userName}/password") // Endpoint for password updates
    public ResponseEntity<UpdatePasswordResponse> updatePassword(@PathVariable String userName, @RequestBody Map<String, String> updateData) {
        String currentPassword = updateData.get("currentPassword");
        String newPassword = updateData.get("newPassword");

        Users existingUser = userDao.findByUserName(userName);
        if (existingUser == null){
            throw new NotFoundException("User not found");
        }

        if (currentPassword == null){
            String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());
            existingUser.setUserPassword(hashedPassword);
            userDao.save(existingUser);
            UpdatePasswordResponse response = new UpdatePasswordResponse("Password Reset Successfully");
            return ResponseEntity.ok(response);
        } else {
            if (!BCrypt.checkpw(currentPassword, existingUser.getUserPassword())){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new UpdatePasswordResponse("Current password is incorrect"));
            }

            String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());
            existingUser.setUserPassword(hashedPassword);
            userDao.save(existingUser);
            UpdatePasswordResponse response = new UpdatePasswordResponse("Password updated successfully");
            return ResponseEntity.ok(response);
        }
    }

    @PutMapping("/{userName}/reset-password")
    public ResponseEntity<UpdatePasswordResponse> resetPassword(@PathVariable String userName, @RequestBody Map<String, String> updateData) {
        String newPassword = updateData.get("newPassword");
        Users existingUser = userDao.findByUserName(userName);
        if (existingUser == null){
            throw new NotFoundException("User not found");
        }

        String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());
        existingUser.setUserPassword(hashedPassword);
        userDao.save(existingUser);
        UpdatePasswordResponse response = new UpdatePasswordResponse("Password Reset Successfully");
        return ResponseEntity.ok(response);
    }


    private static class UpdatePasswordResponse {
        private String message;

        public UpdatePasswordResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }






    }








