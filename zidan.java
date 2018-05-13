package MyContra;

public class zidan {
	int x,y,vx=0,vy=0;
	int who=0;
	public zidan(int x,int y,int vx/**man.lastvx**/,int vy){
		this.x=x;this.y=y;this.who=1;
		if(vy==10){
			if(vx>0){this.vx=5;}
			if(vx<0){this.vx=-5;}
		}
		else{this.vy=-5;}
		
	}
	public void move(){
		if(x>-7&&x<1000&&y>0&&y<600)
		{x+=vx;y+=vy;}
		else{who=0;}
		
	}

}
