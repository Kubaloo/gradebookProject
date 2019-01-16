package com.gradebook.project.service;

import com.gradebook.project.model.LearningGroup;
import com.gradebook.project.model.Mark;
import com.gradebook.project.model.Student;
import com.gradebook.project.model.Teacher;

import java.util.List;

public interface TeacherService {
    List<Student> getStudents(String groupId);

    List<Mark> getStudentsMarksByUsername(String teachersUsername, Integer username);

    void saveMark(Mark mark);

    Student getStudentById(Integer studentId);

    Teacher getTeacherById(Integer teacherId);

    void saveTeacher(Teacher teacher);

    List<LearningGroup> getGroupsByUsername(String username);

    Teacher getTeacherByUsername(String teacherUsername);

    List<Mark> getMarks();
}
