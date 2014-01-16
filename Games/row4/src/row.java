

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class setting
{
   int xcor,ycor;
   int flag,col;
   void set_position(int x,int y){}
   int getx() 
    {
        return(xcor);        
    }
   int gety() 
    {
        return(ycor);
    }   
}

class position extends setting
{
  void set_position(int x,int y) 
    {
      flag=0;
      xcor=105+x*50;
      ycor=455-y*50; 
      col=0;
    }
   
  int getflag()
    {
        return(flag);
    }
   void setflag(int f)
    {
       flag=f; 
    }
   int getcol() 
    {
        return(col);
    }
   void setcol(int f)
    {
       col=f; 
    }        
}

public class row extends Applet
{
   position p[][]=new position[8][8];
   Button b[]=new Button[8];
   int usr=0,system=0,hr,min,sec,win=0,sys=0,user=0;
    TextField txtuser=new TextField();
    TextField txtsys=new TextField();
    Label l1=new Label();Label l2=new Label();Label l3=new Label();
    Label l4=new Label();Label l5=new Label();Label l6=new Label();  
   boolean flag=false; 
   Color c1=new Color(255,175,150);//rose-user
   Color c2=new Color(175,200,250);//blue-system
   Color c3=new Color(185,255,225);
   Color c4=new Color(100,100,150);
   Font f1=new Font("MonotypeCorosiva",Font.BOLD,16);  
   Button res=new Button("RESTART");
   Button home=new Button("HOME");

    class al1 implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            Calendar c=Calendar.getInstance();  
           for(int i=0;i<8;i++)
               for(int j=0;j<8;j++)
               {
                 p[i][j].setflag(0);   
                 p[i][j].setcol(0);
                 system=0;usr=0;
               } 
           l1.setText(Integer.toString(c.get(c.HOUR))+" "+Integer.toString(c.get(c.MINUTE))+" "+Integer.toString(c.get(c.SECOND)));
           c.add(c.SECOND,60);
           l2.setText(Integer.toString(c.get(c.HOUR))+" "+Integer.toString(c.get(c.MINUTE))+" "+Integer.toString(c.get(c.SECOND)));
           hr=c.get(c.HOUR);
           min=c.get(c.MINUTE);
           sec=c.get(c.SECOND);
           l3.setText(Integer.toString(c.get(c.HOUR))+" "+Integer.toString(c.get(c.MINUTE))+" "+Integer.toString(c.get(c.SECOND)));
           repaint();
        }
    }

    public void init()
    {
          new menu().setVisible(true);        
      Calendar c=Calendar.getInstance();  
      add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);
      l4.setText("START TIME");
      l5.setText("END TIME");
      l6.setText("CURRENT TIME");
      l1.setText(Integer.toString(c.get(c.HOUR))+" "+Integer.toString(c.get(c.MINUTE))+" "+Integer.toString(c.get(c.SECOND)));
      c.add(c.SECOND,10);
      l2.setText(Integer.toString(c.get(c.HOUR))+" "+Integer.toString(c.get(c.MINUTE))+" "+Integer.toString(c.get(c.SECOND)));
      hr=c.get(c.HOUR);
      min=c.get(c.MINUTE);
      sec=c.get(c.SECOND);

      super.setSize(800, 501);
      add(txtuser);
      add(txtsys);
      add(res);
      add(home);
      home.setLocation(20, 535);
      res.setLocation(620, 535);
      l3.setText("            ");
      res.addActionListener(new al1());
      home.addActionListener(new al2());
      
    for(int i=0;i<8;i++)  
     {
       b[i] =new Button(""+i);
       b[i].addActionListener(new al());
       b[i].setBackground(c3);
       add(b[i]);
     }
       
     for(int r=0;r<8;r++)
      {
        for(int s=0;s<8;s++)
         {
           p[r][s]=new position();
           p[r][s].set_position(r,s);
          }
       }    
     }
    
  public void paint(Graphics g) 
   {
      Calendar c=Calendar.getInstance();      
      System.out.println(hr+" "+min+" "+sec);
      l3.setText(Integer.toString(c.get(c.HOUR))+" "+Integer.toString(c.get(c.MINUTE))+" "+Integer.toString(c.get(c.SECOND)));
      if((c.get(c.HOUR)>=hr)&&(c.get(c.MINUTE)>=min)&&(c.get(c.SECOND)>=sec))
        {
          hr=1000;
          if(Integer.parseInt(txtuser.getText())>Integer.parseInt(txtsys.getText()))
           {
              msgbox1 dialog = new msgbox1(new javax.swing.JFrame(), true);
              dialog.setVisible(true);
           }
           else  if(Integer.parseInt(txtuser.getText())==Integer.parseInt(txtsys.getText()))
           {
               msgbox2 dialog = new msgbox2(new javax.swing.JFrame(), true);
               dialog.setVisible(true);
           }
           else
           {
              msgbox dialog = new msgbox(new javax.swing.JFrame(), true);
              dialog.setVisible(true);
           }
           
             for(int i=0;i<8;i++)
               for(int j=0;j<8;j++)
               {
                 p[i][j].setflag(0);   
                 p[i][j].setcol(0);
                 system=0;usr=0;
               } 
             l1.setText(Integer.toString(c.get(c.HOUR))+" "+Integer.toString(c.get(c.MINUTE))+" "+Integer.toString(c.get(c.SECOND)));
             c.add(c.SECOND,10);
             l2.setText(Integer.toString(c.get(c.HOUR))+" "+Integer.toString(c.get(c.MINUTE))+" "+Integer.toString(c.get(c.SECOND)));
             l3.setText(Integer.toString(c.get(c.HOUR))+" "+Integer.toString(c.get(c.MINUTE))+" "+Integer.toString(c.get(c.SECOND)));
               repaint();
     }
       
      for(int i=0;i<8;i++)
      {
          if(p[i][7].getflag()!=0)
             b[i].setEnabled(false);
          else
             b[i].setEnabled(true); 
              
      }
      setBackground(c4);
      g.setFont(f1);
      int x=105,y=105,z=105;
      g.setColor(c3);
      g.fill3DRect(100, 100, 400, 400, true);
      g.draw3DRect(100, 100, 400, 400,true);
      g.setColor(c4);
      g.drawString("4 IN A ROW", 250, 50); 
      for(int i=0;i<8;i++)
       {
         b[i].setLocation(z,80);
         z+=52;
         for(int j=0;j<8;j++)
           {
             g.drawOval(x,y, 40, 40);
             x+=50;     
           }
         y+=50;x=105;
      }  
    
      if(flag==true)
       {   
          
        for(int i=0;i<8;i++)
         {
          for(int j=0;j<8;j++) 
           {
             if(p[i][j].getcol()==8)
              {
                 g.setColor(Color.RED);
                 g.fillOval(p[i][j].getx(), p[i][j].gety(), 42, 42);
                 try{
                    Thread.sleep(100);
                 }catch(Exception e){}
                 p[i][j].setcol(0);
                 g.setColor(c3);
                 g.fillOval(p[i][j].getx(), p[i][j].gety(), 40, 40);
              }
           
             if(p[i][j].getflag()==1)
              {
                g.setColor(c1);
                g.fillOval(p[i][j].getx(), p[i][j].gety(), 40, 40);
              }
             else if(p[i][j].getflag()==2) 
              { 
                 g.setColor(c2);
                 g.fillOval(p[i][j].getx(), p[i][j].gety(), 40, 40);
              }
            
//             else if(p[i][j].getflag()==3) 
//              {
//                 g.setColor(c1);
//                 g.fillOval(p[i][j].getx(), p[i][j].gety(), 40, 40);
//                 g.setColor(c3);
//                 g.fillOval(p[i][j].getx()+10, p[i][j].gety()+10, 20, 20); 
//              }   
//            else if(p[i][j].getflag()==4) 
//             {
//                  g.setColor(c2);
//                  g.fillOval(p[i][j].getx(), p[i][j].gety(), 40, 40);
//                  g.setColor(c3);
//                  g.fillOval(p[i][j].getx()+10, p[i][j].gety()+10, 20, 20);
//              }   
             
           
        }
        flag=false;
     } 
   }

      l1.setBackground(Color.orange);
      l1.setLocation(680, 10);
      l2.setBackground(Color.orange);
      l2.setLocation(680, 40);
      l3.setBackground(Color.orange);
      l3.setLocation(680, 70);
      l4.setBackground(Color.orange);
      l4.setLocation(550, 10);
      l5.setBackground(Color.orange);
      l5.setLocation(550, 40);
      l6.setBackground(Color.orange);
      l6.setLocation(550, 70);
       g.setColor(Color.ORANGE);
       txtuser.enable(false);
       txtsys.enable(false);
       g.drawString("USER", 545, 220);
       txtuser.setLocation(635,255);
       txtuser.setSize(50, 20);
       g.drawString("SYSTEM", 545, 265);
       txtsys.setSize(50,20);
       txtsys.setLocation(635,205);
       txtuser.setText(""+usr);
       txtsys.setText(""+system);
       res.setSize(90, 30);
       home.setSize(90, 30);
       res.setBackground(Color.orange);
       home.setBackground(Color.orange);
       res.setLocation(600,350);
       home.setLocation(600,400);

  }
   
  class al2 implements ActionListener
  {
      public void actionPerformed(ActionEvent ae)
      {
           for(int i=0;i<8;i++)
               for(int j=0;j<8;j++)
               {
                 p[i][j].setflag(0);   
                 p[i][j].setcol(0);
               } 
           repaint();
          new menu().setVisible(true);
      }
  }
   class al implements ActionListener
    {
     public void actionPerformed(ActionEvent ae)
      {
         Boolean ch=false;
         system s=new system(); 
       
        for(int q=0;q<8;q++)
         {
          if(ae.getActionCommand().equalsIgnoreCase(Integer.toString(q))==true)  
            if(s.drop(q,1)==false)
            {
             for(int i=0;i<8;i++)
               for(int j=0;j<8;j++)
               {
                 p[i][j].setflag(0);   
                 p[i][j].setcol(0);
                 system=0;usr=0;
               } 
           repaint();
            }  
             
          }
         
       
       
         if(s.drop(1)==false)
          { 
                  
           if(s.drop(2)==false)
            {
              l1:for(int j=0;j<8;j++)
                  {              
                   if(p[j][7].getflag()==0)
                    {
                      s.drop(j,2);
                      break l1;
                    }  
                 }
             }
         }
        if(s.check(1)==true)
           {
              win=1;
              repaint();
            //congrats you win  
           }
         if(s.check(2)==true)
          {
              win=2;
              repaint();
              //sorry u lose}
          }
      }
  }
   
   
   class system
   {
      //system process
       
     boolean check(int y)
     {     
       for(int i=0;i<5;i++)   
         {
          for(int j=0;j<8;j++)
           {                     
            if((p[j][i].getflag()==y)&&(p[j][i+1].getflag()==y)&&(p[j][i+2].getflag()==y)&&(p[j][i+3].getflag()==y))
             {
                 p[j][i].setcol(8);p[j][i+1].setcol(8);p[j][i+2].setcol(8);p[j][i+3].setcol(8);
                 if(y==1) usr+=1;
                 else if(y==2) system+=1;
                 try{
                     Thread.sleep(1000);
                     }catch(Exception e){}
              repaint();

              int k,l;
                  for( k=i+4,l=i;k<8;k++,l++)
                  {
                      p[j][l].setflag(p[j][k].getflag());
                      p[j][k].setflag(0);
                  }             
              for(k=7;k>=l;k--)
                p[j][k].setflag(0);
             
              try{
                 Thread.sleep(1000);
                }catch(Exception e){}
              repaint();
                 
             system s=new system();
             s.check(1);
             s.check(2);
             return(true);
              
            }
          }
       }
            
       for(int i=0;i<8;i++)   
         {
          for(int j=0;j<5;j++)
           {                     
             if((p[j][i].getflag()==y)&&(p[j+1][i].getflag()==y)&&(p[j+2][i].getflag()==y)&&(p[j+3][i].getflag()==y))
              {
                p[j][i].setcol(8);p[j+1][i].setcol(8);p[j+2][i].setcol(8);p[j+3][i].setcol(8);
                 if(y==1) usr+=1;
                 else if(y==2) system+=1;
                
                 repaint();
                
                  if(i==7)
                  for(y=j;y<4;y++)
                     p[y][i].setflag(0); 
                  
                 for(int k=i+1;k<8;k++)
                   for(int n=j;n<j+4;n++)
                   {
                       p[n][k-1].setflag(p[n][k].getflag());
                       p[n][k].setflag(0);
                               
                   }
              
                 try{
                    Thread.sleep(500);
                 }catch(Exception e){}
                 repaint();
                  
               system s=new system();
               s.check(1);
               s.check(2);
               return(true);
               
              }
            }
        }
          
//     
            
       for(int i=0;i<5;i++)   
        {
         for(int j=0;j<5;j++)
          {                     
           if((p[j][i].getflag()==y)&&(p[j+1][i+1].getflag()==y)&&(p[j+2][i+2].getflag()==y)&&(p[j+3][i+3].getflag()==y))
            {
                p[j][i].setcol(8);p[j+1][i+1].setcol(8);p[j+2][i+2].setcol(8);p[j+3][i+3].setcol(8);
                 if(y==1) usr+=1;
                 else if(y==2) system+=1;
              
                try{
                   Thread.sleep(1000);
                 }catch(Exception e){}
                repaint();
                if(i+3==7)
                     p[j+3][i+3].setflag(0);
//
               try{
                  Thread.sleep(1000);
                }catch(Exception e){}
                repaint();
                for(int w=j,n=i;w<j+4;w++,n++)
                 for(int p1=n+1;p1<8;p1++)
                 {
                   p[w][p1-1].setflag(p[w][p1].getflag());  
                   p[w][p1].setflag(0);
                 }
                          
                 system s=new system();
               s.check(1)                                                                                         ;
               s.check(2);
             return(true);
            }                     
          }
       }
            
       for(int i=0;i<5;i++)   
        {
         for(int j=7;j>2;j--)
          {                     
           if((p[j][i].getflag()==y)&&(p[j-1][i+1].getflag()==y)&&(p[j-2][i+2].getflag()==y)&&(p[j-3][i+3].getflag()==y))
            {
                p[j][i].setcol(8);p[j-1][i+1].setcol(8);p[j-2][i+2].setcol(8);p[j-3][i+3].setcol(8);
                if(y==1) usr+=1;
                 else if(y==2) system+=1;
               
                System.out.println("gf");
                try{
                    Thread.sleep(1000);
                }catch(Exception e){}
              
             
                if(j-3==0)
                    p[j-3][i+3].setflag(0);
                
              for(int w=j,n=i;n<i+4;w--,n++)
                 for(int p1=n+1;p1<8;p1++)
                 {
                   p[w][p1-1].setflag(p[w][p1].getflag());  
                   p[w][p1].setflag(0);
                 }
           
              
               system s=new system();
               s.check(1);
               s.check(2);
              return(true);
            }                     
         }
       }
                    
       return(false);     
     }
     
     boolean drop(int q,int f)
      {
        if(p[q][7].getflag()!=0)
            return(false);
       l1: for(int i=0;i<8;i++)
            {
              if(p[q][i].getflag()==0)
               {
                 p[q][i].setflag(f);
                 flag=true;
                 repaint(); 
                 break l1;
                 
               }
            }
       return(true);
      }
      
     boolean drop(int y)
      {   
         
        for(int i=0;i<8;i++)   
         {
          for(int j=0;j<5;j++)
           {                     
            if((p[j][i].getflag()==y)&&(p[j+1][i].getflag()==y)&&(p[j+2][i].getflag()==y)&&(p[j+3][i].getflag()==0))
             {
               if(i!=0)
               {  
                if(p[j+3][i-1].getflag()!=0)
                 {
                   drop(j+3,2);
                   flag=true;
                   repaint();
                   return(true);
                 }
              }
              if(i==0)
               {
                 drop(j+3,2);
                 flag=true;
                 repaint();
                 return(true);
               }
             }
           }
         }   
            
         for(int i=0;i<8;i++)   
          {
           for(int j=7;j>2;j--)
            {                     
             if((p[j][i].getflag()==y)&&(p[j-1][i].getflag()==y)&&(p[j-2][i].getflag()==y)&&(p[j-3][i].getflag()==0))
              {
               if(i!=0)
                {
                 if(p[j-3][i-1].getflag()!=0)
                  {
                    drop(j-3,2);
                    flag=true;
                    repaint();
                    return(true);
                 }
                }
                if(i==0)
                 {
                   drop(j-3,2);
                   flag=true;
                   repaint();
                   return(true);
                 }
              }
           }
        }
          
        for(int i=0;i<8;i++)   
         {
          for(int j=0;j<5;j++)
           {                     
            if((p[i][j].getflag()==y)&&(p[i][j+1].getflag()==y)&&(p[i][j+2].getflag()==y)&&(p[i][j+3].getflag()==0))
             {
                 drop(i,2);
                 flag=true;
                 repaint();
                 return(true);
             }                     
           }
         }
            
        for(int i=0;i<5;i++)   
         {
          for(int j=0;j<5;j++)
           {                     
             if((p[j][i].getflag()==y)&&(p[j+1][i+1].getflag()==y)&&(p[j+2][i+2].getflag()==y)&&(p[j+3][i+3].getflag()==0))
              {
               if(p[j+3][i+2].getflag()!=0)
                {
                  drop(j+3,2);
                  flag=true;
                  repaint();
                  return(true);
                }
              }                     
          }
       }
            
       for(int i=0;i<5;i++)   
        {
         for(int j=7;j>2;j--)
          {                     
           if((p[j][i].getflag()==y)&&(p[j-1][i+1].getflag()==y)&&(p[j-2][i+2].getflag()==y)&&(p[j-3][i+3].getflag()==0))
            {
             if(p[j-3][i+2].getflag()!=0)
              {
                drop(j-3,2);
                flag=true;
                repaint();
                return(true);
              }
            }                     
          }         
       }
                
      for(int i=0;i<8;i++)   
       {
        for(int j=0;j<5;j++)
         {                     
          if((p[j][i].getflag()==0)&&(p[j+1][i].getflag()==y)&&(p[j+2][i].getflag()==y)&&(p[j+3][i].getflag()==0))
           {
              if(i!=0)
               {   
                if(p[j+3][i-1].getflag()!=0)
                 {  
                   drop(j+3,2);
                   flag=true;
                   repaint();
                   return(true);                        
                }  
               }
              if(i==0)
              {
                   drop(j+3,2);
                   flag=true;
                   repaint();
                   return(true);    
              }
           }                     
         }
      }
             
     for(int i=0;i<5;i++)   
      {
       for(int j=0;j<5;j++)
        {          
          if((p[j+1][i+1].getflag()==y)&&(p[j+2][i+2].getflag()==y)&&(p[j+3][i+3].getflag()==y)&&(p[j][i].getflag()==0) )
          {
              if((i!=0)&&(p[j][i-1].getflag()!=0))
              {
             drop(j,2);
              flag=true;
              repaint();
              return(true);
              }
              else
              {
                   drop(j,2);
              flag=true;
              repaint();
              return(true);
              }
          }
         if((p[j][i].getflag()==y)&&(p[j+3][i+3].getflag()==y))
          {
           if((p[j+2][i+2].getflag()==y)&&(p[j+1][i+1].getflag()==0)&&(p[j+1][i].getflag()!=0))
              {   
                 drop(j+1,2);
                 flag=true;
                 repaint();
                 return(true);
              }
            
          else if((p[j+1][i+1].getflag()==y) &&(p[j+2][i+2].getflag()==0)&&(p[j+2][i+1].getflag()!=0))
              {   
                drop(j+2,2);
                flag=true;
                repaint();
                return(true);
              }  
           
        else if((p[j+1][i+1].getflag()==0)&&(p[j+2][i+2].getflag()==0)&&(p[j+2][i].getflag()!=0))
            {
             drop(j+2,2);
             flag=true;
             repaint();
             return(true);
             
          }
        }                     
      }
   }
                
    for(int i=0;i<5;i++)   
     {
      for(int j=7;j>2;j--)
       {         
          if((p[j-1][i+1].getflag()==y)&&(p[j-2][i+2].getflag()==y)&&(p[j-3][i+3].getflag()==y)&&(p[j][i].getflag()==0) )
          {
              if((i!=0)&&(p[j][i-1].getflag()!=0))
              {
             drop(j,2);
              flag=true;
              repaint();
              return(true);
              }
              else
              {
                   drop(j,2);
              flag=true;
              repaint();
              return(true);
              }
          }
        if((p[j][i].getflag()==y)&&(p[j-3][i+3].getflag()==y))
         {
           if((p[j-1][i+1].getflag()==y)&&(p[j-2][i+2].getflag()==0)&&(p[j-2][i+1].getflag()!=0))
             {      
              drop(j-2,2);
              flag=true;
              repaint();
              return(true);
              
          } 
          else if((p[j-2][i+2].getflag()==y)&&(p[j-1][i+1].getflag()==0)&&(p[j-1][i].getflag()!=0))
              {   
               drop(j-1,2);
               flag=true;
               repaint();
               return(true);
              } 
            
         else if((p[j-1][i+1].getflag()==0)&&(p[j-2][i+2].getflag()==0)&&(p[j-1][i].getflag()!=0))
             {   
               drop(j-1,2);
               flag=true;
               repaint();
               return(true);
               
           }
         }                     
      }
   }
    for(int i=0;i<8;i++)   
     {
      for(int j=0;j<5;j++)
       {                     
        if((p[j][i].getflag()==y)&&(p[j+3][i].getflag()==y))
         {
         if((p[j+2][i].getflag()==y)&&(p[j+1][i].getflag()==0))
          {
             repaint();
             try{
               wait(1000);
             }catch(Exception e){}      
             drop(j+1,2);
             flag=true;
             repaint();
            return(true);                        
          }
         else if((p[j+1][i].getflag()==y)&&(p[j+2][i].getflag()==0))
          {
             
            drop(j+2,2);
            flag=true;
            repaint();
            return(true);  
          }
        }                     
      }
   }
   return(false);
   }//check   
  }   
}

    