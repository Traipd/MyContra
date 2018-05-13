package MyContra;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class gamelisten  extends KeyAdapter implements ActionListener {
//    public  man man=new man(500,300);
    public gamewind gw;
    public Graphics g;
    public gamerunning gr;
    public samelist<zidan> zd=new samelist<zidan>();
    public AudioClip clip = Applet.newAudioClip(this.getClass().getResource("Effect5.WAV"));
    public int i=-1;
    public void set(gamewind gw){
    	this.gw=gw;this.g=this.gw.getGraphics();
    	 }
    public void setgr(gamerunning gr){this.gr=gr;}
	
    
	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
//		System.out.println(e.getID()+"  "+e.getKeyCode());
		if(e.getKeyCode()==10){
			gr.gamestopflag=false;
		}
		 if(e.getKeyChar()=='w'){
               gr.man.setv(gr.man.vx, -20);
               if(gr.man.lastvx>0)
               {gr.man.setacticitynumber(2);}
               else
               {gr.man.setacticitynumber(3);}
         }
          if(e.getKeyChar()=='s'){
//        	 

          }
          if(e.getKeyChar()=='a'){
        	  gr.man.setv(-5, gr.man.vy);
        	  gr.man.setacticitynumber(1);
          }
          if(e.getKeyChar()=='d'){
        	  gr.man.setv(5, gr.man.vy);
        	  gr.man.setacticitynumber(0);
          }
          
	}

	public void keyReleased(KeyEvent e) {
              if(e.getKeyChar()=='j'){
//        	  i++;
        	  zidan z=new zidan(gr.man.x,gr.man.y,gr.man.lastvx,gr.man.vy);
//        	  System.out.println(z+"zidan z=new zidan");
        	  zd.add(z);
   //     	  AudioClip clip = Applet.newAudioClip(this.getClass().getResource("Effect5.WAV"));//播放音乐用
          	clip.play();
   
        	  gr.setzidan(zd);
        	 
          }
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
	   	switch(e.getActionCommand()){
	   	case"重新开始":
	   		gr.restart();
	   		break;
	   	case"暂停/开始":
	   		gr.gamestopflag=!gr.gamestopflag;
	   		break;
	   	
	   	}
		
	}
 
}
