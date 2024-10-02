package cp213;

/**
 * @author Your name and id here
 * @version 2023-05-23
 */
public class Strings {
    // Constants
    public static final String VOWELS = "aeiouAEIOU";

    /**
     * Determines if string is a "palindrome": a word, verse, or sentence (such as
     * "Able was I ere I saw Elba") that reads the same backward or forward. Ignores
     * case, spaces, digits, and punctuation in the string parameter s.
     *
     * @param string a string
     * @return true if string is a palindrome, false otherwise
     */
    public static boolean isPalindrome(final String string) {

	// your code here
	boolean val = true;
	String temp = string.toLowerCase().replaceAll("\\d+", "").replaceAll("\\s+", "").replaceAll("\\p{Punct}", "");
	// (muta.length()/2
	for (int i = 0; i < (string.length() / 2); ++i) {
	    if ((temp.charAt(i)) != (temp.charAt(temp.length() - i - 1))) {
		val = false;
	    }

	}

	return val;
    }

    /**
     * Determines if name is a valid Java variable name. Variables names must start
     * with a letter or an underscore, but cannot be an underscore alone. The rest
     * of the variable name may consist of letters, numbers and underscores.
     *
     * @param name a string to test as a Java variable name
     * @return true if name is a valid Java variable name, false otherwise
     */
    public static boolean isValid(final String name) {

	// your code here
	boolean valid = true;
	if ((name.substring(0, 1) == "_") && name.length() == 1) {
	    valid = false;
	}
	if (Character.isDigit(name.charAt(0))) {
	    valid = false;
	}

	return valid;
    }

    /**
     * Converts a word to Pig Latin. The conversion is:
     * <ul>
     * <li>if a word begins with a vowel, add "way" to the end of the word.</li>
     * <li>if the word begins with consonants, move the leading consonants to the
     * end of the word and add "ay" to the end of that. "y" is treated as a
     * consonant if it is the first character in the word, and as a vowel for
     * anywhere else in the word.</li>
     * </ul>
     * Preserve the case of the word - i.e. if the first character of word is
     * upper-case, then the new first character should also be upper case.
     *
     * @param word The string to convert to Pig Latin
     * @return the Pig Latin version of word
     */
    public static String pigLatin(String word) {

	// your code here
	int i = 0;
	boolean up = false;
	if (Character.isUpperCase(word.charAt(0))) {
	    up = true;
	}
	if (VOWELS.contains(word.substring(0, 1))) {
	    word = word + "way";
	} else {
	    String cons = "";
	    while (!VOWELS.contains(word.substring(i, i + 1))) {
		cons += (word.substring(i, i + 1)).toLowerCase();
		i++;
	    }
	    word = word.substring(i, word.length());

	    word = word + cons + "ay";

	}
	if (up == true) {
	    word = word.substring(0, 1).toUpperCase() + word.substring(1);

	}

	return word;
    }

}
