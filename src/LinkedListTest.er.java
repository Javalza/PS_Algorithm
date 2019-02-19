import java.util.Comparator;
class LinkedList<E> {

	class Node<E> {
		private E data;
		private Node<E> next;

		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}

	public LinkedList() {
		head = crnt = null; // 첫 생성시
	}

	private Node<E> head;
	private Node<E> crnt; // 선택 노드

	public E search(E obj, Comparator<? super E> c) { // 하향제한 제네릭스
		Node<E> ptr = head;
		while (ptr != null) {
			if (c.compare(obj, ptr.data) == 0) {
				crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next;
		}
		return null; // 검색 실패
	}

	public void addFirst(E obj) {
		Node<E> ptr = head;
		head = crnt = new Node<E>(obj, ptr);
	}

	public void addLast(E obj) {
		if (head == null)
			addFirst(obj);
		else {
			Node<E> ptr =head;
			while(ptr.next!=null)
				ptr = ptr.next;
			ptr.next = crnt = new Node<E>(obj,null);
		}
	}
	public void removeFirst() {
		if(head!=null)
			head = crnt = head.next;	//head.next.next ? 
	}
	public void removeLast() {
		if(head !=null){
			if(head.next == null) { //노드가 하나만 있는경우 
				removeFirst();
			}
			else {
				Node<E> ptr = head; //스캔중인 노드 
				Node<E> pre = head; //스캔중인 앞 노드
				
				while(ptr.next != null) {
					pre = ptr;
					ptr = ptr.next;  // ptr = ptr.next 
				}
				pre.next = null; // ptr = null 해도 될 것 같음.. 
				crnt = pre; 
			}
			
		}
	}
	public void remove(Node p) {
		if(head != null) {
			if(p==head)
				removeFirst();
			else {
				Node<E> ptr = head;
				
				while(ptr.next != p) {
					ptr = ptr.next;
					if(ptr == null) return ; 
				}
				ptr.next = p.next;
				crnt = ptr; 
			}
		}
	}
	public void removeCurrentNode() {
		remove(crnt);
	}
	public void clear() {
		while(head != null)
			removeFirst();
		crnt = null;
	}
	public boolean next() {
		if(crnt == null || crnt.next ==null)
			return false;
		crnt = crnt.next;
		return true;
	}
	public void printCurrentNode() {
		if(crnt==null) System.out.println("선택한 노드가 없습니다.");
		else System.out.println(crnt.data);
	}
	public void dump() {
		Node<E> ptr = head;
		while(ptr != null) {
			System.out.println(ptr.data);
			ptr=ptr.next;
		}
	}
}

public class List {
	public static void main(String[] args) {

	}

}
