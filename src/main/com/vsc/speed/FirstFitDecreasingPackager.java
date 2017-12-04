package com.vsc.speed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FirstFitDecreasingPackager {

  private List<Integer> in;

  private int boxSize;

  private List<Box> boxes = new ArrayList<Box>();

  public FirstFitDecreasingPackager(List<Integer> in, int boxSize) {
    this.in = in;
    this.boxSize = boxSize;
  }

  public int getResult() {
    Collections.sort(in, Collections.reverseOrder()); // sort input by size (big to small)
    boxes.add(new Box(boxSize)); // add first box
    for (Integer currentItem : in) {
      // iterate over boxes and try to put the item into the first one it fits into
      boolean putItem = false; // did we put the item in a box?
      int currentbox = 0;
      while (!putItem) {
        if (currentbox == boxes.size()) {
          // item did not fit in last box. put it in a new box
          Box newBox = new Box(boxSize);
          newBox.put(currentItem);
          boxes.add(newBox);
          putItem = true;
        } else if (boxes.get(currentbox).put(currentItem)) {
          // item fit in box
          putItem = true;
        } else {
          // try next box
          currentbox++;
        }
      }
    }
    return boxes.size();
  }

  public String printBestBoxesPackaging() {
    String optimalCombination = "";
    for (Box box : boxes) {
      optimalCombination += box.toString() + "/";
    }
    return optimalCombination;

  }
}
