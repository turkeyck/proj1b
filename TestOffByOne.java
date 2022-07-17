import org.testng.annotations.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void TestOffByOne() {
        boolean t1 = offByOne.equalChars('a', 'b');
        assertTrue(t1);
        boolean t2 = offByOne.equalChars('&', '%');
        assertTrue(t2);
        boolean t3 = offByOne.equalChars('z', 'y');
        assertTrue(t3);

        boolean f1 = offByOne.equalChars('a', 'c');
        assertFalse(f1);
        boolean f2 = offByOne.equalChars('&', 'c');
        assertFalse(f2);

    }


}
//Uncomment this class once you've created your CharacterComparator interface and OffByOne class.