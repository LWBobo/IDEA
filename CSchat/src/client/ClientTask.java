package client;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import gui.*;
import org.json.JSONArray;
import org.json.JSONObject;
public class ClientTask extends ClientGUI implements ActionListener{
public Socket cs;
protected DataOutputStream toServer;
protected DataInputStream fromServer;
protected String username;
protected ChangeHeadImage CHI = new ChangeHeadImage(headimg);

public ClientTask() {
	// TODO Auto-generated constructor stub
	jb[0].addActionListener(this);
	jb[1].addActionListener(this);
	sent.addActionListener(this);
	clear.addActionListener(this);
	refresh.addActionListener(this);
	headimg.addActionListener(CHI);
	OnlineStatus.setSelectedIndex(3);
	OnlineStatus.addItemListener(new ItemListener() {
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if (e.getStateChange() == ItemEvent.SELECTED)
			{
				if(OnlineStatus.getSelectedIndex()==0) {
					if(cs==null)
						doConn();
				}
				//if(OnlineStatus.getSelectedIndex()==1) doConn();
				//if(OnlineStatus.getSelectedIndex()==2) doConn();
				if(OnlineStatus.getSelectedIndex()==3) {
					if(cs!=null)
					doExit();
				}
			}
		}
	});
	
}
public void actionPerformed(ActionEvent e){
	   if(e.getSource()==sent)
		    doSent();
	   else if(e.getSource()==clear)
		    doClear();
	   else if(e.getSource()==jb[0])
			doConn();
	   else if(e.getSource()==jb[1])
	   {
		   OnlineStatus.setSelectedIndex(3);
			doExit();
	   }
	   else if(e.getSource()==refresh)
		    doRefersh();
	   
}
	private void doRefersh() {
	// TODO Auto-generated method stub
		try {
			toServer.writeUTF("3&&");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
}
	public void doSent() {
	// TODO Auto-generated method stub
		if(cs==null) JOptionPane.showMessageDialog(null, "服务端未连接！！");
//判断未连接，不向服务端发送json数据
		else {
		String message = inputmess.getText();
		jtchat.append(username +": @"+chatobj.getSelectedItem()+" "+message+"\n");
//		toServer = new DataOutputStream(cs.getOutputStream());
//		toServer.writeUTF("2&&"+message);
//		System.out.println(cs);
		String toServerUser = (String)chatobj.getSelectedItem();   
		List<String> chatMsg = new ArrayList();
		chatMsg.add(username);
		chatMsg.add(message);
		chatMsg.add(toServerUser);
		JSONArray ja = new JSONArray(chatMsg);
		try {
			toServer.writeUTF(ja.toString());
		} catch (IOException e) {
			// toServerDO AutoServer-generated catch block
			e.printStackTrace();
		}	
		}
}
	public void doExit() {
	// TODO Auto-generated method stub
		username_head.setForeground(Color.GRAY);
		jtchat.append("Disconnect Succeed~\n");
	try {	
		toServer.writeUTF("2&&"+username);
		cs.close();
		cs = null;
		OnlineStatus.setSelectedIndex(3);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	public void doConn() {
	// TODO Auto-generated method stub
	if(cs==null) {
	username = jtfs[2].getText();
	String ip = jtfs[0].getText();
	String port = jtfs[1].getText();
	if(port == null || port.equals("")||username == null||username.equals("")){
		JOptionPane.showMessageDialog(null, "请填写IP/端口号/用户名");
		OnlineStatus.setSelectedIndex(3);
		return;}
		else
	{
		try {
		cs= new Socket(ip, Integer.parseInt(port));
		jtchat.append("Connected Succeed~\n");
		fromServer = new DataInputStream(cs.getInputStream());
		toServer = new DataOutputStream(cs.getOutputStream());
		toServer.writeUTF("1&&"+username);
		jtchat.append(username+"登陆成功\n");
		username_head.setText(username);
		username_head.setForeground(Color.green);
		OnlineStatus.setSelectedIndex(0);
		new getMsgThread().start();
		System.out.println(cs.getLocalPort());
	}
	catch (IOException e) {
		jtchat.append("Connected Failed~\n");
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	}
	else
	{
		JOptionPane.showMessageDialog(null, "请尝试断开链接后重新连接！！！");
	}
}
	public void doClear() {
	// TODO Auto-generated method stub
	inputmess.setText("");
}
	
class getMsgThread extends Thread{
		public void run() {
			while(true) {
				try {
					String jaStr = fromServer.readUTF();
					JSONArray ja = new JSONArray(jaStr);
					String flat = ja.getString(0);
					if(flat.equals("3&&")){
						chatobj.removeAllItems();
						 for(int i=1;i<ja.length();i++) {
					        	String s = ja.getString(i);
					        	if(s.equals(username)) continue;
					        	chatobj.addItem(s);
					        }
						 chatobj.addItem("all");
					}
					else if(flat.equals("2&&")){
						 String s = ja.getString(1);
						 chatobj.removeItem(s);
					}
					else if(flat.equals("4&&"))
					{
						doExit();
						jtchat.append("您已被踢出服务器！");
					}
					else {
//						发送信息用户的name不能是"3&&"，"2&&"
						String fromServerName = ja.getString(0);
						String content = ja.getString(1);
						JSONObject messjson; 
						if(content.startsWith("{")){
							messjson = new JSONObject(content);
							content= messjson.getString("content");
							//jtchat.append("茉莉机器人："+messjson.getString("content")+"\n");
						}
						if(!fromServerName.equals(username))
							jtchat.append(fromServerName+"对我说："+content+"\n");
					}
				}catch(IOException e) {
				}
			}
		}
	}


	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame app=new JFrame("客户端任务界面");
		app.getContentPane().add(new ClientTask());
		app.setSize(800,710);
		app.setVisible(true);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

}
