<%@ page language="java" import="java.util.*,java.awt.*,java.awt.image.*,javax.imageio.*,com.lwb.pojo.MD5" pageEncoding="UTF-8"
contentType="image/jpeg" %>
<%!Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}%>
<%
	response.setHeader("Fragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
	int width = 114, height = 47;
	BufferedImage image = new BufferedImage(width, height,
	BufferedImage.TYPE_INT_RGB);
	Graphics g = image.getGraphics();
	Random random = new Random();
	g.setColor(getRandColor(200, 250));
	g.fillRect(0, 0, width, height);
	g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	////////////
	//干扰线长条线
	/////////
	for (int i = 0; i < (random.nextInt(5) + 5); i++) {
		g.setColor(new Color(random.nextInt(255) + 1,
		random.nextInt(255) + 1, random.nextInt(255) + 1));
		g.drawLine(random.nextInt(10), random.nextInt(20), random
		.nextInt(85), random.nextInt(20));
	}
	//////////
	//干扰线小范围成片
	///////////////
	g.setColor(getRandColor(160, 200));
	for (int i = 0; i < 155; i++) {
		int x = random.nextInt(width);
		int y = random.nextInt(height);
		int x1 = random.nextInt(12);
		int y1 = random.nextInt(12);
		int x2 = random.nextInt(50);
		int y2 = random.nextInt(50);
		int x3 = random.nextInt(width - x1);
		int y3 = random.nextInt(height - y1);
		g.drawLine(x, y, x + x1, y + y1);
		g.drawLine(x2, y2, x2 + x3, y2 + y3);
	}
	String sRand = "";
	///////////生成随机验证码数
	for (int i = 0; i < 6; i++) {     ///生成位数
		String rand = String.valueOf(random.nextInt(10));
		sRand += rand;
		g.setColor(new Color(20 + random.nextInt(110), 20 + random
		.nextInt(110), 20 + random.nextInt(110)));
		g.drawString(rand, 13 * i + 16, 26);
	}
	///MD5加密验证码
	MD5 md5 =new MD5();
	String aa=md5.gernerateMD5(sRand);
	/////////////////
	session.setAttribute("rCode", aa);
	g.dispose();
	ImageIO.write(image, "JPEG", response.getOutputStream());
	out.clear();
	out = pageContext.pushBody();
%>