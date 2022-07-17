public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> WordList = new LinkedListDeque<>();
        for (int i = 0; i<word.length(); i++) {
            WordList.addLast(word.charAt(i));
        }
        return WordList;
    }

    /** return true when first=last */
    private boolean assertFirLa(Deque<Character> wl) {
        char x = wl.removeLast();
        char y = wl.removeFirst();
        if (x != y) {
            return false;
        }
        else if (wl.size() < 2) {
            return true;
        }
        return assertFirLa(wl);
    }

    public boolean isPalindrome(String word) {
        Deque<Character> d = wordToDeque(word);
        int length = word.length();
        if (length < 2) {
            return true;
        }
        return assertFirLa(d);
    }

    /** A help method for isPaindrome(String word, CharacterComparator cc) */
    private boolean assertFirLa(Deque<Character> wordList, CharacterComparator cc) {
        if (wordList.size() < 2) {
            return true;
        }
        else if (!cc.equalChars(wordList.removeLast(), wordList.removeFirst())) {
            return false;
        }
        else return assertFirLa(wordList, cc);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> wordList = wordToDeque(word);
        return assertFirLa(wordList, cc);
    }
}
