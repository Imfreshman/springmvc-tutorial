package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.PersonMapper;
import com.example.demo.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper,Person> implements PersonService {
    PersonMapper personMapper;
    @Override
    public int insert(Person person) {
        return personMapper.insert(person);
    }
}
