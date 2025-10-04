package exam.part16;

import java.util.Arrays;
import java.util.List;

public class Practice4 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = 0;

//        for (int number : numbers) {
//            sum += number;
//        }

        sum = numbers.stream().mapToInt(x -> x).sum();

        System.out.println("합계: " + sum); // 합계: 15
    }
}
