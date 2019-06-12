/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otomasyon;

/**
 *
 * @author Sefa
 */
public class Dersler implements Menüler{
    String matematik, fizik, algoritma, bmg, olasılık;

    @Override
    public void menü() {
        System.out.println("1-> matematik\n"
                + "2-> fizik\n"
                + "3-> algoritma\n"
                + "4-> bmg\n"
                + "5-> olasılık");
    }
    
    
    
    
}
