package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.StudentMapper;
import com.example.demo.entity.StuRoleVo;
import com.example.demo.entity.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
    @Resource
    private StudentMapper studentService;
    public List<StuRoleVo> listStuRoleVo(){
        return studentService.listStuRoleVo();
    }

    public List<StuRoleVo> xmlListStuRoleVo(){
        return studentService.xmlListStuRoleVo();
    }
}
