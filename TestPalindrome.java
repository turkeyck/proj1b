import org.testng.annotations.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void TestPalindrom() {
        /** assertTrue: Note that any word of length 1 or 0 is a palindrome. */
        boolean t1 = palindrome.isPalindrome("noon");
        assertTrue(t1);
        boolean t2 = palindrome.isPalindrome("racecar");
        assertTrue(t2);
        boolean t3 = palindrome.isPalindrome("a");
        assertTrue(t3);
        boolean t4 = palindrome.isPalindrome("   ");
        assertTrue(t4);

        /** assertFalse: Note that ‘A’ and ‘a’ should not be considered equal;
         * however,
         * you don’t need to do anything special for capital letters to work properly.
         * In fact, if you forget that capital letters exist,
         * your code will work fine. */
        boolean f1 = palindrome.isPalindrome("acecar");
        assertFalse(f1);
        boolean f2 = palindrome.isPalindrome("Racecar");
        assertFalse(f2);
        boolean f3 = palindrome.isPalindrome("app  ");
        assertFalse(f3);
    }

    @Test
    public void TestPalindromeByN(){
        CharacterComparator obo = new OffByOne();
        boolean t1 = palindrome.isPalindrome("flake", obo);
        assertTrue(t1);
        boolean t2 = palindrome.isPalindrome("wnyzmv", obo);
        assertTrue(t2);

        boolean f1 = palindrome.isPalindrome("abcdef", obo);
        assertFalse(f1);
    }
}
//Uncomment this class once you've created your Palindrome class. */