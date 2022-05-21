package fun.augus.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * @author: Augus
 * @progect: JavawebDemo
 * @package: com.augus.domain
 * @FileName: Person
 * @date 2021年11月28日 19:49
 * @version: 1.0
 */


public class Person {

    private String name;
    private int age;
    private String gender;

    //@JsonIgnore // 忽略该属性
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
