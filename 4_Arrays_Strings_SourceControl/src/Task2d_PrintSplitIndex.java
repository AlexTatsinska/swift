
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
public class Task2d_PrintSplitIndex {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int[] arr = new int[number];
        int arrSum = 0;        
        int possition=0;
        int sum = 0;
        int sum1=0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            arrSum=arrSum+arr[i];
        }
        System.out.println(arrSum);
        for(int i=(arr.length-1);i>1;i--){
            sum=sum+arr[i];
                     
            if(i!=(arr.length-1)){
            for(int j=0;j<i;j++){
                sum1=sum1+arr[j];
                
                if(sum==sum1){ 
                    if(sum!=arrSum){
                    
              possition=j;
            
            }
            }
            
            }
            }
            
            
            
        }
          System.out.println(possition);
            
        /*
        for(int i=0;i<arr.length;i++){
            if (i==0){
                sum=arr[i];
            }
            else{
                sum=sum+arr[i];
                for (int j=i-1;j<leftSum.length;j++)
                {
                    leftSum[j]=sum;
                   // System.out.print(leftSum[j]);
                }
            }
        }
        sum=0;
        for(int i=arr.length-1;i>=0;i--){
            if (i!=(arr.length-1)){               
                sum=sum+arr[i];
                for (int j=0;j<rightSum.length;j++)
                {
                    rightSum[j]=sum;
                   // System.out.print(leftSum[j]);
                }
            }
            else{
                 sum=arr[i];
            }
        }
        for(int i=0;i<leftSum.length;i++){
            System.out.print(leftSum[i]);
        
           // System.out.print(rightSum[i]);
        }
       System.out.println();
         for(int i=0;i<leftSum.length;i++){
            System.out.print(rightSum[i]);

         }*/
    }

}
