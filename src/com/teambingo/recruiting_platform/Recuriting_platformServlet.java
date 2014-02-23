package com.teambingo.recruiting_platform;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.teambingo.recruting_platform.database.Event;
import com.teambingo.recruting_platform.database.EventManager;
import com.teambingo.recruting_platform.database.Person;
import com.teambingo.recruting_platform.database.PersonManager;

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
					Person p = PersonManager.getPerson(personKey);
					
					resp.getWriter().println("TEST!!!");
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
		String action = (String) req.getParameter("action");
		System.out.println("action: " + action);
		if (action != null) {
			if (action.equals("setcandidate")) {
				System.out.println("adding candidate");
				String name = (String) req.getParameter("name");
				String email = (String) req.getParameter("email");
				String address = req.getParameter("address");
				String university = (String) req.getParameter("university");
				String major = (String) req.getParameter("major");
				double gpa = Double.parseDouble(req.getParameter("gpa"));
				String background = req.getParameter("background");
				String interests = req.getParameter("interests");
				String status = req.getParameter("status");
				
				Person p = Person.createPerson(name, email, address, university, major, gpa, background, interests, status);
				PersonManager.addPerson(p);
			} else if (action.equals("setevent")) {
				System.out.println("adding event");
				String name = (String) req.getParameter("name");
				System.out.println(name);
				
				Event e = Event.createEvent(name);
				System.out.println(e.getName());
				EventManager.addEvent(e);
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
