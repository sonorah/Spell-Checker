# Assignment 3: Spell Checker
## Authors
This assignment is completed by Sonora Halili and Frankie Fan. We get started on the task together last Thursday and completed it early on Monday. We discussed potential challenges and feasible methods with classmates during code review on Friday and went to TA hours on Monday evening for a general review of the code.

## Process
When getting started with the assignment, we were a little bit confused about the idea of using HashSet. We thought a hashtable with key as indices were what we need, and we were not sure what it meant when the HashSet `NearMiss()` returned more than one list. We had the idea of having more than one list in the set, but subconsciously we assumed one of them should be a list of indices, indicating the location of a  word caught in the dictionary.

After rewatching the videos of HashSet and seeing examples with the application of HashSet, hashtable, and hashmap, we were clearer with the idea and finished building our class SpellDictionary quickly. After that, we had to write numerous for-loops with if-else statements, which we mastered in CS111. The tricky part was to determine the indices for each loop, which were different because there are many ways to misspell a word.

Also making sure there are no duplicates in the Correct array list took some thought. We ended up using the double condition `&&(!Correct.contains(result#))`  to make sure that no suggestion is added twice to the ArrayList. 

For the TestCode, it was smooth as we have done more tests in A2. We ran tests for each behavior, with the modification happening in the beginning, middle, and end. Some uppercase letters were included for testing purposes as well. One challenge was that we initially forgot to put in the parameters for `NearMiss()`, so there were errors when it was called as a generic ArrayList yet was used to pass in strings. Once we fixed that, we finished the tests easily.

Finally, the most challenging part was with the class SpellChecker. Because we did it on a Saturday night instead of after the class on Monday, we didn't know anything about command-line arguments and redirection. With the resources on CS212 website, we were able to make it work. Given the freedom we had in organizing this class in methods, we decided to keep both modes in main, as the program knows when args is 0, moving on to the file redirection mode. Our input redirection mode uses a new `HashSet` created for the purposes of the method. We found it's much easier to parse through a hashet as opposed to an array. It runs quicker too. 

Note: After stumbling upon a few offensive/innapropriate words in the words.txt file, we decided to remove a few lines that we thought were unnecessary. 

## Resource & Exploration
We discussed our codes with some of our table classmates during code review and found that we have a clearer picture of the project after it.

- Yurika Nakagawa and Emi Neuwalder   
We had the exact same idea of writing separate for-loops for each method. Emi had all of her methods finished, with problems checking lowercase of the vocabs in word.txt, which reminded us to add that feature in our SpellDictionary class. 
   
Yurika had clear names for variables, and we also made our variables easy to understand with proper abbreviations and comments.  


- TA hours   
We finished our task on Monday night but still wanted to double-check the clarity of our code. We went to the TA hours right after that, and Lucie B helped to quickly review our code.

## References
Below is a list of resources we've used (include all links here): 

- https://stackoverflow.com/questions/23981008/how-to-replace-existing-value-of-arraylist-element-in-java (line 122-123 in SpellDictionary)
- https://www.w3schools.blog/substring-in-java (the basic idea of substring)
- https://stackoverflow.com/questions/956199/how-to-swap-string-characters-in-java (line 141-143 in SpellDictionary)
- https://www.w3schools.com/java/java_hashset.asp (the general idea of HashSet)
- https://jcrouser.github.io/CSC212/redirection.html (redirection)

## Final Remarks 
We spent a little less time on this assignment than on A2, probably because A2 was more complicated, composed with more parts, and it was also the first time to test with those setters and getters of each method. We were also good at writing the if-else statements and the for-loops, because a large portion of our final project for CS111 was based on that. However, we learned something new from this assignment as well, not only the use of HashSet in searching for membership but also the command-line arguments and redirection of input and output.

The only thing we might regret is probably that we spent more than two hours trying to debug and figure out the content of SpellChecker on Saturday, yet found that most of the useful information was provided in class on the following Monday. It would be much less stressful if we had done it after Monday's class, yet it also helped us to develop research skills and programming mindset when we were experimenting with the new thing ourselves.

