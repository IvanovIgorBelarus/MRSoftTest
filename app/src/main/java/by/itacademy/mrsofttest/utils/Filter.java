package by.itacademy.mrsofttest.utils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import by.itacademy.mrsofttest.model.Contact;

public class Filter {
    @Inject
    public Filter() {
    }

    public List<Contact> filterContact(String search, List<Contact> contactList) {
        List<Contact> list = new ArrayList<>();
        String fullName;
        if (search.length() == 0) {
            return contactList;
        }
        for (Contact contact : contactList) {
            fullName = String.format("%s %s %s", contact.firstName, contact.secondName, contact.surName);
            if (fullName.toLowerCase().contains(search.toLowerCase())) {
                list.add(contact);
            }
        }
        return list;
    }
}
