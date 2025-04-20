import com.johnsapp.final_project.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {

    @Test
    void testIsValidInteger(){
        System.out.println("isValidInteger str: 5, min: 1, max: 5");
        Assert.assertTrue(Calculator.isValidInteger("5", 1, 5));

        System.out.println("isValidInteger str: -5, min: 1, max: 5");
        Assert.assertFalse(Calculator.isValidInteger("-5", 1, 5));
    }
    @Test
    void testIsValidDouble(){
        System.out.println("isValidFloat str: 5.0, min: 1, max: 5");
        Assert.assertTrue(Calculator.isValidFloat("5.0", 1, 5));

        System.out.println("isValidFloat str: -5.0, min: 1, max: 5");
        Assert.assertFalse(Calculator.isValidFloat("-5.0", 1, 5));
    }

    @Test
    void testAdd(){
        System.out.println("testAdd float x: 4, float y: 5");
        Assert.assertEquals(Calculator.addNumbers(4,5),9.0);

        System.out.println("testAdd float x: -4, float y: 5");
        Assert.assertEquals(Calculator.addNumbers(-4,5),1.0);
    }

    @Test
    void testSubtract(){
        System.out.println("testSubtract float x: 4, float y: 5");
        Assert.assertEquals(Calculator.subtractNumbers(4,5),-1.0);

        System.out.println("testSubtract float x: -4, float y: 5");
        Assert.assertEquals(Calculator.subtractNumbers(-4,5),-9.0);
    }

    @Test
    void testMultiply(){
        System.out.println("testMultiply float x: 4, float y: 5");
        Assert.assertEquals(Calculator.multiplyNumbers(4,5),20.0);

        System.out.println("testMultiply float x: -4, float y: 5");
        Assert.assertEquals(Calculator.multiplyNumbers(-4,5),-20.0);
    }

    @Test
    void testDivide(){
        System.out.println("testDivide float x: 4, float y: 5");
        Assert.assertEquals(Calculator.divideNumbers(4,5),".8000");

        System.out.println("testDivide float x: -4, float y: 5");
        Assert.assertEquals(Calculator.divideNumbers(-4,5),"-.8000");
    }



}
