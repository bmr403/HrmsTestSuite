package com.hrms.app.service;

import com.hrms.app.exception.InvalidUserException;
import com.hrms.app.model.SignupForm;

/**
 * User: ryan
 * Date: 2/8/13
 */
public interface SampleService {

    public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException;

}
