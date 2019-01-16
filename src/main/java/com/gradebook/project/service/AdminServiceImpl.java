package com.gradebook.project.service;

import com.gradebook.project.dao.AdminDAO;
import com.gradebook.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminDAO adminDAO;

    @Override
    @Transactional
    public List<User> getUsers() {
        return adminDAO.getUsersList();
    }
}
