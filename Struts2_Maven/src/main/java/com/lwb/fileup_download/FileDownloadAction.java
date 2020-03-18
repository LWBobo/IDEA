package com.lwb.fileup_download;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 步骤：
 * 1.写个Action
 * 2.在Action写一个输入流属性，提供get方法 
 * 3.在Action中写个downlaod方法，给inputStream赋值
 * 4.写struts.xml配置文件，添加action
 * 5.result中type写stream,以流的形式把数据返回给客户端面
 * 6.在result中添加3个参数
 * 	 inputName
 * 	 contentDisposition
 *   contentType
 * @author gyf
 *
 */
public class FileDownloadAction extends ActionSupport{
	
	
	private InputStream  inputStream;
	private String fileName;

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String download() throws FileNotFoundException, UnsupportedEncodingException{
		org.apache.struts2.dispatcher.StreamResult rs;
		
		fileName = "QQ截图20200218152541.png";
		
		//1.路径
		String path = "C:\\Users\\博\\Pictures\\作业/" + fileName;
		
		//2.给输入流赋值
		inputStream = new FileInputStream(path);
		
		//中文需要URLencode
		fileName = "朝三暮四.jpg";
		fileName = URLEncoder.encode(fileName, "UTF-8");
		//3.通过outputStream返回数据给客户端
		//struts不需要自己写数据给客户端
		return SUCCESS;
	}
	

	
}
