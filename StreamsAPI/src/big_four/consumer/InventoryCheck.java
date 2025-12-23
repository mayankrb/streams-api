package big_four.consumer;

import java.util.function.BiConsumer;

/*
Problem 3: The Inventory Check (BiConsumer)
Goal: Work with two inputs using BiConsumer<T, U>.
Concept: Sometimes you need to consume two related things, like a Product Name and its Stock Quantity.
Task: Create a BiConsumer<String, Integer> called inventoryCheck.
Logic:
If stock < 10, print: "ALERT: [Product] is low on stock ([Count] remaining)".
Else, print: "INFO: [Product] has sufficient stock."
Test:
inventoryCheck.accept("Laptops", 5);
inventoryCheck.accept("Mice", 50);
 */
public class InventoryCheck {
    public static void main(String[] args) {
        BiConsumer<String, Integer> inventoryCheck = (product, stock) -> {
            if(stock < 10){
                System.out.println("ALERT: " + product + " is low on stock (" + stock + " remaining)");
            }else{
                System.out.println("INFO: " + product + " has sufficient stock.");
            }
        };
        inventoryCheck.accept("Laptops", 7);
        inventoryCheck.accept("Mice", 50);
    }
}
