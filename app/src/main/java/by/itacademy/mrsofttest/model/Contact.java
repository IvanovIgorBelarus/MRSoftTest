package by.itacademy.mrsofttest.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Contact {
    @PrimaryKey
    public int id;
    public String firstName;
    public String secondName;
    public String surName;
    public String placeOfWork;
    public int phone;

    Contact(String firstName,
            String secondName,
            String surName,
            String placeOfWork,
            int phone) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.surName = surName;
        this.placeOfWork = placeOfWork;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getSurName() {
        return surName;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public int getPhone() {
        return phone;
    }
}
