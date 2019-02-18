package com.luokp.mongodb.dao;

import com.luokp.mongodb.models.UserEntity;

public interface UserDao {
    public void saveUser(UserEntity user);
    public UserEntity findUserByUserName(String userName);
    public void updateUser(UserEntity user);
    public void deleteUserById(Long id);
}
