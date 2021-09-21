package com.dataflair.fooddeliveryapp.Model;

public class Model {

    String fname, lname, emailaddress, phoneno, userpassword, profilepic, userId;
    String hotelLocation, imageUrl, itemName, itemPrice;

    public Model() {
    }

    public Model(String fname, String lname, String emailaddress, String phonenumber, String profilepic, String userpassword, String address, String userId, String hotelLocation, String imageUrl, String itemName, String itemPrice) {
        this.fname = fname;
        this.lname = lname;
        this.emailaddress = emailaddress;
        this.profilepic = profilepic;
        this.phoneno = phonenumber;
        this.userpassword = userpassword;
        this.userId = userId;
        this.hotelLocation = hotelLocation;
        this.imageUrl = imageUrl;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getFirstName() {
        return fname;
    }

    public void setFirstName(String fname) {
        this.fname = fname;
    }

    public String getLastName() {
        return lname;
    }

    public void setLastName(String lname) {
        this.lname = lname;
    }

    public String getEmailAddress() { return emailaddress; }

    public void setEmailAddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public String getPhoneNumber() {
        return phoneno;
    }

    public void setPhoneNumber(String phonenumber) {
        this.phoneno = phonenumber;
    }

    public String getPassword() {
        return userpassword;
    }

    public void setPassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHotelLocation() {
        return hotelLocation;
    }

    public void setHotelLocation(String hotelLocation) {
        this.hotelLocation = hotelLocation;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }
}