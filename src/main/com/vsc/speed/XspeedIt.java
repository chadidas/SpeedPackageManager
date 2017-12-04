package com.vsc.speed;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class XspeedIt {

  public static void main(String[] args) {

    //        //get the size of the box
    int maxSize = XspeedIt.getBoxMaximalSize();
    //get the list of items to place in the box
    String listOfItems = XspeedIt.getListOfItems();
    //valid the list of items and return them ordered
    List<Integer> itemsIn = filterListOfItems(listOfItems, maxSize);

    FirstFitDecreasingPackager packager = new FirstFitDecreasingPackager(itemsIn, maxSize);
    System.out.println("Total needed boxes for optimal packaging  ==> " + packager.getResult());
    System.out.println(packager.printBestBoxesPackaging());
  }

  /**
   * get the max size of the box
   *
   * @return max size of the box
   */
  public static int getBoxMaximalSize() {
    int maxSize = 0;
    while (true) {
      try {
        //  prompt for the maximal size of the box
        System.out.print("Enter the max size of the box ");
        Scanner scanner = new Scanner(System.in);
        maxSize = scanner.nextInt();
        if (maxSize > 0) {
          return maxSize;
        }
      } catch (Exception e) {
        System.out.println("the entered value is incorrect, try again !");
      }
    }

  }

  /**
   * get the list of items to package in the boxes
   * in case user enter unvalid charcater the operation is repeated
   * and he will asked to re-enter valid item digits 1-9)
   *
   * @return
   */
  public static String getListOfItems() {
    // create a scanner so we can read the command-line input
    Scanner scanner = new Scanner(System.in);
    // strin that will contains the elements entered by the user
    String items = "";
    //regex to verify that all element are + digit
    String regex = "\\d+";
    do {
      System.out.println("Enter list of items, only positif digits are allowed");
      //  prompt for the user's input list of the product to organize
      items = scanner.nextLine();
      items = items.replaceAll("\\s", "");
    } while (!items.matches(regex));
    return items;
  }

  /**
   * Removes all items with size bigger than the max size of the box
   *
   * @param items
   *         list of items to package
   * @param maxSize,
   *         box max capacity
   *
   * @return ordeed list of items to store
   */
  public static List filterListOfItems(String items, int maxSize) {
    List<Integer> list = items.chars().mapToObj(item -> Character.getNumericValue(item))
            .filter(size -> size < maxSize && size > 0).collect(Collectors.toList());

    //order the list of items
    list.sort(Comparator.reverseOrder());
    return list;
  }

  /**
   * returns best combination to store the items in the boxes
   * @param principalList
   * @param maxSizeOfBox
   * @return best combination to store the items in the boxes
   */
/*    public static String countBoxesNeeded(List<Integer> principalList,List<Integer> secondList, int
            maxSizeOfBox) {

        //print the list of items
        System.out.println("list d'element a emballer " + principalList+ secondList);
        int countBox = 0, currentBoxSize = 0;
        String combination = "";
        int principalIndex = 0;
        while (principalList.size() > 0){
            currentBoxSize = principalList.get(principalIndex);
            combination += principalList.get(principalIndex);
            int secondIndex=0;
            while(secondList.size() > 0  && currentBoxSize < maxSizeOfBox &&
                    currentBoxSize + secondList.get(secondIndex) <= maxSizeOfBox && secondIndex == 0 && secondList.get
                    (secondIndex)  <= Math.rint(maxSizeOfBox /2) ){
                if (currentBoxSize + secondList.get(secondIndex) <= maxSizeOfBox ){
                    currentBoxSize += secondList.get(secondIndex);
                    combination += secondList.get(secondIndex);
                    secondList.remove(secondIndex);
                   secondIndex++;
                }
            }
            principalList.remove(principalIndex);

            combination += "/";
            countBox++;
        }
        if(secondList.size() > 0){
            int secondIndex = 0;
            currentBoxSize = secondList.get(secondIndex);
            combination += secondList.get(secondIndex);
            secondList.remove(secondIndex);
            secondIndex =0;
            while(secondList.size() > 0 && currentBoxSize < maxSizeOfBox ){
                if(secondList.get(secondIndex) + currentBoxSize <= maxSizeOfBox){
                    currentBoxSize += secondList.get(secondIndex);
                    combination += secondList.get(secondIndex);
                    secondList.remove(secondIndex);
                    secondIndex = 0;
                }else {
                    secondIndex++;
                }
            }
            combination += "/";
            countBox++;
            currentBoxSize =0;
        }


        System.out.println("Resultats Robot optimise: " + combination + " => "+ countBox+
                " cartons a utiliser");
        return combination;*/
  //}

}
