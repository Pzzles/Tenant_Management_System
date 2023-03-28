// Java program to Sort ArrayList using Comparator
  
import java.util.*;
  
// create the Shop class
class Shop {
  
    int ProductNo;
    String name;
    int stock;
  
    // constructor
    Shop(int ProductNo, String name, int stock)
    {
        this.ProductNo = ProductNo;
        this.name = name;
        this.stock = stock;
    }
}
  
// creates the comparator for comparing name
class NameComparator implements Comparator<Shop> {
  
    // override the compare() method
    public int compare(Shop s1, Shop s2)
    {
        return s1.name.compareTo(s2.name);
    }
}
  
class GFG {
    public static void main(String[] args)
    {
        // create the ArrayList object
        ArrayList<Shop> s = new ArrayList<Shop>();
        s.add(new Shop(218, "Pen", 520));
        s.add(new Shop(223, "Pencil", 213));
        s.add(new Shop(423, "Books", 101));
        s.add(new Shop(512, "Toy", 59));
        s.add(new Shop(723, "Bottle", 10));
                s.add(new Shop(723, "Aottle", 10));
                        s.add(new Shop(723, "Zottle", 10));
  
        System.out.println("before sorting");
        for (Shop shop : s) {
            System.out.println(shop.name + " " + shop.stock
                               + " " + shop.ProductNo);
        }
        System.out.println();
  
        System.out.println("After sorting(sorted by Name)");
  
        // call the sort function
        Collections.sort(s, new NameComparator());
        for (Shop shop : s) {
            System.out.println(shop.name + " " + shop.stock
                               + " " + shop.ProductNo);
        }
    }
}