package exam.part16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = new ArrayList<>();

        numbers.stream().filter(n -> n % 2 == 0).forEach(n-> evenNumbers.add(n));

        System.out.println(evenNumbers); // [2, 4, 6, 8, 10]
    }
}
