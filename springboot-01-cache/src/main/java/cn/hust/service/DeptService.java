package cn.hust.service;

import cn.hust.bean.Department;
import cn.hust.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class DeptService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    RedisCacheManager deptCacheManager;


//    @Cacheable(value = "dept",cacheManager = "deptCacheManager")
    public Department getDeptById(Integer id){
        System.out.println("查询部门"+id);
        Department department= departmentMapper.getDepById(id);
        Cache cache = deptCacheManager.getCache("dept");
        cache.put("dept:1",department);
        return department;

    }
}
