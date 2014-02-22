package com.teambingo.recruiting_platform;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.teambingo.recruting_platform.database.Event;
import com.teambingo.recruting_platform.database.EventManager;
import com.teambingo.recruting_platform.database.Person;
import com.teambingo.recruting_platform.database.PersonManager;

public class DatabaseTestServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, database test");

		Person p = Person.createPerson("John Doe", "johndoe@purdue.edu",
				"Address", "Purdue University", "Computer Science", 3.5,
				"None", "AI","");
		PersonManager.addPerson(p);

		Event e = Event.createEvent("Test event",
				new Date(System.currentTimeMillis()));
		Key eKey = EventManager.addEvent(e);

		EventManager.addJoin(p, eKey);

		Event databaseE = EventManager.getEvent(eKey);
		resp.getWriter().println(databaseE.getJoins().iterator().next());
	}

}
