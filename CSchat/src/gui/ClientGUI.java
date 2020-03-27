package gui;

import java.awt.*;
import javax.swing.*;

public class ClientGUI extends ParentGUI {
	//private JLabel lblUser ;
//	private JTextField txtUser; 
	protected JTextField inputmess;
	protected JLabel chatlist;
	protected JComboBox chatobj;
	protected JButton sent;
	protected JButton clear;
	protected JButton refresh;
	protected JButton headimg;
	protected JLabel username_head;
	protected ImageIcon headimage;
	protected JComboBox<String> OnlineStatus;

	public ClientGUI(){
		super(3);
		headimage = new ImageIcon("src//image//HeadImg.png");
		headimage.setImage(headimage.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		//headimage.setImage(image);
		jb[0].setText("连接 ");
		jb[0].setForeground(Color.red);
		jb[0].setBorderPainted(false);
		jb[1].setText("断开");
		jb[1].setForeground(Color.red);
		jb[1].setBorderPainted(false);
		jlbs[2].setText("登录名称");
		jtchat.setColumns(50);
		
		OnlineStatus = new JComboBox<String>();
		OnlineStatus.addItem("在线");
		OnlineStatus.addItem("请勿打扰");
		OnlineStatus.addItem("隐身");
		OnlineStatus.addItem("离线");
		 
		username_head = new JLabel("null");
		inputmess=new JTextField(30);
		chatlist=new JLabel("选择聊天对象");
		chatobj=new JComboBox();
		refresh=new JButton("刷新");
		sent=new JButton("发送");
		clear=new JButton("清除");
		headimg = new JButton("");
		headimg.setBorderPainted(false);
		headimg.setBackground(Color.white);
		headimg.setIcon(headimage);
		centerPanel.add(headimg);
		centerPanel.add(username_head);
		centerPanel.add(OnlineStatus);
		southPanel.add(inputmess);
		southPanel.add(chatlist);
		southPanel.add(chatobj);
		southPanel.add(refresh);
		southPanel.add(sent);
		southPanel.add(clear);
		
		
	}
	public static void main(String args[]){
		JFrame app=new JFrame("客户端界面");
		app.getContentPane().add(new ClientGUI());
		app.setSize(800,650);
		app.setVisible(true);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
