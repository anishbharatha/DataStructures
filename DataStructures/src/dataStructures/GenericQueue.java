package dataStructures;

public class GenericQueue {
	Object[] queue;
	int size;	//To hold the queue size
	int rear;	//To refer to queue rear-element
	int front;	//To refer to queue front-element
	
	//Constructor to initialize with size = 5 
	public GenericQueue(){		
		size = 5;
		queue = new Object[size];
		front = rear = -1;
	}
	
	//Constructor to initialize Queue with given size
	public GenericQueue(int size){
		if(size!=0){
			this.size = size;
			queue = new Object[this.size];
			front = rear = -1;
		} else {
			System.out.println("Invalid Queue size");
		}
	}
		
	//Method to insert Objects into Queue
	public void insert(Object item){		
		if(!isOverflow()){
			queue[++rear]=item;
			if(front==-1){ front=rear;}
						
		} else {
			System.out.println("Queue is Overflow");
		}
	}
	
	//Method to remove front Object from Queue
	public Object remove(){
		if(!isUnderflow()){
			
			return queue[front++];
									
		} else {
			System.out.println("Queue is Underflow");
			return null;
		}
	}
	
	//Method to display all Objects in Queue
	public void display(){
		if(!isUnderflow()){
			System.out.println();
			for(int i=front; i<=rear; i++){
				System.out.print(queue[i]+" |");
			}
			System.out.println("Rear: "+queue[rear]+" Front: "+queue[front]);
		}
	}
	
	//Method to know whether Queue is Overflow
	public boolean isOverflow(){
		return rear==size-1;
	}
	
	//Method to know whether Queue is Underflow
	public boolean isUnderflow(){
		return rear==-1;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getRear() {
		return rear;
	}

	public int getFront() {
		return front;
	}	
}
