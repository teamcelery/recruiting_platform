package com.teambingo.recruting_platform.database;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

import com.google.appengine.api.datastore.Email;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class Person {

	public static final String KIND_PERSON = "person";
	public static final String KIND_READ_EVENTKEY = "read-event-key";

	public static final String PROPERTY_USERNAME = "username";
//	public static final String PROPERTY_FIRSTNAME = "firstname";
//	public static final String PROPERTY_LASTNAME = "lastname";
	public static final String PROPERTY_EMAIL = "email";
	public static final String PROPERTY_ADDRESS = "address";
	public static final String PROPERTY_UNIVERSITY = "university";
	public static final String PROPERTY_MAJOR = "major";
	public static final String PROPERTY_GPA = "gpa";
	public static final String PROPERTY_BACKGROUND = "background";
	public static final String PROPERTY_INTEREST = "interest";
	public static final String PROPERTY_STATUS = "status";
	public static final String PROPERTY_EVENTKEY = "event-id-key";

	private Key key;
	private String username;
//	private String firstName;
//	private String lastName;
	private Email email;
	private String address;
	private String university;
	private String major;
	private double gpa;
	private String background;
	private String interest;
	private String status;
	private HashSet<Key> readEventKeys;

	protected Person() {

	}

	public Key getKey() {
		return key;
	}

	private Person setKey(Key key) {
		this.key = key;
		return this;
	}

	private Person setKey(String username) {
		this.key = KeyFactory.createKey(KIND_PERSON, username.trim());
		return this;
	}

	public String getUsername() {
		return username;
	}

	private Person setUsername(String username) {
		this.username = username.trim();
		return this;
	}

//	public String getFirstName() {
//		return firstName;
//	}
//
//	private Person setFirstName(String firstName) {
//		this.firstName = firstName.trim();
//		return this;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	private Person setLastName(String lastName) {
//		this.lastName = lastName.trim();
//		return this;
//	}

	public Email getEmail() {
		return email;
	}

	private Person setEmail(Email email) {
		this.email = email;
		return this;
	}

	public String getAddress() {
		return address;
	}

	private Person setAddress(String address) {
		this.address = address.trim();
		return this;
	}

	public String getUniversity() {
		return university;
	}

	private Person setUniversity(String university) {
		this.university = university.trim();
		return this;
	}

	public String getMajor() {
		return major;
	}

	private Person setMajor(String major) {
		this.major = major.trim();
		return this;
	}

	public double getGPA() {
		return gpa;
	}

	private Person setGPA(double gpa) {
		this.gpa = gpa;
		return this;
	}

	public String getBackground() {
		return background;
	}

	private Person setBackground(String background) {
		this.background = background.trim();
		return this;
	}

	public String getInterest() {
		return interest;
	}

	private Person setInterest(String interest) {
		this.interest = interest.trim();
		return this;
	}

	public HashSet<Key> getReadEventKeys() {
		return readEventKeys;
	}

	private Person setReadEventKeys(HashSet<Key> readEventKeys) {
		this.readEventKeys = readEventKeys;
		return this;
	}

	protected static TreeSet<Person> newPeople() {
		TreeSet<Person> people = new TreeSet<Person>(new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				// Sort first name first, then last name.
				int fnc = o1.getUsername().compareTo(o2.getUsername());
				return fnc;
			}
		});

		return people;
	}

	public static Person createPerson(String username,String email) {
		return createPerson(username, new Email(email));
	}

	public static Person createPerson(String username, Email email) {
		Person person = new Person();
		person.setKey(username).setUsername(username).setEmail(email);

		return person;
	}

	public static Person createPerson(Entity entity) {
		if (entity.getKind().equals(KIND_PERSON)) {
			Person person = new Person();
			person.setKey(entity.getKey());
			person.setUsername((String) entity.getProperty(PROPERTY_USERNAME));
//			person.setFirstName((String) entity.getProperty(PROPERTY_FIRSTNAME));
//			person.setLastName((String) entity.getProperty(PROPERTY_LASTNAME));
			person.setEmail((Email) entity.getProperty(PROPERTY_EMAIL));

			// HashSet<Key> readEventKeys =
			// PersonManager.getReadEventKeys(entity.getKey());
			// person.setReadEventKeys(readEventKeys);

			return person;
		} else {
			// throw new EntityKindNotMatchException(
			// "Entity Kind must be KIND_PERSON instead of "
			// + entity.getKind() + ".");
			return null;
		}
	}

	public static TreeSet<Person> createPeople(Iterable<Entity> entities) {
		TreeSet<Person> people = newPeople();
		boolean empty = true;

		for (Entity entity : entities) {
			empty = false;
			Person person = createPerson(entity);
			people.add(person);
		}

		if (empty) {
			return null;
		} else {
			return people;
		}
	}

	public static Key createKey(String personKeyName) {
		return KeyFactory.createKey(KIND_PERSON, personKeyName);
	}

	@Override
	public String toString() {
		// return getFullName(true);
		return getUsername();
	}

}
