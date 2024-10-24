
public class BST<Key extends SingleDay> {
	private Node root;
	
	private class Node {
		private Key key;
		private Node left, right;
		private int n;
		
		public Node(Key key, int n) {
			this.key = key;
			this.n = n;
		}
	}
		
	public BST() {
		root = null;
	}
	
	public int size() {
		return size(root);
	}
	
	private int size(Node x) {
		if (x == null) return 0;
		else return x.n;
	}
	
	public void put(Key key) {
		root = put(root, key);
	}
	

	
	private Node put(Node x, Key key) {
		if (x == null) return new Node(key, 1);
		int cmp = key.compareTo(x.key);
		if (cmp < 0) x.left = put(x.left, key);
		else if (cmp > 0) x.right = put(x.right, key);
		x.n = 1 + size(x.left) + size(x.right);
		return x;
	}
	
	private Key min() {
		Node x = min(root);
		return x.key;
	}
	private Node min(Node x) {
		
		if (x.left == null) return x;
		return min(x.left);
	}
	
	private Key max() {
		Node x = max(root);
		return x.key;
	}
	private Node max(Node x) {
		
		if (x.right == null) return x;
		return min(x.right);
	}
	
	public Iterable<Key> keys() {
		return keys(min(), max());
	}
	
	public Iterable<Key> keys(Key lo, Key hi) {
		Queue<Key> queue = new Queue<Key>();
		keys(root, queue, hi, lo);
		return queue;
		
	}
	
	
	public Iterable<Key> OrderedTraversal(String type) {
		Queue<Key> queue = new Queue<Key>();
		if (type.equals("In")) {
			InOrder(root, queue);
		}
		return queue;
	}
	
	private void InOrder(Node x, Queue<Key> q) {
		if (x == null) return;
		
		InOrder(x.left, q);
		q.enqueue(x.key);
		InOrder(x.right, q);
	}
	private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
		if (x == null) return;
		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);
		if (cmplo < 0) keys(x.left, queue, lo, hi);
		if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
		if (cmphi > 0) keys(x.right, queue, lo, hi);
	}
	
}
