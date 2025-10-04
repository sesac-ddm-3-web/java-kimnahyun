package part15;

import java.util.*;

public class RemoveDuplicates {

    public List<Integer> solution(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int n : arr) {
            set.add(arr[n]);
        }

        return set.stream().toList(); // 결과 리스트를 반환해주세요.
    }

    public static void main(String[] args) {
        RemoveDuplicates solver = new RemoveDuplicates();
        int[] arr = {1, 2, 5, 2, 4, 5, 1, 6};
        System.out.println("Original Array: " + Arrays.toString(arr));
        List<Integer> result = solver.solution(arr);
        System.out.println("Unique List: " + result); // 예상 출력: [1, 2, 4, 5, 6] (순서는 다를 수 있음)
    }
}
