package com.example.rest.repository;

import com.example.entity.User;
import javax.ejb.Stateless;

/**
 *
 * @author Niki
 */
@Stateless
public class UserRepository implements UserRepositoryLocal {

    @Override
    public User getUser(String email, String userName, String firstName, String lastName) {
        return new User(email, userName, firstName, lastName);
    }

}
