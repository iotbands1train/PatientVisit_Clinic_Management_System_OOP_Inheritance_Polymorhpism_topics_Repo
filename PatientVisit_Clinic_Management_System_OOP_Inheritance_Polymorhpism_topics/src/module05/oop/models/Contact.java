package module05.oop.models;

import module05.oop.randompms.MyRandomPersonData;

/**
 * A class representing the contact information of a person.
 */
public class Contact {
    private Long phone;

    /**
     * Default constructor that initializes the contact with a random phone number.
     */
    public Contact() {
        super();
        this.phone = Math.abs(MyRandomPersonData.random(214_111_1111L, 214_999_9999L));
    }

    /**
     * Constructor that allows specifying a custom phone number.
     *
     * @param phone The phone number to set for the contact.
     */
    public Contact(Long phone) {
        super();
        this.phone = phone;
    }

    /**
     * Get the phone number of the contact.
     *
     * @return The phone number.
     */
    public Long getPhone() {
        return phone;
    }

    /**
     * Set the phone number of the contact.
     *
     * @param phone The phone number to set.
     */
    public void setPhone(Long phone) {
        this.phone = phone;
    }

    /**
     * Get a string representation of the contact's information.
     *
     * @return A string containing the contact's phone number.
     */
    @Override
    public String toString() {
        return "Contact [phone=" + phone + "]";
    }
}
