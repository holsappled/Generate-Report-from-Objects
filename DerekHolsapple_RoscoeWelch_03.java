// ********************************************************************************
/**
* Class for main. Reads a student and grade file and writes a report file. 
*  
* This program will test the Student class and the GradeItem class.
* The program will utilize three .txt files that contain student
   and grade item data.
* The program will import the .txt file, convert each line into an object, 
   and create a output .txt file.
* The output report will show student information along with grade items
   throughout the semester.
   
* @author Roscoe Welch, Derek Holsapple
* @version 3/4/2019

* Sentient: adj., having or showing realization, perception, or knowledge : aware

* "Leadership is the art of getting someone else to do something 
*    you want done because he wants to do it." 
*  Dwight Eisenhower (October 14, 1890 - March 28, 1969)
*/
// ********************************************************************************

import java.io.*;
import java.util.*; 


public class DerekHolsapple_RoscoeWelch_03 {

   static Link< Student > listOfStudents;
   static Link< GradeItem > listOfGradeItems;
   static String INPUT_FILE;
   static String OUTPUT_FILE;
   static Student studentAddObject;
   static GradeItem gradeItemAddObject;
   static Student studentDeleteObject;
   static GradeItem gradeItemDeleteObject;
   
   static Scanner input;
   List< Integer > maxScore = new ArrayList< Integer >();
   int maxScoreSum;
   List< Integer > actualScore = new ArrayList< Integer >();
   int actualScoreSum;

   
// ********************************************************************************
/**
   * Method main
   * The main method creates a student and grade item list, calls a process 
         to read a input file, and calls a method to write output file. 
   
   * @param INPUT_FILE        String, path of file being read.
   * @param OUTPUT_FILE       String, path of file being written.
   
   * @param inputDataFile     File, text input file.
   * @param inputdata         String[], Store input data from file
   * @param indexLineArray    String[], splits the line into an array
   
   * @param listOfStudents    List, list of students
   * @param listOfGradeItems  List, list of grade items
   
   */
// ********************************************************************************
   
   public static void main(String[] args) throws IOException {
      

      int max = 9;                            // Max items to be held by input
      String[] inputData = new String[ max ]; // Store input data from file
      File inputDataFile;                     // File
      Scanner input;                          // Read file
      PrintWriter output;                     // Write file
      String indexLine = "";                  // Read the line in file
      int lineRead = 0;                       // To count lines read
        
      // Split the line into array
      String[] indexLineArray = new String[ max ];
            
      // Create the input and output files      
      final String INPUT_FILE = "project_03_Input01.txt";
      final String OUTPUT_FILE = "project_03_Output01.txt";  
      
      // Reference the input file
      inputDataFile = new File( INPUT_FILE );
      
      // Create the student and grade item lists   
      listOfStudents = new Link<>();
      listOfGradeItems = new Link<>();
      
      // Process the incoming data
      processInput( INPUT_FILE , inputDataFile );
      
      // Generate a summary report of each student
      generateReport();
      
      } // end main



// ********************************************************************************
/**
   * Method processInput
   
   * This method reads data into an array, checks if first term is STUDENT or
          GRADE ITEM, and catches file and class exceptions.
   * Another feature is that it calls Student or Grade item process to 
          create  a list. 
   *
   * @param INPUT_FILE        String, Path of file being read.
   * @param inputDataFile     File, text input file.
   */
// ********************************************************************************
   
   public static void processInput( String INPUT_FILE , File inputDataFile )
                                   throws IOException {
      int max = 9;
      String indexLine = "";                  // Read the line in file
      int lineRead = 0;                       // To count lines read
        
      // Split the line into array
      String[] indexLineArray = new String[ max ];
      
      try {
         input = new Scanner( inputDataFile );  
      }
      catch( FileNotFoundException e ) {
         System.err.println( "File " + INPUT_FILE + " not found." );
         System.exit(0);
      }
      
      System.out.println( "Reading data from file " + INPUT_FILE );
      
      while( input.hasNextLine() ) {
         
         indexLine = input.nextLine();
         indexLineArray = indexLine.split( "," );
         lineRead++ ;
         
         if( indexLineArray[0].equals( "STUDENT" ) ) {
            processStudentData( indexLineArray, lineRead );
         }
         else if( indexLineArray[ 0 ].equals( "GRADE ITEM" ) ) {
            processGradeItem( indexLineArray , lineRead );
         }
         else {
            System.err.println( "First term on line: " + lineRead + " was " + 
                               indexLineArray[0] + ".\n First term must be " + 
                               "either \"STUDENT\" " + "or \"GRADE ITEM\" " + 
                               "to continue." );
         }
    
      } //end while loop
            
   } // end processInput

// ********************************************************************************
 /**
   * Method processStudentData
   
   * This method brings data into a list, catchs class exception, and checks if
          adding or deleting from list. 
   *
   * @param indexLineArray        String, array of data for student list.
   
   * @param lineRead              Int, used To display what line an error was on.
   */
// ********************************************************************************
  
   public static void processStudentData( String[] indexLineArray ,
                                         int lineRead ) {
            
      if ( indexLineArray[ 1 ].equals( "ADD" ) ){
         try {   
            // Instantiate 'ADD' student constructor
            studentAddObject = new Student( indexLineArray[ 2 ] ,
                                            indexLineArray[ 3 ] , 
                                            indexLineArray[ 4 ] ,
                                            indexLineArray[ 5 ] );
         }
         catch ( IllegalArgumentException e ) {
            System.err.println( "\nError On line #" + lineRead 
                                + " " + e + "\n" );
            return;
         }
            
                    
         if( listOfStudents.contains( studentAddObject ) ) {
            
            System.out.println( "Student with ID: " + studentAddObject.getId()
                               + " has already been added." );
         }
         else {   
            listOfStudents.add( studentAddObject );
            System.out.println( "Student with ID: " + studentAddObject.getId() +
                               " was added to the list." );                       
         }
      }
      
      else if ( indexLineArray[ 1 ].equals( "DEL" ) ) {
         try {  
            // Instantiate 'Del' student constructor
            studentDeleteObject = new Student( indexLineArray[ 2 ],
                                               indexLineArray[ 3 ] , 
                                               indexLineArray[ 4 ] ,
                                               indexLineArray[ 5 ] );
         }
         catch ( IllegalArgumentException e ) {
            System.err.println( "\nError On line #" + lineRead 
                                + " " + e + "\n" );
            return;
         }
           
         if (!listOfStudents.contains( studentDeleteObject ) ) {
            
            System.out.println( "Student with ID: " + studentDeleteObject.getId()
                               + " does not exist" );
         }
         else {   
            listOfStudents.remove( studentDeleteObject );
            System.out.println( "Student with Id " + studentDeleteObject.getId() +
                               " was deleted from the list." );                       
         }
      }
      
      else {
         System.out.println( "Second term on line: " + lineRead + " was " + 
                             indexLineArray[1] + ".\n Second term must be " + 
                             "either \"ADD\" " + "or \"DEL\" " + 
                             "to continue." );
      } 
       
   } // end processStudentData



// ********************************************************************************
 /**
   * Method processGradeItem
   
   * This method brings data into list, catches class exception, and either 
         adds or deletes incoming data from the list
 
   *
   * @param indexLineArray       String, array of data for student list.
   
   * @param lineRead             Int, used To display what line an error was on.
   */
// ********************************************************************************
  
   public static void processGradeItem( String[] indexLineArray,
                                       int lineRead ) {
      
      if (indexLineArray[1].equals( "ADD" ) ) {
         try {
            // Instantiate 'ADD' GradeItem constructor
            gradeItemAddObject = new GradeItem( indexLineArray[ 3 ] ,
                              Integer.parseInt( indexLineArray[ 2 ] ) , 
                                                indexLineArray[ 4 ] ,
                                                indexLineArray[ 5 ] ,
                                                indexLineArray[ 6 ] ,
                              Integer.parseInt( indexLineArray[ 7 ] ),
                              Integer.parseInt( indexLineArray[ 8 ] ) );
         }
         catch ( IllegalArgumentException e ) {
            System.err.println( "\nError On line #" + lineRead 
                                + " " + e + "\n" );
            return;
         }           
         if (listOfGradeItems.contains( gradeItemAddObject ) ) {
            
            System.out.println( "Grade item with ID: " +
                               gradeItemAddObject.getGradeItem() +
                               " for student ID: " +
                               gradeItemAddObject.getStudentId() +
                               " has already been added." );
         }
         else {   
            listOfGradeItems.add( gradeItemAddObject );
            System.out.println("Grade item with ID: " + 
                               gradeItemAddObject.getGradeItem() +
                               " for student ID: " +
                               gradeItemAddObject.getStudentId() +
                               " was added to the list." );                       
         }
      }
      
      else if (indexLineArray[ 1 ].equals( "DEL" ) ) {
         
         try {
            // Instantiate 'ADD' GradeItem constructor
             gradeItemDeleteObject = new GradeItem( indexLineArray[ 3 ] ,
                                  Integer.parseInt( indexLineArray[ 2 ] ) , 
                                                    indexLineArray[ 4 ] ,
                                                    indexLineArray[ 5 ] ,
                                                    indexLineArray[ 6 ] ,
                                  Integer.parseInt( indexLineArray[ 7 ] ) ,
                                  Integer.parseInt( indexLineArray[ 8 ] ) );
            }
         catch ( IllegalArgumentException e ) {
            System.err.println( "\nError On line #" + lineRead 
                                + " " + e + "\n" );
            return;
         }
         
         if( !listOfGradeItems.contains( gradeItemDeleteObject ) ) {
            
            System.out.println( "Grade item with ID: " +
                                gradeItemDeleteObject.getGradeItem() +
                                " for student ID: " +
                                gradeItemAddObject.getStudentId() +
                                " does not exist." );
         }
         else {   
            listOfGradeItems.remove( gradeItemDeleteObject);
            System.out.println( "Grade item with ID: " +
                               gradeItemDeleteObject.getGradeItem() +
                               " for student ID: " +
                               gradeItemAddObject.getStudentId() +
                               " was deleted from the list." );                       
         }
      }
      
      else {
         System.out.println( "Second term on line: " + lineRead + " was " + 
                             indexLineArray[1] + ".\n Second term must be " +
                             "either \"ADD\" " + "or \"DEL\" " + 
                             "to continue." );
      }
   
   } // end processGradeItem

// ********************************************************************************

  /** Method generateReport  
  
   * This method will match the student list with the corresponding grade item list 
         using the Student ID and output a summary result
   
   */ 
// ********************************************************************************
    
   public static void generateReport() {   
   
   List< Integer > maxScore = new ArrayList< Integer >();
   int maxScoreSum = 0;
   List< Integer > actualScore = new ArrayList< Integer >();
   int actualScoreSum = 0;
   int k = 0;   // Temporary variable used for manipulating an array
   
   
   Object stuArray[] = new Object[ listOfStudents.getCurrentSize() ];
   Object gradeArray[] = new Object[ listOfGradeItems.getCurrentSize() ];

   stuArray = listOfStudents.toArray().clone();
   gradeArray = listOfGradeItems.toArray().clone(); 
   
   // Array used for formatting empty space
   String[] spacingArray = { "         ",             // homework
                             "       ",               // quiz
                             " ",                     // class work
                             "       ",               // test
                             "      ",                // final
                                                      // separator
                             "======================================" + 
                             "========================================", 
                             "                     " + 
                             "                  "     // sum
                             } ;
   
   try{

      PrintWriter writer = new PrintWriter( "project_03_Output01.txt" ,  
                                          "UTF-8" );

      double gradePercent; // Summary result final calculation
                              
      int count; // Count the number grade items per student

      // Format the report with a title
      writer.println( " OUTPUT REPORT \n\n" );

      // For loop that iterates through the student list
      for ( int i = 0; i < stuArray.length ; i++ )
            {

            // Reference the object from the student list. 
            // Separate the student into an array to create a Student object
            // studenet object is needed to gain access to the student ID   
            String studentString = stuArray[ i ].toString();
            String[] studentLoopArray = studentString.split( "," );
            Student studentObject = new Student(studentLoopArray[ 0 ], 
                                                studentLoopArray[ 1 ], 
                                                studentLoopArray[ 2 ], 
                                                studentLoopArray[ 3 ]);
            // Output the student to the report
            writer.println( studentObject.getId() + " " + 
                            studentObject.getFirstName() + " " + 
                            studentObject.getLastName() + " " + 
                            studentObject.getEmail() );
           // Format the report with a subsection Grade Items
           writer.println( "   Grade Items" );
              
         // Embedded loop to compare one student against all grade items
         // The comparison will look for the common element of student ID
         for ( int j = 0; j < gradeArray.length; j++ ) 
               {
               
           // Reference the object from the grade item list. 
           // Separate the grade item into an array to create a Grade item object
           // grade item object is needed to gain access to the student ID
           String gradeItemString = gradeArray[ j ].toString();
           String[] gradeItemLoopArray = gradeItemString.split( "," );
           GradeItem gradeItemObject = new GradeItem( gradeItemLoopArray[ 0 ], 
                                    Integer.parseInt( gradeItemLoopArray[ 1 ] ), 
                                                      gradeItemLoopArray[ 2 ], 
                                                      gradeItemLoopArray[ 3 ], 
                                                      gradeItemLoopArray[ 4 ], 
                                    Integer.parseInt( gradeItemLoopArray[ 5 ] ), 
                                    Integer.parseInt( gradeItemLoopArray[ 6 ] ) );
               
            // If the student IDs match then output to the report
            if ( studentObject.getId().equals( gradeItemObject.getStudentId() ) )
                     {
                  // Match the grade item type and access the proper formating 
                  //    in the spacingArray, write the grade item to the file
                  if ( gradeItemObject.getItemType().equals( "HW" ) ){
                       k = 0;
                  } // End if
                  else if( gradeItemObject.getItemType().equals( "Quiz" ) ){
                       k = 1;
                  } // End else if
                  else if( gradeItemObject.getItemType().equals( "Class Work" ) ){
                       k = 2;
                  } // End else if
                  else if( gradeItemObject.getItemType().equals( "Test" ) ){
                       k = 3;
                  } // End else if
                  else if( gradeItemObject.getItemType().equals( "Final" ) ){
                       k = 4;
                  } // end else if 
                   
                   writer.println( 
                    spacingArray [ 0 ] + gradeItemObject.getGradeItem() + 
                    spacingArray [ 0 ] + gradeItemObject.getItemType() +
                    spacingArray [ k ] + gradeItemObject.getDate() + 
                    spacingArray [ 0 ] + gradeItemObject.getMaxScore() + 
                    spacingArray [ 0 ] + gradeItemObject.getActualScore() );

                        // Add the maximum score to the end of the list
                        maxScore.add( gradeItemObject.getMaxScore() );
                        // Add the actual score to the end of the list
                        actualScore.add( gradeItemObject.getActualScore() );

                     } //End if      
               } // End for

               // Output a separator to the report for summary section
               writer.println( spacingArray [ 5 ] );    

               // If the maximum score list is not empty
               if( maxScore.size() >= 0 ){
               
                     // Calculate the maximum score of all the 
                     //    grade items matching the student ID
                     maxScoreSum = 0;

                     for( int m = 0; m < maxScore.size(); m++ ){
                     
                        maxScoreSum = maxScoreSum + maxScore.get( m );
                        
                         } // End for
                         
                  // Clear the list for the next student       
                  maxScore.clear();
                  
               } // End if

               // If the actual score list is not empty
               if( actualScore.size() >= 0 ) {
               
                     // Calculate the actual score of all the 
                     //    grade items matching the student ID
                  actualScoreSum = 0;

                  for(int x = 0; x < actualScore.size(); x++ ) {
                  
                     actualScoreSum = actualScoreSum + actualScore.get( x );
                     
                      } // End for
                      
                  // Clear the list for the next student 
                  actualScore.clear();
                  
                  }// End if

                  if ( maxScoreSum > 0 ) {
                                                
                           gradePercent = Math.round(( ( double ) actualScoreSum /
                                          maxScoreSum ) * 100 );
                           writer.println("   Total" + spacingArray [ 6 ] + 
                                         maxScoreSum + spacingArray [ 0 ] + 
                                      actualScoreSum + spacingArray [ 0 ] + 
                                        gradePercent + "%" + "\n" );
                                 
                     } // End if
                  else {
                  
                     writer.println( spacingArray [ 0 ] + "No Grade Item Data\n" );
                        
                       } // End else
            } // End for
            
         writer.close(); // Close the writer
         
         } // End try
         
   // Catch exceptions if the file is not found         
   catch( IOException e ){
   
      System.out.println( "file not found" );
      
      } // End catch  
   } // end generateReport  

// ********************************************************************************
} // end class