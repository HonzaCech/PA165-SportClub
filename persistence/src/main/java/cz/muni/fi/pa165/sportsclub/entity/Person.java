package cz.muni.fi.pa165.sportsclub.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Jan
 */
@Entity
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotNull
    @Column(length = 25)
    private String firstName;

    @NotNull
    @Column(length = 25)
    private String lastName;

    //business key
    @Column(length = 25, unique = true, nullable = false)
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}