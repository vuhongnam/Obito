/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.pkg00023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Uchiha Obito
 */
public class Main {

    public static void main(String[] args) {
        boolean run = false;
        ArrayList<Fruit> Fruit = new ArrayList<>();
        ArrayList<Order> Order = new ArrayList<>();
        HashMap<String, String> NameCharacter = new HashMap<>();
        Fruit.add(new Fruit("001", "Coconut", 2, 30, "Viet Nam"));
        Fruit.add(new Fruit("002", "Orange", 3, 30, "US"));
        Fruit.add(new Fruit("003", "Apple", 4, 30, "Thai Lan"));
        Fruit.add(new Fruit("004", "Grape", 6, 30, "France"));
        while (!run) {
            int choose = ChooseMenu();
            run = Functions(choose, Fruit, Order, NameCharacter);
        }

    }

    private static int ChooseMenu() {
        boolean run = false;
        int choose = 0;
        System.out.println("FRUIT SHOP SYSTEM");
        System.out.println("1.	Create Fruit");
        System.out.println("2.	View orders");
        System.out.println("3.	Shopping (for buyer)");
        System.out.println("4.	Exit");
        while (!run) {
            choose = InputInt();
            if (choose == 1 || choose == 2 || choose == 3 || choose == 4) {
                run = true;
            } else {
                System.out.println("Choose wrong number");
                run = false;
            }
        }
        return choose;
    }

    private static int InputInt() {
        boolean run = false;
        int Number = 0;
        Scanner in = new Scanner(System.in);
        while (!run) {
            try {
                Number = in.nextInt();
                run = true;
                if (Number <=0) {
                    System.out.println("Must more than 0 !!!!!!!");
                    run = false;
                }
            } catch (Exception e) {
                System.out.println("Input must be number !!!");
                in.next();
            }
        }
        return Number;
    }

    private static boolean Functions(int choose, ArrayList<Fruit> Fruit, ArrayList<Order> Order, HashMap<String, String> NameCharacter) {
        boolean run = false;
        switch (choose) {
            case 1:
                boolean run1 = false;
                while (!run1) {
                    System.out.println("Do you want to continue (Y/N):");
                    String continues = InputString();
                    if (continues.equalsIgnoreCase("Y")) {
                        Create(Fruit);
                    } else if (continues.equalsIgnoreCase("n")) {
                        run1 = true;
                    } else {
                        System.out.println("User chooses Y to continues, if you chooses N, the program returns main screen");
                        run1 = false;
                    }
                }
                for (int i = 0; i < Fruit.size(); i++) {
                    Fruit get = Fruit.get(i);
                    System.out.println(get);
                }
                break;
            case 2:
                Vieworders(NameCharacter, Order);
                break;
            case 3:
                OrderFruit(Fruit, Order, NameCharacter);
                break;
        }
        return run;
    }

    private static void Create(ArrayList<Fruit> Fruit) {
        boolean AddNew = false;
        System.out.println("Enter New Fruit ID:");
        String ID = InputString();
        System.out.println("Enter New Fruit Name:");
        String FName = InputString();
        System.out.println("Enter New Fruit Price:");
        float FPrice = InputPrice();
        System.out.println("Enter New Fruit Quantity:");
        int FQuanity = InputInt();
        System.out.println("Enter New Fruit Origin:");
        String FOrigin = InputString();
        for (int i = 0; i < Fruit.size(); i++) {
            Fruit get = Fruit.get(i);
            if (get.getFID().equalsIgnoreCase(ID) && get.getFName().equalsIgnoreCase(FName) && get.getFOrigin().equalsIgnoreCase(FOrigin)) {
                System.out.println("the Fruit exist !!!");
                AddNew = true;
            } else if (get.getFID().equalsIgnoreCase(ID)) {
                System.out.println("ID Exist !!!!!!!!");
                AddNew = true;
            }
        }
        if (AddNew == false) {
            Fruit.add(new Fruit(ID, FName, FPrice, FQuanity, FOrigin));
            System.out.println("Add New Succes !!!!!!!!!!!");
        } else {
            System.out.println("Add New Again");
            Create(Fruit);
        }
    }

    private static String InputString() {
        String string = null;
        Scanner in = new Scanner(System.in);
        string = in.nextLine().toLowerCase().trim();
        if (string.equalsIgnoreCase("")) {
            System.out.println("Input must be not null !!!!!!!!!!!!!");
            InputString();
        }
        return string;
    }

    private static float InputPrice() {
        boolean run = false;
        float Number = 0;
        Scanner in = new Scanner(System.in);
        while (!run) {
            try {
                Number = in.nextFloat();
                if (Number < 0) {
                    System.out.println("Price must be more than 0 !!!");
                    run = false;
                } else {
                    run = true;
                }
            } catch (Exception e) {
                System.out.println("Input must be number !!!");
                in.next();
            }
        }
        return Number;
    }

    private static void OrderFruit(ArrayList<Fruit> Fruit, ArrayList<Order> Order, HashMap<String, String> NameCharacter) {
        String selectedName = null;
        boolean flag = false;
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |  ");
        for (int i = 0; i < Fruit.size(); i++) {
            Fruit get = Fruit.get(i);
            System.out.printf("     %-15s%-15s%-15s%-20f \n", get.getFID(), get.getFName(), get.getFOrigin(), get.getFPrice());
        }
        System.out.println("You selected ID :");
        String selectedID = InputString();
        for (int i = 0; i < Fruit.size(); i++) {
            Fruit get = Fruit.get(i);
            if (get.getFID().equalsIgnoreCase(selectedID)) {
                selectedName = get.getFName();
                flag = true;
            }
        }
        if (flag == true) {
            System.out.println("You select :" + selectedName);
            boolean run2 = false;
            while (!run2) {
                System.out.println("Do you want to continue (Y/N):");
                String continues = InputString();
                if (continues.equalsIgnoreCase("Y")) {
                    CreateOrder(selectedID, selectedName, Order, Fruit, NameCharacter);
                    run2 = true;
                    System.out.println(Order);
                    System.out.println(NameCharacter);
                } else if (continues.equalsIgnoreCase("n")) {
                    run2 = true;
                } else {
                    System.out.println("User chooses Y to continues, if you chooses N, the program returns main screen");
                    run2 = false;
                }
            }
        } else {
            System.out.println("Wrong ID , Select again !!!!!!!!!");
            OrderFruit(Fruit, Order, NameCharacter);
        }
    }

    private static void CreateOrder(String selectedID, String selectedName, ArrayList<Order> Order, ArrayList<Fruit> Fruit, HashMap<String, String> NameCharacter) {
        boolean run3 = false;
        System.out.println("Please input quantity:");
        int OrQuantity = InputInt();
        for (int i = 0; i < Fruit.size(); i++) {
            Fruit get = Fruit.get(i);
            if (get.getFID().equalsIgnoreCase(selectedID) && get.getFName().equalsIgnoreCase(selectedName) && get.getFQuantity() == 0) {
                run3 = true;
            }if (get.getFID().equalsIgnoreCase(selectedID) && get.getFName().equalsIgnoreCase(selectedName) && get.getFQuantity()<OrQuantity ) {
                run3 = true;
            }
        }
        if (run3 == true) {
            System.out.println("Can't Buy it !!!!!!!!!!!");
        } else {
            for (int i = 0; i < Fruit.size(); i++) {
                Fruit get = Fruit.get(i);
                if (get.getFID().equalsIgnoreCase(selectedID) && get.getFName().equalsIgnoreCase(selectedName) && get.getFQuantity() > 0) {
                    float Amount = OrQuantity * get.getFPrice();
                    int newQuantity = get.getFQuantity() - OrQuantity;
                    get.setFQuantity(newQuantity);
                    System.out.println("| ++ Product ++ | ++ Quantity ++ | ++ Price ++ | ++ Amount ++ |  ");
                    System.out.printf("    %-20s%-14d%-14f%-10f \n", selectedName, OrQuantity, get.getFPrice(), Amount);
                    System.out.println("Total: " + Amount);
                    System.out.println("Input your name");
                    String Name = InputString();
                    NameCharacter.put(Name, Name);
                    Order.add(new Order(Name, selectedName, OrQuantity, get.getFPrice(), Amount));
                }
            }

        }

    }

    private static void Vieworders(HashMap<String, String> NameCharacter, ArrayList<Order> Order) {
        for (String Name : NameCharacter.keySet()) {
            System.out.println("Customer:" + Name);
            System.out.println("Product    | Quantity | Price | Amount");
            for (int i = 0; i < Order.size(); i++) {
                Order get = Order.get(i);
                if (get.getOrName().equals(Name)) {
                    System.out.println(get);
                }
            }
        }
    }
}
