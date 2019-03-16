import java.util.*;
public class Solution {

	public static void main(String[] args) {
		TreeMap<Node,Integer> hmap=new TreeMap<Node,Integer>(new myComparator());
	}
	

}
class myComparator implements Comparator<Node>{
	 
    @Override
    public int compare(Node e1, Node e2) {
        return e1.value.compareTo(e2.value);
    }
}

class Node{
    
    public String value;
    public int S;
     
}