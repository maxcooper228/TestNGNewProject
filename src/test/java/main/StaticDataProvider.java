package main;

import org.testng.annotations.DataProvider;

public class StaticDataProvider {

    @DataProvider(name = "dataForFillX")
    public static Object[][] createDataForFillX() {
        return new Object[][]{
                {0, 0.7},
                {120, 1.3},
                {260, 2.0}
        };
    }
        @DataProvider(name = "dataForFillY")
        public static Object[][] createDataForFillY(){
            return new Object[][]{
                    {0, -12.746333},
                    {120, 11.606277},
                    {260, 2.732644}
            };
    }
}

