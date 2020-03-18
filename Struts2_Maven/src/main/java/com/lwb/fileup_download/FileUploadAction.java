package com.lwb.fileup_download;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;

public class FileUploadAction extends ActionSupport {

    private String username;
    private String password;
    private File photo;//struts会自动把数据转成文件对象
    private String photoContentType;//文件的类型
    private String photoFileName;//文件名称

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }

    public String getPhotoContentType() {
        return photoContentType;
    }

    public void setPhotoContentType(String photoContentType) {
        this.photoContentType = photoContentType;
    }

    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String upload(){

        //获取参数
        System.out.println(username);
        System.out.println(password);
        System.out.println(photoFileName);
        System.out.println(photoContentType);

        //获取要保存文件夹的物理路径(绝对路径)
        String realPath= ServletActionContext.getServletContext().getRealPath("/upload");
        System.out.println(realPath);
        File file = new File(realPath);

        //测试此抽象路径名表示的文件或目录是否存在。若不存在，创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
        if(!file.exists())file.mkdirs();

        try {
            //保存文件
            FileUtils.copyFile(photo, new File(file,photoFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }
}
