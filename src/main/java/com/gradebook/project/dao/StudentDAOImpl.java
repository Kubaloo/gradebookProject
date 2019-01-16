package com.gradebook.project.dao;


import com.gradebook.project.model.*;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    @Autowired
    private EntityManager entityManagerFactory;


    @Override
    public List<Student> getStudents() {

        Session currentSession = entityManagerFactory.unwrap(Session.class);

        Query<Student> query =
                currentSession.createQuery("FROM Student", Student.class);

        return query.getResultList();
    }

    @Override
    public void saveStudent(Student student) {

        Session currentSession = entityManagerFactory.unwrap(Session.class);

        currentSession.saveOrUpdate(student);
    }

    @Override
    public List<Teacher> getTeachers(String groupId) {
        Session currentSession = entityManagerFactory.unwrap(Session.class);

        Query<java.util.Collection> query =
                currentSession.createQuery("select g.teachers from LearningGroup g where g.groupId=:value", java.util.Collection.class);
        query.setParameter("value",groupId);
        List list = new ArrayList();
        for (int i = 0; i<query.getResultList().size();i++){
            list.add(query.getResultList().get(i));
        }
        return list;
    }
//select s.group from Student s where s.user.username=:value
    @Override
    public LearningGroup getUserGroupByUsername(String username) {
        Session currentSession = entityManagerFactory.unwrap(Session.class);

        Query<Student> query =
                currentSession.createQuery("from Student s where s.user.username=:value",Student.class);
        query.setParameter("value",username);

        return query.getSingleResult().getGroup();
    }

    @Override
    public List<Mark> getStudentMarks(String username) {
        Session currentSession = entityManagerFactory.unwrap(Session.class);

        Query<Mark> query =
                currentSession.createQuery("select m from Mark m join m.student s join s.user u where u.username=:var",Mark.class);
        query.setParameter("var",username);

        return query.getResultList();
    }

    @Override
    public List<LearningGroup> getStudentsGroup(String username) {

        Session currentSession = entityManagerFactory.unwrap(Session.class);

        Query<LearningGroup> query = currentSession.createQuery("select g from Student s join s.group g join s.user u where u.username=:var", LearningGroup.class);
        query.setParameter("var",username);

        return query.getResultList();
    }

    @Override
    public Student getStudentByUsername(String username) {
        Session currentSession = entityManagerFactory.unwrap(Session.class);

        Query<Student> query =
                currentSession.createQuery("select s FROM Student s join s.user u where u.username=:var", Student.class);
        query.setParameter("var",username);

        return query.getSingleResult();
    }

//select g.teachers from Group g join g.students s join User u " +
//                        "where u.username=:value

}
