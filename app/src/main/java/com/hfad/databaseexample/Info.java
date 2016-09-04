package com.hfad.databaseexample;

/**
 * Created by user on 9/1/2016.
 */
public class Info {
    String name;
    String adress;
    public Info(){

    }
    public Info(String name, String adress, String contact,String gender){
        this.name=name;
        this.adress=adress;

        this.contact=contact;
        this.gender=gender;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getGetGender() {
        return gender;
    }

    public void setGetGender(String getGender) {
        this.gender = getGender;
    }

    String contact;
    String gender;
}
