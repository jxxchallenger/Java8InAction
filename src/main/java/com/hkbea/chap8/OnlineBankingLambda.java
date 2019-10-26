package com.hkbea.chap8;

import java.util.function.Consumer;

public class OnlineBankingLambda {

    public static void main(String[] args) {
        new OnlineBankingLambda().processCustomer(123, customer -> System.out.println("hello"));
    }
    
    public void  processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
        Customer customer = Database.getCustomerWithId(id);
        makeCustomerHappy.accept(customer);
    }
    
    static private class Customer {}
    // dummy Database class
    static private class Database{
        static Customer getCustomerWithId(int id){ return new Customer();}
    }
}
