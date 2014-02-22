package com.teambingo.recruiting_platform;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Recuriting_platformServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// resp.setContentType("text/plain");
		// resp.getWriter().println("Hello, world");
		String action = (String) req.getAttribute("action");
		if (action != null) {
			if (action.equals("getcandidate")) {
				int id = Integer
						.parseInt(req.getAttribute("id") != null ? (String) req
								.getAttribute("id") : "-1");
				if (id != -1) {
					// TODO: fetch data
				}
			}
		}
	}
	
	private void error(HttpServletResponse resp, int errorCode) {
		resp.setContentType("application/json");
//		resp.getWriter().println("");
	}
}
