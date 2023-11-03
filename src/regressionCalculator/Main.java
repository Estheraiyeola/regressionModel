package regressionCalculator;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static RegressionCalculator regressionCalculator = new RegressionCalculator();
    private Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Main main = new Main();
        main.collectVariables();
        regressionCalculator.drawTable();
        main.modelCreated();
    }

    public void collectVariables(){
        collect_X_Variables();
        collect_Y_Variables();


    }

    private void collect_Y_Variables() {
        try {
            System.out.println("Enter the data for independent variable (Y) and 0 to stop");

            while (true) {
                String userInput = input.next();

                if (userInput.equals("0")) {
                    break; // User entered 0, exit the loop
                }

                try {
                    double yNumber = Double.parseDouble(userInput);
                    regressionCalculator.collect_Y_Data(List.of(yNumber));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number or 0 to stop.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number or 0 to stop.");
            collect_Y_Variables();
        }
    }

    private void collect_X_Variables() {
        try {
            System.out.println("Enter the data for independent variable (X) and 0 to stop");

            while (true) {
                String userInput = input.next();

                if (userInput.equals("0")) {
                    break; // User entered 0, exit the loop
                }

                try {
                    double xNumber = Double.parseDouble(userInput);
                    regressionCalculator.collect_X_Data(List.of(xNumber));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number or 0 to stop.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number or 0 to stop.");
            collect_X_Variables();
        }
    }

    public void modelCreated() throws InputMismatchException{
        try {
            System.out.println("What is your independent variable? ");
            String independentVariable = input.next();
            try {
                double independentVariableConverted = Double.parseDouble(independentVariable);
                System.out.println("Your dependent variable is " + regressionCalculator.testModel(independentVariableConverted));

            }catch (NumberFormatException e){
                System.out.println("Invalid input. Please enter a valid number");
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid input. Please enter a valid number");
            modelCreated();
        }

    }
}
