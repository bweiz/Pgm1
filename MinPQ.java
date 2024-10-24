import java.util.Comparator;
import java.util.NoSuchElementException;


public class MinPQ<Item extends SingleDay>{
	private Item[] minpq;
	private int n;
	
	public MinPQ() {	
		minpq = (Item[]) new SingleDay[4];
		n = 0;
	}
	
	public int size() {
		return n;
	}
	
	public void insert(Item item) {	
		for (int i = 0; i<n; i++) {
			if (minpq[i].compareTo(item) == 0) return;
		}
		minpq[n++] = item;
		
	}
	
	public Item delMin() {
		int min = 0;
		for (int x = 1; x<n; x++) {
			if (minpq[min].compareTo(minpq[x]) > 0) {
				min = x;
			}
		}
		exchange(min, n-1);
		
		return minpq[n--];
	}
	
	private void exchange(int i, int j) {
		Item swap = minpq[i];
		minpq[i] = minpq[j];
		minpq[j] = swap;
	}
	
	
}
