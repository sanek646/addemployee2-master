package com.example.addemployee.models;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="users") //описание схемы БД
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // авто генерация ключа в БД
    @Column(name="id")
    @CsvBindByName(column = "id")
    private Long Id;

    @Column(name="first_name")
    @CsvBindByName(column = "first_name")
    private String firstName;

    @Column(name="last_name")
    @CsvBindByName(column = "last_name")
    private String lastName;

    @Column(name="company_id")
    @CsvBindByName(column = "company_id")
    private int companyId;

    @Column(name="role")
    @CsvBindByName(column = "role")
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
