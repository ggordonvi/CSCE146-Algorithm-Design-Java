import java.util.*;

public class RPNCalc {
    private static Stack<Integer> stack = new Stack<Integer>();
    private static Scanner input = new Scanner(System.in);


    public static void calculator() throws Exception {

        System.out.println("Welcome to the RPN Calculator program!");

        takeInput();
    }

    private static void takeInput() {
        String numOrOperand = " ";
        while (!numOrOperand.equals("x")) {
            System.out.println("Enter next input: ");
            numOrOperand = input.next();
            try {
                int intNumOrOperand = Integer.valueOf(numOrOperand);
                stack.push(intNumOrOperand);
            } catch (Exception e) {
                if (numOrOperand.equals("*")) {
                    stack.push(stack.pop() * stack.pop());

                } else if (numOrOperand.equals("/")) {
                    stack.push((int) stack.pop() / stack.pop());

                } else if (numOrOperand.equals("+")) {
                    stack.push(stack.pop() + stack.pop());

                } else if (numOrOperand.equals("-")) {
                    stack.push(stack.pop() - stack.pop());

                } else if (numOrOperand.equals("=")) {
                    System.out.println(stack.pop());

                } else if (numOrOperand.equals("c")) {
                    if (!stack.empty()) {
                        for (int i = 0; i < stack.size(); i++) {
                            stack.pop();
                        }
                    }
                } else if (numOrOperand.equals("w")) {
                    for (int i = 0; i < stack.size(); i++) {
                        System.out.println(stack.get(i));
                    }
                }
            }

        }
    }



    public static void main(String[] args) {
        try {
            calculator();
        } catch (Exception e) {
            System.out.println("Oops, that doesn't work... ");
        }

    }
}