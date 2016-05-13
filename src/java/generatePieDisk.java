/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import SNMP.classSNMP;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import utilities.classDisk;
import utilities.classPieGraph;

/**
 *
 * @author Nataniel
 */
public class generatePieDisk extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("image/jpeg");
        OutputStream salida = response.getOutputStream();
        int alto = 500; 
        int ancho = 800; 
        
        //Hacer un método que devuelva un el chart. 
        String disco = request.getParameter("disco");
            if((disco==null)||("".equals(disco))){
                disco = "1"; 
            }
            
            classSNMP objectSNMP= new classSNMP(); 
            classDisk objectDisk = new classDisk(""); 
            objectDisk = objectSNMP.consulta("192.168.1.71", disco); 
            
         classPieGraph constructorGrafica = new classPieGraph();    
         JFreeChart chart = constructorGrafica.createChart(constructorGrafica.createDataset(objectDisk)); 
        
        ChartUtilities.writeChartAsJPEG(salida,chart,ancho,alto);
         
        
        //ChartUtilities.writeCharAsJPEG(salida,grafica.createChart(grafica.createDataset(objectDisk)),ancho,alto);
        
        salida.close();
        
        
        /*
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet generatePieDisk</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet generatePieDisk at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            String disco = request.getParameter("disco");
            if((disco==null)||("".equals(disco))){
                disco = "1"; 
            }
            //out.println(titulo);
            classSNMP objectSNMP= new classSNMP(); 
            classDisk objectDisk = new classDisk(""); 
            objectDisk = objectSNMP.consulta("192.168.1.71", disco); 
            //out.println(objectDisk.StorageIndex + "</br>");
            //out.println(objectDisk.StorageDescr + "</br>");
            //out.println(objectDisk.StorageAllocationFailures + "</br>");
            //out.println(objectDisk.StorageAllocationUnits + "</br>");
            
            //out.println(objectDisk.StorageType + "</br>");
            out.println("Memoria en uso: " + objectDisk.StorageUsed + " gb</br>");
            out.println("Memoria libre: " + (objectDisk.StorageSize - objectDisk.StorageUsed) + " gb </br>");
            out.println("Memoria total: " + objectDisk.StorageSize + " gb </br>");
            */
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
