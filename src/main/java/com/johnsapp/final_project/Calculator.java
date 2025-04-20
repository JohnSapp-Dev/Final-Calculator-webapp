package com.johnsapp.final_project;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Calculator {

    static Scanner UserSelection = new Scanner(System.in);
    static boolean exit = false;

    /**
     * This method prints a menu to the screen for the user to pick from
     * The user input is passed to <code>isInteger</code> for error handling
     * @return int returns the user selected option*/
    public static int menu(){
        System.out.println("\t 1 - Add two numbers");
        System.out.println("\t 2 - Subtract two numbers");
        System.out.println("\t 3 - Multiply two numbers");
        System.out.println("\t 4 - Divide two numbers");
        System.out.println("\t 5 - Exit");
        String input = UserSelection.nextLine();

        while(!isValidInteger(input,1,5)) {
            input = UserSelection.nextLine();
        }
        return Integer.parseInt(input);
    }

    /**
     * This method checks if a passed string will convert to an integer and is
     * within a passed min and max value
     * @param str String this is the value that is checked
     * @param min int this is the minimum exceptionable value
     * @param max int this is the maximum exceptionable value
     * @return boolean returns true if the string is an integer and within the range
     *                 false if not*/
    public static boolean isValidInteger(String str, int min, int max) {
        // boolean result = false;
        try{
            if(Integer.parseInt(str) >= min && Integer.parseInt(str) <= max){
                //System.out.println("in range");
                return true;
            }else{
                System.out.println("Input out of range, try again");
                return false;
            }
        }catch(NumberFormatException e){
            System.out.println("Enter a valid integer");
        }
        return false;
    }

    /**
     * This method checks if a passed string will convert to an integer and is
     * within a passed min and max value
     * @param str String this is the value that is checked
     * @param min float this is the minimum exceptionable value
     * @param max float this is the maximum exceptionable value
     * @return boolean returns true if the string is a float and within the range
     *                 false if not*/
    public static boolean isValidFloat(String str, float min, float max) {
        // boolean result = false;
        try{
            if(Float.parseFloat(str) >= min && Float.parseFloat(str) <= max){
                //System.out.println("in range");
                return true;
            }else{
                System.out.println("Input out of range, try again");
                return false;
            }
        }catch(NumberFormatException e){
            System.out.println("Enter a valid number");
        }
        return false;
    }

    /**
     * This method calls the selected method to complete the users need
     * @param selection int this value */
    public static void menuSwitch(int selection){
        switch(selection){
            case 1:
                System.out.println(addNumbers(inputData(),inputData()));
                break;
            case 2:
                System.out.println(subtractNumbers(inputData(),inputData()));
                break;
            case 3:
                System.out.println(multiplyNumbers(inputData(),inputData()));
                break;
            case 4:
                System.out.println(divideNumbers(inputData(),inputData()));
                break;
            case 5:
                System.out.println("Goodbye");
                exit = true;
                break;
        }
    }

    /**
     * This method takes the two passed values and adds them together
     * @param x float
     * @param y float*/
    public static float addNumbers(float x, float y){
        return x + y;
    }

    /**
     * This method takes the two passed values and subtracts them
     * @param x float
     * @param y float*/
    public static float subtractNumbers(float x, float y){
        return x - y;
    }

    /**
     * This method takes the two passed values and multiplies them together
     * @param x float
     * @param y float*/
    public static float multiplyNumbers(float x, float y){
        return x * y;
    }

    /**
     * This method takes the two passed values and divides them
     * @param x float
     * @param y float*/
    public static String divideNumbers(float x, float y){
        float answer = x / y;
        DecimalFormat df = new DecimalFormat("#.0000");
        return df.format(answer);
    }

    /**
     * This method asks the user for a valid float number and checks if the value is valid
     */
    public static float inputData(){
        System.out.println("Enter a number");
        String input = UserSelection.nextLine();

        while(!isValidFloat(input,Float.MIN_VALUE,Float.MAX_VALUE)) {
            input = UserSelection.nextLine();
        }
        return Float.parseFloat(input);
    }

    public static void main(String[] args) {
        while(!exit){
            menuSwitch(menu());
        }
    }
}