package com.gradebook.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "name")
    private String studentsName;

    @Column(name = "surname")
    private String studentsSurname;

    @Column(name = "email")
    private String studentsEmail;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    @JsonIgnoreProperties (value = {"hibernateLazyInitializer", "handler","student_group"})
    private LearningGroup group;

    @OneToOne
    @JoinColumn(name = "username")
    @JsonBackReference(value = "student_user")
    private User user;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "student", orphanRemoval = true,fetch = FetchType.LAZY)
    @JsonBackReference(value = "student_mark")
    private Set<Mark> marks = new HashSet<>();

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentsName() {
        return studentsName;
    }

    public void setStudentsName(String studentsName) {
        this.studentsName = studentsName;
    }

    public String getStudentsSurname() {
        return studentsSurname;
    }

    public void setStudentsSurname(String studentsSurname) {
        this.studentsSurname = studentsSurname;
    }

    public String getStudentsEmail() {
        return studentsEmail;
    }

    public void setStudentsEmail(String studentsEmail) {
        this.studentsEmail = studentsEmail;
    }

    public LearningGroup getGroup() {
        return group;
    }

    public void setGroup(LearningGroup group) {
        this.group = group;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Mark> getMarks() {
        return marks;
    }

    public void setMarks(Set<Mark> marks) {
        this.marks = marks;
    }
}
