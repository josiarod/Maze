import java.io.*;
import java.util.Scanner;

public class Bili {
    private static char maze [] [] = new char [4] [4];
    private static boolean found = false;
    private static int boundX = 4;
    private static int boundY = 4;
    private char n, w, s, e; //switch
    private static int currentPosX;
    private static int currentPosY;
    private static int treasurePosX;
    private static int treasurePosY;
    // Bili added
    private static Scanner sc= new Scanner(System.in);
    //Austin
    public static void main (String[] args) {
        move();
    }
    // bili utility
    public static void print(String  args) {
        System.out.println(args);

    }

    //Josia initalizes game
    private static void start() {

    }

    //Bili
    private static void move() {
        print("What direction you want to move?");
        print("Press N: for North \n\t  S: for South\n\t  E: for East\n\t  W: for West");

        String direction; // TODO: try to hadle using char
        String quit="C";
        while(!quit.equalsIgnoreCase("Q")) {
            print("your input>>");
            direction = sc.next().toUpperCase();
           if(direction.equalsIgnoreCase("Q"))
           {
               print("Good bye");
               break;
           }
            switch (direction) {

                case "N":
                    moveNorth(maze);
                    print("you are moving North");
                    break;

                case "S":
                    moveNorth(maze);
                    print("you are moving South");
                    break;
                case "E":
                    moveNorth(maze);
                    print("you are moving East");
                    break;
                case "W":
                    moveWest(maze);
                    print("you are moving west");
                    break;
                default:
                    print("sorry, that is not a direction");
            }// end of switch
            print("Do you want to continue Y/Q");
            quit=sc.next();
        }// end of while
        //print("Good bye");

    }

    //Austin
    // if player pos and treasure pos is the same; re-rol
    private static void generatePlayerPos(char [] [] ary) {
        // randomly assign curr x and curr y
        // within the array bounds
    }

    //Josia
    // generate treasure first
    private static boolean generateTreasurePos(char [] [] ary) {
        //generate treasure pos x and y randomly
        return true;
    }

    //Bili
    private static boolean moveNorth(char [] [] ary) {
        // moves up
        // updates current x current y
        return true;
    }
    // Austin
    private static boolean moveSouth(char [] [] ary) {
        // moves up
        // updates current x current y
        return true;
    }
    //Bili
    private static boolean moveEast(char [] [] ary) {
        // moves up
        // updates current x current y
        return true;
    }
    // Josia
    private static boolean moveWest(char [] [] ary) {
        // moves up
        // updates current x current y
        return true;
    }

}

