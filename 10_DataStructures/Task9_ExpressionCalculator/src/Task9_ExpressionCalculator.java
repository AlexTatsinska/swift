
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexT
 */
public class Task9_ExpressionCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();        
        Queue<Character> expression = new ArrayDeque<>();
        char[] expArray = input.toCharArray();
        double a;
        double result=0;
        
        for(int i=0;i<expArray.length;i++){
            expression.add(expArray[i]);
        }
        while(!expression.isEmpty()){
            if(expression.peek()=='('){
                System.out.println(reulstOfExpressionInBrecket(expression));
                            
                        }
                    }
                
            
        }
    static private double reulstOfExpressionInBrecket(Queue<Character> expression){
        double result = 0;
        
        while(expression.peek()!=')'){
            if(expression.peek()!='+'||expression.peek()!='-'||expression.peek()!='*'||expression.peek()!='/'||expression.peek()!='^'){                        
                        result = result+(double)expression.peek();
                        expression.poll();
                    } else{
                        switch(expression.peek()){
                            case '+':
                                expression.poll();
                                result = result+(double)expression.peek();
                                expression.poll();
                            case '-':
                                expression.poll();
                                result = result-(double)expression.peek();
                                expression.poll();
                            case '*':
                                expression.poll();
                                result = result*(double)expression.peek();
                                expression.poll();
                            case '/':
                                expression.poll();
                                result = result/(double)expression.peek();
                                expression.poll();
                        }
                            
                        }
        }
            
        return result;
    }   
}
