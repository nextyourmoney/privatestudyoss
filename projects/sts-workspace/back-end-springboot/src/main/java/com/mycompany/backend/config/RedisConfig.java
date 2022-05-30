package com.mycompany.backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Configuration
public class RedisConfig {
	@Value("${spring.redis.hostName}")
	private String hostName;
	
	@Value("${spring.redis.port}")
	private String port;
	
	@Value("${spring.redis.password}")
	private String password;
	
	@Bean //redis 설정
	public RedisConnectionFactory rediConnectionFactory() {
		log.info("실행");
		RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
		config.setHostName(hostName); //서버 설정
		config.setPort(Integer.parseInt(port)); //포트 설정
		config.setPassword(password); //비밀번호 선언 //redis라는 비밀번호로 redis에서 선언했기에 redis이다. redis에서 비미번호변경시 변경 가능
		LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory(config);
		return connectionFactory;
		
	}
	
	@Bean //redis 전송 및 저장을 위한 형태 및 data정의
	public RedisTemplate<String, String> redisTemplate(){
		log.info("실행");
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(rediConnectionFactory());
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new StringRedisSerializer());
		return redisTemplate;
		
	}

}
