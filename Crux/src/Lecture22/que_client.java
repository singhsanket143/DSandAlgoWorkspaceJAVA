package Lecture22;

public class que_client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			queue q=new queue(5);
			for (int i=0;i<5;i++)
			{
				q.enqueue(5-i);
				displayqueueinfo(q);
			}

				System.out.println("point 1");
				q.enqueue(100);
				System.out.println("point 2");

				while (!q.isempty())
				{
					System.out.println(q.front());
					System.out.println(q.dequeue());
					displayqueueinfo(q);
				}
				
				System.out.println("point 3");
			q.dequeue();
				System.out.println("point 4");
						
					} catch (Exception ex) {
						System.out.println(ex);
					}
				}
				public static void displayqueueinfo(queue q)
				{
					System.out.println("size = "+q.size());
					System.out.println("is empty = "+q.isempty());
					q.display();
				}


	}