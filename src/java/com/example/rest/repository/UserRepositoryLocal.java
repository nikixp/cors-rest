package com.example.rest.repository;

import com.example.entity.User;
import javax.ejb.Local;

/**
 *
 * @author Niki
 */
@Local
public interface UserRepositoryLocal {
    User getUser(String email, String userName, String firstName, String lastName);
}
