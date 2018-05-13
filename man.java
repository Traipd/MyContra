package MyContra;

public class man {
   public int x,y,vx,vy=10;
   public int lastx,lasty,lastvx,lastvy;
   public int blood,attak,changenumber=0,acticitynumber=0;
   public man(int x,int y){
	   this.x=x;this.y=y;
   }
   public void setacticitynumber(int i){
	   this.acticitynumber=changeactivity(i);
   }
   public void setv(int vx,int vy){
	   this.vx=vx;this.vy=vy;
   }
   
   public Boolean vsAI(int x,int y){
	   Boolean flag=false;
	   if(this.x+60<x||x+45<this.x){
		}else {if(vy<5){if(y>this.y+50||this.y>y+75){}
                        else{//System.out.println(this.x+" "+this.y+"   "+x+" "+y);
	                    flag=true;}}
		       else{ if(y>this.y+105||this.y>y+75){}
		              else{//System.out.println(this.x+" "+this.y+"   "+x+" "+y);
			          flag=true;}}
		}
	   return flag;
   }
   
   public void move(){
	   lastx=x;lasty=y;
	   x+=vx;y+=vy;
	   //位置变化与速度记录
	   if(y>=500||y<20){
		   y=lasty;
		   }
	   if(x<250||x>700){
		   x=lastx;
		   }
	   if(vy<10){
		   lastvy=vy;vy+=5;  
		} 
	   if(vx>0){lastvx=vx;vx-=1;}
	   if(vx<0){lastvx=vx;vx+=1;}
	   //动作变化
	   if(vx==0){
		  if(vy==10){ 
		   
		      if(lastvx>0){acticitynumber=2;}
		      if(lastvx<0){acticitynumber=3;}
	          if(lasty>485){
			     if(lastvx>0){acticitynumber=0;}
		         if(lastvx<0){acticitynumber=1;}
	             }
		  }
	   }
	   
   }
   //
   public int changeactivity(int a){
	   if(vx!=0||vy<5)
	   {  changenumber++;
	      if(changenumber%10==0){changenumber=0;}
	      a=a+10*(changenumber/2);
	      
	   }return a;
   }
   
   
}
