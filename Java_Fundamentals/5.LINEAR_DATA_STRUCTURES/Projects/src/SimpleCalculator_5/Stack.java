package SimpleCalculator_5;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

//judge - 100%
//2 + 5 + 10 - 2 - 1

public class Stack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();

        Collections.addAll(stack,input);


        while(stack.size() > 1){
            int firstNum = Integer.parseInt(stack.pop());
            String op = stack.pop();
            int secondNum = Integer.parseInt(stack.pop());


            if(op.equals("+")){
                stack.push(firstNum + secondNum + "");
            }else{
                stack.push(firstNum - secondNum + "");
            }
        }
        
        System.out.println(stack.pop());

    }
}
