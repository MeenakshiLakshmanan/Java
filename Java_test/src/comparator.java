import java.util.*;

class student1 implements Comparable<student1> {
	int mark;
	String name;
	
	public student1(int m,String n) {
		mark=m;name=n;
	}
	
	public int compareTo(student1 s1) {
		return (this.mark-s1.mark);
	}
}

public class comparator {
public static void main (String args[]) {
//Collections
	
	ArrayList<student1> al=new ArrayList<student1>();
	al.addAll(Arrays.asList(new student1(20,"aaa"),new student1(10,"bbb"),new student1(200,"aaa"),new student1(15,"aaa")));
	Collections.sort(al);

	Iterator<student1> it=al.iterator();
	while(it.hasNext()) {
	System.out.println(it.next().mark+"");
	}

//Arrays
	int a[]={10,5,60};
	Arrays.sort(a);
	for(int i:a) {
		System.out.print(i+" ");
	}
	
	System.out.println();
// Objects
	student1 s[]={new student1(20,"aaa"),new student1(10,"bbb"),new student1(200,"aaa")};
	Arrays.sort(s);
	for(int i=0;i<s.length;i++) {
		System.out.print(s[i].mark+" ");
	}
	
}
	
	
}
