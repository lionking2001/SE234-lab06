package camt.se234.unittest.entity;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;

@Builder
public class User {
    String username;
    String password;
    String name;
    LocalDate dateOfBirth;
    String telephoneNo;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public User(String username, String password, String name, LocalDate dateOfBirth, String telephoneNo) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.telephoneNo = telephoneNo;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getUsername() != null ? !getUsername().equals(user.getUsername()) : user.getUsername() != null)
            return false;
        if (getPassword() != null ? !getPassword().equals(user.getPassword()) : user.getPassword() != null)
            return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (getDateOfBirth() != null ? !getDateOfBirth().equals(user.getDateOfBirth()) : user.getDateOfBirth() != null)
            return false;
        return telephoneNo != null ? telephoneNo.equals(user.telephoneNo) : user.telephoneNo == null;
    }

    @Override
    public int hashCode() {
        int result = getUsername() != null ? getUsername().hashCode() : 0;
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (getDateOfBirth() != null ? getDateOfBirth().hashCode() : 0);
        result = 31 * result + (telephoneNo != null ? telephoneNo.hashCode() : 0);
        return result;
    }
}
