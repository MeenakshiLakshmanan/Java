//
//class test1 implements Runnable {
//	public void run() {
//		for(int i=0;i<10;i++) {
//		System.out.println("Inside run method"+i);
//		}
//		}
//}
//
//public class test {
//public static void main (String args[]) {
//	Runnable r1=new test1();
//	Runnable r2=new test1();
//	Thread t1=new Thread(r1);
//	Thread t2=new Thread(r2);
////	for (int i=0;i<10;i++) {
//	t1.start();
//	System.out.println("In main method");
//	t2.start();
//	
////	}
//	}
//	
//	
//}

//class reverse1 {
//	String reverse(String str) {
//		if(str.length()<=1) return "";
//		return(reverse(str.substring(1))+(str.charAt(0)));
//	}
//}
//
//
//
//public class test {
//	public static void main(String args[]) {
//		String str="abcd";
//		reverse1 s=new reverse1();
//		
//		String temp=s.reverse(str);		
//		System.out.println("Reverse string:"+temp);
//	}
//
//}



public class test {
 

     
	
	   // determines the largest of three Comparable objects
	   public static <T extends Comparable<T>> T maximum(T x, T y, T z)
	//public static <T> T maximum(T x, T y, T z)
	{  
		  
	      T max = x; // assume x is initially the largest  
	      
	      if ( y.compareTo( max ) > 0 ){
	         max = y; // y is the largest so far
	    
	      }
	      if ( z.compareTo( max ) > 0 ){
	         max = z; // z is the largest now                 
	      }
	      return max; // returns the largest object   
	   }
	   public static void main( String args[] )
	   {
		   int a=3,b=4,c=5;
		  
	      System.out.printf( "Max of %d, %d and %d is %d\n\n", 
	                   3, 4, 5, maximum( a,b,c) );

	      System.out.printf( "Maxm of %.1f,%.1f and %.1f is %.1f\n\n",
	                   6.6, 8.8, 7.7, maximum( 6.6, 8.8, 7.7 ) );

	      System.out.printf( "Max of %s, %s and %s is %s\n","pear",
	         "apple", "orange", maximum( "pear", "apple", "orange" ) );

	   }
	}