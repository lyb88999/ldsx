package com.highcom.po;

public class Teacher {
    private Integer class_id;
    private Integer teacher_id;
    private String teacher_name;
    private String teacher_no;

    private Classes classes;

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeacher_no() {
        return teacher_no;
    }

    public void setTeacher_no(String teacher_no) {
        this.teacher_no = teacher_no;
    }
}
