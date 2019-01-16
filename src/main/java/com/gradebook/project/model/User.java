package com.gradebook.project.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="users")
public class User {

@Id
@Column(name="username")
private String username;

@Column(name="password")
private String password;


@ManyToMany(fetch = FetchType.LAZY)
@JoinTable(name = "users_authorities",
        joinColumns = @JoinColumn(name = "username"),
        inverseJoinColumns = @JoinColumn(name = "authority_id"))
@JsonManagedReference(value = "user_authority")
private Set<Authority> authorities = new HashSet<>();

@OneToOne(mappedBy = "user", cascade = CascadeType.ALL,
        fetch = FetchType.LAZY, optional = false)
@JsonManagedReference(value = "student_user")
private Student student;

@OneToOne(mappedBy = "user", cascade = CascadeType.ALL,
        fetch = FetchType.LAZY, optional = false)
@JsonManagedReference(value = "teacher_user")
private Teacher teacher;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
