import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by ignacioojanguren on 2/11/16.
 */
public class Palindrome {

    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        String expression = "";

        do{
            System.out.println("Introduce a sentence to analyze: ");
            expression = s.nextLine();
            if(!isPalindrome(expression)){
                System.out.println("The expression: '" + expression + "' is NOT a palindrome");
            }else{
                System.out.println("The expression: '" + expression + "' is a palindrome");
            }
        }while(!expression.equals(""));

    }

    public static boolean isPalindrome(String expression){
        Queue<Character> queue = new LinkedList<Character>();
        Stack<Character> stack = new Stack<Character>();
        char letter;
        int front, rear;

        for(int i = 0; i < expression.length(); i++){
            letter = expression.charAt(i);
            if(Character.isLetter(letter)){
                queue.add(letter);
                stack.push(letter);
            }
        }

        while(!queue.isEmpty()){
            if(queue.remove() != stack.pop()) return false;
        }
        return true;

    }

}
