package com.rohan.servlet;
 
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(description = "Recipe Download", urlPatterns = { "/downloadFileServlet" })
public class DownloadFileServlet extends HttpServlet {
 	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("fileName");
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			Map<String, String> attribute = (Map<String, String>)session.getAttribute("recipesList");
			String recipeTxt  = attribute.get(name);
			 File downloadFile = File.createTempFile(name, ".txt");
			   try (Writer writer = new BufferedWriter(new FileWriter(downloadFile))) {
		              writer.write(recipeTxt);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
			
        FileInputStream inStream = new FileInputStream(downloadFile);
        String mimeType =  "application/octet-stream";
     
        // modifies response
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
     
        // forces download
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
        response.setHeader(headerKey, headerValue);
         
        // obtains response's output stream
        OutputStream outStream = response.getOutputStream();
         
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
         
        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
         
        inStream.close();
        outStream.close();      
    }
	}
}
 
