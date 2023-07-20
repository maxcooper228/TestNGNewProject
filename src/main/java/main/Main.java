package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import static java.lang.Math.*;

public class Main {
    private final double a = 1.65;
    private double EPS = 1e-6;
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
     private void run() {
        try {
           double start = inputStart();
           double end = inputEnd();
           double step = inputStep();
           double[] arrayOfX = fillX(start, end, step);
           double[] arrayOfY = fillY(arrayOfX);
           displayMaxAndPosition(arrayOfY);
           displayMinAndPosition(arrayOfY);
           System.out.println("Sum of values of function is " + sum(arrayOfY) );
           System.out.println("Average value of function is " + avg(arrayOfY));


        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public double inputStart() throws IOException {
        System.out.println("Enter double number for start value of x: ");
        double start = Double.parseDouble(bufferedReader.readLine());

       return start;
    }
    public double inputEnd() throws IOException{
        System.out.println("Enter double number for end value of x: ");
        double end = Double.parseDouble(bufferedReader.readLine());
        return end;
    }
    public double inputStep() throws IOException{
        System.out.println("Enter double number for step value: ");
        double step = Double.parseDouble(bufferedReader.readLine());
        return step;
    }


    public double f(double x) {
        if (x < 1.3-EPS) return PI*x*x - (7/(x*x));
        if (x > 1.3+EPS) return Math.log(x + 7 * sqrt(abs(x + a)));
         return a * Math.pow(x, 3) + 7 * sqrt(x);
    }

    public int steps(double start, double end, double step) {
        return (int) round((end - start)/step + 1);
    }

    public double[] fillX(double start, double end, double step) {
        double[] x = new double[steps(start, end, step)];
        for (int i = 0; i < x.length; i++) {
            x[i] = start + i*step;
        }
        return x;
    }

    public double[] fillY(double[] x) {
        double[] y = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            y[i] = f(x[i]);
        }
        return y;
    }

    public double sum(double[] arr) {
        double result = 0;
        for (double x:arr) {
            result += x;
        }
        return result;
    }

    public double findMin(double[] arr) {
        double min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }

    public double findMax(double[] arr) {
        double max = 0;
        for (double x:arr) {
            max = Math.max(max, x);
        }
        return max;
    }

    public double avg(double[] arr) {
        double avg = sum(arr) / arr.length;

        return avg;
    }
    public void displayMaxAndPosition(double[] arr){
        double max = findMax(arr);
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max){
                index = i+1;
                break;
            }
        }

        System.out.println("Max value = " + max + " position = " + index);
    }
    public void displayMinAndPosition(double[] arr){
        double min = findMin(arr);
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min){
                index = i+1;
                break;
            }
        }

        System.out.println("Min value = " + min + " position = " + index);
    }
}