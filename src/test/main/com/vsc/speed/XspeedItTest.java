package main.com.vsc.speed;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import com.vsc.speed.FirstFitDecreasingPackager;

public class XspeedItTest {

    @Test
    public void testCountBoxesNeeded() {

      // Example: 163841689525773
      List<Integer> in = Arrays.asList(1,6,3,8,4,1,6,8,9,5,2,5,7,7,3);
      FirstFitDecreasingPackager first_test = new FirstFitDecreasingPackager(in, 10);
      Assert.assertTrue(first_test.getResult() == 8);
      Assert.assertTrue(first_test.printBestBoxesPackaging() .contains("91/82/81/73/73/64/6/55"));

    }
}
