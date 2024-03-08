package ert;
import java.util.Scanner;
import java.util.Stack;

public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            if (token.equals("+")) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                stack.push(operand1 + operand2);
            } else if (token.equals("-")) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                stack.push(operand1 - operand2);
            } else if (token.equals("*")) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                stack.push(operand1 * operand2);
            } else if (token.equals("/")) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                stack.push(operand1 / operand2);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReversePolishNotation calculator = new ReversePolishNotation();
        
        System.out.println("Enter the expression in Reverse Polish Notation (RPN), separate each token with space:");
        String input = scanner.nextLine();
        String[] expression = input.split(" ");
        
        int result = calculator.evalRPN(expression);
        System.out.println("Result: " + result);
        
        scanner.close();
    }
}
