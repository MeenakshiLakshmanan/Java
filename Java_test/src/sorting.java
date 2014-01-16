
class sort {
static int j=0,temp,length;
static int array[]=new int[9];
	static void bubble_sort(int a[]) {
		length=a.length;
			for (int i=0;(i<a.length-1);i++) {
				j=0;length--;
				while (j<length) {
					if(a[j]>a[j+1]) {
						temp=a[j];
						a[j]=a[j+1];
						a[j+1]=temp;
					}
					j++;
				}
			}
	
		for (int i:a) {
			System.out.println(i);
		}
	}
	static void selection_sort(int num[]) {
		int pivot,min,pos=0;
		for (int i=0;i<num.length-1;i++) {
			pivot=num[i];min=num[i+1];

			for (int j=i+1;j<num.length;j++) {	
				if(num[j]<=min) {
					min=num[j];
					pos=j;
				}
			}
				if(min<pivot) {
					temp=pivot;
					num[i]=min;
					num[pos]=temp;					
				}			
		}
		for (int i:num) {
			System.out.println(i);
		}
	}
	
	static void insertion_sort(int num[]) {
		int number;
		for (int i=0;i<num.length-1;i++) {
			number=num[i+1];
			for(int j=i;j>=0;j--) {
				if(number<num[j]) {
					num[j+1]=num[j];
					num[j]=number;
				}
				

			}
		}
		for (int i:num) {
			System.out.println(i);
		}
		
	}
	
	static void quick_sort (int lowerIndex, int higherIndex,int array[]) {
		      int i = lowerIndex;
	        int j = higherIndex;
	        // calculate pivot number, I am taking pivot as middle index number
	        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
	        // Divide into two arrays
	        while (i <= j) {
	            /**
	             * In each iteration, we will identify a number from left side which
	             * is greater then the pivot value, and also we will identify a number
	             * from right side which is less then the pivot value. Once the search
	             * is done, then we exchange both numbers.
	             */
	            while (array[i] < pivot) {
	                i++;
	            }
	            while (array[j] > pivot) {
	                j--;
	            }

	            if (i <= j) {
	            	int temp = array[i];
	    	        array[i] = array[j];
	    	        array[j] = temp;
	                //move index to next position on both sides
	                i++;
	                j--;
	            }
	        }
	       
	        
	        // call quickSort() method recursively
	        if (lowerIndex < j)
	            quick_sort(lowerIndex, j,array);
	        if (i < higherIndex)
	            quick_sort(i, higherIndex,array);
	        for (int j1:array) {
	    		System.out.print(j1+",");
	    	}
	        System.out.println();
	        
	   }
	static void merge_sort(int l,int h,int num[]) {

		int m=l+(h-l)/2;
		if(l<h) {
			System.out.println("l:"+l+"m:"+m+"h:"+h);
		merge_sort(l,m,num);
		merge_sort(m+1,h,num);
		combine_sort(l,m,h,num);
		
		for (int i:num) {
			System.out.print(i+",");
		}
		System.out.println();
		}	
			
	}
	static void combine_sort(int l,int m,int h,int num[]) {
		int i,j=m+1,k;int temp[]=new int[10];
			
		for(i=l;i<=h;i++) {
			temp[i]=num[i];
		}
		i=l;k=l;
		while(i<=m && j<=h) {
			
			if(temp[i]<=temp[j]) {
				num[k++]=temp[i++];			
			}
			else  {
				num[k++]=temp[j++];
			}
		}
		
		while(i<=m) {
			num[k++]=temp[i++];
		}
		while(j<=h) {
			num[k++]=temp[j++];
		}			
	}
	
	     
	
}

public class sorting {

public static void main(String args[]) {

	int num[]={3,7,8,5,2,1,9,5,10,4};
//	sort.bubble_sort(num);
//	sort.selection_sort(num);
//	sort.insertion_sort(num);
//	sort.quick_sort(0, num.length-1, num);
	sort.merge_sort(0, num.length-1, num);
}

	
}
