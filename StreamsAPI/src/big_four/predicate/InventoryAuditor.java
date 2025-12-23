package big_four.predicate;
/*
Problem 1: The Inventory Auditor
Goal: Use Predicate composition to filter a list of products based on complex business rules.
Setup: Use your existing Product class (with name and price).
Task: Create three separate Predicate<Product> instances:
isCheap: Price is less than $50.
isExpensive: Price is greater than $500.
hasLongName: Name is longer than 15 characters.
Composition: Use .and(), .or(), and .negate() to create a final predicate called auditRequired that returns true if:
The product is Expensive OR
The product is Cheap AND has a Long Name.
Test: Create a list of products and use your auditRequired predicate to print which ones need an audit.
 */

import java.util.function.Predicate;

class Product{
    String name;
    double price;
    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }
    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }
    public String toString(){
        return String.format("Product: %s, Price: %.2f", this.name, this.price);
    }
}

public class InventoryAuditor {
    public static void main(String[] args) {
        /*
        isCheap: Price is less than $50.
        isExpensive: Price is greater than $500.
        hasLongName: Name is longer than 15 characters.
         */
        Product cheapProduct = new Product("Cheap Product", 10.0);
        Product cheapAndLongNamedProduct = new Product("Cheap and long Name Product", 10.0);
        Product expensiveProduct = new Product("Expensive", 1000.0);
        Product expensiveAndLongNamedProduct = new Product("Expensive and long named Product", 1000.0);
        /*
            Composition: Use .and(), .or(), and .negate() to create a final predicate called auditRequired that returns true if:
            The product is Expensive OR
            The product is Cheap AND has a Long Name.
         */
        Predicate<Product> isCheap = p -> p.getPrice() < 50.0;
        Predicate<Product> isExpensive = p -> p.getPrice() > 500.0;
        Predicate<Product> hasLongName = p -> p.getName().length() > 15;
        Predicate<Product> auditRequired = isExpensive.or(isCheap.and(hasLongName));
        System.out.println("Audit required for expensiveAndLongNamedProduct: "  + auditRequired.test(expensiveAndLongNamedProduct));
        System.out.println("Audit required for cheapAndLongNamedProduct: "  + auditRequired.test(cheapAndLongNamedProduct));
        System.out.println("Audit required for expensiveProduct: "  + auditRequired.test(expensiveProduct));
        System.out.println("Audit required for cheapProduct: "  + auditRequired.test(cheapProduct));
    }
}
