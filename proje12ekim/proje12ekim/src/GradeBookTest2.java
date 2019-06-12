/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pelin
 */
public class GradeBookTest2
 {
 public static void main( String[] args )
 {
 // create GradeBook object myGradeBook and
 // pass course name to constructor
 GradeBook2 myGradeBook = new GradeBook2(
 "CS101 Introduction to Java Programming" );

 myGradeBook.displayMessage(); // display welcome message
 myGradeBook.inputGrades(); // read grades from user
myGradeBook.displayGradeReport();

 } // end main
 } // end class GradeBookTest
