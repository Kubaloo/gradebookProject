package com.gradebook.project.service;



import com.gradebook.project.model.LearningGroup;
import com.gradebook.project.model.Mark;
import com.gradebook.project.model.Student;
import com.gradebook.project.model.Teacher;

import java.util.List;

public interface StudentService {
    public List<Student> getStudents();

    void saveStudent(Student student);

    public List<Teacher> getTeachersByGroup(String groupId);

    public LearningGroup getUserGroupByUsername(String username);

    List<Mark> getMarks(String username);

    List<LearningGroup> getStudentsGroup(String username);

    Student getStudentByUsername(String username);
}
