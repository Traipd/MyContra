package MyContra;

import java.util.Random;

public class AI extends man{
public int who=1;	  
public Random ra1=new Random();
public AI(int x, int y) {
		super(x, y);
		if(x>500){this.x=1000;this.vx=-3;}
		else{this.x=0;this.vx=3;}
		
	}

public Boolean vszidan(int x,int y){
	Boolean flag=false;
	   if(this.x+65<x||x+7<this.x){
		}else {if(y>this.y+90||this.y>y+7){}
		       else{System.out.println(this.x+" "+this.y+"   "+x+" "+y);
			   flag=true;}
		}
	   return flag;
}

public void move(){
	   lastx=x;lasty=y;
	   x+=vx;y+=vy;
if(ra1.nextInt(40)%17==0){vy=-25;}
    
	   //位置变化与速度记录
	   if(y>=500||y<20){
		   y=lasty;
		   }
	   if(x<-50||x>1001){
		   who=0;
		   }
	   if(vy<10){
		   lastvy=vy;vy+=5;
		  
		} 
//	   if(vx>0){lastvx=vx;vx-=1;}
//	   if(vx<0){lastvx=vx;vx+=1;}
	   //动作变化
	   if(vx>0){
		   this.acticitynumber=changeactivity(6);
		  }
	   else{
		   this.acticitynumber=changeactivity(7);
	   }
	   }


	


}
