/**
 * PostFixCalculator.java
 * Copyright (c) Emeri Joe Dingal 2018
 */
package edu.ics211.h06;

import java.util.Stack;
import edu.ics211.h06.TextIO;

/**
 * A PostFix Calculator
 * 
 * @author Emeri Joe Dingal. TextIO written by David Eck. Help from Paul Sneider, Dr. Moore, Worked with Kade Shiroma,
 * Kason Shiroma, Russel Alegre
 *
 */
public class PostFixCalculator {
  private static PostFixCalculator instance;


  /**
   * Main allows for user input for a Postfix calculator
   * 
   * @param args not used
   */
  public static void main(String[] args) {
    System.out.println("WELCOME TO THE POST FIX CALCULATOR \n");
    boolean keepGoing = true;
    Number calculated = null;
    do {
      System.out.println("What would you like to calculate?");
      String expression = TextIO.getln();
      try {
        PostFixCalculator x = PostFixCalculator.getInstance();
        calculated = x.calculate(expression);
      }
      catch (InvalidExpressionException e) {
        System.out.println("INVALID EXPRESSION!");
        ;
      }
      System.out.print("The answer is: ");
      System.out.println(calculated);
      System.out.println("Type \"YES\" to continue");
      String check = TextIO.getlnWord();
      if (check.equals("YES")) {
        keepGoing = true; 
        calculated = null; // reset calculator
      }
      else {
        keepGoing = false;
      }
    }
    while (keepGoing == true);
  } // end main


  /**
   * Singleton of the PostFixCalculator
   * 
   * @return instance
   */
  public static PostFixCalculator getInstance() {
    if (instance == null) {
      instance = new PostFixCalculator();
    }
    return instance;
  }


  /**
   * Calculates the answer to the postfix expression and return the result as a Number.
   * 
   * @param expression a String the postfix expression.
   * @return the result of the postfix expression as a Number.
   * @throws InvalidExpressionException if the expression isn't valid postfix.
   */
  public static Number calculate(String expression) throws InvalidExpressionException {
    Stack<Number> stack = new Stack<Number>();
    // push first two numbers
    String[] nums = expression.split(" "); // split expression by spaces

    for (int i = 0; i < nums.length; i++) { // begin looping through expression
      switch (nums[i]) { // begin switch statement
      case "+":
        if (stack.empty()) {
          throw new InvalidExpressionException();
        }
        Number numR = stack.pop(); // pop off number
        if (stack.empty()) {
          throw new InvalidExpressionException();
        }
        Number numL = stack.pop(); // pop off number
        if (numR instanceof Integer && numL instanceof Integer) { // check if doing int math
          Number result = (int) numL + (int) numR;
          stack.push(result);
        }
        else if (numR instanceof Integer && numL instanceof Double) {
          Number result = (double) numL + (int) numR;
          stack.push(result);
        }
        else if (numR instanceof Double && numL instanceof Integer) {
          Number result = (int) numL + (double) numR;
          stack.push(result);
        }
        else if (numR instanceof Double && numL instanceof Double) { // do double math
          Number result = (double) numL + (double) numR;
          stack.push(result);
        }
        break;
      case "-":
        if (stack.empty()) {
          throw new InvalidExpressionException();
        }
        numR = stack.pop(); // pop off number
        if (stack.empty()) {
          throw new InvalidExpressionException();
        }
        numL = stack.pop(); // pop off number
        if (numR instanceof Integer && numL instanceof Integer) { // check if doing int math
          Number result = (int) numL - (int) numR;
          stack.push(result);
        }
        else if (numR instanceof Integer && numL instanceof Double) {
          Number result = (double) numL - (int) numR;
          stack.push(result);
        }
        else if (numR instanceof Double && numL instanceof Integer) {
          Number result = (int) numL - (double) numR;
          stack.push(result);
        }
        else if (numR instanceof Double && numL instanceof Double) { // do double math
          Number result = (double) numL - (double) numR;
          stack.push(result);
        }
        break;
      case "*":
        if (stack.empty()) {
          throw new InvalidExpressionException();
        }
        numR = stack.pop(); // pop off number
        if (stack.empty()) {
          throw new InvalidExpressionException();
        }
        numL = stack.pop(); // pop off number
        if (numR instanceof Integer && numL instanceof Integer) { // check if doing int math
          Number result = (int) numL * (int) numR;
          stack.push(result);
        }
        else if (numR instanceof Integer && numL instanceof Double) {
          Number result = (double) numL * (int) numR;
          stack.push(result);
        }
        else if (numR instanceof Double && numL instanceof Integer) {
          Number result = (int) numL * (double) numR;
          stack.push(result);
        }
        else if (numR instanceof Double && numL instanceof Double) { // do double math
          Number result = (double) numL * (double) numR;
          stack.push(result);
        }
        break;
      case "/":
        if (stack.empty()) {
          throw new InvalidExpressionException();
        }
        numR = stack.pop(); // pop off number
        if (stack.empty()) {
          throw new InvalidExpressionException();
        }
        numL = stack.pop(); // pop off number
        if (numR instanceof Integer && numL instanceof Integer) { // check if doing int math
          Number result = (int) numL / (int) numR;
          stack.push(result);
        }
        else if (numR instanceof Integer && numL instanceof Double) {
          Number result = (double) numL / (int) numR;
          stack.push(result);
        }
        else if (numR instanceof Double && numL instanceof Integer) {
          Number result = (int) numL / (double) numR;
          stack.push(result);
        }
        else if (numR instanceof Double && numL instanceof Double) { // do double math
          Number result = (double) numL / (double) numR;
          stack.push(result);
        }
        break;
      default: // push number
        if (nums[i].indexOf(".") == -1) { // no decimals, push int
          int number = (int) Integer.valueOf(nums[i]);
          stack.push(number);

        }
        else { // decimals exist, push double
          double number = (double) Double.valueOf(nums[i]);
          stack.push(number);
        }
        break;
      } // end switch statement
    } // end for loop
    Number r = stack.pop(); // should be last number in stack
    if (!stack.isEmpty()) {
      throw new InvalidExpressionException();
    }
    return r;
  }

}
