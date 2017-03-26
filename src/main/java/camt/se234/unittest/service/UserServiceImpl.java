package camt.se234.unittest.service;


import camt.se234.unittest.dao.UserDaoImpl;
import camt.se234.unittest.entity.User;
import camt.se234.unittest.exception.OldDateException;
import camt.se234.unittest.exception.OldManException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl {

    UserDaoImpl userDao;
    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public User login(String username, String password){

        if (username == null || username.length() == 0 || password == null || password.length() == 0){
            throw new NullPointerException();
        }
        if (!username.matches("[a-zA-Z0-9]*")){
            throw new RuntimeException("The user name must not contain special character");
        }

        List<User> users = userDao.getUsers();
        return users.stream().filter(u -> (u.getUsername().equals(username) && u.getPassword().equals(password)))
                .findFirst().orElse(null);
    }

    public boolean isAbleToGoToPub(User user, LocalDate date){
        if (date.isBefore(user.getDateOfBirth())){
            throw new OldDateException("User is not Born Yet");
        }
        if(date.isBefore(LocalDate.now())){
            throw new OldDateException();
        }
        return ChronoUnit.YEARS.between(user.getDateOfBirth(),date)>=20;
    }

    public List<User> getPubAllowanceUser(LocalDate date){
        List<User> users = userDao.getUsers();

        return users.stream().filter(u-> isAbleToGoToPubIgnoreException(u,date)).collect(Collectors.toList());
    }

    private boolean isAbleToGoToPubIgnoreException(User user, LocalDate date){
        if(ChronoUnit.YEARS.between(user.getDateOfBirth(),date)> 45){
            throw new OldManException();
        }
        if (user.getName().length() > 8){
            return false;
        }
        try{
            return isAbleToGoToPub(user,date);
        }catch (OldDateException e){
            return false;
        }
    }}