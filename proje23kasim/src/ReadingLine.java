/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pelin
 */
import java.io.*;
 // klavyeden girilen stringi satır olarak okur
class ReadingLine{
	public static String SatiriOku()
	{
		String s = "";
		try {
	InputStreamReader a = new InputStreamReader(System.in);// neyin okunacagini belirtiriz
BufferedReader buf = new BufferedReader(a);// okunan veri bu bufferda depolanacak
	s = buf.readLine();
		} catch (Exception e) {
	System.out.println("Error! Exception: "+e); 
		}
		return s;
	}
	
	public static void main(String[] args)
	{
		System.out.print("Hello, what's your name? ");
		String name=SatiriOku();
		System.out.println("Hello "+name+"!");
		System.out.println("");
	}
}

