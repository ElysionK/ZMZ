package com.tianwen.core.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.tianwen.core.user.entity.User;

@Repository
public interface UserDao {

	User findUserByPhone(@Param("phone") String phone);

	Integer addUser(@Param("user") User user);

	User findUserByPhoneAndPassword(@Param("phone") String phone, @Param("password") String password);

	User findUserById(@Param("userId") Integer userId);
	
	
}
