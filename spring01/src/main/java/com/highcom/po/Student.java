package com.highcom.po;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Student {
    private Integer id;
    private String name;
    private Character sex;
    private Date birthday;
    private List<String> hobbies;
    private Map<String,String> score;
    private String[] s;

    public Student(Integer id, String name, Character sex, Date birthday, List<String> hobbies, Map<String, String> score, String[] s) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.hobbies = hobbies;
        this.score = score;
        this.s = s;
    }

    public Student(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Map<String, String> getScore() {
        return score;
    }

    public void setScore(Map<String, String> score) {
        this.score = score;
    }

    public String[] getS() {
        return s;
    }

    public void setS(String[] s) {
        this.s = s;
    }

    public Student(Integer id, String name, Character sex, Date birthday) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                '}';
    }
}
