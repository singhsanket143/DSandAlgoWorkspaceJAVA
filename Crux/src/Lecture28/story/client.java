package Lecture28.story;

public class client {

	public static void main(String[] args) {

		car[] cars=new car[5];
		cars[0]=new car(10, 100);
		cars[1]=new car(100, 100);
		cars[2]=new car(50000, 100);
		cars[3]=new car(80, 100);
		cars[4]=new car(120, 100);
		
		bubblesort(cars);
		for(car car: cars){
			System.out.println(car);
		}
	}

	public static <T extends Comparable<T>> void bubblesort(T[] arr) {
		int counter = 1;
		while (counter <= arr.length - 1) {
			for (int i = 0; i < arr.length - counter; i++) {
				if (arr[i + 1].compareTo(arr[i]) < 0) {
					T temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}

			}
			counter++;
		}
	}

}
