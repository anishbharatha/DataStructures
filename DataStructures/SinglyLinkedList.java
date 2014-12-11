package batmanDataStructures;

public class SinglyLinkedList {
	
	private int size;		//Variable to hold number of nodes in LinkedList
	private Node headNode;		//Node object to hold head node	
	private Node tailNode;		//Node object to hold tail node
	
	//Constructor to initialize LinkedList
	public SinglyLinkedList() {
		tailNode=null;
		size=0;		
	}
	
	//Appends the specified element to the end of this list
	public void add(Object element){
		if(isListEmpty()){
			headNode = new Node();
			headNode.data = element;
			headNode.next = null;			
			tailNode = headNode;
		} else {
			tailNode.next = new Node();
			tailNode = tailNode.next;
			tailNode.data = element;
			tailNode.next = null;			
		}
		size++;		
	}
	
	//Inserts the specified element at the specified position in this list.
	public void add(int index, Object element){
		 if(index>size || index<0){
				System.out.println("\naddNode: Invalid Node pos. No such Node exists.");
		 }else if(index==size){
			add(element);
		} else if(index==0){
			Node tempHead = new Node();
			tempHead.data = element;
			tempHead.next = headNode;
			headNode = tempHead;
			size++;		
		} else {
			Node tempNode = new Node();
			Node previousToNodePos = this.get(index-1);
			tempNode.data = element;
			tempNode.next = previousToNodePos.next;
			previousToNodePos.next = tempNode; 
			size++;
		}
	}
	
	/*Appends all of the elements in the specified collection to the end of this list, 
	 * in the order that they are returned by the specified collection's iterator.
	 */
	public void addAll(Object elements[]){
		for(int i=0; i<elements.length; i++){
			add(elements[i]);
		}
	}

	/*Inserts all of the elements in the specified collection into this list, 
	 * starting at the specified position.
	 */
	public void addAll(int index, Object elements[]){
		for(int i=0; i<elements.length; i++){
			add(index+i, elements[i]);
		}
	}
	
	//Inserts the specified element at the beginning of this list.
	public void addFirst(Object element){
		if(isListEmpty()){
			headNode = new Node();
			headNode.data = element;
			headNode.next = null;
			tailNode = headNode;
		} else {
			Node tempHead = new Node();
			tempHead.data = element;
			tempHead.next = headNode;
			headNode = tempHead;
		}
		size++;
	}
	
	//Appends the specified element to the end of this list.
	public void addLast(Object element){
		add(element);
	}
	
	//Removes all of the elements from this list.
	public void clear(){
		headNode = tailNode = null;
	}
	
	//Returns a shallow copy of this LinkedList.
	public SinglyLinkedList clone(){
		SinglyLinkedList clone = new SinglyLinkedList();
		for(int i=0; i<size; i++){
			clone.add(get(i));
		}
		return clone;
	}
	
	//Returns true if this list contains the specified element.
	public boolean contains(Node node){
		for(int i=0; i<size; i++){
			if(get(i)==node.data){
				return true;
			}			
		}
		return false;
	}
	
	//Removes the first occurrence of the specified element from this list, if it is present.		
	public void	remove(){
		removeLast();
	}

	//Retrieves and removes the head (first element) of this list. 
	public void remove(int index){
		if(index==0){	
			removeFirst();
		} else if(index==size){
			removeLast();
		} else if(index>size || index<0){
			System.out.println("\nremoveNode: Invalid Node #. No such Node exists.");
		} else{ 		
			Node previousToTargetNode = headNode;
			int i=0;
			while(i<index-1){
				previousToTargetNode = previousToTargetNode.next;
				i++;
			}
			previousToTargetNode.next = previousToTargetNode.next.next; 
			size--;
		}				
	}
	
	//Removes and returns the first element from this list.
	public void removeFirst(){
		if(size==0){
			System.out.println("No nodes to display.");
		} else if(size==1){
			System.out.println("**"+tailNode);
			headNode = null;
			size--;
		} else {
			headNode = headNode.next;
			size--;
		}
	}
	
	//Removes and returns the last element from this list.
	public void removeLast(){		
		if(size==0){
			System.out.println("No nodes to display.");
		} else if(size==1){
			System.out.println("**"+tailNode);
			headNode = null;
			size--;
		} else {
			Node previousToTail = headNode;
			while(previousToTail.next!=tailNode){
				previousToTail = previousToTail.next;
			}
			tailNode = previousToTail;
			tailNode.next = null;			
			size--;
		}
	}
	
			
	//Returns the element at the specified position in this list.
	public Node get(int nodePos){
		if(!isListEmpty() && nodePos==0){
			return headNode;
		} else if(!isListEmpty() && nodePos==size){
			return tailNode;
		} else if(nodePos>size || nodePos<0){
			System.out.println("getNode. Invalid Node pos. No such Node exists.");
			return null;
		} else {
			Node tempNode = headNode;
			int i=0;
			while(i<nodePos){
				tempNode = tempNode.next;
				i++;
			}
			return tempNode;
		}
	}
	
	//Returns the first element in this list.
	public Node	getFirst(){
		return headNode;
	}

	//Returns the last element in this list.
	public Node	getLast(){
		return tailNode;
	}

	
	//Method to display all the nodes in the LinkedList.
	public void show(){
		if(isListEmpty()){
			System.out.println("No nodes to display.");
		} else {
			Node tempNode = headNode;
			System.out.println();
			for(int i=0; i<size; i++){							
				//System.out.print(" ["+tempNode.data+"| "+tempNode.next+"]"); //Uncomment this line to display the real address of next node
				System.out.print(" ["+tempNode.data+"| "+(tempNode.next!=null?"@NEXT":"NULL")+"]");
				tempNode = tempNode.next;
			}
		}
	}
	
	//Method to check whether the LinkedList is empty
	public boolean isListEmpty(){
		return size==0;
	}
	
	//Returns the number of elements in this list.
	public int	getSize(){
		return size;
	}
}

//Node class to hold data and next nodes' address
class Node{
	Object data;
	Node next;
	
	
	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}
	/**
	 * @return the next
	 */
	public Node getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(Node next) {
		this.next = next;
	}
}