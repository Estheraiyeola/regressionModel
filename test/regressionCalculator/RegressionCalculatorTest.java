package regressionCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import regressionCalculator.RegressionCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegressionCalculatorTest {
    private RegressionCalculator regressionCalculator;
    @BeforeEach
    public void setRegressionCalculator(){
        regressionCalculator = new RegressionCalculator();
    }
    @Test
    public void testThatX_And_Y_Data_Can_BeCollected(){
        regressionCalculator.collect_X_Data(List.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        regressionCalculator.collect_Y_Data(List.of(3.5, 5.1, 7.2, 8.4, 11.1, 12.5, 14.8, 16.2, 18.0, 19.7));
        assertEquals(List.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0), regressionCalculator.getX_Data());
        assertEquals(List.of(3.5, 5.1, 7.2, 8.4, 11.1, 12.5, 14.8, 16.2, 18.0, 19.7), regressionCalculator.getY_Data());
    }

    @Test
    public void testThatX_And_Y_Data_Can_BeCollected_And_Their_Means_Can_Be_Calculated(){
        List<Double> x_Data = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        List<Double> y_Data = new ArrayList<>(Arrays.asList(3.5, 5.1, 7.2, 8.4, 11.1, 12.5, 14.8, 16.2, 18.0, 19.7));

        regressionCalculator.collect_X_Data(x_Data);
        regressionCalculator.collect_Y_Data(y_Data);
        assertEquals(List.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0), regressionCalculator.getX_Data());
        assertEquals(List.of(3.5, 5.1, 7.2, 8.4, 11.1, 12.5, 14.8, 16.2, 18.0, 19.7), regressionCalculator.getY_Data());

        regressionCalculator.calculateX_Mean(x_Data);
        regressionCalculator.calculateY_Mean(y_Data);

        assertEquals(5.5,regressionCalculator.getX_Mean());
        assertEquals(11.65,regressionCalculator.getY_Mean());

    }

    @Test
    public void testThatSlope_Can_Be_BeCalculated(){
        List<Double> x_Data = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        List<Double> y_Data = new ArrayList<>(Arrays.asList(3.5, 5.1, 7.2, 8.4, 11.1, 12.5, 14.8, 16.2, 18.0, 19.7));

        regressionCalculator.collect_X_Data(x_Data);
        regressionCalculator.collect_Y_Data(y_Data);
        assertEquals(List.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0), regressionCalculator.getX_Data());
        assertEquals(List.of(3.5, 5.1, 7.2, 8.4, 11.1, 12.5, 14.8, 16.2, 18.0, 19.7), regressionCalculator.getY_Data());

        regressionCalculator.calculateX_Mean(x_Data);
        regressionCalculator.calculateY_Mean(y_Data);

        assertEquals(5.5,regressionCalculator.getX_Mean());
        assertEquals(11.65,regressionCalculator.getY_Mean());

        System.out.println(Arrays.deepToString(regressionCalculator.drawTable()));
        double[][] table = regressionCalculator.drawTable();

        assertEquals(1.83, regressionCalculator.calculateSlope(table));

    }

    @Test
    public void testThatY_Intercept_Can_Be_BeCalculated(){
        List<Double> x_Data = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        List<Double> y_Data = new ArrayList<>(Arrays.asList(3.5, 5.1, 7.2, 8.4, 11.1, 12.5, 14.8, 16.2, 18.0, 19.7));

        regressionCalculator.collect_X_Data(x_Data);
        regressionCalculator.collect_Y_Data(y_Data);
        assertEquals(List.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0), regressionCalculator.getX_Data());
        assertEquals(List.of(3.5, 5.1, 7.2, 8.4, 11.1, 12.5, 14.8, 16.2, 18.0, 19.7), regressionCalculator.getY_Data());

        regressionCalculator.calculateX_Mean(x_Data);
        regressionCalculator.calculateY_Mean(y_Data);

        assertEquals(5.5,regressionCalculator.getX_Mean());
        assertEquals(11.65,regressionCalculator.getY_Mean());

        System.out.println(Arrays.deepToString(regressionCalculator.drawTable()));
        double[][] table = regressionCalculator.drawTable();
        double slope = regressionCalculator.calculateSlope(table);

        double x_Mean = regressionCalculator.getX_Mean();
        double y_Mean = regressionCalculator.getY_Mean();

        assertEquals(1.58, regressionCalculator.calculateY_Intercept(x_Mean,y_Mean, slope));

    }@Test
    public void testThatTheModel_Is_Working(){
        List<Double> x_Data = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        List<Double> y_Data = new ArrayList<>(Arrays.asList(3.5, 5.1, 7.2, 8.4, 11.1, 12.5, 14.8, 16.2, 18.0, 19.7));


        regressionCalculator.collect_X_Data(x_Data);
        regressionCalculator.collect_Y_Data(y_Data);
        assertEquals(List.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0), regressionCalculator.getX_Data());
        assertEquals(List.of(3.5, 5.1, 7.2, 8.4, 11.1, 12.5, 14.8, 16.2, 18.0, 19.7), regressionCalculator.getY_Data());

        regressionCalculator.calculateX_Mean(x_Data);
        regressionCalculator.calculateY_Mean(y_Data);

        assertEquals(5.5,regressionCalculator.getX_Mean());
        assertEquals(11.65,regressionCalculator.getY_Mean());

        System.out.println(Arrays.deepToString(regressionCalculator.drawTable()));
        double[][] table = regressionCalculator.drawTable();
        double slope = regressionCalculator.calculateSlope(table);

        double x_Mean = regressionCalculator.getX_Mean();
        double y_Mean = regressionCalculator.getY_Mean();

        double intercept = regressionCalculator.calculateY_Intercept(x_Mean,y_Mean, slope);
        double independentVariable = 6.2;


        assertEquals(12.93, regressionCalculator.testModel(independentVariable));
    }


}
