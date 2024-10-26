package com.shoeshop.Model;



public class Purchase {
	private int id;
    private Shoe shoe;
    private Customer customer;
    private int qty = 0;
    private double totalPrice=0;
    
    
    public Purchase(Shoe shoe, Customer customer, int qty) {
        this.shoe = shoe;
        this.customer = customer;
        this.qty = qty;
        this.customer.addPurchase(this);
        this.shoe.addPurchase(this);
        this.totalPrice = this.shoe.getPrice()*qty;
    }
    
    public Purchase(int id, Shoe shoe, Customer customer, int qty) {
    	this.id =id;
        this.shoe = shoe;
        this.customer = customer;
        this.qty = qty;
        this.customer.addPurchase(this);
        this.shoe.addPurchase(this);
        this.totalPrice = this.shoe.getPrice()*qty;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Shoe getShoe() {
        return shoe;
    }

    public void setShoe(Shoe shoe) {
        this.shoe = shoe;
    }
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "shoe=" + shoe +
                ", customer=" + customer +
                ", qty=" + qty +
                '}';
    }


}

