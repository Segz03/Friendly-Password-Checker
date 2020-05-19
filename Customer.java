// Customer Account Class
// Written by Francisco J Segarra Jr

public class Customer 
{
	// private data members
   private String firstName, lastName, title, userID, password;

		// set values to a Student
   public Customer(String fn, String ln, String t, String id, String pw)
   {
      firstName = fn;
      lastName = ln;
      title = t;
      userID = id;
      password = pw;
   	   
   } // end Customer
		
	   // setting the private data with set methods
	   // set first name of customer
   public void setFirstName(String fn)
   {
      firstName = fn;
      
   } // end setFirstName
		
	   // set the last name of customer
   public void setLastName(String ln)
   {
      lastName = ln;
      
   } // end setLastName
	   
	   // set the title of the customer
   public void setTitle(String t)
   {
      title = t;
      
   } // end setTitle
	   
	   // set the UserID of customer
   public void setUserID(String id)
   {
      userID = id;
      
   } // end setUserID
	   
	   // set the password of the customer
   public void setPassword(String pw)
   {
      password = pw;
      
   } // end setPassword
	   
	   
	   
	   // methods that return the private information
   public String getFirstName()
   {
      return firstName;
         
   } // end getFirstName
	   
   public String getLastName()
   {
      return lastName;
         
   } // end getLastName
	   
   public String getTitle()
   {
      return title;
         
   } // end getTitle
	   
   public String getUserID()
   {
      return userID;
         
   } // end getUserID
	   
   public String getPassword()
   {
      return password;
         
   } // end getPassword
	   
	   // to String method that returns a String message
   public String toString()
   {
      return firstName + " " + lastName + " " + title + " " + userID + " " + password;
      
   } // end toString
			
} // end Class
