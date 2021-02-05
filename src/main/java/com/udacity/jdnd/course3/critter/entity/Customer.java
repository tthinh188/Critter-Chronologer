package com.udacity.jdnd.course3.critter.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "customers")
public class Customer extends User {
    private String phoneNumber;
    private String notes;

    @OneToMany(mappedBy = "customer")
    private List<Pet> pets;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }
}
