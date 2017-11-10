package test.java;

import main.java.app.XspeedIt;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class XspeedItTest {

    @Test
    public void testCountBoxesNeeded() {
        List<Integer> validItems= XspeedIt.getValidItems("78956412539892",7);
        String combination= XspeedIt.countBoxesNeeded(validItems,7);
       Assert.assertTrue(combination.matches("7/61/52/52/4/3/"));
    }
    @Test
    public void testValidItems() {
        //list of valid elements to sort
        List<Integer> validItems= XspeedIt.getValidItems("78956412539892",7);
        Assert.assertTrue(validItems.size() == 9);
    }
}
