import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class XspeedIt {


    public static void main(String[] args) {

        //get the size of the box
        int maxSize = XspeedIt.getBoxMaximalSize();
        //get the list of items to place in the box
        String listOfItems = XspeedIt.getListOfItems();
        //valid the list of items and return them ordered
        List<Integer> validItems = getValidItems(listOfItems, maxSize);
        if (validItems != null && validItems.size() > 0) {
            //put list of item in boxes
            countBoxesNeeded(validItems, maxSize);
        }
    }

    /**
     * get the max size of the box
     * @return max size of the box
     */
    public static int getBoxMaximalSize() {
        int maxSize = 0;
        while (true) {
            try {
                //  prompt for the maximal size of the box
                System.out.print("Entrer la taille maximale d'un carton: ");
                Scanner scanner = new Scanner(System.in);
                maxSize = scanner.nextInt();
                if (maxSize > 0) {
                    return maxSize;
                }
            } catch (Exception e) {
                System.out.println("La taille maximale du carton est incorrecte. Veuillez rentrer un chiffre a nouveau");
            }
        }

    }

    /**
     * get the list of items to package in the boxes
     * in case user enter unvalid charcater the operation is repeated
     * and he will asked to re-enter valid item digits 1-9)
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
            System.out.println("veuillez saisir des chiffres positifs");
            //  prompt for the user's input list of the product to organize
            items = scanner.nextLine();
            items = items.replaceAll("\\s", "");
        } while (!items.matches(regex));
        return items;
    }

    /**
     * Removes all items with size bigger than the max size of the box
     * @param items list of items to package
     * @param maxSize, box max capacity
     * @return ordeed list of items to store
     */
    public static List getValidItems(String items, int maxSize) {
        List<Integer> list = items.chars().mapToObj(item -> Character.getNumericValue(item))
                .filter(size -> size <= maxSize && size > 0)
                .collect(Collectors.toList());
        //order the list of items
        list.sort(Comparator.reverseOrder());
        //print the list of items
        System.out.println("list d'element a emballer " + list);
        return list;
    }

    /**
     * returns best combination to store the items in the boxes
     * @param listOfItems
     * @param maxSizeOfBox
     * @return best combination to store the items in the boxes
     */
    public static String countBoxesNeeded(List<Integer> listOfItems, int maxSizeOfBox) {
        int productIndex, countBox = 0, currentBoxSize = maxSizeOfBox;
        String combination = "";
        while (listOfItems.size() > 0) {
            productIndex = 0;
            while (productIndex < listOfItems.size()) {
                if (listOfItems.get(productIndex) > 0 && listOfItems.get(productIndex) <= currentBoxSize) {
                    currentBoxSize -= listOfItems.get(productIndex);
                    combination += listOfItems.get(productIndex);
                    listOfItems.remove(productIndex);
                }
                productIndex++;
            }
            currentBoxSize = maxSizeOfBox;
            combination += "/";
            countBox++;
        }
        System.out.println("Nombre de cartons a utiliser: " + countBox);
        System.out.println("les produits doivent etre emballes dans l'ordre suivant: " + combination);
        return combination;
    }

}
