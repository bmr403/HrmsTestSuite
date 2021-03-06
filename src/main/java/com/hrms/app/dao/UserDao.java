package com.hrms.app.dao;

import com.hrms.app.dao.model.User;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.NamedQuery;

/**
 * User: ryan
 * Date: 2/20/13
 */
public interface UserDao extends CrudRepository<User,Long> {

    User findByEmail(String emailAddress);

    User findByLastName(String lastName);

    User findByFirstName(String firstName);

}
