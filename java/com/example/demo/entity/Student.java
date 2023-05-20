package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;


//声明表名
@TableName("student")
public class Student implements Serializable {

    //id自增长Auto
    @TableId(value = "sid",type = IdType.INPUT)
    //    private Integer role_id;
    private Integer sid;
    private String sname;
    private String password;
    private boolean ssex;
    @TableField("sage")   //字段注解，非主键
    private Integer sage;
    private String svillage;
    private String remark;

//    public Integer getRole_id() {
//        return role_id;
//    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public boolean isSsex() {
        return ssex;
    }

    public void setSsex(boolean ssex) {
        this.ssex = ssex;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }

    public String getSvillage() {
        return svillage;
    }

    public void setSvillage(String svillage) {
        this.svillage = svillage;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Student{" +
                " sid=" + sid +
                ", sname='" + sname + '\'' +
                ", password=" + password +
                ", ssex=" + ssex +
                ", sage=" + sage +
                ", svillage='" + svillage + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
