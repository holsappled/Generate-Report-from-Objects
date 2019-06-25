/**
* Class to create a GradeItem object. 
*  
* @author Roscoe Welch
* @version 2/13/2019
*/

import java.util.Objects;

public class GradeItem {
   
   private String studentId;   // Student ID
   private int gradeItem;      // Grade ID
   private String courseId;    // Course ID
   private String itemType;    // Assignment Type
   private String date;        // Date yyyymmdd
   private int maxScore;       // Maximum Grade Score
   private int actualScore;    // Actual Grade Score
   
   // Item type choices
   String itemTypeArray[] = {"HW", "Quiz", "Class Work", "Test", "Final"};
   // To keep track of item type matching
   boolean validItemType = false;
   
   
   //*************************************************************************
   
   
   /**
   * GradeItem
   * Default Constuctor - sets varribles to null.
   */
      
   // Default constructor
   public GradeItem() {
      
      studentId = "";
      gradeItem = 0;
      courseId = "";
      itemType = "";
      date = "";
      maxScore = -1;
      actualScore = -1;
   } // End default constuctor 
   
   
   //*************************************************************************    
   
   
   /**
   * GradeItem 
   * Constructor to set all fields
   * Checks if fields are blank
   * Checks if scores are in a valid range
   *
   * @param inputStudentId, String for Student's ID
   * @param inputGradeItem, int for GradeItem ID
   * @param inputCourseId, String for ID of course
   * @param inputItemType, String for type of item 
   *                       (HW, Quiz, Class Work, Test, Final)
   * @param inputDate, String for date of GradeItem
   * @param inputMaxScore, int for GradeItem's max score
   * @param inputActualScore, int for GradeItem actual score  
   */
   
   // Constuctor - Checks: blank fields, valid item type, valid score values  
   public GradeItem(String inputStudentId, int inputGradeItem,
                    String inputCourseId, String inputItemType,
                    String inputDate, int inputMaxScore, 
                    int inputActualScore) {
      
      studentId = inputStudentId;
      gradeItem = inputGradeItem;
      courseId = inputCourseId;
      itemType = inputItemType;
      date = inputDate;
      maxScore = inputMaxScore;
      actualScore = inputActualScore;
      
      // Compare itemType to choices 
      for (int i = 0; i < itemTypeArray.length; i++) {
            if (itemType.equals(itemTypeArray[i])) {
               validItemType = true;
               break;
            }  
      }
      
      if (studentId.equals("") ||          
         courseId.equals("") ||        
         date.equals("") ||
         maxScore < 1 ||
         actualScore > maxScore ||
         actualScore < -1 ||      
         !validItemType) {
          
         throw new IllegalArgumentException("Invalid data:\n"
                                          + "All following fields must "
                                          + "not be blank. \n"
                                          + "(Student Id, Course Id, "
                                          + "Item Type, Date)\n"
                                          + "Item type must be one of the "
                                          + "following (case sensitive): \n"
                                          + "(HW, Quiz, Class Work, "
                                          + "Test, Final)\n"
                                          + "Max Score must be more than 1.\n"
                                          + "Actual Score must be a value "
                                          + "between 0 and maxScore."); 
      }
      
   } // End GradeItem
   
   
   //*************************************************************************   
   
   
   // Getters
   
   /**
   * getStudentId 
   *
   * @return studentId - String with Student's id
   */
   
   public String getStudentId() {
      return studentId;
   }
   
   
   //*************************************************************************
   
   
   /**
   * getGradeItem
   * 
   * @return gradeItem - int id for gradeItem
   */
   
   public int getGradeItem() {
      return gradeItem;
   }
   
   
   //*************************************************************************
   
   
   /**
   * getCourseId
   * 
   * @return courseId - String with the courseId for gradeItem
   */
   
   public String getCourseId() {
      return courseId;
   }
   
   
   //*************************************************************************
   
   
   /**
   * getItemType
   * 
   * @return itemType - String with the item type of gradeItem
   */
   
   public String getItemType() {
      return itemType;
   }
   
   
   //*************************************************************************
   
   
   /**
   * getDate
   *
   * @return date - String with date of gradeItem (yyyymmdd)
   */
   
   public String getDate() {
      return date;
   }
   
   
   //*************************************************************************
   
   
   /**
   * getMaxScore 
   *
   * @return maxScore - Integer with max grade score
   */
   
   public int getMaxScore() {
      return maxScore;
   }
   
   
   //*************************************************************************
   
   
   /**
   * getActualScore 
   *
   * @return actualScore - Integer with actual grade score
   */
   
   public int getActualScore() {
      return actualScore;
   } // end getters
   
   
   //*************************************************************************
   
   
      @Override
    public int hashCode() {
        int hash = 3;
        hash += 97 * hash + Objects.hashCode(this.studentId);
        hash += 97 * hash + Objects.hashCode(this.gradeItem);
        hash += 97 * hash + Objects.hashCode(this.courseId);
        hash += 97 * hash + Objects.hashCode(this.itemType);
        hash += 97 * hash + Objects.hashCode(this.date);
        hash += 97 * hash + Objects.hashCode(this.maxScore);
        hash += 97 * hash + Objects.hashCode(this.actualScore);
        return hash;
    } // End hashCode
   
   
   //*************************************************************************
   
   /**
   * Method equals
   * Compares to instances of GradeItem 
   *
   * @param gradeItemToCompare - GradeItem object
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
        GradeItem other = (GradeItem) obj;
      
      
      if (Objects.equals(this.studentId, other.studentId) &&
          this.gradeItem == other.gradeItem) {
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
      result = getStudentId() + 
               "," + getGradeItem() +
               "," + getCourseId() +
               "," + getItemType() +
               "," + getDate() +
               "," + getMaxScore() +
               "," + getActualScore();
      return result;
   } // end toString method
   
   
   //*************************************************************************

} // end class