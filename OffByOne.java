public class OffByOne implements CharacterComparator{
    /** Returns true if characters are equal by the rules of the implementing class. */
    @Override
    public boolean equalChars(char x, char y){
        int Intx = x;
        int Inty = y;
        int diff = Intx - Inty;
        if (diff == 1 | diff == -1) return true;
        else return false;
    }

}
