import com.Calculator;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;

public class CalculatorTest {
    private Calculator cal;

    @BeforeClass
    public static void bc() {
        System.out.println("before.class");
    }

    @AfterClass
    public static void ac(){
        System.out.println("after.class");
    }

    @org.junit.Before
    public void setUp() throws Exception {
        System.out.println("before");
        cal = new Calculator();
    }

    @org.junit.After
    public void tearDown() throws Exception {
        System.out.println("after");
    }

    @org.junit.Test
    public void add() {
        System.out.println("add测试");
        Assert.assertEquals(3, cal.add(1, 2));
    }

    @org.junit.Test
    public void sub() {
        System.out.println("sub测试");
        Assert.assertEquals(cal.sub(2, 1), 1);
    }
}