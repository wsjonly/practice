package com.weng.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCommands;
import redis.clients.jedis.JedisPool;

public class Main {
	public static void main(String[] args) {
		
		String host = "10.16.1.235";
		JedisPool jedisPool = new JedisPool(host, 7379);
	
		Jedis jedis = jedisPool.getResource();
		for(Object i: jedis.keys("profile*")){
			System.out.println(i);
			jedis.del(i.toString());
		}
		jedisPool.returnResource(jedis);
		
//		System.out.println(JedisCommands.class.getMethods().length);
	}
}
