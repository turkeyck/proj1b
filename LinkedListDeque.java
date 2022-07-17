import java.util.Objects;

public class LinkedListDeque<T> implements Deque<T> {


    private class LList {
        T item;
        public LList previous;
        public LList next;

        public LList(LList p, T i, LList n) {
            item = i;
            previous = p;
            next = n;
        }
    }

        private LList sentinel;
        private LList sentinellast;
        public LinkedListDeque(){
            sentinel = new LList(null,null,null);
            sentinel.next = new LList(sentinel, null, null);
            sentinellast = sentinel.next;
            size = 0;
        }

        public int size;
        public LinkedListDeque(T x){
            sentinel = new LList(null,null, null);
            sentinellast = new LList(sentinel, null, null);
            sentinel.next = new LList(sentinel, x, sentinellast);
            sentinellast.previous = sentinel.next;
            size = 1;
        }


        public void addFirst(T y){
            sentinel.next = new LList(sentinel,y, sentinel.next);
            sentinel.next.next.previous = sentinel.next;
            size += 1;
        }

        public T getfirst(){
            return sentinel.next.item;
        }

        public void addLast(T y){
            sentinellast.previous = new LList(sentinellast.previous, y, sentinellast);
            sentinellast.previous.previous.next = sentinellast.previous;
            size += 1;
        }

        public T getLast(){
            return sentinellast.previous.item;
        }


        public int size() {
            return size;
        }

        public boolean isEmpty(){
            return size == 0;
        }

        public void printDeque(){
            LList p = sentinel.next;
            while (p.next != null) {
                    System.out.print(p.item + " ");
                    p = p.next;
                }
            System.out.println("\n");
        }

        public T removeFirst(){
            if (sentinel.next.next == null){
                return null;
            }
            size -= 1;
            T first = getfirst();
            sentinel.next.next.previous = sentinel.next.previous;
            sentinel.next = sentinel.next.next;
            return first;
        }

        public T removeLast(){
            T last = getLast();
            sentinellast.previous.previous.next = sentinellast.previous.next;
            sentinellast.previous = sentinellast.previous.previous;
            size -= 1;
            return last;
        }

        /**iterative method */
        public T get(int index){
            if (this.isEmpty()){
                return null;
            }
            LList pt = sentinel.next;
            int i = 0;
            while (i != index){
                pt = pt.next;
                i += 1;
            }
            return pt.item;
        }


         /** deepcopy of LinkedListDeque other */
        public LinkedListDeque(LinkedListDeque<T> other){
            sentinel = new LList(null,null,null);
            sentinel.next = new LList(sentinel, null, null);
            sentinellast = sentinel.next;
            size = 0;

            for (int j = 0; j < other.size(); j++) {
                addLast(other.get(j));
                size += 1;
            }

        }


    /** 'get' in recursive method */
        public T getRecursive(int index){
            if (index > this.size){
                return null;
            }
            return getR(this.sentinel.next, index-1);
        }

        private T getR(LList L, int i){
            if (i == 0){
                return L.item;
            }
            return getR(L.next, i -1);
        }


//        public static void main(String[] args){
//
//            /** Create two lists, DL and DLL:
//                DL is (19, 20, 91, 92), while DLL is (44, 45, 90, 100, 101). */
//            LinkedListDeque<Integer> DL = new LinkedListDeque<Integer>();
//            LinkedListDeque<Integer> DLL = new LinkedListDeque<Integer>(90);
//            DLL.addFirst(45);
//            DLL.addFirst(44);
//            DLL.addLast(100);
//            DLL.addLast(101);
//
//            DL.addFirst(20);
//            DL.addFirst(19);
//            DL.addLast(91);
//            DL.addLast(92);
//
//            /** test printDeque() and deepcopy() */
//            DL.printDeque();
//            DLL.printDeque();
//            LinkedListDeque<Integer> DLLcopy = new LinkedListDeque<Integer>(DLL);
//            DLLcopy.printDeque();
//            LinkedListDeque<Integer> DLcopy = new LinkedListDeque<Integer>(DL);
//            DLcopy.printDeque();
//        }
}


