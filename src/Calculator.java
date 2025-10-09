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
}
