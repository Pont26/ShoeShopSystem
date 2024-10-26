package com.shoeshop.Model;


import java.util.ArrayList;
import java.util.List;




public class Customer {
	private int id;
	private String name;
	private String email;
	private String phone;
    private String address;
    private List<Purchase> purchases;

 
    public Customer(String name, String email,String phone, String address) {
        this.purchases=new ArrayList<Purchase>();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Customer(int id,String name, String email,String phone, String address) {
        this.purchases=new ArrayList<Purchase>();
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }


    public int getId() {
    	return id;
    }

    public void addPurchase(Purchase purchase){
        this.purchases.add(purchase);
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }
    

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }


}

