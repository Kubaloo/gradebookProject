package com.gradebook.project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "marks")
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mark_id")
    private Integer markId;

    @Column(name = "mark_value")
    private String markValue;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonIgnoreProperties (value = "student_mark")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    @JsonIgnoreProperties (value = "teacher_mark")
    private Teacher teacher;
}
