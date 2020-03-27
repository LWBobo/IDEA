package client;

import java.awt.event.*;
import javax.swing.*;

import gui.AdLogin;
import gui.ServerGUI;
import org.json.JSONArray;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class ServerTask extends ServerGUI implements ActionListener{
	protected ServerSocket ss;
	protected Socket currs;
	protected IOHandler ioh;
	protected ListThread lst;
	protected int usrport;

	List<String> nameL = new ArrayList(); 
	List<DataOutputStream> outL = new ArrayList(); 
	List<DataInputStream> inL = new ArrayList(); 
	List<Integer> UPL = new ArrayList<>();
	//userportlist
	
	public ServerTask(){
		try{
		jtfs[0].setText(InetAddress.getLocalHost().getHostAddress());
		}catch(IOException e){}
		jb[0].addActionListener(this);
		jb[1].addActionListener(this);
		ForceOffline.addActionListener(this);
		jluser.getSelectedIndex();
		nameL.add("3&&");
	}
	
	@Override
   public void actionPerformed(ActionEvent e){
	   if(e.getSource()==jb[0])
		   doStart();
	   if(e.getSource()==jb[1])
		   doExit();
	   if(e.getSource()==ForceOffline)
		   doOffLine();
		   
   }
	
   public void doStart(){
	   String port=jtfs[1].getText();
	   try {
			if(port == null || port.equals("")){
				JOptionPane.showMessageDialog(null, "请输入端口号");
				return;	}
			else
		  { 
		 ss = new ServerSocket(Integer.parseInt(port));
	     jtchat.setText(null);
	     jtchat.append("服务器已启动！\n");
	     new ListThread().start();
              }
      }catch(IOException e){
    	  jtchat.append("服务器启动失败！\n");
      }
   }
 
   
   public boolean doOffLine()
   {
	  List<String> temp = new ArrayList();
	  String flag = "4&&";
	  String username  = jluser.getSelectedValue().toString();
	 // System.out.println(username);
	  int n = nameL.indexOf(username);
	  temp.add(flag);
	  temp.add(username);
	  try {
			nameL.remove(username);
			dm.removeElement(username);
			//发送用户信息
			JSONArray ja = new JSONArray(temp);
			for(int i=0;i<outL.size();i++){
				outL.get(i).writeUTF(ja.toString());
			}
			jtchat.append(username + " 被踢出服务器\n");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		JOptionPane.showMessageDialog(null, "请确认已有用户连接到服务端！");
		e.printStackTrace();
	}

		
	   return false;  
   }
   
   
   class ListThread extends Thread{
	   public void run(){
		   currs=null;
		   while(true){
			   try{
				   currs=ss.accept();
				  // System.out.println(currs.getRemoteSocketAddress());
				   DataInputStream dis = new DataInputStream(currs.getInputStream());
				   DataOutputStream dos = new DataOutputStream(currs.getOutputStream());
				   inL.add(dis);
				   outL.add(dos);
				   new IOHandler(dis).start();
			   }catch(IOException e){}
		   }
	   }
   }
   class IOHandler extends Thread{
	   private DataInputStream s;
	   public IOHandler(DataInputStream s){
		   this.s=s;
	   }
	   public void run(){
		   try{
			   while(true) {
			   String mess = s.readUTF();
				//发送姓名
				if(mess.startsWith("1&&")) {
					String username = mess.substring(3);
					nameL.add(username);
					dm.addElement(username);
					jtchat.append(username + " 登录服务器\n");
					//发送用户信息
					JSONArray ja = new JSONArray(nameL);
					for(int i=0;i<outL.size();i++){
						outL.get(i).writeUTF(ja.toString());
					}
				}
				else if(mess.startsWith("2&&")) {
					String username = mess.substring(3);
					dm.removeElement(username);
					int n = nameL.indexOf(username);
					nameL.remove(n);
					inL.remove(n-1);
					outL.remove(n-1);
					jtchat.append(username + " 退出服务器\n");
					
					List<String> list = new ArrayList();
					list.add("2&&");
					list.add(username);
					JSONArray ja = new JSONArray(list);
					for(int i=0;i<outL.size();i++){
						outL.get(i).writeUTF(ja.toString());
					}
				}
				//处理群发消息
				//处理一对一聊天信息
				else {
					JSONArray ja = new JSONArray(mess);
					String fromName = ja.getString(0);
					String content = ja.getString(1);
					String toName = ja.getString(2);
					if(toName.equals("all")) {
						jtchat.append(fromName + "对所有人说："+content+"\n");
						for(int i=0;i<outL.size();i++) {
							DataOutputStream toOut = outL.get(i);
							toOut.writeUTF(mess);
						}
					}else {
						jtchat.append(fromName + "对"+toName+"说："+content+"\n");
						int n = nameL.indexOf(toName);
						DataOutputStream toOut = outL.get(n-1);
						toOut.writeUTF(mess);
					}
				}
			   }
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
   }
   public void doExit(){
	   jtchat.setText(null);
	   jtchat.append("服务器已关闭！\n");
	   dm.removeAllElements();
	   nameL.removeAll(nameL);
	   
	   try{
		   ss.close();
	   }catch(IOException e){}
   }
	public static void main(String args[]){
		//创建登陆窗口
		AdLogin adlog = new AdLogin();
		
		while(!adlog.getFlag()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println(adlog.getFlag());
		if(adlog.getFlag()) {
		adlog.setVisible(false);
		JFrame app=new JFrame("服务器端界面");
		app.getContentPane().add(new ServerTask());
		app.setSize(800,650);
		app.setVisible(true);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setLocationRelativeTo(adlog);
		}
		}
	}
   
/****调试时使用***/
//   public static void main(String args[]){
//   
//		JFrame app=new JFrame("服务器端界面");
//		app.getContentPane().add(new client.ServerTask());
//		app.setSize(800,650);
//		app.setVisible(true);
//		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		app.setLocationRelativeTo(app);
//   }
 }

