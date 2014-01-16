import java.util.*;

class student implements Comparable<student> {
	String name;
	int age;
	student (String n,int a) {
		name=n;age=a;
	}
	
	public int compareTo(student s1) {
		if(this.age<s1.age) {
			return -1;
		}
		else {
			return 1;
		}
	}
	
	
}

class student_sort implements Comparator<student> {
	public int compare (student s1, student s2) {
		if(s1.age>s2.age) {
			return 1;
		}
		else {
		return -1;
		}
	}
}

class search_arr_collection {
	int search(ArrayList<student> arr,int key,int start,int end) {
		if(start<end ) {
		int mid=start+(end-start)/2;
		if(key<arr.get(mid).age) {
			return(search(arr,key,start,mid));
		}
		else if(key>arr.get(mid).age) {
			return(search(arr,key,mid+1,end));
		}
		else if(key==arr.get(mid).age) {
			return key;
		}
		}
		else {
		return -1;
	}
		return 1;
	}
	
}

public class stack {

	public static void main(String args[]) {
	
		
//		int num[]=new int[10];
//		for(int i=0;i<10;i++) {
//			num[i]=i;
//		}
//		for (int i:num) {
//		System.out.println("Array Contents :"+ num[i]);
//
//		}
		
		
//		ArrayList<Integer> al=new ArrayList<Integer>();
//		al.add(new Integer(100));
//		al.add(new Integer(30));
//		//enqueue
//		al.add(40);
//		al.add(50);
//		//dequeue
//		System.out.println("Dequeue:"+al.get(0));
//		al.remove(0);
//		Iterator<Integer> arr= al.iterator();
//		
//		while(arr.hasNext()) {
//			System.out.println(arr.next());
//		}
		
System.out.println("good");
		ArrayList<student> al=new ArrayList<student>();
	
		al.add(new student("aa",30));
		al.add(new student("bb",10));
		al.add(new student("zb",60));
		student s=new student("qq",35);
		al.add(s);

		//comparator
		//Collections.sort(al,new student_sort());
		System.out.println(al.contains(s));
		
		//comparable
		Collections.sort(al);
		
		Iterator<student> it=al.iterator();
		while (it.hasNext()) {
			s=it.next();
			System.out.println(s.name+":"+ s.age);
		}
		search_arr_collection s1=new search_arr_collection();
		System.out.println("Searching for :"+s1.search(al,35,0,al.size()));
		
		}
}
