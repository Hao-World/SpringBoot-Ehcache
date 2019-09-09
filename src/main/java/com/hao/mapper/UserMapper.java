
package com.hao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import com.hao.entity.Users;


@CacheConfig(cacheNames = "userCache")
public interface UserMapper {
	@Select("SELECT ID ,NAME,AGE FROM member where id=#{id}")
	@Cacheable
	List<Users> getUser(@Param("id") Long id);
	
//	@Cacheable  加了该注解的方法表示可以缓存
//    @CacheConfig 表示创建缓存配置，Key为userCache
}
