package com.mikeycaine.helloclient.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mikeycaine.helloclient.service.SessionBeanHello;

/**
 * Servlet implementation class TestPage
 */
@WebServlet(name="testpage", urlPatterns={"/testpage"})
public class TestPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	SessionBeanHello hello;
	
    /**
     * Default constructor. 
     */
    public TestPage() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet at " + 
                request.getContextPath () + "</h1>");
            //out.println("<p>" + sayHello("WHOEVER YOU ARE") + "</p>");
            out.println("<p>" + hello.greet("FRIEND") + "</p>");
            out.println("</body>");
            out.println("</html>");
            
        } finally { 
            out.close();
        }
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
//    private String sayHello(String person) {
////        helloservice.endpoint.Hello port = service.getHelloPort();
////        return port.sayHello(arg0);
//  	return hello.greet(person);
//    }

}
