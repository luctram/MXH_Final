/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.FileDAO;
import DAO.UserPostDAO;
import Model.UserPost;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author TramLuc
 */
@WebServlet(name = "Servlet_AddNewPost", urlPatterns = {"/Servlet_AddNewPost"})
public class Servlet_AddNewPost extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "FilePost";

    // upload settings
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
 @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String error = "";
        PrintWriter out = response.getWriter();
         //checks if the request actually contains upload file
        if (!ServletFileUpload.isMultipartContent(request)) {
            // if not, we stop here
            PrintWriter writer = response.getWriter();
            writer.println("Error: Form must has enctype=multipart/form-data.");
            writer.flush();
            return;
        }

        // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // sets memory threshold - beyond which files are stored in disk 
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // sets temporary location to store files
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);

        // sets maximum size of upload file
        upload.setFileSizeMax(MAX_FILE_SIZE);

        // sets maximum size of request (include file + form data)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        // constructs the directory path to store upload file
        // this path is relative to application's directory
        String uploadPath = getServletContext().getRealPath("")
                + File.separator + UPLOAD_DIRECTORY;

        // creates the directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
int userid=0;
String imgvideolink="";
String contentspost ="";
String[] fieldValue = new String[2];
        try {
            // parses the request's content to extract file data
            System.out.println(request);
            @SuppressWarnings("unchecked")

            List<FileItem> formItems = upload.parseRequest(request);

            if (formItems != null && formItems.size() > 0) {
                // iterates over form's fields
                int i=0;
                for (FileItem item : formItems) {
                   
                    {  // processes only fields that are not form fields
                    if (item.isFormField()) {
                     
                        String fieldName = item.getFieldName();
                         fieldValue[i] = item.getString();
                         i++;
                         
                    }
                    else {
                         String fileName = new File(item.getName()).getName();
                          int check = FileDAO.checkfile(fileName);
                          if(check == 0 || check == 1 ){
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);

                        item.write(storeFile);
                        imgvideolink =  UPLOAD_DIRECTORY + "/" + fileName;}
                          else {
                             out.print("<html><meta charset=\"utf-8\"/>");
                out.print("<script>alert('Chỉ đăng được ảnh hoặc video');");
               out.print("window.location = 'http://localhost:8084/MXH_Final/NewPost.jsp' ;</script></html>");
                            return;
                          }
                    }
                    }
            }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            request.setAttribute("message",
                    "There was an error: " + ex.getMessage());
        }
        userid=Integer.parseInt(fieldValue[0]);
       contentspost=fieldValue[1];
       
            try {
             
                       UserPost uPost  = new UserPost();
                           uPost.setUserId(userid);
                           uPost.setContent(contentspost);
                           uPost.setImgVideoLink(imgvideolink);
                           uPost.setDate(java.time.LocalDate.now().toString());
                           uPost.setCountLike(0);
                           UserPostDAO.createPost(uPost);
                             
                             out.print("<html><meta charset=\"utf-8\"/>");
                out.print("<script>alert('Đăng bài thành công!');");
               out.print("window.location = 'http://localhost:8084/MXH_Final/UserPage.jsp' ;</script></html>");           
                             return;
                       
            }  
             catch (Exception e) {
            }
    }    
}
