package net.javatutorial.tutorials;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleServlet extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String tip = request.getParameter("tip");

        UrlCozucu urlCozucu = new UrlCozucu();
        if (tip.equals("1")) {
            String url = request.getParameter("url");
            String kelime = request.getParameter("text");
            kelime = URLDecoder.decode(kelime, "UTF-8");

            response.getWriter().println(url + " sayfasında " + kelime + " kelimesi " + urlCozucu.urldekiKelimeleriSay(url, kelime) + "defa geçiyor");
        } else if (tip.equals("2")) {
            String url = request.getParameter("url");
            String kelime = request.getParameter("text");

            List<String> links = Arrays.asList(url.split(","));
            List<String> keywords = Arrays.asList(kelime.split(","));

            List<URLObjesi> urlObjeleri = urlCozucu.urlSiralama(links, keywords);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Sonuçlar</title>");
            out.println("</head>");
            out.println("<ol>");
            for (URLObjesi urlObjesi : urlObjeleri) {
                out.println("<li>" + urlObjesi.yazdirilacakHali() + "</li>");
            }
            out.println("</ol>");
            out.println("</body>");
            out.println("</html>");
        } else if (tip.equals(3)) {
            String l = request.getParameter("url");
            String t = request.getParameter("text");

            List<String> links = Arrays.asList(l.split(","));
            List<String> keywords = Arrays.asList(t.split(","));
            List<URLObjesi> urlObjeleri = urlCozucu.siteSiralama(links, keywords);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Sonuçlar</title>");
            out.println("</head>");
            out.println("<ol>");
            for (URLObjesi urlObjesi : urlObjeleri) {
                out.println("<li>" + urlObjesi.yazdirilacakHali() + "</li>");
            }
            out.println("</ol>");
            out.println("</body>");
            out.println("</html>");
        } else if (tip.equals(4)) {
            String l = request.getParameter("url");
            String t = request.getParameter("text");

            List<String> links = Arrays.asList(l.split(","));
            List<String> keywords = Arrays.asList(t.split(","));

            List<URLObjesi> urlObjeleri = urlCozucu.semantikAnaliz(links, keywords);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Sonuçlar</title>");
            out.println("</head>");
            out.println("<ol>");
            for (URLObjesi urlObjesi : urlObjeleri) {
                out.println("<li>" + urlObjesi.yazdirilacakHali() + "</li>");
            }
            out.println("</ol>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet " + this.getServletName() + " has started");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet " + this.getServletName() + " has stopped");
    }




}
