/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pelin
 */
public class ZincirlemeHata {
    public static void main(String argv[]){
      try{
        System.out.println("main try method1 oncesi");
        method1();
        System.out.println("main try method1 sonrasi");
      }
      catch(Exception ex){
        System.out.println("main catch");
      }
    }    
    public static void method1() throws Exception{
        try{
          method2();}
       catch(Exception ex){
       System.out.println("method1 catch throwdan once");
       throw new Exception();
    }
    }
     public static void method2() throws Exception{
        try{
           method3();}
        catch(Exception ex){
          System.out.println("method2 catch throwdan once");
          throw new Exception();}
    }
      public static void method3() throws Exception{
          System.out.println("method3 throwdan once");
               throw new Exception();
       }
    }


