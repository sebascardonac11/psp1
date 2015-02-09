/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.controller;

/**
 *
 * @author sebascardonac11
 */


import edu.uniandes.ecos.Calculos;
import edu.uniandes.ecos.view.MainView;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main Application
 */
public class App extends HttpServlet{

    public static void main(String[] args) {
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new App()), "/*");
        try {
            server.start();
            server.join();
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        MainView.showHome(req,resp);
        MainView.showResults(req,resp,0.0," ",0.0);       
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                
        try {
            MainView.showHome(req,resp);
            consoleInput(req, resp);
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
   
    /**
     * Method to set the console input for the numbers
     */
    public void consoleInput(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //System.out.println("Por favor, ingrese la cantidad de numeros que desea ingresar:");
        //Scanner input = new Scanner(System.in);
        String calc = req.getParameter("calc");

        String[] strElements = calc.split(" ");
        Double nextElement = 0D;
        LinkedList<Double> numbersList = new LinkedList<Double>();
         LinkedList<Double> x = new LinkedList<Double>();
        x.add(130.0);
        x.add(650.0);
        x.add(99.0);
        x.add(150.0);
        x.add(128.0);
        x.add(302.0);
        x.add(95.0);
        x.add(945.0);
        x.add(368.0);
        x.add(961.0);
        LinkedList<Double> y = new LinkedList<Double>();
        /* y.add(163.0);
         y.add(765.0);
         y.add(141.0);
         y.add(166.0);
         y.add(137.0);
         y.add(355.0);
         y.add(136.0);
         y.add(1206.0);
         y.add(433.0);
         y.add(1130.0);
        */
        y.add(186.0);
        y.add(699.0);
        y.add(132.0);
        y.add(272.0);
        y.add(291.0);
        y.add(331.0);
        y.add(199.0);
        y.add(1890.0);
        y.add(788.0);
        y.add(1601.0);
        Calculos cal= new Calculos(numbersList, numbersList);
       // StatisticCalculator calculator = new StatisticCalculator();

        for (String strElement : strElements) {
            try {
                nextElement = Double.valueOf(strElement);
                numbersList.add(nextElement);
                
            }catch(NumberFormatException ex){
                MainView.error(req, resp);
            }
        }

        //calculator.setInputData(numbersList);
        
        MainView.showResults(req, resp, cal.getB0(), numbersList.toString(), cal.getB1());
    }

    /**
     * Method to set the file input for the numbers
     */
    public void fileInput() {
  /*      ClassLoader classLoader = this.getClass().getClassLoader();
        FileInput inputReader = new FileInput();
        inputReader.getFile(classLoader.getResource("inputs.txt").getFile());
        inputReader.readNumbersFromFile();
        LinkedList<Double> values = inputReader.getValuesFromFile();

        StatisticCalculator calculator = new StatisticCalculator();
        calculator.setInputData(values);
        
        System.out.println("Leyendo desde el archivo inputs.txt");
        System.out.println("Lista: " + values.toString());
        System.out.println("Media: " + calculator.calculateMean());
        System.out.println("Desviacion Estandar: " + calculator.calculateStdDev());
*/
    }

}
