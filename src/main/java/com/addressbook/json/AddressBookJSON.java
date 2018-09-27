package com.addressbook.json;

import java.util.ArrayList;
import java.util.List;

public class AddressBookJSON {
    private List emplComList;

    public AddressBookJSON() {
        emplComList = new ArrayList<>();
    }

    public List getContacts() {
        return emplComList;
    }

    public void addContacts(List emplComList) {
        this.emplComList.addAll(emplComList);
    }

    public void putContacts(List emplComList) {
        this.emplComList = emplComList;
    }

    public void clearContacts() {
        this.emplComList.clear();
    }

    @Override
    public String toString() {
        return "AddressBookJSON{" +
                "emplComList=" + emplComList +
                '}';
    }
}
