package batmanDataStructures;

/*
 * Generic version of the Stack class
 */

public class GenericStack {

	Object[] stack;
	int size;
	int top;
	
	//Constructor to initialize size and top variables.
	public GenericStack(){
		size=5;
		stack = new Object[size];
		top=-1;
	}
	
	//Constructor overloaded to set size
	public GenericStack(int size){
		this.size = size;
		stack = new Object[this.size];
		top = -1;
	}
	
	//Method to push object into stack
	void push(Object item){
		if(size!=0 && !isOverflow()){
			stack[++top]=item;
		} else {
			System.out.println("Stack is Overflow.");
		}
	}
	
	//Method to push array of objects into stack
	void push(Object[] items){
		if(size!=0 && !isOverflow() && size-top-1>=items.length){
			for(int i=0; i<items.length; i++){
				stack[++top]=items[i];
			}
		} else {
			System.out.println("Not enough room in the Stack");
		}
	}
	
	//Method to pop object out of stack
	Object pop(){
		if(size!=0 && !isUnderflow()){
			return stack[top--];
		} else {
			System.out.println("Stack is Underflow");
			return null;
		}
	}
	
	//Method to display current stack objects
	void display(){
		if(size!=0 && !isUnderflow()){
			System.out.println();
			for(int i=0; i<=top; i++){
				System.out.print(stack[i]+" |");
			}
		} else {
			System.out.println("Stack is Underflow");
		}
	}
	
	//Method to know whether Stack is overflow
	boolean isOverflow(){		
		return top==size-1;	
	}	
	
	//Method to know whether Stack is underflow
	boolean isUnderflow(){		
		return top==-1;	
	}
	
	//Method to get top element in stack
	public int getTop() {
		return top;	
	}
	
	//Method to get size 
	public int getSize() {
		return size;
	}

	//Method to set Stack size
	public void setSize(int size) {	
		this.size = size;	
	}	
	
	//Method to know whether Stack is empty
	public boolean isEmpty(){
		return top==size-1;
	}
}
