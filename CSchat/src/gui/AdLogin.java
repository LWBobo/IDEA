package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author 情空明月
 *
 */
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.sun.xml.internal.org.jvnet.staxex.Base64EncoderStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder; 
public class AdLogin extends JFrame implements ActionListener{
	protected JButton loginButton;
	protected JTextField username;
	protected JPasswordField password;
	protected BASE64Encoder encrypt;
	protected BASE64Decoder decrypt;
	protected boolean loginflag;
	public AdLogin() {
			loginflag = false;
		    decrypt = new BASE64Decoder();
			setLayout(new BorderLayout());
	        JPanel mpc = new JPanel();
	        JPanel mpb = new JPanel();
	        JPanel mpt = new JPanel();
	        add(mpc,BorderLayout.CENTER);
	        add(mpb,BorderLayout.SOUTH);
	        add(mpt,BorderLayout.NORTH);
	        mpc.setLayout(null);
	        JLabel welcome = new JLabel("欢迎进入管理员界面，请先登录");
	        welcome.setForeground(Color.red);
	        JLabel usernameLabel = new JLabel("用户名:");
	        usernameLabel.setBounds(20,20,80,25);
	        username = new JTextField(20);
	        username.setBounds(100,20,165,25);
	        JLabel passwordLabel = new JLabel("密码:");
	        passwordLabel.setBounds(20,50,80,25);
	        password = new JPasswordField(20);
	        password.setBounds(100,50,165,25);
	        loginButton = new JButton("登录");
	        loginButton.addActionListener(this);
	        
	        
	        mpt.add(welcome);
	        mpc.add(usernameLabel);
	        mpc.add(username);
	        mpc.add(passwordLabel);
	        mpc.add(password);
	        mpb.add(loginButton);
	        setTitle("管理员登录");
	        setLocationRelativeTo(getOwner());
	    	setSize(300, 200);
	    	setVisible(true);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
    
    public boolean getFlag()
    {
		return loginflag;
    	
    }
    public void setFlag(boolean flag)
    {
    	this.loginflag = flag;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource()==loginButton)
		{
			if(username.getText().equals("admin")&&password.getText().equals("admin")) {
				loginflag = true;
			}
			else
			{
				JOptionPane.showMessageDialog( null , "用户名或密码错误，请检查后重试！" ,"登陆失败" , JOptionPane.ERROR_MESSAGE) ;
				username.setText(null);
				password.setText(null);
			}
		}

	}

}