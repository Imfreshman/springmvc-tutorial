package com.example.demo.entity;
/*
封装数据库多表查询的结果
 */
public class StuRoleVo {
    private Integer sid;
    private String sname;
    private Integer roleid;
    private String rolename;
    private String roledist;
    private Integer status;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoledist() {
        return roledist;
    }

    public void setRoledist(String roledist) {
        this.roledist = roledist;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StuRoleVo{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                ", roledist='" + roledist + '\'' +
                ", status=" + status +
                '}';
    }
}
