public class NumArrayList implements NumList {
    /* internalArray is for storing the values in the NumArrayList */
    private double[] internalArray = null;
    private int size = 0;

    /**
     * Creates a new NumArrayList with a capacity of 0
     */
    public NumArrayList() {
        this.internalArray = new double[0];
        this.size = 0;
    }

    /**
     * Creates a new NumArrayList with the specified capacity
     * @param capacity
     */
    public NumArrayList(int capacity) {
        this.internalArray = new double[capacity];
        this.size = 0;
    }
    
    /**
     * Getter method for the internalArray
     * @return the internalArray
     */
    private double[] getInternalArray() {
        return this.internalArray;
    }

    /**
     * Setter method for the internalArray
     * @param internalArray the new array to set as the internal array
     */
    private void setInternalArray(double[] internalArray) {
        this.internalArray = internalArray;
    }

    /**
     * Getter method for the size of the array
     * The size is the number of numbers currently in the array
     * @return the size of the array
     */
    public int size() {
        return this.size;
    }

    /**
     * Getter method for the capacity of the array
     * The capacity is the number of numbers the array can hold without resizing
     * @return the capacity of the array
     */
    public int capacity() {
        return getInternalArray().length;
    }

    /**
     * Adds a number of the end of the array
     * The method expands the capacity if needed
     * @param value the number to be added to the end of the array
     */
    public void add(double value) {
        if (size() == capacity()) {
            increaseCapacity();
        }
        
        getInternalArray()[size()] = value;
        this.size++;
    }

    /**
     * Adds a number at a specified position of the array
     * All numbers after (and the number at) the specified position are shifted down the array
     * If the array has i or fewer numbers, then the value is added in the same fashion as the add method
     * @param i the index to insert the new value at
     * @param value the value to add to the array
     */
    public void insert(int i, double value) {
        if (size () == capacity()) {
            this.increaseCapacity();
        }
        
        if (i >= size()) {
            this.add(value);
        }
        else {
            for (int j = size(); j > i; j--) {
                getInternalArray()[j] = getInternalArray()[j - 1];
            }

            getInternalArray()[i] = value;
            size++;
        }
    }

    /**
     * Removes the number at the specified position of the array
     * All numbers after the specified position are shifted up the array
     * The size of the array is shortened by this method if there is a number at the specified position
     * @param i the index where the value should be removed
     */
    public void remove(int i) {
        if (i < size()) {
            for (int j = i; j < size() - 1; j++) {
                getInternalArray()[j] = getInternalArray()[j + 1];
            }

            size--;
        }
    }

    /**
     * Checks whether the array contains the input value
     * @param value the value is what the method is confirming is in the array
     * @return true if the value is in the array, false otherwise
     */
    public boolean contains(double value) {
        for (double element : getInternalArray()) {
            if (element == value) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns the i-th element of the array
     * @param i the index of the array to get the value from
     * @return the value stored at the specified index
     * @throws IndexOutOfBoundsException when the input index is greater than or equal to the size of the array
     */
    public double lookup(int i) throws IndexOutOfBoundsException {
        if (i >= size()) {
            throw new IndexOutOfBoundsException();
        }
        
        return getInternalArray()[i];
    }

    /**
     * Checks whether this array is equal to the input array
     * Two arrays are equal if they have all the same numbers in the same order
     * @param otherList the other array to compare this array to
     * @return true if the two are equal, false otherwise
     */
    public boolean equals(NumList otherList) {
        if (this.size() != otherList.size()) {
            return false;
        }
        else {
            for (int i = 0; i < this.size(); i++) {
                if (this.lookup(i) != otherList.lookup(i)) {
                    return false;
                }
            }

            return true;
        }
    }

    /**
     * Removes duplicates in this array while preserving the current order of the numbers
     */
    public void removeDuplicates() {
        for (int i = 0; i < size(); i++) {
            for (int j = size() - 1; j > i; j--) {
                if (getInternalArray()[i] == getInternalArray()[j]) {
                    this.remove(j);
                }
            }
        }
    }

    /**
     * Provides a String representation of this array
     * For an empty array, an empty String is returned
     * Numbers are separated by a space and no other characters are included
     * @return a String representation of the array
     */
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < size() - 1; i++) {
            result.append(this.lookup(i)).append(" ");
        }

        if (size() != 0) {
            result.append(this.lookup(size() - 1));
        }

        return result.toString();
    }

    /**
     * Copies the contents of one array onto another array and returns the new array
     * @param emptyArray the array the values are copied onto. This is the array that is returned by the method
     * @param originalArray the array the values are copied from
     * @return the array the values were copied onto
     */
    private static double[] copyArray(double[] emptyArray, double[] originalArray) {
        for (int i = 0; i < originalArray.length; i++)
            emptyArray[i] = originalArray[i];
        
        return emptyArray;
    }

    /**
     * Increases the capacity of the NumArrayList
     * Doubles the capacity
     */
    private void increaseCapacity() {
        double[] tempArray = new double[Math.max(1, getInternalArray().length * 2)];
        NumArrayList.copyArray(tempArray, getInternalArray());
        setInternalArray(tempArray);
    }

    public static void main(String[] args) throws Exception {
        String indent = "    ";
        String newLine = "\n";

        System.out.println(newLine + "*** Demonstration for the NumArrayList class ***" + newLine);
    
        System.out.println("Methods:" + newLine +
                           indent + "NumArrayList(); // constructor for an empty list with 0 capacity" + newLine +
                           indent + "NumArrayList(capacity); // constructor for an empty list with set capacity" + newLine +
                           indent + "list.size(); // returns the size, the number of elements in the list" + newLine + 
                           indent + "list.capacity(); // returns the capacity, the number of elements the list can store without expanding" + newLine +
                           indent + "list.add(value); // adds the value to the end of the list" + newLine +
                           indent + "list.insert(index, value); // adds the value to the list at the specified index" + newLine +
                           indent + "list.remove(index); // removes the value stored at the specified index" + newLine +
                           indent + "list.contains(value); // returns whether the list contains the value or not" + newLine +
                           indent + "list.lookup(index); // returns the value stored at the index" + newLine +
                           indent + "list.equals(anotherList); // returns whether the two lists store the exact same values in the same order or not" + newLine +
                           indent + "list.removeDuplicates(); // removes duplicate values in the list" + newLine +
                           indent + "list.toString(); // returns the values in the list separated by spaces" + newLine);
        
        System.out.println("Demonstration for NumArrayList(), size(), capacity(), add(value), and toString()");
        System.out.println("--- Code ---");
        System.out.println("NumArrayList list = new NumArrayList();" + newLine +
                           "System.out.println(list.size());" + newLine +
                           "System.out.println(list.capacity());" + newLine +
                           newLine +
                           "list.add(0.0);" + newLine +
                           "list.add(1.0);" + newLine +
                           "System.out.println(list.size());" + newLine +
                           "System.out.println(list.capacity());" + newLine +
                           "System.out.println(list.toString());" + newLine);
        System.out.println("-- Output --");

        NumArrayList list = new NumArrayList();
        System.out.println(list.size());
        System.out.println(list.capacity());
        
        list.add(0.0);
        list.add(1.0);
        System.out.println(list.size());
        System.out.println(list.capacity());
        System.out.println(list.toString());

        System.out.println(""); // new line

        System.out.println("Demonstration for NumArrayList(capacity), insert(index, value), remove(index), contains(value), lookup(index)");
        System.out.println("--- Code ---");
        System.out.println("NumArrayList list = new NumArrayList(4);" + newLine +
                           "System.out.println(list.size());" + newLine +
                           "System.out.println(list.capacity());" + newLine +
                           newLine +
                           "list.insert(0, 3.0);" + newLine +
                           "list.insert(0, 1.0);" + newLine +
                           "list.insert(0, 0.0);" + newLine +
                           "list.insert(2, 2.0);" + newLine +
                           "list.insert(2, 2.0);" + newLine +
                           newLine +
                           "System.out.println(list.toString());" + newLine +
                           newLine +
                           "System.out.println(list.lookup(3));" + newLine +
                           "list.remove(3);" + newLine +
                           "System.out.println(list.lookup(3));" + newLine +
                           "System.out.println(list.toString());" + newLine +
                           newLine +
                           "System.out.println(list.contains(0.0));" + newLine +
                           "System.out.println(list.contains(0.5));" + newLine);
        System.out.println("-- Output --");

        list = new NumArrayList(4);
        System.out.println(list.size());
        System.out.println(list.capacity());

        list.insert(0, 3.0);
        list.insert(0, 1.0);
        list.insert(0, 0.0);
        list.insert(2, 2.0);
        list.insert(2, 2.0);

        System.out.println(list.toString());

        System.out.println(list.lookup(3));
        list.remove(3);
        System.out.println(list.lookup(3));
        System.out.println(list.toString());

        System.out.println(list.contains(0.0));
        System.out.println(list.contains(0.5));

        System.out.println(""); // new line

        System.out.println("Demonstration for equals(anotherList) and removeDuplicates()");
        System.out.println("--- Code ---");
        System.out.println("NumArrayList list = new NumArrayList();" + newLine +
                           "list.add(0.0);" + newLine +
                           "list.add(1.0);" + newLine +
                           "list.add(2.0);" + newLine +
                           "list.add(1.0);" + newLine +
                           "list.add(2.0);" + newLine +
                           "list.add(3.0);" + newLine +
                           newLine +
                           "System.out.println(list.toString());" + newLine +
                           newLine +
                           "// Copying the list" + newLine +
                           "NumArrayList listCopy = new NumArrayList();" + newLine +
                           "listCopy.add(0.0);" + newLine +
                           "listCopy.add(1.0);" + newLine +
                           "listCopy.add(2.0);" + newLine +
                           "listCopy.add(1.0);" + newLine +
                           "listCopy.add(2.0);" + newLine +
                           "listCopy.add(3.0);" + newLine +
                           newLine +
                           "System.out.println(list.equals(listCopy));" + newLine +
                           newLine +
                           "list.removeDuplicates();" + newLine +
                           newLine +
                           "System.out.println(list.toString());" + newLine +
                           "System.out.println(listCopy.toString());" + newLine +
                           "System.out.println(list.equals(listCopy));" + newLine);
        System.out.println("-- Output --");

        list = new NumArrayList();
        list.add(0.0);
        list.add(1.0);
        list.add(2.0);
        list.add(1.0);
        list.add(2.0);
        list.add(3.0);

        System.out.println(list.toString());

        // Copying the list
        NumArrayList listCopy = new NumArrayList();
        listCopy.add(0.0);
        listCopy.add(1.0);
        listCopy.add(2.0);
        listCopy.add(1.0);
        listCopy.add(2.0);
        listCopy.add(3.0);

        System.out.println(list.equals(listCopy));

        list.removeDuplicates();

        System.out.println(list.toString());
        System.out.println(listCopy.toString());
        System.out.println(list.equals(listCopy));

        System.out.println(""); // new line

        System.out.println("*** Demonstration Complete ***");

        /*
        *** Demonstration for the NumArrayList class ***

        Methods:
            NumArrayList(); // constructor for an empty list with 0 capacity
            NumArrayList(capacity); // constructor for an empty list with set capacity
            list.size(); // returns the size, the number of elements in the list
            list.capacity(); // returns the capacity, the number of elements the list can store without expanding
            list.add(value); // adds the value to the end of the list
            list.insert(index, value); // adds the value to the list at the specified index
            list.remove(index); // removes the value stored at the specified index
            list.contains(value); // returns whether the list contains the value or not
            list.lookup(index); // returns the value stored at the index
            list.equals(anotherList); // returns whether the two lists store the exact same values in the same order or not
            list.removeDuplicates(); // removes duplicate values in the list
            list.toString(); // returns the values in the list separated by spaces

        Demonstration for NumArrayList(), size(), capacity(), add(value), and toString()
        --- Code ---
        NumArrayList list = new NumArrayList();
        System.out.println(list.size());
        System.out.println(list.capacity());
        
        list.add(0.0);
        list.add(1.0);
        System.out.println(list.size());
        System.out.println(list.capacity());
        System.out.println(list.toString());

        -- Output --
        0
        0
        2
        2
        0.0 1.0

        Demonstration for NumArrayList(capacity), insert(index, value), remove(index), contains(value), lookup(index)
        --- Code ---
        NumArrayList list = new NumArrayList(4);
        System.out.println(list.size());
        System.out.println(list.capacity());

        list.insert(0, 3.0);
        list.insert(0, 1.0);
        list.insert(0, 0.0);
        list.insert(2, 2.0);
        list.insert(2, 2.0);

        System.out.println(list.toString());

        System.out.println(list.lookup(3));
        list.remove(3);
        System.out.println(list.lookup(3));
        System.out.println(list.toString());

        System.out.println(list.contains(0.0));
        System.out.println(list.contains(0.5));

        -- Output --
        0
        4
        0.0 1.0 2.0 2.0 3.0
        2.0
        3.0
        0.0 1.0 2.0 3.0
        true
        false
        
        Demonstration for equals(anotherList) and removeDuplicates()
        --- Code ---
        NumArrayList list = new NumArrayList();
        list.add(0.0);
        list.add(1.0);
        list.add(2.0);
        list.add(1.0);
        list.add(2.0);
        list.add(3.0);

        System.out.println(list.toString());

        // Copying the list
        NumArrayList listCopy = new NumArrayList();
        listCopy.add(0.0);
        listCopy.add(1.0);
        listCopy.add(2.0);
        listCopy.add(1.0);
        listCopy.add(2.0);
        listCopy.add(3.0);

        System.out.println(list.equals(listCopy));

        list.removeDuplicates();

        System.out.println(list.toString());
        System.out.println(listCopy.toString());
        System.out.println(list.equals(listCopy));

        -- Output --
        0.0 1.0 2.0 1.0 2.0 3.0
        true
        0.0 1.0 2.0 3.0
        0.0 1.0 2.0 1.0 2.0 3.0
        false

        *** Demonstration Complete ***
        */
    }
}
