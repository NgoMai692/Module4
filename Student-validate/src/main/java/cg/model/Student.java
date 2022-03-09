package cg.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull()
    @Pattern(regexp = "^[A-Za-z]")
    private String name;

    @Range(min = 6,max = 50)
    private int age;
    @Pattern(regexp = "(^$|[0-9]{10,11})")
    private String phone;

    private String address;

    @Range(min= 0,max = 10)
    private double avgPoint;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassRoom classRoom;

    public Student() {
    }

    public Student(String name, int age, String phone, String address, double avgPoint, ClassRoom classRoom) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.avgPoint = avgPoint;
        this.classRoom = classRoom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAvgPoint() {
        return avgPoint;
    }

    public void setAvgPoint(double avgPoint) {
        this.avgPoint = avgPoint;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }
}
