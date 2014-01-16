import java.io.DataInputStream;
import java.io.IOException;
import java.util.*;

class node1 {
	String data;
	node1(String data) {
		this.data=data;
	}
}

class traversal {
	HashMap <String,ArrayList<String>> adj=new HashMap<String,ArrayList<String>>();
	ArrayList<String> value;
	HashMap <String,Integer> visited=new HashMap<String,Integer>();
	Queue<String> q=new LinkedList<String>();
	Stack<String> s=new Stack<String>();
	String elem="";
	
void connect(node1 src,node1 dest) {
	value=adj.get(src.data);
	
	if(value==null) {
		value=new ArrayList<String>();
	}	
	value.add(dest.data);
	adj.put(src.data, value);
}

void bfs(node1 n) {
	q.add(n.data);
	visited.put(n.data, 1);
	while(true) {
		if(q.size()==0) return;

		elem=q.remove(); 
		System.out.print(elem+" ");
		ArrayList<String> t=adj.get(elem);
	
	if(t.size()>0 ) {
	Iterator<String> it=t.iterator();
	while(it.hasNext()) {
		String temp=it.next();
		if(visited.get(temp)!=1) {	
			visited.put(temp,1);
			q.add(temp);
			}	
		}
	  }
	}
  }

String firstunvisited(String n) {
	ArrayList<String> t=adj.get(n);
	Iterator<String> it=t.iterator();
	while(it.hasNext()) {
		String temp=it.next();
		if(visited.get(temp)==0) return temp;
	}
	return null;
		
}

void dfs(node1 n) {
	s.push(n.data);
	visited.put(n.data,1);
	System.out.print(n.data+" ");
	
	while(true) {
		if(s.size()==0) return;
		String s1=firstunvisited(s.peek());
	
		if(s1!=null) {
			visited.put(s1,1);
			System.out.print(s1+" ");
			s.push(s1);
		}
		else s.pop();		
    }
  }
}


public class Graph {
@SuppressWarnings("deprecation")
public static void main(String args[]) throws IOException {
	System.out.println("Enter 5 nodes:");
	traversal t=new traversal();
	DataInputStream in=new DataInputStream(System.in);
	String inp=new String();
	String temp[]=new String[20];
	
	
	node1 n[]=new node1[5];
	for(int i=0;i<5;i++) {
		n[i]=new node1(in.readLine());
		t.visited.put(n[i].data, 0);
	}
	
	System.out.println("Enter node connections:");
	for(int i=0;i<5;i++) {
		System.out.println("Node1 connectons of "+n[i].data);
		inp=in.readLine();
		temp=inp.split(" ");
		
		for (int k=0;k<temp.length;k++) {
		for(int j=0;j<5;j++) {
			if(temp[k].equals(n[j].data)) {
				t.connect(n[i],n[j]);
				break;
			}
		}
		}
	}
//	t.connect(n[0],n[1]);
//	t.connect(n[1],n[0]);
//	t.connect(n[0],n[2]);
//	t.connect(n[2],n[0]);
	
	
System.out.print("BFS:");
	t.bfs(n[0]);
	for(int i=0;i<5;i++) {
		t.visited.put(n[i].data,0);
	}
	System.out.print("DFS:");
	t.dfs(n[0]);
	
 }
	
}
