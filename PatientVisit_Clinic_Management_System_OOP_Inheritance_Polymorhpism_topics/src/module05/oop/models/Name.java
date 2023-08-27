package module05.oop.models;

import module05.oop.randompms.MyRandomPersonData;

/**
 * The Name class represents the name information of a person.
 */
public class Name {
    private String title;
    private String fname;
    private String mi;
    private String lname;

    /**
     * Default constructor for Name class.
     * Initializes name components with random values.
     */
    public Name() {
        super();
        this.title = MyRandomPersonData.randomTitle();
        this.fname = MyRandomPersonData.randomFname();
        this.mi = MyRandomPersonData.randomFname();
        this.lname = MyRandomPersonData.randomLname();
    }

    /**
     * Parameterized constructor for Name class.
     *
     * @param title The title of the person's name.
     * @param fname The first name of the person.
     * @param mi    The middle initial of the person.
     * @param lname The last name of the person.
     * @param other Additional parameter (not used).
     */
    public Name(String title, String fname, String mi, String lname, String other) {
        super();
        this.title = title;
        this.fname = fname;
        this.mi = mi;
        this.lname = lname;
    }

    /**
     * Get the title.
     *
     * @return The title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the title.
     *
     * @param title The title to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the first name.
     *
     * @return The first name.
     */
    public String getFname() {
        return fname;
    }

    /**
     * Set the first name.
     *
     * @param fname The first name to set.
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * Get the middle initial.
     *
     * @return The middle initial.
     */
    public String getMi() {
        return mi;
    }

    /**
     * Set the middle initial.
     *
     * @param mi The middle initial to set.
     */
    public void setMi(String mi) {
        this.mi = mi;
    }

    /**
     * Get the last name.
     *
     * @return The last name.
     */
    public String getLname() {
        return lname;
    }

    /**
     * Set the last name.
     *
     * @param lname The last name to set.
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * Convert the Name object to a string representation.
     *
     * @return The string representation of Name.
     */
    @Override
    public String toString() {
        return "Name [title=" + title + ", fname=" + fname + ", mi=" + mi + ", lname=" + lname + "]";
    }
}
