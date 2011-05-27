package org.bigbluebutton.api;

import org.bigbluebutton.api.domain.Meeting;
import redis.clients.jedis.Jedis;
import java.util.*;

public class RedisDispatcherImp implements IRedisDispatcher {

//	private String redisHost;
//	private int redisPort;
	private final static String COLON = ":";
	
	@Override
	public void createConferenceRecord(Meeting conf, String redisHost, int redisPort) {
		System.out.println("In createConferenceRecord " + redisHost + ":" + redisPort);
		Jedis jedis = new Jedis(redisHost, redisPort);
		
		Map<String, String> confMap = new HashMap<String,String>();
		System.out.println("Storing " + conf.getName());
		confMap.put("name", conf.getName());
		
		jedis.hmset("meeting.info" + COLON + conf.getMeetingToken(), confMap);
		jedis.hmset("meeting:metadata"+ COLON + conf.getMeetingToken(), conf.getMetadata());
	}

//	public void setRedisHost(String redisHost) {
//		this.redisHost = redisHost;
//	}

//	public void setRedisPort(int redisPort) {
//		this.redisPort = redisPort;
//	}

}
