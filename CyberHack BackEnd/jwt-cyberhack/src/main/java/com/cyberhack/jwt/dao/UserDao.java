package com.cyberhack.jwt.dao;

import com.cyberhack.jwt.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<Users, String> {
Users findByUserName(String userName);
void deleteByUserName(String userName);
List<Users> findByUserRole(String userRole);

}