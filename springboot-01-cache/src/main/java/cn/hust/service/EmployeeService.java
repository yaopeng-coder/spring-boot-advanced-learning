package cn.hust.service;

import cn.hust.bean.Employee;
import cn.hust.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@CacheConfig(cacheManager = "empCacheManager")
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Cacheable(value = {"emp"})
    public Employee getEmpById(Integer id){
        System.out.println("查询"+id+"号员工");
       return employeeMapper.getEmpById(id);
    }

    @CachePut(value = "emp" ,key = "#result.id")
    public Employee updateEmp(Employee employee){
        System.out.println("update"+employee);
        employeeMapper.updateEmp(employee);
        return  employee;
    }

    @Caching(cacheable = {
            @Cacheable(value="emp",key = "#lastName")},
    put = {@CachePut(value = "emp",key = "#result.id")

    })
    public Employee getEmpByLastName(String lastName) {
        return  employeeMapper.getEmpByLastName(lastName);
    }
}
