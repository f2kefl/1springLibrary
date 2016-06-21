package ru.FL.SpringLibrary.servlets;

import ru.FL.SpringLibrary.objects.LibraryFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * Created by F4KEFLY on 17.06.2016.
 * Description:
 * TODO:
 */
@WebServlet(name = "booksContent", urlPatterns = {"/booksContent"})
public class booksContent extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/doc; charset=UTF-8");
        OutputStream out = response.getOutputStream();

        try {
            Long id = Long.valueOf(request.getParameter("id"));
            boolean save = Boolean.valueOf(request.getParameter("save"));
            LibraryFacade libraryFacade = (LibraryFacade) getServletContext().getAttribute("libraryFacade");
            byte[] content = libraryFacade.getContent(id);
            response.setContentLength(content.length);
            if (save){
                String filename = request.getParameter("filename");
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8") + ".doc");
            }
            out.write(content);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }
}
