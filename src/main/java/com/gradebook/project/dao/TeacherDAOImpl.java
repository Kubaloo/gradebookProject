package com.gradebook.project.dao;


import com.gradebook.project.model.LearningGroup;
import com.gradebook.project.model.Mark;
import com.gradebook.project.model.Student;
import com.gradebook.project.model.Teacher;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TeacherDAOImpl implements TeacherDAO{

    @Autowired
    private EntityManager entityManagerFactory;

    @Override
    public List<Student> getStudents(String groupId) {
        Session currentSession =
                entityManagerFactory.unwrap(Session.class);
        Query<Student> query =
                currentSession.createQuery("select s from Student s where s.group.groupId=:var ",Student.class);
        query.setParameter("var",groupId);
        return query.getResultList();
    }

    @Override
    public List<Mark> getStudentsMarksByUsername(String teachersUsername, Integer id) {
        Session currentSession = entityManagerFactory.unwrap(Session.class);
        Query<Mark> query =
                currentSession.createQuery(
                        "select m from Mark m join m.student s " +
                                "join s.user us " +
                                "join m.teacher t " +
                                "join t.user ut " +
                                "where s.studentId=:var1 and ut.username=:var2",Mark.class);
        query.setParameter("var1",id);
        query.setParameter("var2",teachersUsername);
        return query.getResultList();
    }

    @Override
    public void saveMark(Mark mark) {
        Session currentSession =
                entityManagerFactory.unwrap(Session.class);
        currentSession.save(mark);
    }

    @Override
    public Student getStudentById(Integer studentId) {
        Session currentSession =
                entityManagerFactory.unwrap(Session.class);
        Query<Student> query =
                currentSession.createQuery("select s from Student s where s.studentId = :val",Student.class);
        query.setParameter("val",studentId);
        return query.getSingleResult();
    }

    @Override
    public Teacher getTeacherById(Integer teacherId) {
        Session currentSession =
                entityManagerFactory.unwrap(Session.class);
        Query<Teacher> query =
                currentSession.createQuery("select t from Teacher t where t.teachersId = :val",Teacher.class);
        query.setParameter("val",teacherId);
        return query.getSingleResult();
    }

    @Override
    public void saveTeacher(Teacher teacher) {
        Session currentSession = entityManagerFactory.unwrap(Session.class);

        currentSession.saveOrUpdate(teacher);
    }

    @Override
    public List<LearningGroup> getGroupsByUsername(String username) {
        Session currentSession =
                entityManagerFactory.unwrap(Session.class);
        Query<LearningGroup> query =
                currentSession.createQuery("select g from Teacher t join t.learningGroups g join t.user u where u.username = :val",LearningGroup.class);
        query.setParameter("val",username);

        return query.getResultList();
    }

    @Override
    public Teacher getTeacherByUsername(String teacherUsername) {
        Session currentSession =
                entityManagerFactory.unwrap(Session.class);
        Query<Teacher> query =
                currentSession.createQuery("select t from Teacher t join t.user u where u.username = :val",Teacher.class);
        query.setParameter("val",teacherUsername);
        return query.getSingleResult();
    }

    @Override
    public List<Mark> getMarks() {
        Session currentSession =
                entityManagerFactory.unwrap(Session.class);
        Query<Mark> query =
                currentSession.createQuery("from Mark", Mark.class);
        return query.getResultList();
    }
}
