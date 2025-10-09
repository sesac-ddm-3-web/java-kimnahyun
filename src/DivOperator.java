import java.beans.PropertyEditorSupport;

public class DivOperator implements Operator {
    @Override
    public int calculate(int x, int y) {
        return x / y;
    }
}
