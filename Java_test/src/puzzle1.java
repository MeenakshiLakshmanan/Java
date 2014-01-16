import java.util.*;


public class puzzle1 {
public static void main(String args[]) {
	ArrayList<Integer> al=new ArrayList<Integer>();
	for(int i=1;i<=5;i++) {
		al.add(i*10);
	}

	int cnt=1;
	Iterator<Integer> it=al.iterator();
	while(al.size()>1) {
		it=al.iterator();
	while(it.hasNext()) {
		it.next();
		if(cnt%3==0) {
			it.remove();
		}
		cnt++;
	}
	
	}
	it=al.iterator();
	while(it.hasNext()) {
		System.out.print(it.next()+" " );
	}
//	int cnt=1;int i=0;
//
//	while(al.size()>1) {
//		
//		
//		
//		if(cnt%3==0) {
//			al.remove(i);
//			i--;
//		}
//		System.out.println("HEELO"+i+" "+cnt+" "+al.size());
//		if((i+1)==al.size()) {i=0;}
//		cnt++;i++;
//		
//	}
//	
//	System.out.println();
//Iterator<Integer> it=al.iterator();
//while(it.hasNext()) {
//	System.out.print(it.next()+" " );
//}
}
}
