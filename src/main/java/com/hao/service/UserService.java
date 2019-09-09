
package com.hao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hao.entity.Users;
import com.hao.mapper.UserMapper;


@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public List<Users> getUser(Long id) {
		return userMapper.getUser(id);
	}

}
