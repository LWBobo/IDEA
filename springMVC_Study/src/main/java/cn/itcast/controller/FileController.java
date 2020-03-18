package cn.itcast.controller;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/file")
public class FileController {

    /**
     * 传统方式文件上传
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/fileUpload")
    public String fileUpload(HttpServletRequest req) throws Exception {
        System.out.println("文件上传...");

        //使用fileupload组件成文件上传
        //上传的位置
        String path = req.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        //创建磁盘文件项工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        //解析request对象
        List<FileItem> fileItems = fileUpload.parseRequest(req);

        for(FileItem fileItem : fileItems){
            if(fileItem.isFormField()){

            }else {
                //上传文件项
                //获取上传文件的名称
                String filename = fileItem.getName();
                //把文件的名称设为唯一值
                String uuid = UUID.randomUUID().toString().replace("-","");
                filename = uuid +"_"+ filename;
                //上传文件
                fileItem.write(new File(file,filename));
                System.out.println("上传完成！");
                //删除临时文件
                fileItem.delete();
            }
        }

        return "filesuccess";
    }

    /*
     * mvc方式文件上传
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/mvcfileUpload")
    public String mvcfileUpload(HttpServletRequest req, MultipartFile upload) throws Exception {
        System.out.println("mvc文件上传...");
        //使用fileupload组件成文件上传
        //上传的位置
        String path = req.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }

        //获取上传文件名称
        String filename = upload.getOriginalFilename();
        //把文件的名称设为唯一值
        String uuid = UUID.randomUUID().toString().replace("-","");
        filename = uuid +"_"+ filename;
        //完成文件上传
        upload.transferTo(new File(path,filename));



        return "filesuccess";
    }



}
