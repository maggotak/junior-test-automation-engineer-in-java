package org.epam.learn.java.classes;


import java.time.LocalDate;

public class Student {
    {
        idGenerator++;
    }
    private static int idGenerator = 0;
    private int id = 0;
    private String surname;
    private String name;
    private String fatherName;
    private LocalDate birthDate;
    private String address;
    private long phoneNumber;
    private Faculty faculty;
    private Course course;
    private Group group;

    public Student(String surname, String name, String fatherName,
                   LocalDate birthDate, String address, long phoneNumber,
                   Faculty faculty, Course course, Group group) {
        this.id = idGenerator;
        this.surname = surname;
        this.name = name;
        this.fatherName = fatherName;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    public Student(String name, String fatherName, LocalDate birthDate) {
        this.name = name;
        this.fatherName = fatherName;
        this.birthDate = birthDate;
    }

    public Student(String name, String fatherName, long phoneNumber, Faculty faculty, Course course, Group group) {
        this.name = name;
        this.fatherName = fatherName;
        this.phoneNumber = phoneNumber;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "\nStudent " + surname + " " + name + " " + fatherName + ", "
                + birthDate +  ", id = " + id + ", " + "address: " + address + ", phone number: " + phoneNumber + ", "
                + faculty.getFaculty() + ", " + course.getCourse() + ", " + group.getGroup();
    }
}
