package MyContra;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class gamewind extends JFrame{
	 public AudioClip clip = Applet.newAudioClip(this.getClass().getResource("Effect10.wav"));
	public ImageIcon [] manactivity=new ImageIcon[100];
	public  static void main(String[] args){
		gamewind gw=new gamewind();
		gw.makewind();
	} 
    public void makewind(){
    	this.setTitle("��Ϸ����");
    	this.setSize(1000, 600);
    	this.setLayout(null);//this.setLayout(new FlowLayout(FlowLayout.CENTER));
    	this.setLocationRelativeTo(null);
    	this.setDefaultCloseOperation(3);
    	
    	clip.loop();
    	
//    	ImageIcon [] manactivity=new ImageIcon[5];
    	for(int i=0;i<=7;i++){//�������ͼƬ
//    		manactivity[i]=new ImageIcon(this.getClass().getResource(String.valueOf(i)+"man.png"));
    		for(int j=0;j<=4;j++)
    		{	int a=i+j*10;
    		manactivity[a]=new ImageIcon(this.getClass().getResource(String.valueOf(a)+"man.png"));
    		}//    		System.out.println(	manactivity.length);
    	}

    	MenuBar mb=new MenuBar();
    	Menu m=new Menu("����");
    	Menu b=new Menu("����˵��");
        MenuItem m1=new MenuItem("���¿�ʼ"); 
        MenuItem m2=new MenuItem("��ͣ/��ʼ"); 
        MenuItem m3=new MenuItem("w/��    j/����"); 
        MenuItem m4=new MenuItem("a/��    d/��"); 

    	mb.add(m);
    	mb.add(b);
    	m.add(m1);
    	m.addSeparator();
    	m.add(m2);
    	b.add(m3);
    	b.add(m4);
    	this.setMenuBar(mb);
    	
//    	ImageIcon imag=new ImageIcon(this.getClass().getResource("ȫͼ.jpg"));
//    	System.out.println(imag);
//		
//		JLabel lab=new JLabel(null,imag,0);
//		lab.setSize(200, 200);
//		this.add(lab);
    	
//    	 ImageIcon image = new ImageIcon("1S640NK-0.jpg");
//    	 JLabel la3 = new JLabel(image);
//    	 la3.setBounds(0, 0, this.getWidth(),this.getHeight() );//���ͼƬ������ͼƬ��СΪ���ڵĴ�С��
//    	 this.getLayeredPane().add(la3,new Integer(Integer.MIN_VALUE)); //��JLable���뵽�����������߲�
//    	 JPanel jp = (JPanel)this.getContentPane(); 
//    	 jp.setOpaque(false); //�����������Ϊ͸��
    	
        this.setVisible(true); 
        
        
    	
         gamerunning gr=new gamerunning();
        gr.set(this);
        gr.start();gr.setmanactivity(manactivity);
        
        gamelisten gl=new gamelisten();
        gl.set(this);gl.setgr(gr);
        this.addKeyListener(gl);
        
               m1.addActionListener(gl);
               m2.addActionListener(gl);
       
    }
}
