/**
 *.  Main class. Contains tests for all methods.
 *.  @author SonoraHalili & FrankieFan
 *.  @version Spring 2022
 */

class Main {

  /** Main method to call test methods*/
  public static void main(String[] args) {
    System.out.println("Welcome!");
    testSpellDictionary();
    testContainsWord();
  }

  
  /** Contains tests for all methods and behaviors in SpellDictionary class.*/
  public static void testSpellDictionary() {
    
    /*constructs object of type SpellDictionary, testing the constructor */
    SpellDictionary dict = new SpellDictionary("words.txt");
    
    /*tests for all behaviors*/

    //Deletion 
    TestCode.beginTest("Deletion");
    /*Deletes first char of word to find match*/
    TestCode.subTest("Deletion Beggining", dict.nearMisses("vcattle").contains("cattle"));
    /*Deletes a char somewhere in the middle of the word to find match*/
    TestCode.subTest("Deletion Middle", dict.nearMisses("mirrtor").contains("mirror"));
    /* Deletes last char of word to find match. Uppercase char to test the converter*/
    TestCode.subTest("Deletion End", dict.nearMisses("purpOsew").contains("purpose"));
    TestCode.concludeTest();
 
    //Insertion
    TestCode.beginTest("Insertion");
    /*Inserts first char of word to find match*/
    TestCode.subTest("Insertion Beggining", dict.nearMisses("uest").contains("quest"));
     /*Inserts a char somewhere in the middle of the word to find match*/
    TestCode.subTest("Insertion Middle", dict.nearMisses("meber").contains("member"));
    TestCode.subTest("Insertion End", dict.nearMisses("directo").contains("director"));
    TestCode.concludeTest();

    //Substitution
    TestCode.beginTest("Substitution");
    /*Substitutes first char of word to find match*/
    TestCode.subTest("Substitution Beggining", dict.nearMisses("Malent").contains("talent"));
     /*Substitutes a char somewhere in the middle of the word to find match*/
    TestCode.subTest("Substitution Middle", dict.nearMisses("consysTent").contains("consistent"));
    /*Substitutes last char of word to find match*/
    TestCode.subTest("Substitution End", dict.nearMisses("tendes").contains("tender"));
    TestCode.concludeTest();

    
    //Transposition
    TestCode.beginTest("Transposition");
    /* Swaps first two chars of word to find match*/
    TestCode.subTest("Transposition Beggining", dict.nearMisses("olve").contains("love"));
     /*Swaps a char somewhere in the middle of the word to find match*/
    TestCode.subTest("Transposition Middle", dict.nearMisses("freind").contains("friend"));
    /*Swaps last two chars of word to find match*/
    TestCode.subTest("Transposition End", dict.nearMisses("articel").contains("article"));
    TestCode.concludeTest();


    /* Three kinds of splits*/
    TestCode.beginTest("Splits");
    TestCode.subTest("Splits 1", dict.nearMisses("messup").contains("mess up"));
    TestCode.subTest("Splits 2", dict.nearMisses("afterdinner").contains("after dinner"));
    TestCode.subTest("Splits 3", dict.nearMisses("tendto").contains("tend to"));

    
    TestCode.concludeTest();
  }

  /** Method to test whether the boolean method ContainsWord works correctly */
  public static void testContainsWord() {
    /*constructs object of type SpellDictionary, testing the constructor */
    SpellDictionary dict = new SpellDictionary("words.txt");

    /*Tests a word that is in the dictionary*/
    TestCode.runTest("ContainsWord -T", dict.containsWord("apple")==(true));
    /*Tests a word that isn't in the dictionary*/
    TestCode.runTest("ContainsWord -F", dict.containsWord("ScoobyDoo")==(false));
  }
}