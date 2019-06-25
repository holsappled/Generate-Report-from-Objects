/**
* Class to create a Student object. 
*  
* @author Roscoe Welch
* @version 2/13/2019
*/
import java.util.Objects;

public class Student {
   
   private String id;         // Student ID
   private String firstName;  // Student First Name
   private String lastName;   // Student Last Name
   private String email;      // Student Email 
   
   
   //*************************************************************************
   
   
   /**
   * Student
   * Default Constuctor - sets varribles to null.
   */
   
   // Default constructor
   public Student() {
      id = "";
      firstName = "";
      lastName= "";
      email = "";   
   } // End default constructor
   
   
   //*************************************************************************
   
   
   /**
   * Student 
   * Constructor to set all fields
   * Checks if fields are blank
   * Checks if email has an @ sign
   *
   * @param inputId, String for Student's ID
   * @param inputFirstName, String for Student's first name
   * @param inputLastName, String for Student's last name
   * @param inputEmail, String for Student's email address
   */
   
   // Constuctor - Checks: blank fields, @ symbol in email 
   public Student(String inputId, String inputFirstName, String inputLastName,
                  String inputEmail) {
      
      id = inputId;
      firstName = inputFirstName;
      lastName = inputLastName;
      email = inputEmail;
      
      if (id.equals("") ||          
         firstName.equals("") ||    
         lastName.equals("") ||     
         email.equals("") ||        
         !email.contains("@")) {    
         
         throw new IllegalArgumentException("\nInvalid data:\n"
                                          + "All following fields "
                                          + "must not be blank.\n"
                                          + "(Student ID, First Name, "
                                          + "Last Name, Email) \n"
                                          + "Email must contain an "
                                          + "at \"@\" sign."); 
      } 
   
   } // end Constuctor
   
   
   //*************************************************************************
   
   
   /**
   * getId 
   *
   * @return id - String with Student's id
   */
   
   // Getters
   public String getId() {
      return id;
   }
   
   
   //*************************************************************************
   
   
   /**
   * getFirstName 
   *
   * @return firstName - String with Student's first name
   */
   
   public String getFirstName() {
      return firstName;
   } 
   
   
   //*************************************************************************
   
   
   /**
   * getLastName 
   *
   * @return lastName - String with Student's last name
   */
   
   public String getLastName() {
      return lastName;
   } 
   
   
   //*************************************************************************
   
   
   /**
   * getEmail
   *
   * @return email - String with Student's email
   */
   
   public String getEmail() {
      return email;
   } // end getters
   
   //*************************************************************************
   
   @Override
    public int hashCode() {
        int hash = 3;
        hash += 97 * hash + Objects.hashCode(this.id);
        hash += 97 * hash + Objects.hashCode(this.firstName);
        hash += 97 * hash + Objects.hashCode(this.lastName);
        hash += 97 * hash + Objects.hashCode(this.email);
        return hash;
    } // End hashCode
   
   //*************************************************************************
   
   
   /**
   * Method equals
   * Compares to instances of Student 
   *
   * @param studentToCompare - Student object
   *
   * @return true - if all fields match 
   * @return false - if any field is different
   */
   
   // Compares object, Checks if all fields match
   @Override
   public boolean equals(Object obj) {
      
      boolean isEqual = false;
        if (this == obj) {
            return true;
        }
        // Make sure the object is not null
        if (obj == null) {
            return false;
        }
        // Makes sure class types are equivalent
        if (getClass() != obj.getClass()) {
            return false;
        }

        // Cast the object to that of the same type as this object
        // Student would cast as Student, and GradeItem as GradeItem
        Student other = (Student) obj;
      
      
      if (Objects.equals(this.id, other.id)) {
          isEqual = true;
        }
        
        return isEqual;
      
      
   } // end equals method
   
   
   //*************************************************************************
   
   
   /**
   * Method toString
   * Converts fields into a formatted string 
   *
   * @return result - formatted string
   */
   
   
   // Returns object as string
   public String toString() {
      String result = "";
      result = getId()+ "," + getFirstName() + "," + 
               getLastName() + ","+ getEmail();
      return result;
   } // end toString method
   
   
   //*************************************************************************
   
} // end class           