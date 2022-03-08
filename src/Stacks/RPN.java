
import java.io.*;
import java.util.*;
import java.util.Stack;


public class RPN {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        Stack<String> calcStack = new Stack<String>();
        Scanner sc = new Scanner(System.in);


        
        System.out.println(stack);
        do {
            String str = sc.nextLine();
            stack.push(str);
            calcStack.push(str);

            if(stack.peek().equals("+") || stack.peek().equals("-") || stack.peek().equals("*") || stack.peek().equals("/")) {
                calculate(calcStack);
            }
            if(stack.size() == 0) {
                return;
            }
            
        } while(!stack.peek().equals("Q") && !stack.peek().equals("q"));
        stack.pop();


        calcStack.pop();
        System.out.println(stack + " = " + calcStack);


        


    }

    public static Stack<String> calculate(Stack<String> stack) {
        if(stack.peek().equals("Q") || stack.peek().equals("q")); {
            //stack.pop();
        }

        Stack<String> originalStack = stack;

        String operator = stack.pop();        

        if(operator.equals("+")) {
            int num1 = Integer.parseInt(stack.pop());
            int num2 = Integer.parseInt(stack.pop());
            String str = Integer.toString(num1 + num2);

            //System.out.println("CALC: " + num1 + " + " + num2 + " = " + str);

            originalStack.push(str);
            return originalStack;

        }
        if(operator.equals("-")) {
            int num2 = Integer.parseInt(stack.pop());
            int num1 = Integer.parseInt(stack.pop());
            String str = Integer.toString(num1 - num2);

            //System.out.println("CALC: " + num1 + " - " + num2 + " = " + str);

            originalStack.push(str);
            return originalStack;

        }
        if(operator.equals("*")) {
            int num1 = Integer.parseInt(stack.pop());
            int num2 = Integer.parseInt(stack.pop());
            String str = Integer.toString(num1 * num2);

            //System.out.println("CALC: " + num1 + " * " + num2 + " = " + str);

            originalStack.push(str);
            return originalStack;

        }
        if(operator.equals("/")) {
            int divisor = Integer.parseInt(stack.pop());
            int dividend = Integer.parseInt(stack.pop());
            String str = Integer.toString(dividend / divisor);

            //System.out.println("CALC: " + dividend + " / " + divisor + " = " + str);

            originalStack.push(str);
            return originalStack;
        }
        return originalStack;
    }
    
}
