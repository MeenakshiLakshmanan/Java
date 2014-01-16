import java.io.*;

class node {
	node left;
	node right;
	int data;

	public node(int value) {
		this.data=value;
		this.left=null;
		this.right=null;
	}
}

class BST {
	node root,elem;
	public void insert(int data) {
		node n=new node(data);		
		if(root==null) {
			root=n;		
		}
		else {
			insert_tree(root,n);
		}
	}
	
	public node insert_tree(node elem,node n) {

			if(elem!=null) {				 
				 if(n.data<elem.data) { elem.left=insert_tree(elem.left,n); }
				 if(n.data>elem.data) { elem.right=insert_tree(elem.right,n); }
			}
			else {
				elem=n;
			}
			return (elem);			
		}
		
	public void delete(int data) {
		delete_tree(root,data);
	}
	
	public node delete_tree(node elem,int data) {
		node elem1;
		
			 if(elem.data==data) {
				 if(elem.left==null && elem.right==null) {return null;}
				 else if(elem.left==null) {return elem.right;}
				 else if(elem.right==null) {return elem.left;}
				 else {
					 elem1=min(elem.right);
					 elem1.right=deletemin(elem.right);
					 elem1.left=elem.left;
					 return elem1;
				 }
			 }
			 if(data<elem.data) { elem.left=delete_tree(elem.left,data); }
			 if(data>elem.data) { elem.right=delete_tree(elem.right,data); }
			
		
	
			 return elem;
	}
	public node deletemin(node n) {
		if (n.left==null) return n.right;
		n.left=deletemin(n.left);
		return n;
	}
	
	public node min(node x) {
		node min=x;
		while(x!=null) {
			min=x;
			x=x.left;	
		}
		return min;
	}
	
	public void print() {
		
		print_tree(root);
	}
	public void print_tree(node n) {
		
		if(n==null) return;
			System.out.println(n.data);
			print_tree(n.left);
			print_tree(n.right);
			
	
		}
	public void bfs() {
		System.out.println(root.data);
		bfs_tree(root);
	}
	
	public void bfs_tree(node n) {
		if(n==null) return;
		else {
			if(n.left!=null) System.out.println(n.left.data); 
			if(n.right!=null) System.out.println(n.right.data);
		bfs_tree(n.left);
		bfs_tree(n.right);
		}
	}
	
	public void mirror() {
		mirror_tree(root);
		this.print();
	}
	
	public node mirror_tree(node n) {
		if(n!=null) {
		n.left=mirror_tree(n.left);
		n.right=mirror_tree(n.right);
		node temp=n.left;
		n.left=n.right;
		n.right=temp;
		}
	return n;
	
}
}

public class tree {
@SuppressWarnings("deprecation")
public static void main(String args[]) throws NumberFormatException, IOException {
	DataInputStream in;
	int data;String cont;
	BST b=new BST();;
do {
	System.out.println("1. Insert");
	System.out.println("2. Delete");
	System.out.println("3. Print");
	System.out.println("4. Mirror");
	System.out.println("5. BFS Tree");
	
	System.out.println("Enter a choice:");
	in=new DataInputStream(System.in);
	int choice=Integer.parseInt(in.readLine());
	
	
	switch(choice) {
	case 1:
		System.out.println("Enter a number to insert:");
		in=new DataInputStream(System.in);
		data=Integer.parseInt(in.readLine());
		b.insert(data);
	break;
		
	case 2:
		System.out.println("Enter a number to delete:");
		in=new DataInputStream(System.in);
		data=Integer.parseInt(in.readLine());	
		b.delete(data);
	break;	

	case 3:
		b.print();
	break;	
	
	case 4:
		b.mirror();
	break;
	
	case 5:
		b.bfs();
	break;	
	}
	System.out.println("Want to continue (y/n)");
	in=new DataInputStream(System.in);
	cont =in.readLine();
} while(cont.equals("y"));

}
}
