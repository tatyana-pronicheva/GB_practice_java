import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static final char X_DOT = 'X';
    private static final char O_DOT = 'O';
    private static final char EMPTY_DOT = '•';
    private static final int MAP_SIZE = 3;
    private static final int WIN_ROW_SIZE = 3;
    private static final Scanner SCANNER = new Scanner(System.in);
    private static char[][] map;

    public static void main(String[] args){
        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            System.out.println();
            if (isWin(X_DOT)) {
                System.out.println("You win");
                break;
            }
            if (isDraw()){
                System.out.println("Draw");
                break;
            }
            computerTurn();
            printMap();
            if (isWin(O_DOT)) {
                System.out.println("You lose");
                break;
            }
        }
    }
    private static boolean isDraw(){
        for (int i=0;i<MAP_SIZE;i++){
            for (int j=0; j<MAP_SIZE;j++){
                if (map[i][j] == EMPTY_DOT)  return false;
            }}
        return true;
    }

    private static boolean isWin(char dot){
        //horizontal
        for (int i=0;i<MAP_SIZE;i++){
            int sum=0;
            for (int j=0; j<MAP_SIZE;j++){
               if (map[i][j]==dot){
                   sum++;
                   if (sum==WIN_ROW_SIZE) return true;
               }else {sum=0;}
            }

        }
        //vertical
        for (int i=0;i<MAP_SIZE;i++){
            int sum=0;
            for (int j=0; j<MAP_SIZE;j++){
                if (map[j][i]==dot){
                    sum++;
                    if (sum==WIN_ROW_SIZE) return true;
                }else {sum=0;}
            }
        }
        // diagonal 1
        int sum=0;
        for (int i=0;i<MAP_SIZE;i++){
            if (map[i][i]==dot){
                sum++;
                if (sum==WIN_ROW_SIZE) return true;
            }else sum=0;
        }
        //diagonal 2
        sum=0;
        for (int i=0;i<MAP_SIZE;i++){
            if (map[i][MAP_SIZE-1-i]==dot){
                sum++;
                if (sum==WIN_ROW_SIZE) return true;
            } else sum=0;
        }
        return false;
    }

    private static void humanTurn() {
        int xCoordinate = -1;
        int yCoordinate = -1;
        do{
            System.out.println("Введите координаты хода в формате \"x пробел y\"");
            if (SCANNER.hasNextInt()){
                xCoordinate = SCANNER.nextInt();
            }
            if (SCANNER.hasNextInt()){
                yCoordinate = SCANNER.nextInt();
            }
            SCANNER.nextLine();
        }while(!isValidHumanTurn(xCoordinate,yCoordinate));
    }
    private static void computerTurn() {
        int xCoordinate = -1;
        int yCoordinate = -1;
        Random r = new Random();
        do{
            xCoordinate=r.nextInt(MAP_SIZE);
            yCoordinate=r.nextInt(MAP_SIZE);
        }while(!isValidComputerTurn(xCoordinate,yCoordinate));
    }
    private static boolean isValidComputerTurn(int xCoordinate, int yCoordinate) {
        if (map[xCoordinate][yCoordinate] == EMPTY_DOT) {
            map[xCoordinate][yCoordinate] = O_DOT;
            return true;
        }
        return false;
    }
    private static boolean isValidHumanTurn(int xCoordinate, int yCoordinate) {
        if (xCoordinate < 1 || xCoordinate > MAP_SIZE ||
                yCoordinate < 1 || yCoordinate > MAP_SIZE) {
            System.out.println("Вы ввели неправильные координаты.");
            return false;
        }

        if (map[xCoordinate - 1][yCoordinate - 1] == EMPTY_DOT) {
            map[xCoordinate-1][yCoordinate-1] = X_DOT;
            return true;
        }
        System.out.println("Это поле уже занято.");
        return false;
    }


    private static void printMap() {
        for (int i=0;i<MAP_SIZE;i++){
            for (int j=0; j<MAP_SIZE;j++){
                System.out.print(map[i][j]+"  ");
            }
            System.out.println();
        }
    }

    private static void initMap() {
        map = new char[MAP_SIZE][MAP_SIZE];
        for (int i=0;i<MAP_SIZE;i++){
            Arrays.fill(map[i], EMPTY_DOT);
        }
    }

}
