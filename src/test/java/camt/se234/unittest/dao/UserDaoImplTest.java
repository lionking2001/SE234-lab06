package camt.se234.unittest.dao;
import camt.se234.unittest.entity.User;
import camt.se234.unittest.service.UserServiceImpl;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;


public class UserDaoImplTest {
    @Test
    public void testGetUsers(){
        UserDaoImpl userDao = new UserDaoImpl();
        assertThat(userDao.getUsers(),
                hasItems(new User("Prayuth","1234","Tu",
                                LocalDate.of(2016,12,28),"08612345678"),
                        new User("Tucky","5675","Tuckung",
                                LocalDate.of(2014,11,22),"08687654321")
                ));
    }


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testLoginException(){
        UserServiceImpl userService = new UserServiceImpl();
        UserDaoImpl userDao = new UserDaoImpl();
        userService.setUserDao(userDao);
        // check for the exception we expect
        thrown.expect(NullPointerException.class);
        userService.login("","");
    }
    @Test
    public void testgetPubAllowanceUser(){
        UserServiceImpl userService = new UserServiceImpl();
        UserDaoImpl userDao = new UserDaoImpl();
        userService.setUserDao(userDao);
        assertThat(userService.getPubAllowanceUser( LocalDate.of(2017,3,20)), hasItems(new User("Prayuth","1234","Tu",
                LocalDate.of(1979,2,14),"08612345678")));
    }


}
