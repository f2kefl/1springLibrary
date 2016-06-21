package ru.FL.SpringLibrary.servlets;

import ru.FL.SpringLibrary.objects.LibraryFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by F4KEFLY on 14.06.2016.
 * Description:
 * TODO:
 */
@WebServlet(name = "ShowImage", urlPatterns = {"/ShowImage"})
public class ShowImage extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("image/jpeg");
        OutputStream out = response.getOutputStream();
        int index = Integer.valueOf(request.getParameter("index"));
        try {
            LibraryFacade libraryFacade = (LibraryFacade) getServletContext().getAttribute("libraryFacade");
            byte[] image = libraryFacade.getBooks().get(index).getImage();
            response.setContentLength(image.length);
            out.write(image);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }
}
