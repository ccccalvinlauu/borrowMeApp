package com.groupProject.borrowMe.models;

/**
 * Created by Enache on 19/04/2018.
 */

public class ItemCheck {


    private String title;
    private String price;
    private String details;
    private String department;
    private String item_id;
    private String email;

    public ItemCheck(String item_id,String email ,String title, String price, String details,String department) {
        this.item_id= item_id;
        this.email = email;
        this.title = title;
        this.price = price;
        this.details = details;
        this.department = department;
    }

    public String getItemTitle() {
        return title;
    }

    public String getItemId() {
        return item_id;
    }

    public String getItemEmail() {
        return email;
    }

    public void setItemTitle(String title) {
        this.title = title;
    }

    public String getItemPrice() {
        return price;
    }

    public void setItemPrice(String price) {
        this.price = price;
    }

    public String getItemDetails() {
        return details;
    }

    public void setItemDetails(String details) {
        this.details = details;
    }

    public String getItemDepartment() {
        return department;
    }

    public void setItemDepartment(String department) {
        this.department = department;
    }

}
