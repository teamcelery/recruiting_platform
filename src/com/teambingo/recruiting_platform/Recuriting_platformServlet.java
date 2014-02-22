package com.teambingo.recruiting_platform;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.teambingo.recruting_platform.database.Person;

@SuppressWarnings("serial")
public class Recuriting_platformServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// resp.setContentType("text/plain");
		// resp.getWriter().println("Hello, world");
		String action = (String) req.getAttribute("action");
		if (action != null) {
			if (action.equals("getcandidate")) {
				long id = Long
						.parseLong(req.getAttribute("id") != null ? (String) req
								.getAttribute("id") : "-1");
				if (id >= 0) {
					Key personKey = Person.createKey(id);
				} else {
					error(resp, 0x2);
				}
			}
		} else {
			error(resp, 0x1);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String action = (String) req.getAttribute("action");
		if (action != null) {
			if (action.equals("setcandidate")) {
				req.getAttribute("test");
			}
		} else {
			error(resp, 0x1);
		}
	}

	private void error(HttpServletResponse resp, int errorCode)
			throws IOException {
		resp.setContentType("application/json");
		resp.getWriter().println("{ \"error:\"" + errorCode + "  }");
	}
}
