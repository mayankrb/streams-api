package functional_interafces_and_lambda_expression;

/*
Problem 2: The Object Validator
Goal: Practice using lambdas to validate complex objects.
Create a class Product with String name and double price.
Create a functional interface ProductValidator with a method boolean validate(Product p).
Write a lambda that returns true if the product name is not empty and the price is greater than 0.
Write a second lambda that returns true only if the product is a "Premium" item (name contains the word "Premium").
 */

@FunctionalInterface
interface ProductValidator{
    boolean validate(Product p);
}

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

public class ObjectValidator {
    static void applyTransformation(Product target, ProductValidator processor, String processorName){
        System.out.println(target);
        System.out.println("Checking processor: " + processorName);
        System.out.println("Result: " + processor.validate(target));
    }
    public static void main(String[] args){
        Product premiumProduct = new Product("Premium Item", 100.0);
        Product normalProductZeroPrice = new Product("Normal Item", 0.0);
        Product emptyProductName = new Product("", 100.0);
        Product normalProduct = new Product("Normal Item", 100.0);
        Product preProduct = new Product("Pre Item", -100.0);
        ProductValidator validNameAndPriceValidator = p-> !p.getName().isEmpty() && p.getPrice()>0.0;
        ProductValidator premiumProductValidator = p -> p.getName().toLowerCase().contains("premium");

        applyTransformation(premiumProduct, validNameAndPriceValidator, "validNameAndPriceValidator");
        applyTransformation(normalProductZeroPrice, validNameAndPriceValidator, "validNameAndPriceValidator");
        applyTransformation(emptyProductName, validNameAndPriceValidator, "validNameAndPriceValidator");
        applyTransformation(normalProduct, validNameAndPriceValidator, "validNameAndPriceValidator");
        applyTransformation(preProduct, validNameAndPriceValidator, "validNameAndPriceValidator");
        applyTransformation(premiumProduct, premiumProductValidator, "premiumProductValidator");
        applyTransformation(normalProductZeroPrice, premiumProductValidator, "premiumProductValidator");
        applyTransformation(emptyProductName, premiumProductValidator, "premiumProductValidator");
        applyTransformation(normalProduct, premiumProductValidator, "premiumProductValidator");
        applyTransformation(preProduct, premiumProductValidator, "premiumProductValidator");
    }
}
