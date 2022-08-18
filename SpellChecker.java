import java.util.HashSet;
import java.util.*;
import java.util.Scanner;


/**
 *.  Class to handle user interaction
 *.  @author SonoraHalili & FrankieFan
 *.  @version Spring 2022
 */
public class SpellChecker {
  //makes an instance of the dictionary for the purposes of the class.
  static SpellDictionary set = new SpellDictionary("words.txt");
  
  /** 
  *  Main method operates in two modes.
  *  @param String[] args args from user.
  */
  
  public static void main(String[] args) {
    
    ////////////////////* MODE 1 *////////////////////
    
    /* Command Line Mode. User inputs args.*/
    
    //For-loop to check spelling for each arg and print suggestions.
    for (String s: args) {
      //word is spelled correctly
      if (set.containsWord(s)) {
        System.out.println("This word is spelled correctly: " +s);
      } else {
        //word is spelled wrong
        System.out.println("> Not found: "+s);
        System.out.println( "* Suggestions: "+set.nearMisses(s));
      }
    }

    


    ////////////////////* MODE 2 *////////////////////
    //File input redirection mode. User offers a txt file. 

    //Array to store words of each line 
    String [] split_list;
    //Hashset to store all individual words from arraylist
    Set <String> file_read = new HashSet <String>();
    //Array with punctuation elements
    String[] punctuation = {",",".",":",";","?","!"};
  
      
    /* reads text file*/
    Scanner input = new Scanner(System.in);  
    while (input.hasNextLine()) {
      //converts each line to string
      String text = input.nextLine();
      //splits lines into words
      split_list = (text.toLowerCase().split(" "));
      //stores words in hashset to be accessed later
      Collections.addAll(file_read, split_list);
    }
    input.close();
  
     
    /* for-loop to read each word i the hashset */
    for (String f : file_read ){
      //for-loop to remove punctuation
      for (int i=0; i < 6; i++) {
        if (f.contains(punctuation[i])){
          int a = f.indexOf(punctuation[i]);
          f = f.substring(0,a) + f.substring(a + 1);
        } 
      }
  
      /* generates suggestions or skips if word is spelled correctly*/
      if (set.containsWord(f)) {
        continue;
      } else {
        System.out.println("> Not found: "+ f);
        System.out.println( "* Suggestions: "+ set.nearMisses(f));
      }
    }
  } 
} 




