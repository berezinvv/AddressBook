package com.addressbook.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "company")
    private Set<WorkPlace> workPlaceSet;

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<WorkPlace> getWorkPlaceSet() {
        return workPlaceSet;
    }

    public void setWorkPlaceSet(Set<WorkPlace> workPlaceSet) {
        this.workPlaceSet = workPlaceSet;
    }

    @Override
    public String toString() {
        return "Company{" +
                "Name='" + name + '\'' +
                ", Address='" + address + '\'' +
                ", PhoneNumber='" + phoneNumber +'\'' +
                //", workPlaceSet='" + workPlaceSet +
                '}';
    }
}
