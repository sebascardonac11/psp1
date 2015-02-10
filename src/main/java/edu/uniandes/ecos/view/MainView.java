/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.view;

/**
 *
 * @author sebascardonac11
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oscarkiyoshigegarcesaparicio
 */
public class MainView {

    public static void showHome(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();
        pw.write("<html>");
        pw.println("<h1>PSP1 Program 3</h1>");
        pw.println("<h2>Sebastian Cardona Correa</h2>");

        pw.println("<p>Por favor ingresar los numero de las listas, separadas por \"-\", y siempre decimales con \",\". </p>");
        pw.println("<p>Asegurese que las dos lista, tienen la misma cantidad de elementos.</p>");
        pw.println("<p>Ejemplo:</p>");

        pw.println("<p>Test1:</p>");
        pw.println("<p>x= 130.0-650.0-99.0-150.0-128.0-302.0-95.0-945.0-368.0-961.0</p>");
        pw.println("<p>y= 186.0-699.0-132.0-272.0-291.0-331.0-199.0-1890.0-788.0-1601.0</p>");
        pw.println("<p>yk:386</p>");

        pw.println("<p>Test2:</p>");
        pw.println("<p>x= 130.0-650.0-99.0-150.0-128.0-302.0-95.0-945.0-368.0-961.0</p>");
        pw.println("<p>y= 15.0-69.9-6.5-22.4-28.4-65.9-19.4-198.7-38.8-138.2</p>");
        pw.println("<p>yk:386</p>");

        pw.println("<p>Test3:</p>");
        pw.println("<p>x= 163.0-765.0-141.0-166.0-137.0-355.0-136.0-1206.0-433.0-1130.0</p>");
        pw.println("<p>y= 186.0-699.0-132.0-272.0-291.0-331.0-199.0-1890.0-788.0-1601.0</p>");
        pw.println("<p>yk:386</p>");

        pw.println("<p>Test4:</p>");
        pw.println("<p>x= 163.0-765.0-141.0-166.0-137.0-355.0-136.0-1206.0-433.0-1130.0</p>");
        pw.println("<p>y= 15.0-69.9-6.5-22.4-28.4-65.9-19.4-198.7-38.8-138.2</p>");
        pw.println("<p>yk:386</p>");

        pw.write("<form action=\"calc\" method=\"post\"> \n"
                + "    x: <input type=\"text\" name=\"lst1\">\n"
                + "    y: <input type=\"text\" name=\"lst2\">\n"
                + "    yk: <input type=\"text\" name=\"yk\">\n"
                + "    <input type=\"submit\" value=\"Calc\">\n"
                + "</form> ");

        pw.write("</html>");

    }

    public static void showResults(HttpServletRequest req, HttpServletResponse resp, Double B0, Double B1, Double Rxy, Double r2, Double Yk)
            throws ServletException, IOException {
        resp.getWriter().println("<b>B0:</b> " + B0 + "<br>");
        resp.getWriter().println("<b>B1:</b> " + B1 + "<br>");
        resp.getWriter().println("<b>Rxy: </b> " + Rxy + "<br>");
        resp.getWriter().println("<b>R2:</b> " + r2 + "<br>");
        resp.getWriter().println("<b>Yk: </b> " + Yk + "<br>");
    }

    public static void error(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getWriter().println("Error!!!");
    }

}
