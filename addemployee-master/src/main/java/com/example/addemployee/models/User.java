package com.example.addemployee.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="USERS") //создание таблицы БД
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // авто генерация ключа в БД
    @Column(name="ID")
    private Long Id;

//создание колонок в БД
   @Column(name="FIRST_NAME")
    private String firstName;
   @Column(name="LAST_NAME")
    private String lastName;
    @Column(name="COMPANY_ID")
    private int companyId;
   @Column(name="ROLE")
    private String role;

    public User() { // создание пустого конструктора (Обязательно)
    }

    public User(String firstName, String lastName, int companyId, String role) { //создание конструктора с полями объектов
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyId = companyId;
        this.role = role;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() { // строковый вид
        return "User {" +
                "Id=" + Id +
                ", companyId=" + companyId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
