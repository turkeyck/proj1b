import org.testng.annotations.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offBy3 = new OffByN(3);

    // Your tests go here.
    @Test
    public void TestOffByN() {
        boolean t1 = offBy3.equalChars('g', 'd');
        assertTrue(t1);
        boolean t2 = offBy3.equalChars('s', 'v');
        assertTrue(t2);
        boolean t3 = offBy3.equalChars('&', '#');
        assertTrue(t3);

        boolean f1 = offBy3.equalChars('a', 'c');
        assertFalse(f1);
        boolean f2 = offBy3.equalChars('&', 'c');
        assertFalse(f2);

    }


}
