package gui;

import java.awt.*;
import javax.swing.*;
public class ParentGUI extends JPanel {
   protected int jlab_size;
   protected JLabel jlbs[];  //服务器IP地址、服务器端口号标签
   protected JTextField jtfs[];
   protected JButton jb[]; //启动服务器、结束按钮
	protected JLabel chatmess;  //聊天信息标签
	protected JTextArea jtchat; //聊天信息框
	protected JPanel northPanel;
   protected JPanel centerPanel;
   protected JPanel southPanel;
   public ParentGUI(int size){
	   jlab_size=size;
	   setLayout(new BorderLayout());
	   jlbs=new JLabel[jlab_size];
	   jtfs=new JTextField[jlab_size];
	   jb=new JButton[2];
	   for(int i=0;i<jlbs.length;i++){
		   jlbs[i]=new JLabel("标签"+i);
		   jtfs[i]=new JTextField(12);
		 
	   }
	   for(int i=0;i<2;i++)
		   jb[i]=new JButton("按钮"+i);
	   jlbs[0].setText("服务器IP ");
	   jlbs[1].setText("服务器端口号");
	    northPanel=new JPanel();
	   for(int j=0;j<jlbs.length;j++){
		   northPanel.add(jlbs[j]);
		   northPanel.add(jtfs[j]);
		   	   }
	   for(int j=0;j<2;j++)
		   northPanel.add(jb[j]);
	   chatmess=new JLabel("聊天信息");
	   jtchat=new JTextArea(30,35);	
	   jtchat.setLineWrap(true);
	   jtchat.setEditable(false);
	   
	   JScrollPane jscro = new JScrollPane(jtchat);
	   jscro.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	   jscro.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

	   centerPanel=new JPanel();
	   southPanel=new JPanel();
	  JPanel innerPanel=new JPanel();
	   innerPanel.setLayout(new BorderLayout());
	  innerPanel.add(chatmess,BorderLayout.NORTH);
	   innerPanel.add(jscro,BorderLayout.CENTER);
	   centerPanel.add(innerPanel);
	   
	   add(northPanel,BorderLayout.NORTH);
	   add(centerPanel,BorderLayout.WEST);
	  add(southPanel,BorderLayout.SOUTH);
   }
   public static void main(String args[]){
	   JFrame app=new JFrame("父类图形界面");
	   ParentGUI p=new ParentGUI(2);
	   app.getContentPane().add(p);
	   app.setSize(700, 650);
	   app.setVisible(true);
	   
			   }
}
