package com.gradebook.project.service;

import com.gradebook.project.dao.StudentDAO;

import com.gradebook.project.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDAO studentDAO;

    @Override
    @Transactional
    public List<Student> getStudents() {
        return studentDAO.getStudents();
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
        studentDAO.saveStudent(student);
    }

    @Override
    @Transactional
    public List<Teacher> getTeachersByGroup(String groupId) {
        return studentDAO.getTeachers(groupId);
    }

    @Override
    @Transactional
    public LearningGroup getUserGroupByUsername(String username) {
        return studentDAO.getUserGroupByUsername(username);
    }

    @Override
    @Transactional
    public List<Mark> getMarks(String username) {
        return studentDAO.getStudentMarks(username);
    }

    @Override
    @Transactional
    public List<LearningGroup> getStudentsGroup(String username) {
        return studentDAO.getStudentsGroup(username);
    }

    @Override
    public Student getStudentByUsername(String username) {
        return studentDAO.getStudentByUsername(username);
    }

}
