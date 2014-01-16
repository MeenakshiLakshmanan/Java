import java.util.Arrays;
import java.util.*;



class search_arr {
	int search(int arr[],int key,int start,int end) {
		if(start<end ) {
		int mid=start+(end-start)/2;
		if(key<arr[mid]) {
			return(search(arr,key,start,mid));
		}
		else if(key>arr[mid]) {
			return(search(arr,key,mid+1,end));
		}
		else if(key==arr[mid]) {
			return key;
		}
		}
		else {
		return -1;
	}
		return 1;
	}
	
}



public class search implements Comparator<Integer> {
	static int arr[]={10,20,35,30,40,80};
	
	public int compare(Integer a,Integer b) {
		if (a>b) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	public static void main (String args[]) {
	



Arrays.sort(arr);

	search_arr s=new search_arr();
	System.out.println("Found: "+s.search(arr,30,0,arr.length-1));
	
}



}
