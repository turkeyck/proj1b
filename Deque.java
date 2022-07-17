public interface Deque<Item> {
    public void addFirst(Item x);
    public void addLast(Item x);
    public int size();
    default public boolean isEmpty() {
        return this.size() == 0;
    }

    public void printDeque();
    public Item removeFirst();
    public Item removeLast();
    public Item get(int index);

}
