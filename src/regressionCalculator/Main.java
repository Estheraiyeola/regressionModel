package regressionCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static RegressionCalculator regressionCalculator = new RegressionCalculator();
    private Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Main main = new Main();
        main.collectVariables();
        regressionCalculator.drawTable();
        System.out.println(main.modelCreated());
    }

    public void collectVariables(){
        System.out.println("Enter the data for independent variable(X) and 0 to stop");
        double xNumber = input.nextDouble();
        while (xNumber != 0){
            regressionCalculator.collect_X_Data(List.of(xNumber));
            System.out.println("Enter the data for independent variable");
            xNumber = input.nextDouble();
        }
        System.out.println("Enter the data for dependent variable(Y) and 0 to stop");
        double yNumber = input.nextDouble();
        while (yNumber != 0){
            regressionCalculator.collect_Y_Data(List.of(yNumber));
            System.out.println("Enter the data for independent variable");
            yNumber = input.nextDouble();
        }
    }
    public double modelCreated(){
        System.out.println("What is your intercept? ");
        double intercept = input.nextDouble();

        System.out.println("What is your slope? ");
        double slope = input.nextDouble();

        System.out.println("What is your X_Variable? ");
        double independentVariable = input.nextDouble();
        return regressionCalculator.testModel(intercept, slope, independentVariable);
    }
}
