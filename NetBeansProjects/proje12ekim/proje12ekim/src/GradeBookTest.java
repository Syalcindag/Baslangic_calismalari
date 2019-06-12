/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pelin
 */
 import java.util.Scanner; // program uses Scanner

public class GradeBookTest
 {

 public static void main( String[] args )
 {
 
 Scanner input = new Scanner( System.in );
 GradeBook myGradeBook = new GradeBook();
 System.out.printf( "Initial course name is: %s\n\n",
 myGradeBook.getCourseName());

 System.out.println( "Please enter the course name:" );
 String theName = input.nextLine(); // read a line of text
 myGradeBook.setCourseName( theName );
 System.out.println(); // outputs a blank line

 myGradeBook.displayMessage();
 } // end main
 } // end class GradeBookTest