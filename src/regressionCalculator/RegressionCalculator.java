package regressionCalculator;

import java.util.ArrayList;
import java.util.List;

public class RegressionCalculator {
    private List<Double> storageX = new ArrayList<>();
    private List<Double> storageY = new ArrayList<>();
    private double x_Mean;
    private double y_Mean;
    private double slope;
    private double y_Intercept;


    public void collect_X_Data(List<Double> xVariables) {
        storageX.addAll(xVariables);
        System.out.println(storageX);
    }

    public void collect_Y_Data(List<Double> yVariables) {
        storageY.addAll(yVariables);
        System.out.println(storageY);
    }

    public List<Double> getX_Data() {
        return storageX;
    }

    public List<Double> getY_Data() {
        return storageY;
    }

    public void calculateX_Mean(List<Double> xData) {
        x_Mean = calculateMean(xData);
    }
    private double calculateMean(List<Double> storage){
        double total = 0;
        int counter = 0;
        double mean = 0;
        for (Double x : storage) {
            total += x;
            counter++;
        }
        mean = total / counter;
        return Double.parseDouble(String.format("%.2f",mean));
    }
    public void calculateY_Mean(List<Double> yData) {
        y_Mean = calculateMean(yData);
    }

    public double getX_Mean() {
        return x_Mean;
    }

    public double getY_Mean() {
        return y_Mean;
    }
    public double[][] drawTable(){
        calculateX_Mean(storageX);
        calculateY_Mean(storageY);
        int lengthOfTable = storageX.size();

        double[][] table = new double[lengthOfTable][6];
        collectIndependentVariable(storageX, table);
        collectDependentVariable(storageY, table);
        differenceBetweenIndependentVariableAndItsMean(storageX, table);
        differenceBetweenDependentVariableAndItsMean(storageY, table);
        productOfBothDifferences(table);
        squareOfTheDifferenceOfIndependentVariableAndItsMean(storageX, table);
        printTable(table);
        slope = calculateSlope(table);
        y_Intercept = calculateY_Intercept(x_Mean,y_Mean,slope);
        System.out.println("The slope is "+ slope);
        System.out.println("The intercept is "+y_Intercept);
        if (slope >=0) System.out.println("b is positive, an increase in X leads to an increase in Y");
        else System.out.println("b is negative, an increase in X leads to a decrease in Y");
        return table;
    }

    private void printTable(double[][] table) {
        System.out.println("""
                X\t\tY\t\tX-Mean\t\tY-Mean\t\t((X-Mean)(Y-Mean))\t\t(X-Mean)2""");
        for (int index = 0; index < table.length; index++) {
            for (int idx = 0; idx < table[index].length; idx++) {
                System.out.printf("%.2f\t",table[index][idx]);
            }
            System.out.println();
        }
    }

    public double calculateSlope(double[][] table) {
        double totalOfBothDifferences = 0;
        double totalOfSquaredIndependentVariable = 0;
        for (int index = 0; index < table.length; index++) {
            totalOfBothDifferences += table[index][4];
            totalOfSquaredIndependentVariable += table[index][5];
        }
        return Double.parseDouble(String.format("%.2f",totalOfBothDifferences / totalOfSquaredIndependentVariable));
    }

    private void squareOfTheDifferenceOfIndependentVariableAndItsMean(List<Double> storageX, double[][] table) {
        for (int index = 0; index < storageX.size(); index++) {
            table[index][5] = Double.parseDouble(String.format("%.2f",Math.pow(table[index][2], 2)));
        }
    }

    private void productOfBothDifferences(double[][] table) {
        for (int index = 0; index < storageX.size(); index++) {
            table[index][4] = Double.parseDouble(String.format("%.2f",table[index][2] * table[index][3]));
        }
    }

    private void differenceBetweenDependentVariableAndItsMean(List<Double> storageY, double[][] table) {
        for (int index = 0; index < storageY.size(); index++) {
            table[index][3] = Double.parseDouble(String.format("%.2f",storageY.get(index) - y_Mean));
        }
    }

    private void differenceBetweenIndependentVariableAndItsMean(List<Double> storageX, double[][] table) {
        for (int index = 0; index < storageX.size(); index++) {
            table[index][2] = Double.parseDouble(String.format("%.2f",storageX.get(index) - x_Mean));
        }
    }

    private static void collectDependentVariable(List<Double> storageY, double[][] table) {
        for (int index = 0; index < storageY.size(); index++) {
            table[index][1] = storageY.get(index);
        }
    }

    private static void collectIndependentVariable(List<Double> storageX, double[][] table) {
        for (int index = 0; index < storageX.size(); index++) {
            table[index][0] = storageX.get(index);
        }
    }


    public double calculateY_Intercept(double xMean, double yMean, double slope) {
        return Double.parseDouble(String.format("%.2f",yMean - slope * xMean));
    }

    public double testModel(double intercept, double slope, double independentVariable) {
        return Double.parseDouble(String.format("%.2f", y_Intercept + this.slope * independentVariable));
    }
}
