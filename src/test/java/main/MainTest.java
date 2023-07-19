package main;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MainTest {

    private final double EPS = 1e-6;
    Main main;


    @BeforeMethod
    public void setUp() {
        main = new Main();
    }
//    @Test
//    public void testF1(){
//        double expected = -3.858407;
//        double x = 1;
//        double actual = main.f(x);
//        assertEquals(actual, expected, EPS);
//    }
//
//    @Test
//    public void testF2(){
//        double expected = 11.606278;
//        double x = 1.3;
//        double actual = main.f(x);
//        assertEquals(actual, expected, EPS);
//    }
//
//    @Test
//    public void testF3(){
//        double expected = 2.732644;
//        double x = 2;
//        double actual = main.f(x);
//        assertEquals(actual, expected, EPS);
//    }
    @DataProvider(name = "dataForTest")
    public Object[][] createDataForTestF() {
        return new Object[][]{
                {1, -3.858407 },
                {1.3, 11.606278},
                {2, 2.732644}
        };
    }

    @Test(dataProvider = "dataForTest")
    public void testF(double x, double expected){
        double actual = main.f(x);
        assertEquals(actual, expected, EPS);
    }

    @Test
    public void testSteps(){
        double start = 0.7;
        double end = 2.0;
        double step = 0.005;
        int expected = 261;
        int actual = main.steps(start, end, step);
        assertEquals(actual, expected);
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataForFillX")
    public void testFillX(int index, double expected){
        double start = 0.7;
        double end = 2.0;
        double step = 0.005;
        double[] actual = main.fillX(start, end, step);
        assertEquals(actual[index], expected, EPS);
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataForFillY")
    public void testFillY(int index, double expected){
        double start = 0.7;
        double end = 2.0;
        double step = 0.005;
        double[] actual = main.fillY(main.fillX(start, end, step));
        assertEquals(actual[index], expected, EPS);
    }

    @Test
    public void testSum(){
        double[] arr = {1.0, 2.0, 3.0};
        double expected = 6.0;
        double actual = main.sum(arr);
        assertEquals(actual, expected, EPS);
    }
    @Test
    public void testFindMin(){
        double[] arr = {2.0, 1.0, 3.0, 0.8};
        double expected = 0.8;
        double actual = main.findMin(arr);
        assertEquals(actual, expected, EPS);
    }
    @Test
    public void testFindMax(){
        double[] arr = {2.0, 4.0, 1.0, 200.0, 10.0};
        double expected = 200.0;
        double actual = main.findMax(arr);
        assertEquals(actual, expected, EPS);
    }
    @Test
    public void testAVG(){
        double[] arr = {1.0, 2.0, 3.0};
        double expected = 2.0;
        double actual = main.avg(arr);
        assertEquals(actual, expected, EPS);
    }


}