package com.yuan.Servlet;


import com.yuan.Service.AllService;
import com.yuan.Tool.Data;
import com.yuan.Tool.FileName;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet("/AcceptData")
public class AcceptData extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<String> inputData= new ArrayList<>();
        List<String> receiveData=new ArrayList<>();
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //文件上传解析器
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 判断enctype属性是否为multipart/form-data
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        if (isMultipart) {
            try {
                //解析请求，将表单中每个输入项封装成一个FileItem对象
                List<FileItem> fileItems = upload.parseRequest(req);
                // 迭代表单数据
                for (FileItem fileItem : fileItems) {
                    //判断输入的类型是 普通输入项 还是文件
                    if (fileItem.isFormField()) {
                        //普通输入项 ,得到input中的name属性的值,fileItem.getFieldName()
                        ////得到输入项中的值,fileItem.getString("UTF-8"),"UTF-8"防止中文乱码
//                        System.out.println(fileItem.getFieldName()+"\t"+fileItem.getString("UTF-8"));
                        String IData=fileItem.getString("UTF-8");
                        inputData.add(IData);
                    } else {
                        //上传的是文件，获得文件上传字段中的文件名
                        //注意IE或FireFox中获取的文件名是不一样的，IE中是绝对路径，FireFox中只是文件名
                        String fileName = fileItem.getName();
                        System.out.println(fileName);
                        //Substring是字符串截取，返回值是一个截取后的字符串
                        //lastIndexOf(".")是从右向左查,获取.之后的字符串
                        String ext = fileName.substring(fileName.lastIndexOf("."));
                        System.out.println(ext);
                        //UUID.randomUUID().toString()是javaJDK提供的一个自动生成主键的方法, UUID的唯一缺陷在于生成的结果串会比较长
                        String paperName=FileName.GetFileName();
                        String name = paperName+ext;
                        System.out.println(name);
                        receiveData.add(name);
                        //将FileItem对象中保存的主体内容保存到某个指定的文件中
                        File file = new File(".\\src\\main\\webapp\\xiazai\\"+name);
                        fileItem.write(file);
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else{
            System.out.println("普通表单");
        }
        System.out.println(inputData);
        System.out.println(receiveData);

        Data data=new Data();
        data.setTupian(receiveData.get(0));
        data.setWenjian(receiveData.get(1));
        data.setJieshao(inputData.get(0));
        data.setLianjie(inputData.get(1));
        data.setMingzi(inputData.get(2));
        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        AllService allService= (AllService) ctx.getBean("select");
        int row=allService.insertData(data);
        if(row==1){
            resp.sendRedirect("/uploadfile/index.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
