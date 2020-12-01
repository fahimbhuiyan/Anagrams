import java.util.*;

/**
 * Author: Fahim Bhuiyan (40091942)
 * SOEN 343 TUT6
 */
public class Main
{
    /**
     * Are anagrams boolean.
     *
     * @param word1 the word 1
     * @param word2 the word 2
     * @return the boolean
     */
    /* a method that checks whether two words are anagrams */
    public static boolean are_anagrams(String word1, String word2)
    {
        //if the lengths are different, they are not anagrams
        if (word1.length() != word2.length())
            return false;

        //converting to the lower cases
        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();

        //converting from strings to arrays of chars
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        //sorting the arrays regarding alphabet orders
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        //converting from arrays to strings
        word1 = new String(chars1);
        word2 = new String(chars2);

        //if the strings are equal, they are anagrams
        if (word1.equals(word2))
            return true;
        return false;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    /* the main method */
    public static void main(String[] args)
    {
        System.out.println("*** Anagrams ***");
        System.out.println("Please type a list of strings.");

        //reading the input line
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        //split the input string with spaces
        String[] splited = input.split("\\s+");
        int words = splited.length;

        //an array to indicate which words are considered before
        boolean[] checked = new boolean[words];
        for(int i = 0; i < words; i++)
            checked[i] = false; //initiating with false

        //check all the words
        for(int i = 0; i < words; i++)
        {
            //if the word is checked before, we should pass that
            if (checked[i])
                continue;

            //check the current word and print that
            checked[i] = true;
            System.out.print(splited[i]);

            //check the other words if they are anagrams with the current word
            for (int j = i + 1; j < words; j++)
            {
                //if the word is checked before, we should pass that
                if (checked[j])
                    continue;

                //print the word if it is anagram
                if (are_anagrams(splited[i], splited[j]))
                {
                    checked[j] = true;
                    System.out.print(" ");
                    System.out.print(splited[j]);
                }
            }

            //print a new line
            System.out.println();
        }
    }
}
