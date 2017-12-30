package Lecture29;


public class HeapClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Heap<student> RankList = new Heap<>(true);
		// RankList.add(new student(900, 10, "AK"));
		// RankList.add(new student(800, 20, "RY"));
		// RankList.add(new student(700, 30, "MY"));
		// RankList.add(new student(600, 40, "NM"));
		// RankList.add(new student(500, 50, "A"));
		// RankList.add(new student(400, 60, "B"));
		// RankList.add(new student(300, 70, "C"));
		// RankList.add(new student(200, 80, "D"));
		// RankList.add(new student(100, 90, "E"));
//		student[] students = new student[9];
//		students[0] = new student(900, 10, "AK");
//		students[1] = new student(800, 20, "RY");
//		students[2] = new student(700, 30, "MY");
//		students[3] = new student(600, 40, "NM");
//		students[4] = new student(500, 50, "A");
//		students[5] = new student(400, 60, "B");
//		students[6] = new student(300, 70, "C");
//		students[7] = new student(200, 80, "D");
//		students[8] = new student(100, 90, "E");
//		Heap<student> RankList = new Heap<>(students, true);
		Integer[] arr={10,20,80,30,14,19,22};
		HeapSort(arr);
		for(Integer val:arr){
			System.out.println(val);
		}
//		RankList.display();

		// while (!RankList.isEmpty()) {
		// System.out.println(RankList.remove());
		// }
	}

	public static class student implements Comparable<student> {
		int marks;
		int rank;
		String name;

		student(int marks, int rank, String name) {
			this.marks = marks;
			this.rank = rank;
			this.name = name;
		}

		public String toString() {
			return "[" + this.name + " , M = " + this.marks + " , R = " + this.rank + "]";
		}

		public int compareTo(student o) {
			return this.rank - o.rank;
		}
	}

	public static void HeapSort(Integer[] arr) {
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			downHeapify(arr, i, arr.length);
		}
		for (int i = 0; i < arr.length; i++) {
			Integer temp = arr[0];
			arr[0] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
			downHeapify(arr, 0, arr.length - 1 - i);
		}
	}

	public static void downHeapify(Integer[] arr, int pi, int lp) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		int mi = pi;
		if (lci < lp && arr[lci] > arr[mi]) {
			mi = lci;
		}
		if (rci < lp && arr[rci] > arr[mi]) {
			mi = rci;
		}
		if (mi != pi) {
			Integer temp = arr[mi];
			arr[mi] = arr[pi];
			arr[pi] = temp;
			downHeapify(arr, mi, lp);
		}
	}
}