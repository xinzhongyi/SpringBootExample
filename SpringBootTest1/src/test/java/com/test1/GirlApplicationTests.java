package com.test1;

import com.alibaba.fastjson.JSON;
import com.test1.entity.UsersEntity;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate ;

	@Autowired
	private RedisTemplate redisTemplate ;


	@Test
	public void contextLoads() {

	}

	@Test
	public void testRedis(){
//		stringRedisTemplate.opsForValue().set("aaa","1111");
//		Assert.assertEquals("1111",stringRedisTemplate.opsForValue().get("aaa"));

		stringRedisTemplate.opsForHash().put("hashtest","name1","123");
		stringRedisTemplate.opsForHash().put("hashtest","name2","456");
		Assert.assertNotNull(stringRedisTemplate.opsForHash().get("hashtest","name1")) ;
	}

	@Test
	public void testRedisSet(){
		stringRedisTemplate.opsForList().rightPush("listtest","1") ;
		stringRedisTemplate.opsForList().rightPush("listtest","2") ;

		Assert.assertNotNull(stringRedisTemplate.opsForList().range("listtest",0,-1)) ;
	}

	@Test
	public void testRedisJSONUser(){
		UsersEntity usersEntity = new UsersEntity() ;
		usersEntity.setUserName("test1");
		usersEntity.setPassword("test1");
		stringRedisTemplate.opsForValue().set("userjson", JSON.toJSONString(usersEntity));
	}

	@Test
	public void testRedisUser(){
		UsersEntity usersEntity = new UsersEntity() ;
		usersEntity.setUserName("test1");
		usersEntity.setPassword("test1");
		redisTemplate.opsForValue().set("userobj",usersEntity,10,TimeUnit.SECONDS);
	}

}
