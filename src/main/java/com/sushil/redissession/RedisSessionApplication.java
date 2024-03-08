package com.sushil.redissession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisSessionApplication {
	/**
	 * How does this work?
	 *     1. We inform Spring that sessions will now be cached in Redis.
	 *     2. Spring receives a request.
	 *     3. Spring Security kicks in and user is authenticated.
	 *     4. Spring Session object is serialized and saved in the cache.
	 *     5. Client gets a cookie with the Session ID.
	 *     6. Client then sends the session id for further requests.
	 *     7. Any instance of the UI Service will check in the cache for a session object against the Session ID provided by the client.
	 *     8. Session object is de-serialized and reused.
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(RedisSessionApplication.class, args);
	}

}
