package exam.part16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Practice2 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        List<Integer> wordLengths = new ArrayList<>();

//        for (String word : words) {
//            wordLengths.add(word.length());
//        }

         words.stream().map(n -> n.length()).forEach(n -> wordLengths.add(n));

        System.out.println(wordLengths); // [5, 6, 6, 4]
    }
}

