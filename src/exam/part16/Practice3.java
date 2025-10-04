package exam.part16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class Practice3 {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Alice", 25),
                new User("Bob", 30),
                new User("Charlie", 22),
                new User("David", 28)
        );
        List<String> userNames = new ArrayList<>();

//        for (User user : users) {
//            if (user.getAge() >= 25) {
//                userNames.add(user.getName());
//            }
//        }

        users.stream().filter(n -> n.getAge() >= 25).map(n -> n.getName()).forEach(n -> userNames.add(n));

        System.out.println(userNames); // [Alice, Bob, David]
    }
}

