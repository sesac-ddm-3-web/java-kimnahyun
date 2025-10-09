import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void calculateAllTest() {
        Calculator calculator = new Calculator();
        String question = "3+2*5";
        Assertions.assertEquals(calculator.calculateAll(question), "13");
    }

}
