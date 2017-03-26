package camt.se234.unittest.dao;
import camt.se234.unittest.entity.User;
import camt.se234.unittest.service.UserServiceImpl;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItems;


public class UserDaoImplTest {
    @Test
    public void testGetUsers(){
        UserDaoImpl userDao = new UserDaoImpl();
        assertThat(userDao.getUsers(),
                hasItems(new User("Prayuth","1234","Tu",
                                LocalDate.of(1979,2,14),"08612345678"),
                        new User("Tucky","5675","Tuckung",
                                LocalDate.of(1999,8,30),"08687654321"),
                        new User("Honey","aabbcc","Honey",
                                LocalDate.of(2012,11,13),"0000000000"),
                        new User("None","none","NoName",
                                LocalDate.of(2112,1,1),"9999999999")

                ));

        assertThat(userDao.getUsers(),
                contains(new User("Prayuth","1234","Tu",
                                LocalDate.of(1979,2,14),"08612345678"),
                        new User("Tucky","5675","Tuckung",
                                LocalDate.of(1999,8,30),"08687654321"),
                        new User("Honey","aabbcc","Honey",
                                LocalDate.of(2012,11,13),"0000000000"),
                        new User("None","none","NoName",
                                LocalDate.of(2112,1,1),"9999999999")

                ));

        assertThat(userDao.getUsers(),
                contains(new User("Prayuth","1234","Tu",
                                LocalDate.of(1979,2,14),"08612345678"),
                        new User("Tucky","5675","Tuckung",
                                LocalDate.of(1999,8,30),"08687654321"),
                        new User("Honey","aabbcc","Honey",
                                LocalDate.of(2012,11,13),"0000000000"),
                        new User("None","none","NoName",
                                LocalDate.of(2112,1,1),"9999999999")
                ));

        assertThat(userDao.getUsers(),
                containsInAnyOrder(new User("Prayuth","1234","Tu",
                                LocalDate.of(1979,2,14),"08612345678"),
                        new User("Tucky","5675","Tuckung",
                                LocalDate.of(1999,8,30),"08687654321"),
                        new User("Honey","aabbcc","Honey",
                                LocalDate.of(2012,11,13),"0000000000"),
                        new User("None","none","NoName",
                                LocalDate.of(2112,1,1),"9999999999")

                ));




    @Test
    public void testisAbleToGoToPub(){

    }
    @Test
    public void testLoginException()  {
        UserServiceImpl userService = new UserServiceImpl();
        UserDaoImpl userDao = new UserDaoImpl();
        userService.setUserDao(userDao);
        // check for the exception we expect
        thrown.expect(NullPointerException.class);
        userService.login("","");
        User user = new User("Prayuth","1234","Tu", LocalDate.of(1979,2,14),"08612345678");
        assertThat(userService.login("Prayuth","1234"),null);
    }
    @Test

    public void testisAbleToGoToPub(){
        UserServiceImpl userService = new UserServiceImpl();
        UserDaoImpl userDao = new UserDaoImpl();
        userService.setUserDao(userDao);
        assertThat(userService.isAbleToGoToPub(userService.login("Prayuth","1234"), LocalDate.of(2017,3,20)), is(true));
        assertThat(userService.isAbleToGoToPub(userService.login("Tucky","5675"), LocalDate.of(2017,3,20)), is(false));
        assertThat(userService.isAbleToGoToPub(userService.login("Honey","aabbcc"), LocalDate.of(2017,3,20)), is(false));
        assertThat(userService.isAbleToGoToPub(userService.login("None","none"), LocalDate.of(2017,3,20)), is(false));

    }
    @Test
    public void testgetPubAllowanceUser(){

        UserServiceImpl userService = new UserServiceImpl();
        UserDaoImpl userDao = new UserDaoImpl();
        userService.setUserDao(userDao);
        assertThat(userService.isAbleToGoToPub(userService.login("Prayuth","1234"), LocalDate.of(2017,3,20)), is(true));
        assertThat(userService.isAbleToGoToPub(userService.login("Tucky","5675"), LocalDate.of(2017,3,20)), is(false));
        assertThat(userService.isAbleToGoToPub(userService.login("Honey","aabbcc"), LocalDate.of(2017,3,20)), is(false));
        assertThat(userService.isAbleToGoToPub(userService.login("None","none"), LocalDate.of(2017,3,20)), is(false));

    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();



}