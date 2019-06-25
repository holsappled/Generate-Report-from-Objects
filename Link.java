class Link<T> implements MyCollectionInterface {
   
   private Node<Object> linkStart;           // Pointer to 1st entry
   private Node<Object> temp;                // Tempary storage for adding entry
   private Node<Object> position;            // To track position in collection
   private Node<Object> previousPosition;    // To hold the position previous 
   private static int counter;               // To track size of collection
   private static int frequencyCount;        // To track number of identical items
   private static boolean result;            // Hold return value
   private static int max;                   // Hold total size of collection
   
/**
* Default constuctor - Sets up empty collection.
*
*/  

   public Link() {
      linkStart = new Node<>( null );
      counter = 0;
   }   


// ********************************************************************************
 
/**
* Adds a new entry to this collection at the end
* 
* @param  data   The data to be added to the collection
* @return True   If the addition is successful, or false if not.
*/

   public boolean add ( Object data ) {
      
      if ( linkStart.getNextNode() == null ) {
         counter = 0;
       }
      
      result = false;
      temp = new Node<>( data );
      position = linkStart;
      
      if ( position != null ) {
         
         while ( position.getNextNode() != null ) {
            position = position.getNextNode();
         }
         
         position.setNextNode( temp );
         result = true;
      
      }
      
      return result;
   } // end add

// ********************************************************************************

   /**
    * Removes the last entry from the collection, if possible.
    *
    * @return Either the removed entry, if the removal was successful, or null.
    */
   public Object remove () {
           
      position = linkStart; 
      
      if ( position != null ) {
         
         while ( position.getNextNode() != null ) {
            previousPosition = position;
            position = position.getNextNode();
         }
         
         previousPosition.setNextNode( null );
      }
      
      return position.getData();
   }

// ********************************************************************************

   /**
    * Removes one occurrence of a given entry from this collection.
    *
    * @param data The entry to be removed.
    * @return true if the removal was successful, false if not.
    */
   public boolean remove ( Object data ) {
      result = false;      
      position = linkStart;  
         
         while ( position != null ) {
            
            if ( data.equals( position.getData() ) ) {
               previousPosition.setNextNode( position.getNextNode() );
               result = true;      
            }
            
            previousPosition = position;
            position = position.getNextNode();      
         }
      return result;
   }

// ********************************************************************************

   /**
    * Removes all entries from this collection.
    */
   public void clear() {
      linkStart.setNextNode( null );
      counter = 0;   
   }

// ********************************************************************************

   /**
    * Gets the current number of entries in this collection.
    *
    * @return The integer number of entries currently in the collection.
    */
   public int getCurrentSize() {
     counter = 0;
     position = linkStart.getNextNode();
     
      while (position != null) {
            position = position.getNextNode();
            counter++;
         }
      
      return counter;
   }

// ********************************************************************************

   /**
    * Check to see if the collection is empty.
    *
    * @return True if the collection is empty, or false if not.
    */
   public boolean isEmpty() {
      result = false;
      
      if ( linkStart.getNextNode() == null ) {
         
         result = true;
         
      }
      
      return result;
   }

// ********************************************************************************

   /**
    * Counts the number of times a given entry appears in this collection.
    *
    * @param data The entry to be counted.
    * @return The number of times data appears in the collection.
    */
   public int getFrequencyOf( Object data ) {
      
      frequencyCount = 0;
      position = linkStart;  
      
         
      while ( position != null ) {
            
         if ( data.equals( position.getData() ) ) {
            frequencyCount++;      
         }
            
         position = position.getNextNode();
      
      }
      return frequencyCount;
   }

// ********************************************************************************

   /**
    * Tests whether this collection contains a given entry.
    *
    * @param data The entry to locate.
    * @return True if the collection contains data, or false if not.
    */
   public boolean contains ( Object data ) {
      position = linkStart;  
      result = false;
         
      while ( position != null ) {
            
         if ( data.equals( position.getData() ) ) {
            result = true;      
         }
            
         position = position.getNextNode();
      
      }

      return result;
   }

// ********************************************************************************

   /**
    * Retrieves all entries that are in this collection.
    *
    * @return A newly allocated array of all the entries in the collection. 
    * Note: If the collection is empty, the returned array is empty.
    */
    
   public Object[] toArray () {
      max = this.getCurrentSize();
      position = linkStart;
      Object[] array = new Object[ max ]; 
      
      for (int i = 0; i < max; i++){
         position = position.getNextNode();
         array[ i ] = position.getData();
         
      }
      return array;
   }

} // End class 