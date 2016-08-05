package com.servlet.sample;

import java.io.IOException;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;

import java.util.Calendar;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ServletLog4J extends HttpServlet
{
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";
    public static Logger logger;

    public void init(ServletConfig config) throws ServletException
    {
        
      logger = Logger.getLogger(this.getClass());
        String DATE_FORMAT = "yyyy-MM-dd";
        SimpleDateFormat sdf =  new SimpleDateFormat(DATE_FORMAT);
        Calendar now = Calendar.getInstance(); 
        System.setProperty("log4j.date", sdf.format(now.getTime()) );
       // PropertyConfigurator.configure( logPropertiesLocation);
        
        super.init(config);
    }

    public void service(HttpServletRequest request,
                        HttpServletResponse response) throws ServletException,
                                                             IOException
    {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>ServletLog4J</title></head>");
        out.println("<body>");
        out.println("<p>The servlet has received a POST or GET. This is the reply.</p>");
        
        out.println("<p>hello World</p>");
        out.println("Current working Directory: "+System.getProperty("user.dir"));
        
        logger.debug("Debug test");
        logger.info("Info test");
        
        out.println("</body></html>");
        out.close();
    }
}
