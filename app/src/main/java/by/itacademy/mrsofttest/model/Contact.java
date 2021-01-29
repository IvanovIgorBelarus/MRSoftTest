package by.itacademy.mrsofttest.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contacts")
public class Contact {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String firstName;
    public String secondName;
    public String surName;
    public String placeOfWork;
    public int phone;

    public Contact(String firstName,
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
}
