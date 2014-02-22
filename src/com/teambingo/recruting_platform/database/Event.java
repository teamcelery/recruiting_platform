package com.teambingo.recruting_platform.database;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.TreeSet;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public final class Event {

	public static final String KIND_EVENT = "event";
	public static final String KIND_JOIN_PERSONKEY = "join-person-key";
//	public static final String KIND_PERSONKEY = "person-key";

	public static final String PROPERTY_NAME = "name";
	public static final String PROPERTY_TIME = "time";
	public static final String PROPERTY_PERSONKEY = "person-id-key";

	private Key key;
	private String name;
	private Date time;
	private TreeSet<Person> joins;

	private Event() {
	}

	public Key getKey() {
		return key;
	}

	private Event setKey(Key key) {
		this.key = key;

		return this;
	}

	public String getName() {
		return name;
	}

	private Event setName(String name) {
		this.name = name;

		return this;
	}

	public Date getTime() {
		return time;
	}

	private Event setTime(Date time) {
		this.time = time;

		return this;
	}

	public TreeSet<Person> getJoins() {
		return joins;
	}

	private Event setJoins(TreeSet<Person> joins) {
		this.joins = joins;
		
		return this;
	}
	
	protected Event addJoin(Person join) {
		if (this.joins == null) {
			this.joins = Person.newPeople();
		}
		
		this.joins.add(join);
		
		return this;
	}
	
	protected Event addJoins(Iterable<Person> joins) {
		if (this.joins == null) {
			this.joins = Person.newPeople();
		}
		
		if (joins != null) {
			for (Person join : joins) {
				this.joins.add(join);
			}
		}
		
		return this;
	}

	protected static TreeSet<Event> newEvents() {
		TreeSet<Event> events = new TreeSet<Event>(new Comparator<Event>() {
			@Override
			public int compare(Event o1, Event o2) {
				Calendar o1Time = Calendar.getInstance();
				o1Time.setTime(o1.getTime());
				Calendar o2Time = Calendar.getInstance();
				o2Time.setTime(o2.getTime());
				int timeDiff = (o1Time.get(Calendar.HOUR_OF_DAY) * 60 + o1Time.get(Calendar.MINUTE)
						) - (o2Time.get(Calendar.HOUR_OF_DAY) * 60 + o2Time.get(Calendar.MINUTE));
				if (timeDiff == 0) {
					return (int) (o1.getKey().getId() - o2.getKey().getId());
				} else {
					return timeDiff;
				}
			}
		});

		return events;
	}
	
	// Key will be null if created using this method.
	public static Event createEvent(String name, Date time) {
		if (name != null && time != null) {
			Event event = new Event();
			event.setName(name).setTime(time);
			return event;
		} else {
			return null;
		}
	}

	public static Event createEvent(Entity entity) {
		if (entity.getKind().equals(KIND_EVENT)) {
			Event event = new Event();
			event.setKey(entity.getKey());
			event.setName((String) entity.getProperty(PROPERTY_NAME));
			event.setTime((Date) entity.getProperty(PROPERTY_TIME));

			TreeSet<Person> joins = EventManager.getJoinPeople(entity.getKey());
			event.setJoins(joins);

			return event;
		} else {
			throw new EntityKindNotMatchException(
					"Entity Kind must be KIND_EVENT instead of "
							+ entity.getKind() + ".");
		}
	}

	public static TreeSet<Event> createEvents(Iterable<Entity> entities) {
		TreeSet<Event> events = newEvents();
		boolean empty = true;

		for (Entity entity : entities) {
			empty = false;
			Event event = createEvent(entity);
			events.add(event);
		}

		if (empty) {
			return null;
		} else {
			return events;
		}
	}
	
	public static Key createKey(long eventKeyId) {
		return KeyFactory.createKey(KIND_EVENT, eventKeyId);
	}
	
	@Override
	public String toString() {
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(time);
//		return name + " created by " + creator.getFullName() + " at " + 
//				restaurantKey.getName() + " " + calendar.get(Calendar.HOUR_OF_DAY)
//				+ ":" + calendar.get(Calendar.MINUTE) + " invites: " + invites;
		return "";
	}

}
