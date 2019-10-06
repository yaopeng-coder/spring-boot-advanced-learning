package cn.hust;

import cn.hust.bean.Employee;
import cn.hust.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot01CacheApplicationTests {

	@Autowired
	EmployeeMapper employeeMapper;

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Autowired
	RedisTemplate<Object, Employee> empRedisTemplate;

	@Autowired
	RedisTemplate redisTemplate;

	@Test
	public void test(){
		stringRedisTemplate.opsForValue().append("msg","hello");
		String msg = stringRedisTemplate.opsForValue().get("msg");

	}

	@Test
	public  void test01(){
		Employee emp = employeeMapper.getEmpById(1);
		empRedisTemplate.opsForValue().set("emp-02",emp);
	}
	@Test
	public void contextLoads() {
		Employee emp = employeeMapper.getEmpById(1);
		System.out.println(emp);
	}

}
