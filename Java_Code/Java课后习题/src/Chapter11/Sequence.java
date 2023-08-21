package Chapter11;
import java.util.*;

interface Selector {
boolean end();
Object current();
void next();
}	

public class Sequence {
private ArrayList items;
private int next = 0;
public Sequence() { items = new ArrayList<Object>(); }
public void add(Object x) {
   //items[next++] = x;
	items.add(x);
}
private class SequenceSelector implements Selector {
 private int i = 0;
 public boolean end() { return i == items.size(); }
 public Object current() { return items.get(i); }
 public void next() { if(i < items.size()) i++; }
}
public Selector selector() {
 return new SequenceSelector();
}	
public static void main(String[] args) {
 Sequence sequence = new Sequence();
 for(int i = 0; i < 100; i++)
   sequence.add(Integer.toString(i));
 Selector selector = sequence.selector();
 while(!selector.end()) {
   System.out.print(selector.current() + " ");
   selector.next();
 }
}
} /* Output:
0 1 2 3 4 5 6 7 8 9
*///:~

