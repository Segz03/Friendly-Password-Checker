// The Friendly Password-Checker
// Written by Francisco J Segarra Jr

import java.util.Scanner;
import java.util.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.io.*;


public class Main 
{

   public static void main(String[] args) throws IOException
   {
   	// Scanner for user input
      Scanner kb = new Scanner(System.in);
   	
   	// Scanner for reading in text file
      File inFile = new File("accountData.txt");
      Scanner inputFile = new Scanner(inFile);
   	
   	// declaring the variables
      int size = 124, position;
      String firstName, lastName, title, userID, password;
      String kb_userID, kb_password;				
   	
   	// creating a Customer array
      Customer [] person = new Customer[size];
   		
   	// loop used to put the information in the objects of the array
      for (int i = 1 ; i < person.length; i++)
      {
         String line = inputFile.nextLine();
         Scanner s = new Scanner(line).useDelimiter(" ");	// splits elements with a space
           
         firstName = s.next();
         lastName = s.next();
         title = s.next();
         userID = s.next();
         password = s.next();
               
         person[i] =  new Customer (firstName, lastName, title, userID, password);
      		        
      } // end for Loop
   	
   	// user input for the ID being tested
      System.out.print("Enter the userid: ");
      kb_userID = kb.nextLine();
   	
   	// user input for the password being tested
      System.out.print("Enter the password: ");
      kb_password = kb.nextLine();
   		
   	// calling a validation method to return the position of the object
      position = loginValidation(person, kb_userID, kb_password);
      
   	// output statement if there are no or 1 mistake in the password or the userID
   	// it prints out the time of day, the persons title, and their last name 
      if (position != -1)
         System.out.println(time() + ", " + person[position].getTitle() + " " + person[position].getLastName());
   	
   	// out statement if there are more than 2 errors or the length of the passwords are different
      if (position == -1)
         System.out.println("No account with the given userID and password was found");
   	
   	// closes the file
      inputFile.close();
   } // end Main

	// method that checks the amount of mistakes for the userID and returns the position of the
	// object to be used in the print statements, along with keeping track of the mistakes in 
	// both the userID and password
   public static int loginValidation(Customer[] person, String inputID, String inputPW)
   {
   	// declare and initialize variables
      String userID, userPW;
      int val = 0, mistake = 0;
      boolean done = false;
   		
   	// loop that cycles through the objects to find the object
   	// with a matching userID and then saves the location of that
   	// in val to in order to check the password later
      for (int i = 1 ;( (i < person.length) && (!done) ); i++)
      {
    	  mistake = 0;
    	  userID = person[i].getUserID();
    	  userPW = person[i].getPassword();
      	
      	// checking the length of both inputs and private data types
         if ((userID.length() == inputID.length()) && (userPW.length() == inputPW.length()))
         {
 	
        	if (userID.equals(inputID) && userPW.equals(inputPW))
      	   	{
      		   val = i;
      		   done = true;
      	   	}
        	
        	else
        	{
        	 
        	 // checks the userId for errors and if only one 
            	// error is found it still passes val to password
               for (int j = 0; j < userID.length(); j++)
               {	
					if (userID.charAt(j) != inputID.charAt(j))
						mistake ++;
					
               } // end for loop
         
               for (int j = 0; j < userPW.length(); j++)
               {	
					if (userPW.charAt(j) != inputPW.charAt(j))
						mistake ++;
					
               } // end for loop
               
               if (mistake == 1)
				{
					val = i;
					done = true;
				}
               
               
        	} // end else
        	
         } // end if 	
         
      } // end for Loop
      
      if (mistake > 1)
      {
         val = -1;
      }
   	
      if (mistake == 1)
         System.out.println("Well, you were close - I'll let you in this time... ");
   	
      return val;
   	
   } // end Method
		
   public static String time()
   {
   	// finding the time of day
      Calendar cal = new GregorianCalendar();
      int hour = cal.get(Calendar.HOUR_OF_DAY);
      int min = cal.get(Calendar.MINUTE);	
      String time = "";
   	
      if (hour < 12)
         time ="Good Morning";
   	
      if ((hour >= 12) && (hour < 18))
         time = "Good afternoon";
   	
      if (hour >= 18)
         time = "Good evening";
   	
      return time;
   
   } // end Method
	
} // end Class
