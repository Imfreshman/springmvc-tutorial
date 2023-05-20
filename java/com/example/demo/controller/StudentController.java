package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.dao.StudentMapper;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import com.example.demo.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// import javax.jws.WebParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.SecureRandom;
import java.util.List;

@Controller
@RequestMapping("/student") // 加上前缀student,访问时必须加上前缀 http://localhost:8080/student/list
public class StudentController {

    @Autowired
    // private StudentMapper studentMapper;
    private StudentService studentService;
    // @GetMapping("/student")
    // @ResponseBody
    // public List student() {
    // List<Student> list = studentMapper.selectList(null);
    // return list;
    // }

    @GetMapping("/sturole")
    @ResponseBody
    public List sturole() {
        return this.studentService.listStuRoleVo();
    }

    @GetMapping("/xmlsturole")
    @ResponseBody
    public List xmlsturole() {
        return this.studentService.xmlListStuRoleVo();
    }

    // @PostMapping("/stulogin")
    // private stulogin(@PathVariable Integer id,Student student){
    // Model model =
    // }

    @GetMapping("/register")
    public String register() {
        return "sturegister.html";
    }

    @PostMapping("/stuRegislogin")
    public String stuRegislogin(String sname, String password, String surepassword, Model model) {

        if (!password.equals(surepassword)) {
            model.addAttribute("error", "两次输入密码不一致");
            return "sturegister.html";
        }
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sname", sname);
        Student oldstudent = this.studentService.getOne(queryWrapper);
        if (oldstudent != null) {
            model.addAttribute("error", "该用户已被注册");
        }
        Student student = new Student();
        student.setSname(sname);
        student.setPassword(password);
        this.studentService.save(student); // 操作实体对象，等于操作数据库
        return "stulogin.html";
    }

    @GetMapping("/loginview")
    public String loginview(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getRequestURI());
        System.out.println(request.getServletPath());
        System.out.println(request.getRemoteUser());
        System.out.println(request.getRequestURL());
        System.out.println(request.getMethod());
        System.out.println(request.getRemoteAddr());
        response.addCookie(new Cookie("dashuju", "123456789"));

        return "stulogin.html";
    }

    @GetMapping("/stulogin")
    public String stulogin(String sname, String password, HttpServletRequest request) {
        System.out.println(sname);
        System.out.println(password);
        // 选择查询
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sname", sname).eq("password", password);
        Student student = this.studentService.getOne(queryWrapper);
        if (null == student) {
            System.out.println("密码错误，请重新输入！");
            return "stulogin.html";
        }

        HttpSession session = request.getSession();
        session.setAttribute("student", student);// 键值对 存session。。。绘画 读到一个session就存入到session，后面检查有没有session

        return "houtai.html";
    }

    @GetMapping("/houtai")
    public String houtai(HttpSession session) {
        Student student = (Student) session.getAttribute("student");
        if (student == null) { // 以前登过，并且存在于服务端
            // System.out.println(student.toString());
            return "houtai.html";
        }
        return "stulogin.html";
    }

    // 列出表格
    @GetMapping("/list")
    // @ResponseBody
    public String list(Model model) {
        Page<Student> page = new Page<>(1, 5); // 现在第几页，每页放多少
        Page<Student> list = this.studentService.page(page);
        // 键值对，健指的是字符串，值指的是Java对象，object。
        model.addAttribute("student", list.getRecords());
        return "Student.html";// 返回网页的名字，包括路径
    }

    // 添加一个student对象

    // 删除一行
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        this.studentService.removeById(id);
        Student student = this.studentService.getById(id);
        model.addAttribute("student", student);
        System.out.println("删除成功！");
        return "redirect:/student/list";
    }

    // 修改并更新一行
    @PostMapping("/update")
    public String update(Student student) {
        this.studentService.updateById(student); // 调用 Service 层的 updateById 方法进行更新
        System.out.println("修改成功！");
        return "redirect:/student/list"; // 重定向到列表页
    }

    // 查找
    @GetMapping("/find/{id}")
    // @PathVariable Integer id 表示将 URL 中的一个变量绑定到 id 参数上，并且将该参数的值传递给控制器方法 find
    public String find(@PathVariable Integer id, Model model) {
        Student student = this.studentService.getById(id);
        model.addAttribute("student", student);
        System.out.println("find:" + student);
        return "Student.html";
    }

    @GetMapping("/fix/{id}")
    // @PathVariable Integer id 表示将 URL 中的一个变量绑定到 id 参数上，并且将该参数的值传递给控制器方法 find
    public String fix(@PathVariable Integer id, Model model) {
        Student student = this.studentService.getById(id);
        model.addAttribute("student", student);
        return "StudentEdit.html";
    }

    // 访问添加数据的网页
    @GetMapping("/addview")
    public String addview() {
        return "StudentAdd.html";
    }

    @PostMapping("/add")
    // public String add(String sname,Boolean ssex,Integer sage,String
    // svillage,String remark){ //第一种方式，直接根据名字一个一个指
    public String add(Student student) {
        System.out.println("增加成功！");
        // Student student = new Student();
        // student.setSname(sname);
        // student.setSsex(ssex);
        // student.setSage(sage);
        // student.setSvillage(svillage);
        // student.setRemark(remark);
        this.studentService.save(student);

        // System.out.println(sname);
        // System.out.println(ssex);
        // System.out.println(sage);
        // System.out.println(svillage);
        // System.out.println(remark);
        return "redirect:/student/list"; // redirect重定向 到/list
    }

    @GetMapping("/confirm/{id}")
    public String confirm(@PathVariable Integer id, Model model) {
        Student student = this.studentService.getById(id);
        model.addAttribute("student", student);
        return "confirm.html";
    }
}
