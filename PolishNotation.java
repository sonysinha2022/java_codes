package ert;

import java.util.Scanner;
import java.util.Stack;

public class PolishNotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the arithmetic expression in Polish Notation:");
        String[] expression = scanner.nextLine().split("\\s+");
        int result = evaluate(expression);
        System.out.println("Result: " + result);
    }

    public static int evaluate(String[] expression) {
        Stack<Integer> stack = new Stack<>();
        for (String token : expression) {
            switch (token) {
                case "+":
                    int operand2 = stack.pop();
                    int operand1 = stack.pop();
                    stack.push(operand1 + operand2);
                    break;
                case "-":
                    operand2 = stack.pop();
                    operand1 = stack.pop();
                    stack.push(operand1 - operand2);
                    break;
                case "*":
                    operand2 = stack.pop();
                    operand1 = stack.pop();
                    stack.push(operand1 * operand2);
                    break;
                case "/":
                    operand2 = stack.pop();
                    operand1 = stack.pop();
                    stack.push(operand1 / operand2);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
