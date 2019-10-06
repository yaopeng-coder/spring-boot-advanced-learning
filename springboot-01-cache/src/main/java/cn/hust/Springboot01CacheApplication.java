package cn.hust;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Springboot01CacheApplication {

	public static void main(String[] args) {

		SpringApplication.run(Springboot01CacheApplication.class, args);
	}

}
