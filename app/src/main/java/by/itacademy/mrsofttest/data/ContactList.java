package by.itacademy.mrsofttest.data;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import by.itacademy.mrsofttest.model.Contact;

public class ContactList {
    private static List<Contact> contactList = new ArrayList<>();

    private ContactList() {
    }

    public static List<Contact> getList() {
        List<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact("Igor", "Igorevich", "Ivanov", "MRSoft", 292820875));
        contactList.add(new Contact("Ivan", "Igorevich", "Petrov", "SolbegSoft", 292820875));
        contactList.add(new Contact("Denis", "Ivanovich", "Sidorov", "Epam", 292820875));
        contactList.add(new Contact("Vlad", "Denisovich", "Turov", "IT-Academy", 292820875));
        contactList.add(new Contact("Dmitri", "Sergeevich", "Shapkin", "iTechArt Group", 292820875));
        contactList.add(new Contact("Maria", "Nikolaevna", "Ivanova", "Itransition", 292820875));
        Log.d("mytag", String.format("create list %s", contactList.size()));
        return contactList;
    }
}
