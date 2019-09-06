package ru.job4j.service;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@Log4j2
public class UpLoadFileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        if (isMultipart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            try {
                List items = upload.parseRequest(req);
                Iterator iterator = items.iterator();
                while (iterator.hasNext()) {
                    FileItem item = (FileItem) iterator.next();
                    if (!item.isFormField()) {
                        String fileName = item.getName();
                        String root = getServletContext().getRealPath("/");
                        File path = new File(root + "/uploads");
                        if (!path.exists()) {
                            path.mkdirs();
                        }
                        File uploadedFile = new File(path + "/" + fileName);
                        session.setAttribute("path", uploadedFile);
                        item.write(uploadedFile);
                    }
                }
            } catch (FileUploadException e) {
                log.error(e.getMessage(), e);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.append("<span class = \"label label-success\">Фото успешно загружено</span>");
        out.close();
    }
}
