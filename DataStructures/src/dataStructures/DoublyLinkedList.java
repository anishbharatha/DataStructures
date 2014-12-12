package src.dataStructures;

public class DoublyLinkedList {
	int size;
	Node headNode;
	Node tailNode;
	
	DoublyLinkedList(){
		size=0;
		headNode = tailNode = null;
	}
	
	//Appends the specified element to the end of this list.
	void add(Object element){
		if(size==0){
			headNode = new Node();
			headNode.prev = null;
			headNode.data = element;
			headNode.next = null;
			tailNode = headNode;
		} else {
			tailNode.next = new Node();
			tailNode.next.prev = tailNode;			
			tailNode.next.data = element;
			tailNode.next.next = null;
			tailNode = tailNode.next;
		}
		size++;
	}
	
	//Inserts the specified element at the specified position in this list.
	void add(Object element, int index){
		if(index==0){
			addFirst(element);
		} else if(index==size){
			addLast(element);
		} else if(index<0 || index>size){
			System.out.println("Wrong node position. No such node exists.");
		} else {
			Node tempNode = new Node();
			Node previousToIndexNode = this.get(index-1);	
			tempNode.prev = previousToIndexNode;
			tempNode.data = element;
			tempNode.next = previousToIndexNode.next;
			previousToIndexNode.next = tempNode;
			tempNode.next.prev = tempNode;
			size++;
		}
	}
	
	//Inserts the specified element at the beginning of this list.
	void addFirst(Object element){
		Node tempNode = new Node();
		tempNode.prev = null;
		tempNode.data = element;
		tempNode.next = headNode;		
		headNode.prev = tempNode;
		headNode = tempNode;
		size++;
	}
	
	//Appends the specified element to the end of this list.
	void addLast(Object element){	
		add(element);
	}	
	
	//Removes all of the elements from this list.
	void clear(){
		headNode = tailNode = null;
		size=0;
	}
		
	//Returns the element at the specified position in this list.
	Node get(int position){
		if(size==0 || position>=size){
			System.out.println("List is empty. No node exists at "+position);
			return null;
		} 
		else if(position==0) return getFirst();
		else if(position==size-1) return getLast();
		else {
			Node tempNode = headNode;
			int i=0;
			while(i<position){
				tempNode = tempNode.next;
				i++;
			}
			return tempNode;
		}
	}
	
	//Returns the first element in this list.
	Node getFirst(){
		return headNode;
	}
	
	//Returns the last element in this list.
	Node getLast(){
		return tailNode;
	}
	
	//Prints all the elements in this list.
	void show(){
		if(size==0){
			System.out.println("\nNo elements to show. List is empty.");
		} else {
			Node tempNode = headNode;
			System.out.println();
			for(int i=0; i<size; i++){
				System.out.print(tempNode.data+"->");//Uncomment to show real prev & next address
				/*System.out.print(tempNode.prev!=null?"[@PREV":"[NULL");
				System.out.print("| "+tempNode.data+" |");
				System.out.print(tempNode.next!=null?"@NEXT] ":"NULL] ");
				*/
				tempNode = tempNode.next;
			}
		}
	}

	//Prints all the elements in this list in reverse order.
	void showReverse(){
		if(size==0){
			System.out.println("\nNo elements to show. List is empty.");
		} else {
		Node tempNode = tailNode;
		System.out.println();
		for(int i=0; i<size; i++){			
			System.out.print(tempNode.data+"<-");
			tempNode = tempNode.prev;
		}
		}
	}
	
	//Retrieves and removes the head (first element) of this list.
	void remove(){
		if(size==0){
			System.out.println("List is empty to remove any node.");
		} else if(size==1){
			headNode = tailNode = null;
			size--;
		} else {
			tailNode = tailNode.prev;
			tailNode.next = null;
			size--;
		}
	}
	
	//Removes the element at the specified position in this list.
	void remove(int index){
		if(index==0) removeFirst();
		else if(index==size) removeLast();
		else if(index>size){
			System.out.println("List is empty. No nodes to remove.");
		} else {
			Node previousToIndexNode = get(index-1);
			previousToIndexNode.next = previousToIndexNode.next.next;
			previousToIndexNode.next.prev = previousToIndexNode;
			size--;
		}
	}
	
	//Removes and returns the first element from this list.
	void removeFirst(){
		if(size>0){
			headNode = headNode.next;
			headNode.prev = null;
			size--;
		} else {
			System.out.println("List is empty. No nodes to remove.");
		}
	}
	
	//Removes and returns the last element from this list.
	void removeLast(){
		if(size>0){
			tailNode = tailNode.prev;
			tailNode.next = null;
			size--;
		} else {
			System.out.println("List is empty. No nodes to remove.");
		}
	}	
	
	//Returns the number of elements in this list.
	int size(){
		return size;
	}

	class Node{
		Node prev;
		Object data;
		Node next;
		
		public Node getPrev() {
			return prev;
		}
		public Object getData() {
			return data;
		}
		public Node getNext() {
			return next;
		}
	}	
}
