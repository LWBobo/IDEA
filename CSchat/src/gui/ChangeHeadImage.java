package gui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ChangeHeadImage implements ActionListener {

	protected ImageIcon img;
	public JButton headimg;
	protected List<String> headsrc = new ArrayList();; 
	protected int headflag=0;

	public ChangeHeadImage(JButton head) {
		// TODO Auto-generated constructor stub
		 this.headimg = head;
		 //获取客户端头像按钮
		 if(headsrc.isEmpty()) //判断数组是否为空，防止重复添加
		 {
		 
		 for(int i=1;i<=6;i++) {
				headsrc.add("src//image//img"+i+".jpeg");
			 }
		 }

	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getSource());
		if(headflag<6) {
		img = new ImageIcon(headsrc.get(headflag));
		headflag++;
		if(headflag>=6) headflag=0;
		}
		img.setImage(img.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		headimg.setIcon(img);
		//System.out.println(headsrc.get(0));
		
	}

	
	
}
