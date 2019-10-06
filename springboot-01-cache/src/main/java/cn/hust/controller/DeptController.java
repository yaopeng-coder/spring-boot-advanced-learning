package cn.hust.controller;

import cn.hust.bean.Department;
import cn.hust.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DeptController {
    @Autowired
    DeptService deptService;

    @GetMapping("/dept/{id}")
    public Department getDepById(@PathVariable("id") Integer id){
        return  deptService.getDeptById(id);
    }
}
