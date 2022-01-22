import org.junit.Assert;
import org.junit.Test;
import java.lang.NoSuchFieldException;

public class NumArrayListTester {
    /**
     * Creates a NumArrayList with the specified double values
     * Uses the empty constructor and the add method
     */
    private static NumArrayList createArrayList(double... values) {
        NumArrayList list = new NumArrayList();
        for (double value : values)
            list.add(value);

        return list;
    }

    /**
     * Compares two NumArrayLists and asserts that they are equal using org.junit.Assert
     * The method uses reflection to access the private field storing the internal array, and compares those directly
     * @param message the String message to report when the lists are not equal
     * @param list1 the first list to be compared
     * @param list2 the second list to be compared
     */
    private static void assertNumArrayListEquals(String message, NumArrayList list1, NumArrayList list2) {
        try {
            Assert.assertTrue(message,
                          list1.getClass().getField("internalArray").equals(
                          list2.getClass().getField("internalArray")));
        }
        catch (NoSuchFieldException e) {
            Assert.fail("There was an unexpected exception thrown by the unit test");
        }
    }

    /**
     * Unit tests for the NumArrayList constructors
     */
    @Test
    public void testNumArrayList() {

    }
    
    /**
     * Unit tests for the size method
     */
    @Test
    public void testSize() {

    }

    /**
     * Unit tests for the capacity method
     */
    @Test
    public void testCapacity() {

    }

    /**
     * Unit tests for the add method
     */
    @Test
    public void testAdd() {
        
    }

    /**
     * Unit tests for the insert method
     */
    @Test
    public  void testInsert() {

    }

    /**
     * Unit tests for the remove method
     */
    @Test
    public  void testRemove() {

    }

    /**
     * Unit tests for the contains method
     */
    @Test
    public void testContains() {

    }

    /**
     * Unit tests for the lookup method
     */
    @Test
    public void testLookup() {

    }

    /**
     * Unit tests for the equals method
     */
    @Test
    public void testEquals() {

    }

    /**
     * Unit tests for the remove duplicates method
     */
    @Test
    public void testRemoveDuplicates() {

    }

    /**
     * Unit tests for the toString method
     */
    @Test
    public void testToString() {


    }
}
