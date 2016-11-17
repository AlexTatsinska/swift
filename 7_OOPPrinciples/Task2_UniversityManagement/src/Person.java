/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexT
 */
public abstract class Person {
   private String name;
   private String phone;
   private int tolerance;
    
   Person(String name, String phone){
       this.name=name;
       this.phone=phone;
       this.tolerance = 20;
   } 
   String getName(){
       return name;
   }
   String getPhone(){
       return phone;       
   }
   int getTolerance(){
       return tolerance;
   }
   int setToleranceUp(int toleranceChange){
       tolerance = tolerance+toleranceChange;
       return tolerance;
   }
   int setToleranceDown(int toleranceChange){
       tolerance = tolerance-toleranceChange;
       return tolerance;
   }
    
}
