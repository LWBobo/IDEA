package gui;

import java.awt.*;
import javax.swing.*;
public class ServerGUI extends ParentGUI {
	protected JPanel right;
	protected JLabel userlist;
	protected JList jluser;
	protected DefaultListModel dm;
	protected JButton ForceOffline;
	public ServerGUI(){
		super(2);
		
       jb[0].setText("启动服务器");
		jb[1].setText("停止服务器");
		ForceOffline = new JButton("强制下线");
		userlist=new JLabel("在线用户列表");
		jluser=new JList();	
		 dm=new DefaultListModel();
		 jluser.setModel(dm);
		 northPanel.add(ForceOffline);
		right=new JPanel();
		 right.setLayout(new BorderLayout());
		 right.add(userlist,BorderLayout.NORTH);
		 right.add(jluser,BorderLayout.CENTER);
	  
		add(right,BorderLayout.CENTER);
						
	}
	public static void main(String args[]){
		JFrame app=new JFrame("服务器端界面");
		app.getContentPane().add(new ServerGUI());
		app.setSize(800,650);
		app.setVisible(true);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

