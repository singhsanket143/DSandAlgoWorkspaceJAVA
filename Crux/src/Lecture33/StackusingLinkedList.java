package Lecture33;


import Lecture33.queuesandstacks.linkedlist;

public class StackusingLinkedList {

	private linkedlist list;
	
	public StackusingLinkedList(){
		this.list=new linkedlist();
	}
	
	public void push(int item) throws Exception{
		this.list.addfirst(item);
	}
	public int size(){
		return this.list.size();
	}
	public boolean isEmpty(){
		return this.size()==0;
	}
	
	public int pop() throws Exception {
		
		try{
			int rv=this.list.removefirst();
			return rv;
		}catch(Exception ex){
			throw new Exception("Stack is empty");
		}
		
		
	}
	
	public int top() throws Exception {
		try{
			int rv=this.list.getfirst();
			return rv;
		}catch(Exception ex){
			throw new Exception("Stack is empty");
		}
	}
	
	public void display() throws Exception{
		this.list.display();
	}
	
}
