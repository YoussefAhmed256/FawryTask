import Models.*;
import Services.Cart;
import Services.CheckOut;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

          // this block for testing

          System.out.println("Welcome to Youssef's ECom Service");

          Customer customer = new Customer("Youssef",50000.0);
          Product cheese = new ShippableAndExpirable("Cheese",100.0,20,200.0,LocalDate.of(2025, 11, 15));
          Product biscuit = new ShippableProducts("Biscuit", 200.0, 15, 100);
          Product scratchCard = new Product("Scratch Card", 20.0, 10);

          Cart cart = new Cart();
          try {
                cart.addToCart(cheese,2);
                cart.addToCart(biscuit,1);
                cart.addToCart(scratchCard,3);
          }
          catch (Exception e) {
                System.out.println(e.getMessage());
          }
          try {
                CheckOut checkOut = new CheckOut();
                checkOut.CheckOut(customer,cart);
          }
          catch (Exception e) {
                System.out.println(e.getMessage());
          }

          // end testing

          /* in the future i will add choices to make end user able to choose what he want to do from adding products
          or making new customers using the ECom class that will contains all lists of the project
           */

    }
}