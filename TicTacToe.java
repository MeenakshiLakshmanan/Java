import java.io.DataInputStream;
import java.io.IOException;

class board {
	int elem[][]=new int[3][3];

	board () {
		for (int i=0;i<3;i++)
			for (int j=0;j<3;j++)
				elem[i][j]=-1;
	}

	int set_location(int r,int c,int str) {
		System.out.println("Played: " + r +" "+c+" "+ str);
		
		elem[r][c]=str;
		if (check_win() ==0) {
			System.out.println("System has won");
			return 0;
		}
		else if(check_win()==1) {
			System.out.println("You have won");
			return 1;
		}
	 return -1;
	}
		
		
	int check_win() {
		for (int i=0;i<3;i++)
			if(elem[i][0]==elem[i][1] && elem[i][1] ==elem[i][2]) return elem[i][1];
				
		for (int j=0;j<3;j++)
				if(elem[0][j]==elem[1][j] && elem[1][j]==elem[2][j]) return elem[2][j];
							
		if(elem[0][0]==elem[1][1] && elem[1][1]==elem[2][2]) return elem[1][1];
		else if (elem[0][2]==elem[1][1] && elem[1][1]==elem[2][0])  return elem[1][1];
		
		return -1;
	}
	

}

interface player {
	int player=-1;
	Boolean play(board b);
}

class human implements player  {
	DataInputStream ds;

	public Boolean play (board b) {
		int row=0,col=0;
		
		System.out.println("You have to play: ");
		try {
			System.out.println("Enter row :");
			ds=new DataInputStream(System.in);
			row=Integer.parseInt(ds.readLine());
				
			System.out.println("Enter col :");
			ds=new DataInputStream(System.in);
			col=Integer.parseInt(ds.readLine());
			
			b.set_location(row,col,1);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
		
	}
	
}


class computer implements player {

	@Override
	public Boolean play(board b) {
		int set=0,r=0,c=0,cont=-1;
		
		
		System.out.println("System have to play: ");
		// Put 0 in empty places and see if system can win, if not revert back
		 out: for (int i=0;i<3;i++) {
			 
			for(int j=0;j<3;j++) {
				if(b.elem[i][j]==-1){
					
					b.elem[i][j]=0;
					if(b.check_win()==0) { set=1; cont=b.set_location(i, j, 0); break out;}
					else b.elem[i][j]=-1;

					r=i;c=j;
				}
			}
		}
		
		// Put 1 in empty places and see if user can win, if so, in that location put 0,
		if(set ==0) 
		out:for (int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(b.elem[i][j]==-1){
					b.elem[i][j]=1;
					if(b.check_win()==1) { set=1; cont=b.set_location(i, j, 0); break out;}
					else b.elem[i][j]=-1;
					r=i;c=j;
					}
			}
		}
		 
		// If not set anywhere, place it in some random last location
	 if (set==0) {	 cont=b.set_location(r, c, 0); }
	if(cont!=-1) return false;	
	
	return true;	
	}
   
}

public class TicTacToe {

	public static void main(String args[]) throws Exception{
		board b=new board();
		Boolean var=true;
		player h=new human();
		player c= new computer();
		while (var==true) {
			var=h.play(b);
			var=c.play(b);
		}
	}
	
	
	
}
