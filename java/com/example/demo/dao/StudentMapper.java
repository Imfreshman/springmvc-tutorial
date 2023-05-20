package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.StuRoleVo;
import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    //方法1，直接在接口中写select
    @Select(" SELECT sid,sname,roleid,rolename,roledist\n" +
            "        from student\n" +
            "        LEFT JOIN role \n" +
            "        on sid=roleid\n")
    List<StuRoleVo> listStuRoleVo();

    //方法2，当查询时，直接用接口得不到满足，写一个xml配置映射文件，其中的命名空间对应接口的路径。查询语句也在其中写出
    @Select("xmlListStuRoleVo")
    List<StuRoleVo> xmlListStuRoleVo();

//    @Insert()
//    Boolean insertStu(){}
}
