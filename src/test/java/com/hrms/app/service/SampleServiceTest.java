package com.hrms.app.service;

import com.hrms.app.dao.UserDao;
import com.hrms.app.dao.model.User;
import com.hrms.app.exception.InvalidUserException;
import com.hrms.app.model.SignupForm;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SampleServiceTest {

    private UserDao userDao;
    private SampleService sampleService;

    @Before
    public void doSetup() {
        userDao = mock(UserDao.class);
        sampleService = new SampleServiceImpl(userDao);
    }

    @Test
    public void testSaveForm() {

        SignupForm signupForm = new SignupForm();
        signupForm.setLastName("formLast");
        signupForm.setFirstName("formFirst");
        signupForm.setEmail("form@test.com");

        when(userDao.save(any(User.class)))
                .thenAnswer(new Answer<User>() {
                    @Override
                    public User answer(InvocationOnMock invocation) throws Throwable {
                        User user = (User) invocation.getArguments()[0];
                        user.setId(1L);
                        return user;
                    }
                });

        assertNull(signupForm.getId());

        signupForm = sampleService.saveFrom(signupForm);

        assertNotNull(signupForm.getId());
        assertTrue(signupForm.getId() > 0);
    }

    @Test(expected = InvalidUserException.class)
    public void testInvalidUserException() {
        SignupForm signupForm = new SignupForm();
        signupForm.setLastName("formLast");
        signupForm.setFirstName("Dave");
        signupForm.setEmail("form@test.com");

        sampleService.saveFrom(signupForm);
    }


}
