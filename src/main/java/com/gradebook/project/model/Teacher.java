package com.gradebook.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "teacher_id")
    private Integer teachersId;

    @Column(name = "name")
    private String teachersName;

    @Column(name = "surname")
    private String teachersSurname;

    @Column(name = "email")
    private String teachersEmail;

    @Column(name = "subject")
    private String subject;

    @ManyToMany(mappedBy = "teachers")
    @JsonBackReference(value = "teacher_group")
    private Set<LearningGroup> learningGroups = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    @JsonBackReference(value = "teacher_user")
    private User user;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "teacher", orphanRemoval = true)
    @JsonBackReference(value = "teacher_mark")
    private Set<Mark> marks = new HashSet<>();

    public Integer getTeachersId() {
        return teachersId;
    }

    public void setTeachersId(Integer teachersId) {
        this.teachersId = teachersId;
    }

    public String getTeachersName() {
        return teachersName;
    }

    public void setTeachersName(String teachersName) {
        this.teachersName = teachersName;
    }

    public String getTeachersSurname() {
        return teachersSurname;
    }

    public void setTeachersSurname(String teachersSurname) {
        this.teachersSurname = teachersSurname;
    }

    public String getTeachersEmail() {
        return teachersEmail;
    }

    public void setTeachersEmail(String teachersEmail) {
        this.teachersEmail = teachersEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Set<LearningGroup> getLearningGroups() {
        return learningGroups;
    }

    public void setLearningGroups(Set<LearningGroup> learningGroups) {
        this.learningGroups = learningGroups;
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
