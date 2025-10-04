package part15;

import java.util.Stack;

public class ValidParentheses {

    boolean solution(String s) {

       String[] arr = s.split("");

        Stack<Integer> count = new Stack<>();
        for (String str : arr) {
            if (str.equals("(")) {
                count.push(1);
            }
            if (str.equals(")")) {
                if (count.isEmpty()){
                    return false;
                }
                count.pop();
            }
        }

        if (count.isEmpty()) {
            return true;
        }
            return false; // 올바른 괄호인지 여부를 반환해주세요.
    }

    public static void main(String[] args) {
        ValidParentheses solver = new ValidParentheses();
        System.out.println("Case 1: (())() -> " + solver.solution("(())()")); // 예상 출력: true
        System.out.println("Case 2: )()( -> " + solver.solution(")()("));   // 예상 출력: false
        System.out.println("Case 3: (() -> " + solver.solution("(("));    // 예상 출력: false
    }
}
