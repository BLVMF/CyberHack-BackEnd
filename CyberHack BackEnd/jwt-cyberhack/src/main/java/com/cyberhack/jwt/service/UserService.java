package com.cyberhack.jwt.service;

import com.cyberhack.jwt.dao.UserDao;
import com.cyberhack.jwt.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Users findByUserName(String userName){
        return userDao.findByUserName(userName);
    }
    public Users registerNewUser(Users user) {
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        return userDao.save(user);
    }

    public void initUser() {
        Users adminUser = new Users();

        adminUser.setUserName("Admin");
        adminUser.setUserFirstName("administrator");
        adminUser.setUserEmail("adminCH@cyberhack.com");
        adminUser.setUserPassword(getEncodedPassword("Admining"));
        adminUser.setUserRole("Admin");
        userDao.save(adminUser);

        Users ngoUser = new Users();

        ngoUser.setUserName("EcoWarriors");
        ngoUser.setUserFirstName("Eco Warriors");
        ngoUser.setUserEmail("OL-Kim@EcoWarriors.org");
        ngoUser.setUserPhone("+1 (555) 123-4567");
        ngoUser.setUserPassword(getEncodedPassword("EcoWars123"));
        ngoUser.setNgoNeeds("Security Awareness and Training, Pen Testing, Incident Response and Recovery, Secure Communications Channels");
        ngoUser.setWorkRefs("Empowering Sustainable Change for a Greener Future.");
        ngoUser.setLinkedIn("www.EcoWarriors.org");
        ngoUser.setUserRole("ngo");
        userDao.save(ngoUser);

        Users volUser = new Users();

        volUser.setUserName("CaryG");
        volUser.setUserFirstName("Cary");
        volUser.setUserLastName("Grant");
        volUser.setUserPassword(getEncodedPassword("Hollywood123"));
        volUser.setUserEmail("caryGrant@oldHollywood.com");
        volUser.setUserPhone("1-818-555-2279");
        volUser.setCurrentPosition("CyberSecurity Analyst");
        volUser.setYearsOfExperience("11-15");
        volUser.setEduLvl("University Degree");
        volUser.setVolInterests("Risk Assessment and Management, Pen Testing, Compliance and Regulations");
        volUser.setWklyHrs("13 hours");
        volUser.setCrimCheck("Yes");
        volUser.setWorkRefs("Frank Capra, George Cukor, Garson Kanin");
        volUser.setLinkedIn("https://www.linkedin.com/in/cary-grant-1235a8796/");
        volUser.setUserRole("volunteer");
        volUser.setAvNow("Yes");
        userDao.save(volUser);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }





}
