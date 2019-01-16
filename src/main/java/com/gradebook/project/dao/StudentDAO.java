package com.gradebook.project.dao;

import com.gradebook.project.model.*;

import java.util.List;

public interface StudentDAO {

   public List<Student> getStudents();

   public void saveStudent(Student student);

   List<Teacher> getTeachers(String groupId);

   LearningGroup getUserGroupByUsername(String username);

    List<Mark> getStudentMarks(String username);

    List<LearningGroup> getStudentsGroup(String username);

    Student getStudentByUsername(String username);
}
