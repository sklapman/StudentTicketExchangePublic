package com.example.studentticketexchange;

public class Listing {

    public String gameID;
    public String sellerEmail;
    public int section;
    public int row;
    public int quantity;
    public double price;
    public Boolean studentTicket;
    public Boolean validated;
    public Boolean negotiable;

    //public String message;
    //assume qty will be generated by counting the number of child Tickets associated with a Listing

    /*public Listing(String sellerEmail, Boolean studentTicket, Boolean validated, String section, String message) {
        this.gameID = "1";
        this.sellerEmail = sellerEmail;
        this.studentTicket = studentTicket;
        this.validated = validated;
        this.section = section;
        this.message = message;
    }
    */

    public Listing(String gameID, String sellerEmail, int section, int row, int quantity,
                   double price, Boolean studentTicket, Boolean validated, Boolean negotiatble){
        this.gameID = gameID;
        this.sellerEmail = sellerEmail;
        this.section = section;
        this.row = row;
        this.quantity = quantity;
        this.price = price;
        this.studentTicket = studentTicket;
        this.validated = validated;
        this.negotiable = negotiatble;
    }

    public Listing(){

    }
}
