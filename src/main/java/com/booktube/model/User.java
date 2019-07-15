package com.booktube.model;

import com.booktube.model.subModel.Address;
import com.booktube.model.subModel.Interest;
import com.booktube.model.subModel.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String login;

    @Column
    private String name;

    @Column
    private String surname;

    @ElementCollection
    @CollectionTable(
            name="USER_ROLE",
            joinColumns=@JoinColumn(name="OWNER_ID"))
    private List<Role> roles;

    @ElementCollection
    @CollectionTable(
            name = "USER_ADDRESS",
    joinColumns = @JoinColumn(name = "OWNER_ID"))
    private List<Address> addresses;

    @JsonIgnore
    @Column
    private String email;

    @JsonIgnore
    @Column
    private String password;

    @Lob
    private Interest interests;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Interest getInterests() {
        return interests;
    }

    public void setInterests(Interest interests) {
        this.interests = interests;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", roles=" + roles +
                ", addresses=" + addresses +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", interests=" + interests +
                '}';
    }
}
