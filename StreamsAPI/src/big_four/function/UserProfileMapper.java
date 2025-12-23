package big_four.function;

import java.util.function.Function;

/*
Problem 2: The User Profile MapperGoal: Practice object-to-object transformation.
Setup: Imagine you have a User class with firstName and lastName.
Task: Create a Function<User, String> named toFullName.
Logic: Combine the first and last name into a single string (e.g., "John Doe").
Chaining: Create a second Function<String, String> that wraps a string in square brackets (e.g., "[John Doe]").
Requirement: Use .andThen() to create a toBracketedName function that goes directly from User to [Full Name].
 */
class User{
    String firstName;
    String lastName;
    public User(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String toString(){
        return String.format("User: %s %s", this.firstName, this.lastName);
    }
}
public class UserProfileMapper {
    public static void main(String[] args) {
        Function<User, String> toFullName = user -> user.getFirstName() + " " + user.getLastName();
        Function<String, String> toBracketedName = name -> "[" + name + "]";
        Function<User, String> toBracketedFullName = toFullName.andThen(toBracketedName);
        User user = new User("John", "Doe");
        System.out.println(toBracketedFullName.apply(user));
    }
}
