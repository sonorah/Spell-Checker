import java.util.HashSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


/**
 *.  Class to store a spelling dictionary
 *.  @author SonoraHalili & FrankieFan
 *.  @version Spring 2022
 */
public class SpellDictionary {

  /** Stores the dictionary words */
  private HashSet<String> words = new HashSet<String>();


  /** 
   *  Constructor sets up the set of words
   *  @param filename The word list file
   */

  public SpellDictionary(String filename) {

    Scanner file = null;
    try {
      file = new Scanner (new File("words.txt"));
    } catch (FileNotFoundException e) {
      System.err.println("Cannot locate file.");
      System.exit(-1);
    }
    while (file.hasNextLine()) {
      String word = file.nextLine();
      words.add(word.toLowerCase());
    }
    file.close();

    for (String word : words) {
      //System.out.println( word );
    }
  }


  /** Boolean method applied on spelldictionary 
  *. object that returns true if a certain string can
  *. be located in the HashSet.
  *. @param x a string to be checked
  *. @return boolean
  */
  public boolean containsWord(String x) {
    return (words.contains(x));
  } 

  
  /** Method that offers suggestions for misspelled words
  *. Constructs an empty array list for us to add the 
  *. correct spellings of near misses
  *. @param each_word String to undergo near misses
  *. @return Correct ArrayList of suggestions.
  */

  public ArrayList <String> nearMisses(String each_word) {
    
    //converts input to lowercase
    each_word = each_word.toLowerCase();

    //Arraylist to store all suggestions. Will be returned at the end of this method.
    ArrayList <String> Correct = new ArrayList <String>();
    //Char array to store all letters of the alphabet to be used in the for-loops.
    char[] alphabet =   {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'}; 
    //String array to store all punctuation that could come with a word.
    String[] punctuation = {",",".",":",";","?","!"};
    //the length of the inputted string in this method
    int n = each_word.length();
   
    /* For-loop that deletes punctuation, so each word can
    *. go through the following modifications. */
    for (int i=0; i < 6; i++) {
      if (each_word.contains(punctuation[i])){
        int a = each_word.indexOf(punctuation[i]); //spots punctuation
        //modifies original word into unpunctuated version.
        each_word = each_word.substring(0,a) + each_word.substring(a + 1);
      } 
    }

    
    /*For-loop to handle deletions that could result to a match.*/
    for (int i = 0; i < n ; i++){
      //String to store result after deleting each of the characters, one at a time. 
      String result1 = each_word.substring(0, i) + each_word.substring(i + 1);

      //if/else statement to avoid duplicates via double condition
      if (containsWord(result1) && (!Correct.contains(result1))) {
        //adds suggestion to Correct arraylist
        Correct.add(result1);
      } else { 
        continue;
      }
    }

    /* Nested for loop to check if adding a character from the alphabet to word causes a match.*/
    for (int i = 0;i < (n+1) ; i++){
      for (int a = 0; a < 26 ; a++) {
        /*String to store result after adding a character, one at a time. */
        String result2 = each_word.substring(0, i) + alphabet[a] + each_word.substring(i, n);
        
        if (containsWord(result2) && (!Correct.contains(result2))) {
          Correct.add(result2);
        } else { 
          continue;
        }
      }
    }


    /* Nested for loop to check if substituting a character in word with an element from the alphabet causes a match.*/
    for (int i = 0; i < n; i++) {
      for (int a = 0; a <25; a++) {
        //any letter of the alphabet
        char ch = alphabet[a];
        //letter to be substituted
        char subletter;


        /* if/else statement to try substitutions*/
        if (each_word.charAt(i) != ch){
          subletter = alphabet[a];
        } else {
          continue;
        }

        //resulting string with substitution
        String result3 = each_word.substring(0, i) + subletter + each_word.substring(i + 1);

        //adds resulting string to arraylist
        if (containsWord(result3) && (!Correct.contains(result3))) {
          Correct.add(result3);
        } else { 
          continue;
        }
      }
    }
    

    /* For loop to check if swapping characters in word causes a match.*/
    for (int i = 0; i < (n-1) ; i++) {
      //arraylist to store every letter of each word
      ArrayList<Character> chars = new ArrayList<Character>();
      //For-loop that does the storing
      for (char c : each_word.toCharArray()) {
        chars.add(c);
      }

      //swaps adjacent characters
      char swap = chars.get(i);
      chars.set( i, chars.get(i+1));
      chars.set( i+1, swap );

      //string to store result in
      String result4= new String();
      for(char c : chars){
        result4 = result4 + c;
      }
      //adds result to arraylist
      if (containsWord(result4) && (!Correct.contains(result4))) {
        Correct.add(result4);
      } else { 
        continue;
      }
    }

  
    /* For loop to check if splitting word causes two matches.*/
    for (int i = 0; i < (n-1) ; i++){
      //two strings for two potential results after splitting
      String result5 = each_word.substring(0, i); 
      String result6 = each_word.substring(i);
      //string that results when splitting occurs
      String split_result = (result5 + " " + result6);

      //adds both results to correct arraylist if both are words.
      if (containsWord(result5) && containsWord(result6) && (!Correct.contains(result5))){
        Correct.add(split_result);
      } else { 
        continue;
      }
    }      
    //returns arraylist of suggestions
    return (Correct);
  }

}