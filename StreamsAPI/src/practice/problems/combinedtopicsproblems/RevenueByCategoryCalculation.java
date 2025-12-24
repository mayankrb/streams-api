package practice.problems.combinedtopicsproblems;


import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

record LineItem(String productName, String category, double price, int quantity) {
    double getTotal() { return price * quantity; }
}

record Order(int id, String customerName, List<LineItem> items) {}

public class RevenueByCategoryCalculation {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, "Alice", List.of(
                        new LineItem("Laptop", "Electronics", 1200.0, 1), // Keep (Alice + >50)
                        new LineItem("Mouse", "Electronics", 20.0, 2)     // Discard (Total 40 < 50)
                )),
                new Order(2, "Bob", List.of(
                        new LineItem("Phone", "Electronics", 800.0, 1)    // Discard (Bob is not 'A')
                )),
                new Order(3, "Aaron", List.of(
                        new LineItem("Chair", "Furniture", 150.0, 2),     // Keep (Aaron + >50)
                        new LineItem("Desk", "Furniture", 300.0, 1)       // Keep
                ))
        );
        /*
        Write a single stream pipeline to calculate the Total Revenue per Category, but with strict rules:
        Filter Customers: Only process orders from customers whose names start with "A" (Our VIPs).
        Flatten: You need to dig out the LineItems from these orders.
        Filter Items: We only care about "High Value" items where the line total (price * quantity) is greater than $50.
        Group & Sum: Group the remaining items by Category and sum up their totals.
        Expected Output: A Map<String, Double> where:
        Key = Category Name (e.g., "Electronics")
        Value = Sum of all valid line totals.
         */
        // YOUR CODE HERE
        // Map<String, Double> revenueByCategory = ...
        Predicate<Order> startsWithA = o->o.customerName().startsWith("A");
        Map<String, Double> revenueByCategory = orders.stream()
                .filter(startsWithA)
                .flatMap(order -> order.items().stream())
                .filter(lineItem -> lineItem.getTotal()>50.0)
                .collect(Collectors.groupingBy(LineItem::category, Collectors.summingDouble(LineItem::getTotal)));
        System.out.println("Revenue by Categories:");
        for(Map.Entry<String, Double> entry : revenueByCategory.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
