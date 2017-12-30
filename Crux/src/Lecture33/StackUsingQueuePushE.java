package Lecture33;

import Lecture33.queuesandstacks.dynamic_queue;

public class StackUsingQueuePushE {
	private dynamic_queue queuePrimary;
	private dynamic_queue queueSecondary;
	
	public StackUsingQueuePushE(){
		this.queuePrimary=new dynamic_queue();
		this.queueSecondary=new dynamic_queue();
	}
	
	public void push(int item) throws Exception{
		this.queuePrimary.enqueue(item);
	}
	public int size(){
		return this.queuePrimary.size();
	}
	public boolean isEmpty(){
		return this.size()==0;
	}
	
	public int pop() throws Exception{
		int rv=0;
		while(this.queuePrimary.size()==1){
			this.queueSecondary.enqueue(this.queuePrimary.dequeue());
		}
		rv=this.queuePrimary.dequeue();
		dynamic_queue temp=this.queuePrimary;
		this.queuePrimary=this.queueSecondary;
		this.queueSecondary=temp;
		return rv;
	}
	
	public int top() throws Exception{
		int rv=0;
		while(this.queuePrimary.size()==1){
			this.queueSecondary.enqueue(this.queuePrimary.dequeue());
		}
		rv=this.queuePrimary.dequeue();
		this.queueSecondary.enqueue(rv);
		dynamic_queue temp=this.queuePrimary;
		this.queuePrimary=this.queueSecondary;
		this.queueSecondary=temp;
		return rv;
	}
	
	public void display() throws Exception{
		this.displayhelper();
		System.out.println("end");
		dynamic_queue temp=this.queuePrimary;
		this.queuePrimary=this.queueSecondary;
		this.queueSecondary=temp;
	}
	private void displayhelper() throws Exception{
		if(this.queuePrimary.isempty()){
			return;
		}
		int item=this.queuePrimary.dequeue();
		this.queueSecondary.enqueue(item);
		this.displayhelper();
		System.out.print(item+"=>");
	}
}
