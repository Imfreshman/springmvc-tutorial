package com.example.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/list")
    public String list(Model model) {
        Page<Person> page = new Page<>(1, 5); // 现在第几页，每页放多少
        Page<Person> list = this.personService.page(page);
        // 键值对，健指的是字符串，值指的是Java对象，object。
        model.addAttribute("person", list.getRecords());
        return "Person.html";// 返回网页的名字，包括路径
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        this.personService.removeById(id);
        Person person = this.personService.getById(id);
        model.addAttribute("person", person);
        System.out.println("删除成功！");
        return "redirect:/list";
    }

    @PostMapping("/update")
    public String update(Person person) {
        this.personService.updateById(person);
        return "redirect:/list";
    }

    @GetMapping("/fix/{id}")
    public String fix(@PathVariable Integer id, Model model) {
        Person person = this.personService.getById(id);
        model.addAttribute("person", person);
        return "PersonEdit.html";
    }

    // 新增 返回一个新增信息的界面，为一个表格
    @GetMapping("/addview")
    public String addview() {
        return "PersonAdd.html";
    }

    @PostMapping("/add")
    public String add(Person person) {
        this.personService.save(person);
        return "redirect:/list";
    }

    @GetMapping("find/{id}")
    public String find(@PathVariable Integer id, Model model) {
        Person person = this.personService.getById(id);
        model.addAttribute("person", person);
        return "Person.html";
    }
}
