
class base {
	
}

class derived extends base {
	public int a[]={1,2,3};
	derived() {
		System.out.println(a[5]);
		
	}
	derived(String messages) {
		System.out.print("Hello");
	}
}


public class Exceptions {
 public static void main (String args[]) {
	derived d= new derived(); 
 }
}
