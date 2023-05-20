package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Person;

import java.util.List;

public interface PersonService extends IService<Person> {
    int insert(Person person);

}
