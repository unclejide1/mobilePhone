package com.decagonhq;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contacts> myContacts = new ArrayList<>();

    public MobilePhone() {
        this.myContacts = new ArrayList<>();
    }

    public ArrayList<Contacts> getMyContacts() {
        return myContacts;
    }
    public boolean addContacts(Contacts contact){
        if(findContacts(contact.getName()) >=0){
            System.out.println("Contact exist Already");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public void printContactList(){
        System.out.println("you have " + myContacts.size() + " items in your Contact List");
        for(int i = 0; i< myContacts.size(); i++){
            System.out.println((i + 1) + "." + this.myContacts.get(i).getName() + "-->" + this.myContacts.get(i).getPhoneNo());
        }
    }

    public boolean modifyContacts(Contacts oldContact, Contacts newContact){
        int position = findContacts(oldContact);
        if(position < 0){
            System.out.println(oldContact.getName() + " does not exist in your contact list");
            return false;
        }else if(findContacts(newContact.getName()) != -1){
            System.out.println("Contact with name " + newContact.getName() + " exist Already. Update unsuccessful");
            return false;
        }
        this.myContacts.set(position,newContact);
         System.out.println(oldContact.getName() + " has been replaced with " + newContact.getName());
         return true;
    }

//
    public boolean removeContact(Contacts contact){
        int position = findContacts(contact);
        if(position < 0){
            System.out.println(contact.getName() + " does not exist in your contact list");
            return false;
        }
        this.myContacts.remove(position);
        System.out.println(contact.getName() + " has been successfully deleted");
        return true;

    }

    private int findContacts(Contacts contact){
        return myContacts.indexOf(contact);
    }
    private int findContacts(String contactName){
        for(int i = 0; i< myContacts.size(); i++) {
            Contacts tempContact = this.myContacts.get(i);
            if(tempContact.getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }
//
    public String queryContact(Contacts contact){
        int position = findContacts(contact);
        if(position >= 0){
            return contact.getName();
        }
        return null;
    }

    public Contacts queryContact(String name){
        int position = findContacts(name);
        if(position >= 0){
            return this.myContacts.get(position);
        }
        return null;
    }
}
