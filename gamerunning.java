package MyContra;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class gamerunning extends Thread{
    public  man man=new man(500,300);
    public samelist<zidan> zd;
    public samelist<AI> ai=new samelist<AI>();
    
    public Boolean gamestopflag=false;
    
    public gamewind gw;
    public Graphics g;
    public Random ra1=new Random();//随机数类
    ImageIcon img=new ImageIcon(this.getClass().getResource("1S640NK-0.jpg"));
    public Image imag=img.getImage();
    public Image[] bgimag=new Image[]{imag,imag};
    public ImageIcon [] manactivity=new ImageIcon[100];
    public int mapx1=0,mapx2=985;
    public char [] a=new char[3];
    
    
    public void set(gamewind gw){
    	this.gw=gw;this.g=this.gw.getGraphics();
	 }
    public void setmanactivity(ImageIcon [] manactivity){
    	this.manactivity=manactivity;
    }
    public void setman(man man){
    	this.man=man;
    }
    public void setzidan(samelist<zidan> zd){
    	this.zd=zd; System.out.println(this.zd);
    	}
    
    public void restart(){ man=new man(500,300);
    zd=new samelist<zidan>();
    ai=new samelist<AI>();
  gamestopflag=false;
     }
    
    public int  mapxmove(int j){//地图移动
    	if(j<-980)
    	 {j=980;}
    	if(j>980)
   	    {j=-980;}
    	j-=man.vx;
    	return j;
    	
    }
    
    public void run(){
    	while(true){
    		
    		while(gamestopflag){ try {//游戏暂停循环
				Thread.sleep(35);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    		}
    	
		if(ra1.nextInt(1000)%499==0){//刷怪速度
    			AI a1=new AI(man.x,man.y);ai.add(a1);//
    	}
    		
    		man.move();mapx1=mapxmove(mapx1);mapx2=mapxmove(mapx2);
    		g.drawImage(imag, mapx1, 0, gw);
    		g.drawImage(imag,mapx2, 0, gw);
    		if(zd!=null){
    		for(int i=0;i<zd.size();i++)
    		{if(zd.get(i)!=null)
    		    { if(zd.get(i).who!=0)
    			    {zd.get(i).move();
    		         g.setColor(Color.red);
    		         g.fillOval(zd.get(i).x+20,zd.get(i).y+25,7, 7);
    			    }
    		    }
    		}
    	  }
    		if(ai!=null){//System.out.println(ai);//怪物生成
        		for(int i=0;i<ai.size();i++)
        		{if(ai.get(i)!=null)
        		    { if(ai.get(i).who!=0){
        		    	ai.get(i).move();
        		         g.drawImage(manactivity[ai.get(i).acticitynumber].getImage(), ai.get(i).x, ai.get(i).y, gw);
        		           }
        			 }
        		    }
        		}
            g.drawImage(manactivity[man.acticitynumber].getImage(), man.x, man.y, gw);//玩家生成
            if(ai!=null){//System.out.println(ai);//怪物碰子弹
        		for(int i=0;i<ai.size();i++)
        		{if(ai.get(i)!=null)
        		    { if(ai.get(i).who!=0){	   		    	
        		 		if(zd!=null){
        		    		for(int k=0;k<zd.size();k++)
        		    		{if(zd.get(k)!=null)
        		    		    { if(zd.get(k).who!=0){
        		    		    	if(ai.get(i).vszidan(zd.get(k).x+20,zd.get(k).y+25))
        		    	                {ai.get(i).who=0;
        		    	                zd.get(k).who=0;
        		    	                }     
        		    			    }
        		    		    }
        		    		}
        		    	  }
        		    	
        		           }
        			 }
        		    }
        		}
            
            if(ai!=null){//System.out.println(ai);//怪物碰玩家
        		for(int i=0;i<ai.size();i++)
        		{if(ai.get(i)!=null)
        		    { if(ai.get(i).who!=0){
        		    	if(gamestopflag=man.vsAI(ai.get(i).x, ai.get(i).y))	
        		    	break;
        		           }
        			 }
        		    }
        		}
             	try {
				Thread.sleep(35);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
   	  
   	 
//    	g.drawChars(a, 100, 100,100, 100);
    
    }

}
