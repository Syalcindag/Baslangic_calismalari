/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongodbexample;
import com.mongodb.client.*; 
import com.mongodb.MongoClient; 
import com.mongodb.MongoCredential;  

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 *
 * @author Sefa
 */
public class MongoDbExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creating a Mongo client 
       // Creating a Mongo client 
   // Creating a Mongo client 
      MongoClient mongo = new MongoClient("localhost", 27017);
   
      // Creating Credentials 
//      MongoCredential credential; 
//      credential = MongoCredential.createCredential("sampleUser", "myDb", 
//         "password".toCharArray()); 
//      System.out.println("Connected to the database successfully");  
//      
//      // Accessing the database 
//      MongoDatabase database = mongo.getDatabase("myDb"); 
//      System.out.println("Credentials ::"+ credential);     
   } 
  
   
    }
    

