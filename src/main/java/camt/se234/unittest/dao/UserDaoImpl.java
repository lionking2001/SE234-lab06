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
        users.add(new User("Kanjanaroot","1234","Fluke",
                LocalDate.of(1980,2,14),"08612341678"));
        users.add(new User("Kittipan","5675","James",
                LocalDate.of(1998,8,30),"08687654311"));
        users.add(new User("Kanatip","1134","Max",
                LocalDate.of(1979,2,24),"08612345671"));
        users.add(new User("Thapakorn","5615","OAT",
                LocalDate.of(2000,8,30),"08187654321"));

    }

    public List<User> getUsers(){
        return users;
    }
}
