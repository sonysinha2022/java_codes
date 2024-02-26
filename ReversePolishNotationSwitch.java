package ert;

import java.util.Scanner;
import java.util.Stack;

public class ReversePolishNotationSwitch {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int operand2 = stack.pop();
                    int operand1 = stack.pop();
                    stack.push(operand1 - operand2);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int divisor = stack.pop();
                    int dividend = stack.pop();
                    stack.push(dividend / divisor);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        
        return stack.pop();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReversePolishNotationSwitch calculator = new ReversePolishNotationSwitch();
        
        System.out.println("Enter the expression in Reverse Polish Notation (RPN), separate each token with space:");
        String input = scanner.nextLine();
        String[] expression = input.split(" ");
        
        int result = calculator.evalRPN(expression);
        System.out.println("Result: " + result);
        
        scanner.close();
    }
}
