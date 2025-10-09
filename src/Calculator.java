import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    Operator div = new DivOperator();
    Operator mul = new MulOperator();
    Operator add = new AddOperator();
    Operator sub = new SubOperator();

    public String calculateAll(String question) {
        List<String> expression = new ArrayList<>(Arrays.asList(question.split("")));

        return calculateAddOrSub(calculateDivOrMul(expression));
    }

    private List<String> calculateDivOrMul(List<String> expression) {
        for (int i = 0; i < expression.size(); i++) {
            if (expression.get(i).equals("*") || expression.get(i).equals("/")) {
                int first = Integer.parseInt(expression.get(i - 1));
                int second = Integer.parseInt(expression.get(i + 1));

                int result = expression.get(i).equals("*") ? mul.calculate(first, second) : div.calculate(first, second);

                expression.set(i - 1, Integer.toString(result));

                expression.remove(i);
                expression.remove(i);
                i--;
            }
        }
        return expression;
    }

    private String calculateAddOrSub(List<String> expression) {
        while (expression.size() != 1) {
            for (int i = 0; i < expression.size(); i++) {
                if (expression.get(i).equals("+") || expression.get(i).equals("-")) {
                    int first = Integer.parseInt(expression.get(i - 1));
                    int second = Integer.parseInt(expression.get(i + 1));

                    int result = expression.get(i).equals("+") ? add.calculate(first, second) : sub.calculate(first, second);

                    expression.set(i - 1, Integer.toString(result));

                    expression.remove(i);
                    expression.remove(i);
                    i--;
                }
            }
        }
        return expression.get(0);
    }

    /*
    question split해서 list<>에 넣기
    -> 거기서 * / 있는지 for문 순회
    -> 있으면 앞뒤 문자 불러와서 int로 변환
    -> 해당하는 operator로 계산
    -> 그 전 위치에 넣고 계속 순회
    ->-> 그다음 +-있는지 for문 순회
    -> 해당 계산하고 값 넣기
    -> list 사이즈 1일때까지 반복
     */
}
