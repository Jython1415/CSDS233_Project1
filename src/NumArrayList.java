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
        size++;
    }

    /**
     * Adds a number at a specified position of the array
     * All numbers after (and the number at) the specified position are shifted down the array
     * If the array has i or fewer numbers, then the value is added in the same fashion as the add method
     * @param i the index to insert the new value at
     * @param value the value to add to the array
     */
    public  void insert(int i, double value) {

    }

    /**
     * Removes the number at the specified position of the array
     * All numbers after the specified position are shifted up the array
     * The size of the array is shortened by this method if there is a number at the specified position
     * @param i the index where the value should be removed
     */
    public  void remove(int i) {

    }

    /**
     * Checks whether the array contains the input value
     * @param value the value is what the method is confirming is in the array
     * @return true if the value is in the array, false otherwise
     */
    public boolean contains(double value) {
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
        return false;
    }

    /**
     * Overrides the equals method inherited from Object
     * Checks whether this NumArrayList is identical to another NumArrayList
     * Two NumArrayLists are equal if they have all the same numbers in the same order
     * @param otherNumArrayList the other NumArrayList to compare this NumArrayList to
     * @return true is the two are equal, false otherwise
     */
    @Override
    public boolean equals(Object otherNumArrayList) {
        return false;
    }

    /**
     * Removes duplicates in this array while preserving the current order of the numbers
     */
    public void removeDuplicates() {

    }

    /**
     * Provides a String representation of this array
     * For an empty array, an empty String is returned
     * Numbers are separated by a space and no other characters are included
     * @return a String representation of the array
     */
    public String toString() {
        return "";
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
