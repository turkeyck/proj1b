public class OffByN implements CharacterComparator{
    int size;
    public OffByN(int N) {
        size = N;
    }

    @Override
    public boolean equalChars(char x, char y){
        int Intx = x;
        int Inty = y;
        int diff = Intx - Inty;
        if (diff == this.size | diff == -this.size) return true;
        else return false;
    }
}
