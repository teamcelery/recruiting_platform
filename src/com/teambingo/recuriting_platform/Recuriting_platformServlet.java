package com.teambingo.recuriting_platform;
import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Recuriting_platformServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
