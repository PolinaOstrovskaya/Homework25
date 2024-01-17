import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

@WebServlet("/downoald/*")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 10)
public class DownoaldSer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("txt/html");
        resp.setHeader("Content-Disposition", "attachment;filename=example.txt");
        FileInputStream fis = new FileInputStream("D:\\example.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        ServletOutputStream sos = resp.getOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = bis.read(buffer)) != -1) {
            sos.write(buffer, 0, bytesRead);
        }
        bis.close();
        fis.close();
        sos.close();
    }
}

