package com.youyue.jdbc03end.model;

/**
 * @author lei_she
 * @version 1.0
 * @create_time 2021-06-05 10:36
 */
public class Employee {
    private Integer empno;
    private String ename;
    private String job;
    private Double sal;

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public Employee() {
    }

    public Employee(Integer empno, String ename, String job, Double sal) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.sal = sal;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
