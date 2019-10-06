package cn.hust.controller;

import cn.hust.bean.Employee;
import cn.hust.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
        return  employeeService.getEmpById(id);
    }

    @GetMapping("/update")
    public Employee updateEmp(Employee employee){
        return employeeService.updateEmp(employee);
    }

    @GetMapping("/emp1/{lastName}")
    public Employee getEmpaa(@PathVariable("lastName") String lastName){
        return  employeeService.getEmpByLastName(lastName);
    }
}
