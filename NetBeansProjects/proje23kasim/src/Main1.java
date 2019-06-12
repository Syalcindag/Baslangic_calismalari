/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pelin
 */
public class Main1 {
  public static void main(String[] args) {
    try {
          int array[] = new int[100];
          array[100] = 100; 
          array[5]=40/0; 
          
        } 
    //catch (ArithmeticException e) {
      //      System.out.println("Matematiksel Hata");
        //}
    catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Dizi elemanı fazla girildi"+e.getMessage());
        } 
         catch (Exception e) {
            System.out.println("başka Bir Hata oluştu");
        }
}}
