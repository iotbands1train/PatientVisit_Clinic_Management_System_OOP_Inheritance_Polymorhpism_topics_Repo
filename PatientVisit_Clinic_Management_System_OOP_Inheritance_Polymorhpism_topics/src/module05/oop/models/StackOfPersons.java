package module05.oop.models;

/**
 * The StackOfPersons class represents a stack of Person objects.
 */
public class StackOfPersons {
    private Person[] stack;
    private int top;
    private int capacity;

    /**
     * Default constructor for StackOfPersons.
     * Initializes the stack with a default capacity of 500.
     */
    public StackOfPersons() {
        this.stack = new Person[500]; // Assuming a maximum of 500 persons
        capacity = stack.length;
        top = -1;
    }

    /**
     * Parameterized constructor for StackOfPersons.
     * Initializes the stack with a specified capacity.
     *
     * @param capacity The maximum capacity of the stack.
     */
    public StackOfPersons(int capacity) {
        stack = new Person[capacity]; // Assuming a maximum of x persons
        this.capacity = capacity;
        top = -1;
    }

    /**
     * Constructor for StackOfPersons with an existing array of persons.
     *
     * @param stack The array of persons to initialize the stack with.
     */
    public StackOfPersons(Person[] stack) {
        this.stack = stack;
        top = stack.length - 1;
        capacity = stack.length;
    }

    /**
     * Get the number of persons in the stack.
     *
     * @return The number of persons in the stack.
     */
    public int getPersonCount() {
        return top + 1;
    }

    /**
     * Get the capacity of the stack.
     *
     * @return The capacity of the stack.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Push a person onto the stack.
     *
     * @param person The person to push onto the stack.
     */
    public void push(Person person) {
        if (top < stack.length - 1) {
            top++;
            stack[top] = person;
        } else {
            System.out.println("Stack is full. Cannot push more persons.");
        }
    }

    /**
     * Pop a person from the top of the stack.
     *
     * @return The person popped from the stack.
     */
    public Person pop() {
        if (top >= 0) {
            Person person = stack[top];
            stack[top] = null;
            top--;
            return person;
        } else {
            System.out.println("Stack is empty. Cannot pop.");
            return null;
        }
    }

    /**
     * Peek at the person on top of the stack.
     *
     * @return The person on top of the stack.
     */
    public Person peek() {
        if (top >= 0) {
            return stack[top];
        } else {
            System.out.println("Stack is empty. Cannot peek.");
            return null;
        }
    }

    /**
     * Print all persons in the stack.
     */
    public void printAllPersons() {
        for (int i = 0; i <= top; i++) {
            System.out.println(i + " " + stack[i]);
        }
    }

    /**
     * Update an existing person's information in the stack.
     *
     * @param oldPerson The person to be updated.
     * @param newPerson The new person information.
     */
    public void updatePerson(Person oldPerson, Person newPerson) {
        for (int i = 0; i <= top; i++) {
            if (stack[i] == oldPerson) {
                stack[i] = newPerson;
                break;
            }
        }
    }

    /**
     * Delete a person from the stack.
     *
     * @param person The person to be deleted.
     */
    public void deletePerson(Person person) {
        for (int i = 0; i <= top; i++) {
            if (stack[i] == person) {
                for (int j = i; j < top; j++) {
                    stack[j] = stack[j + 1];
                }
                stack[top] = null;
                top--;
                break;
            }
        }
    }

    /**
     * Create bulk persons and push them onto the stack.
     *
     * @param persons The array of persons to be pushed.
     */
    public void createBulkPersons(Person[] persons) {
        for (Person person : persons) {
            push(person);
        }
    }

    /**
     * Search for a person by ID in the stack.
     *
     * @param searchId The ID to search for.
     * @return The found person, or null if not found.
     */
    public Person searchPersonById(long searchId) {
        if (top > 1) {
            for (int i = 0; i <= top; i++) {
                if (stack[i].getId() == searchId) {
                    return stack[i];
                }
            }
        } else {
            System.out.println("Only 1 person in database");
        }
        return null;
    }

    /**
     * Set the capacity of the stack.
     *
     * @param input The new capacity to set.
     */
    public void setCapacity(int input) {
        capacity = input;
    }

    /**
     * Clear the stack by creating a new array of persons.
     */
    public void clear() {
        stack = new Person[capacity];
        top = 0;
    }
}
