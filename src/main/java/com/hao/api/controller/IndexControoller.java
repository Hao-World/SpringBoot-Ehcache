
package com.hao.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hao.cache.MapCaChe;
import com.hao.entity.Users;
import com.hao.service.UserService;


@RestController
public class IndexControoller {
	@Autowired
	private UserService userService;
	@Autowired
	private CacheManager cacheManager;

	@Autowired
	private MapCaChe<String, String> mapCaChe;

	@RequestMapping("/remoKey")
	public void remoKey() {
		cacheManager.getCache("userCache").clear();
	}

	@RequestMapping("/getUser")
	public List<Users> getUser(Long id) {
		return userService.getUser(id);
	}
	
	

	@RequestMapping("/put")
	public String put(String key, String value) {
		mapCaChe.put(key, value);
		return "success";
	}

	@RequestMapping("/get")
	public String get(String key) {
		String value = mapCaChe.get(key);
		return value;
	}
	
	
	@RequestMapping("/remove")
	public String remove(String key) {
		mapCaChe.remove(key);
		return "success";
	}
	
	

}
