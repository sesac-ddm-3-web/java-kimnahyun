import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OperatorTest {

    @Test
    void testAdd(){
        Operator add = new AddOperator();
        Assertions.assertEquals(add.calculate(5,3), 8);
    }

    @Test
    void testSub(){
        Operator sub = new SubOperator();
        Assertions.assertEquals(sub.calculate(5,3), 2);
    }

    @Test
    void testMul(){
        Operator mul = new MulOperator();
        Assertions.assertEquals(mul.calculate(5,3), 15);
    }

    @Test
    void testDiv() {
        Operator div = new DivOperator();
        Assertions.assertEquals(div.calculate(6, 3), 2);
    }
}
