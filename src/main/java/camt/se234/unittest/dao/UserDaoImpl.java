package camt.se234.unittest.dao;

import camt.se234.unittest.entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl {
    List<User> users;
    public UserDaoImpl() {
        users = new ArrayList<>();
        users.add(new User("Prayuth","1234","Tu",
                LocalDate.of(1979,2,14),"08612345678"));
        users.add(new User("Tucky","5675","Tuckung",
                LocalDate.of(1999,8,30),"08687654321"));
        users.add(User.builder().name("Honey").username("Honey").password("aabbcc")
                .dateOfBirth(LocalDate.of(2012,11,13)).telephoneNo("0000000000").build());
        users.add(User.builder().name("NoName").username("None").password("none")
                .dateOfBirth(LocalDate.of(2112,1,1)).telephoneNo("9999999999").build());
    }

    public List<User> getUsers(){
        return users;
    }
}
