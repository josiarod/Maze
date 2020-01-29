import java.util.Random;
import java.util.Scanner;

public class Austin {

    private static String maze [] [] = new String [4] [4];
    private static boolean found = false;
    //bounds of the maze
    private static int boundX = 4;
    private static int boundY = 4;
    // current player position
    private static int currPlayerPosX;
    private static int currPlayerPosY;
    // treasure position
    private static int treasurePosX;
    private static int treasurePosY;
    private static Random rand;
    // initial player position
    private static int initPlayerPosX;
    private static int initPlayerPosY;

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static Scanner sc = new Scanner(System.in);


    //Austin
    public static void main (String[] args) {
        start();
    }

    //Josia
    // initializes the board and starts the maze game
    private static void start() {
        // initializes the maze
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                maze[i][j] = "[ ]";
            }
        }
        generateTreasurePos();
        generatePlayerPos();
        printMaze();
        move();
    }

    //Bili
    private static void move() {
        String dir;

        while (!foundTreasure()) {

            System.out.print("Enter a direction [ N W S E ] or Q to exit: ");
            dir = sc.nextLine();
            switch (dir.toLowerCase()) {
                case "n":
                    moveNorth();
                    printMaze();
                    break;
                case "s":
                    moveSouth();
                    printMaze();
                    break;
                case "w":
                    moveWest();
                    printMaze();
                    break;
                case "e":
                    moveEast();
                    printMaze();
                    break;
                case "q":
                    exit();
                    break;
                default:
                    System.out.println(ANSI_RED + "Invalid direction." + ANSI_RESET);
            }

            if (found) {
                System.out.println(ANSI_RED + "You have found the treasure!" + ANSI_RESET);
                exit();
            }
        }
    }

    // Austin
    // prints out the current board
    private static void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    //Austin
    private static void generatePlayerPos() {
        rand = new Random();
        // randomly assign initial player position within the array bounds
        initPlayerPosX = rand.nextInt(boundX);
        initPlayerPosY = rand.nextInt(boundY);
        // if the initial X and Y pos of the player and the treasure are the same
        //call random again until the the treasure and player are at different positions.
        while (true) {
            if ((initPlayerPosX == treasurePosX) && (initPlayerPosY == treasurePosY)) {
                rand = new Random();

                initPlayerPosX = rand.nextInt(boundX);
                initPlayerPosY = rand.nextInt(boundY);
                currPlayerPosX = initPlayerPosX;
                currPlayerPosY = initPlayerPosY;

            } else {
                currPlayerPosX = initPlayerPosX;
                currPlayerPosY = initPlayerPosY;
                maze[currPlayerPosX][currPlayerPosY] = "[X]";
                break;
            }
        }
    }

    //Josia
    // generate treasure first
    private static void generateTreasurePos() {
        //generate treasure pos x and y randomly
        rand = new Random();
        treasurePosX = rand.nextInt(boundX);
        treasurePosY = rand.nextInt(boundY);
        maze[treasurePosX][treasurePosY] = "[O]";
    }

    //Bili
    // To shift upwards: (-1, 0);
    private static void moveNorth() {
        int currX = currPlayerPosX;
        int currY = currPlayerPosY;

        if  (currPlayerPosX-1 < 0) {
            System.out.println(ANSI_RED + "You cannot move outside the boundaries of the maze." + ANSI_RESET);
        } else {
            maze[currX][currY] = "[ ]";
            maze[currPlayerPosX-1][currPlayerPosY] = "[X]";
            currPlayerPosX -= 1;
        }
        foundTreasure();
    }

    //Austin - moveSouth
    // To shift downwards: 1, 0);
    private static void moveSouth() {
        int currX = currPlayerPosX;
        int currY = currPlayerPosY;

        if (currPlayerPosX+1 > 3) {
            System.out.println(ANSI_RED + "You cannot move outside the boundaries of the maze." + ANSI_RESET);
        } else {
            maze[currX][currY] = "[ ]";
            maze[currPlayerPosX+1][currPlayerPosY] = "[X]";
            currPlayerPosX += 1;
        }
        foundTreasure();
    }

    //Austin - moveWest
    // To shift left: (0, -1);
    private static void moveWest() {
        int currX = currPlayerPosX;
        int currY = currPlayerPosY;

        if (currPlayerPosY-1 < 0) {
            System.out.println(ANSI_RED + "You cannot move outside the boundaries of the maze." + ANSI_RESET);
        } else {
            maze[currX][currY] = "[ ]";
            maze[currPlayerPosX][currPlayerPosY-1] = "[X]";
            currPlayerPosY -= 1;
        }
        foundTreasure();
    }

    //Austin - moveEast
    // To shift right: (0, 1);
    private static void moveEast() {
        int currX = currPlayerPosX;
        int currY = currPlayerPosY;

        if (currPlayerPosY+1 > 3) {
            System.out.println(ANSI_RED + "You cannot move outside the boundaries of the maze." + ANSI_RESET);
        } else {
            maze[currX][currY] = "[ ]";
            maze[currPlayerPosX][currPlayerPosY+1] = "[X]";
            currPlayerPosY += 1;
        }
        foundTreasure();
    }

    // Returns true if the treasure is found and updates the [O] with [$]
    private static boolean foundTreasure() {
        if (currPlayerPosX == treasurePosX && currPlayerPosY == treasurePosY) {
            maze[currPlayerPosX][currPlayerPosY] = "[" + ANSI_YELLOW + "$" + ANSI_RESET + "]";
            found = true;
        }
        return found;
    }

    private static void exit() {
        System.exit(0);
    }









}
