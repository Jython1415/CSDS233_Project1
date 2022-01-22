import org.junit.Assert;
import org.junit.Test;
import java.lang.NoSuchFieldException;
import java.lang.reflect.InvocationTargetException;

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
     * Compares a NumListArray to an array and returns true if they are the same, false otherwise
     * Accounts for the size problem
     * @param list1 the NumListArray to compare to array
     * @param array the array to compare list1 to
     * @return true is array is identical to list1 up to list1's size
     * @throws IllegalAccessException passes along exception from reflection
     * @throws InvocationTargetException passes along exception from reflection
     * @throws NoSuchMethodException passes along exception from reflection
     */
    private static boolean compareNumArrayListToArray(NumArrayList list1, double[] array) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        double[] arrayList = (double[])(list1.getClass().getMethod("getInternalArray", null).invoke(list1, null));
        for (int i = 0; i < list1.size(); i++) {
            if (arrayList[i] != array[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * Compares two NumArrayLists and asserts that they are equal using org.junit.Assert
     * The method uses reflection to access the private field storing the internal array, and compares those directly
     * @param message the String message to report when the lists are not equal
     * @param list1 the first list to be compared
     * @param list2 the second list to be compared
     */
    // private static void assertNumArrayListEquals(String message, NumArrayList list1, NumArrayList list2) {
    //     try {
    //         Assert.assertTrue(message,
    //                       list1.getClass().getMethod("getInternalArray", null).invoke(list1, null).equals(
    //                       list2.getClass().getMethod("getInternalArray", null).invoke(list1, null)));
    //     }
    //     catch (Exception e) {
    //         Assert.fail("There was an unexpected exception thrown by the unit test");
    //     }
    // }

    /**
     * Compares a NumArrayList to an array and asserts that they are equal using org.junit.Assert
     * The method uses reflection to access the private field storing the internal array, and compares that to the array directly
     * @param message the String message to report when the lists are not equal
     * @param list1 the NumArrayList to be compared
     * @param values the array to be compared
     */
    private static void assertNumArrayListEquals(String message, NumArrayList list1, double[] array) {
        try {
            Assert.assertTrue(message, NumArrayListTester.compareNumArrayListToArray(list1, array));
        }
        catch (Exception e) {
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
        // 0 elements
        NumArrayList list1 = new NumArrayList();
        assertNumArrayListEquals("list1 was not empty when it should have been", list1, new double[] {});
        Assert.assertTrue("list1 size should have been 0 but it was not", list1.size() == 0);
        Assert.assertTrue("list1 capacity should have been 0 but it was not", list1.capacity() == 0);

        // 1 element
        list1.add(1.0);
        assertNumArrayListEquals("list1 did not have the correct element", list1, new double[] {1.0});
        Assert.assertTrue("list1 size should have been 1 but it was not", list1.size() == 1);
        Assert.assertTrue("list1 capacity should have been 1 but it was not", list1.capacity() == 1);

        // 3 elements
        list1.add(2.0);
        list1.add(3.0);
        assertNumArrayListEquals("list1 did not have the correct elements", list1, new double[] {1.0, 2.0, 3.0});
        Assert.assertTrue("list1 size should have been 3 but it was not", list1.size() == 3);
        Assert.assertTrue("list1 capacity should have been 4 but it was not", list1.capacity() == 4);
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
