package by.itacademy.mrsofttest.model;

public class Contact {
    private String firstName;
    private String secondName;
    private String surName;
    private String placeOfWork;
    private int phone;
    Contact(String firstName,
            String secondName,
            String surName,
            String placeOfWork,
            int phone){
        this.firstName=firstName;
        this.secondName=secondName;
        this.surName=surName;
        this.placeOfWork=placeOfWork;
        this.phone=phone;
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
