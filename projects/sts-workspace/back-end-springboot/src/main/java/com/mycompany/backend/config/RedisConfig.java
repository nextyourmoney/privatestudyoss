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
	//value는 properties의 값을 가져오도록 한다. 
	@Value("${spring.redis.hostName}")
	private String hostName;
	
	@Value("${spring.redis.port}")
	private String port;
	
	@Value("${spring.redis.password}")
	private String password;
	
	@Bean //redis 설정
	public RedisConnectionFactory rediConnectionFactory() {
		log.info("실행");
		RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(); //redis 설정 객체 생성 및 선언
		config.setHostName(hostName); //서버 설정 //hostname 즉 localhost와 같은 이름을 선언한다. 
		config.setPort(Integer.parseInt(port)); //포트 설정 //portqjsgh 생성
		config.setPassword(password); //비밀번호 선언 
								 	  //redis라는 비밀번호로 redis에서 선언했기에 redis이다. redis에서 비미번호변경시 변경 가능 
									  //비밀 번호는 redis의 설치 경로 redis.conf에서 수정하거나 redis-cli에서 CONFIG SET requirepass "비밀번호을 선언하여 사용가능하다. 
		LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory(config); //Lettuce는 Netty 기반의 Redis Client로 비동기로 요청을 처리하여 성능에 장점이 있다. 
		return connectionFactory;
		
	}
	
	@Bean //redis 전송 및 저장을 위한 형태 및 data정의 //redisTemplate와 stringRedisTemplate가 존재하는데두개의차이는 직렬화이다. 
		  // redisTemplate의 key, value serializer는 JdkSerializationRedisSerializer이고 stringRedisTemplate의 serializer StringRedisSerializer입니다.
	public RedisTemplate<String, String> redisTemplate(){ //Redis 서버에 데이터 CRUD를 위한 Key Type Operations 와 Key Bound Operations 인터페이스를 제공
		log.info("실행");
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<>(); //레디스 구성 데이터 객체 선언
		redisTemplate.setConnectionFactory(rediConnectionFactory()); //RedisConnection 은 Redis 서버와의 통신 추상화를 제공하며, exception 발생시 Spring DataAccessException으로 전환
		
		/*
		RedisTemplate 를 이용해서 실제 레디스를 스프링에서 사용하는데 중요한 것은 setKeySerializer(), setValueSerializer() 메소드들이다. 
		이 메소드를 빠트리면 실제 스프링에서 조회할 때는 값이 정상으로 보이지만 redis-cli로 보면 key값에 \xac\xed\x00\x05t\x00\x0 이런 값들이 붙는다
		*/
		/*
		프레임워크 관점에서 Redis에 저장된 데이터는 바이트에 불과합니다.
		Redis 자체는 다양한 유형을 지원하지만 대부분의 경우 데이터가 무엇을 나타내는지가 아니라 데이터가 저장되는 방식을 나타냅니다.
		정보가 문자열로 변환될지 또는 다른 개체로 변환될지는 사용자에게 달려 있습니다 //Serializer는 형태를 변환해주는 어댑터 역활이다. 
		*/
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new StringRedisSerializer());
		return redisTemplate;
		
	}

}
