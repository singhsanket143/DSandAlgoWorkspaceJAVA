package Lecture28.story;

public class car implements Comparable<car>{
	int speed;
	int price;
	car(int speed,int price){
		this.speed=speed;
		this.price=price;
	}
	@Override
	public int compareTo(car o){
		return this.speed-o.speed;
	}
	
	@Override
	public String toString(){
		return this.speed+"&"+this.price;
	}
}
