package Model;

import java.time.LocalDate;

public class User {
    private static int idd = 1;
    private int ids;
    private String firstname;
    private String LastName;
    private String email;
    private LocalDate registered_date;

    public User(String firstname, String lastName, String email, LocalDate registered_date) {

        if (firstname == null || firstname.isEmpty()) {
            throw new IllegalArgumentException("FirstName cannot be null or name");
        }
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Surname cannot be null or empty");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }

        this.ids = idd++;
        this.firstname = firstname;
        LastName = lastName;
        this.email = email;
        this.registered_date = registered_date;
    }

    public static int getIdd() {
        return idd;
    }

    public static void setIdd(int idd) {
        User.idd = idd;
    }

    public int getId() {
        return ids;
    }

    public void setId(int id) {
        this.ids = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getRegistered_date() {
        return registered_date;
    }

    public void setRegistered_date(LocalDate registered_date) {
        this.registered_date = registered_date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + ids +
                ", firstname='" + firstname + '\'' +
                ", LastName='" + LastName + '\'' +
                ", email='" + email + '\'' +
                ", registered_date=" + registered_date +
                '}';
    }
}
