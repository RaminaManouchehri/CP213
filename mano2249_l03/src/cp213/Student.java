package cp213;

import java.time.LocalDate;

/**
 * Student class definition.
 *
 * @author your name here
 * @version 2022-01-17
 */
public class Student implements Comparable<Student> {

    // Attributes
    private LocalDate birthDate = null;
    private String forename = "";
    private int id = 0;
    private String surname = "";

    /**
     * Instantiates a Student object.
     *
     * @param id        student ID number
     * @param surname   student surname
     * @param forename  name of forename
     * @param birthDate birthDate in 'YYYY-MM-DD' format
     */
    public Student(int id, String surname, String forname, LocalDate birthDate) {

	// assign attributes here
	this.id = id;
	this.surname = surname;
	this.forename = forname;
	this.birthDate = birthDate;

	return;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString() Creates a formatted string of student data.
     */
    @Override
    public String toString() {
	String string = "";

	// your code here
	string = "Name:      " + this.surname + ", " + this.forename;
	string = string + "\nID:        " + this.id;
	string = string + "\nBirthDate: " + this.birthDate;
	return string;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(final Student target) {
	int result = 0;

	// your code here
	result = surname.compareTo(target.surname);
	if (result == 0) {
	    result = forename.compareTo(target.forename);
	    if (result == 0) {
		if (target.id > id) {
		    result = -1;
		} else if (target.id < id) {
		    result = 1;
		} else {
		    result = 0;
		}
	    }
	}

	return result;
    }

    // getters and setters defined here
    /**
     * Setters below
     *
     * @param id student id number
     */
    public void setId(int id) {
	this.id = id;
    }

    /**
     * @param student surname
     */
    public void setSurname(String surname) {
	this.surname = surname;
    }

    /**
     * @param student forename
     */
    public void setForename(String forename) {
	this.forename = forename;
    }

    /**
     * @param student birthDate in 'YYYY-MM-DD' format
     */
    public void setBirthDate(LocalDate birthDate) {
	this.birthDate = birthDate;
    }

    /**
     * Getters below
     *
     * @return student id
     */
    public int getId() {
	return id;
    }

    /**
     * @return student surname
     */
    public String getSurname() {
	return surname;
    }

    /**
     * @return student forename
     */
    public String getForename() {
	return forename;
    }

    /**
     * @return student birthDate in 'YYYY-MM-DD' format
     */
    public LocalDate getBirthDate() {
	return birthDate;
    }

}
