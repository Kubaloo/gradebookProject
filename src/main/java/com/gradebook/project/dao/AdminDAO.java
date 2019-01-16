package com.gradebook.project.dao;

import com.gradebook.project.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDAO {
    List<User> getUsersList();
}
