import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Floodfill {
    private static char[][] filledShape;

    public static void main(String[] args) {
        boolean inside = false;
        boolean startFound = false;
        char[][] shape;
        ArrayList<Integer> sStarsRow = new ArrayList<Integer>();
        ArrayList<Integer> sStarsCol = new ArrayList<Integer>();
        ArrayList<Integer> eStarsRow = new ArrayList<Integer>();
        ArrayList<Integer> eStarsCol = new ArrayList<Integer>();

        shape = readIn();
        String row1, col1;
        int row, col;

        row1 = JOptionPane.showInputDialog("Enter row");
        col1 = JOptionPane.showInputDialog("Enter col");
        row = Integer.parseInt(row1);
        col = Integer.parseInt(col1);



//        for(int i = 0; i < shape[0].length; i++) {
//            startFound = false;
//            for(int x = 0; x < shape.length; x++) {
//                if(shape[x][i] == '*' && !startFound) {
//                    sStarsRow.add(i + 1);
//                    sStarsCol.add(x + 1);
//                    startFound = true;
//                }
//            }
//        } //Makes arraylist of starting stars
//        for(int i = 0; i < shape[0].length; i++) {
//            for(int x = 0; x < shape.length; x++) {
//                if(shape[x][i] == '*') {
//                    //sStarsRow.add(i + 1);
//                    //sStarsCol.add(x + 1);
//                }
//            }
//        } //Makes arraylist of ending stars (WIP)
        inside = isInside(shape, row, col);
        floodFill(shape, inside, 1, 1);
        System.out.print(inside);

        for (int i = 0; i < shape[0].length; i++) {
            for (int x = 0; x < shape.length; x++) {
                System.out.print(filledShape[x][i]);
            }
            System.out.println("");

        }
//            if (shape[row - 1][col - 1] != '*') { // - 1 to account for index starting at 0 | determines if index is inside the shape
//                int distanceToLeft = row - 1;
//                int distanceToRight = shape[0].length - row;
//                int starCounterL = 0, starCounterR = 0;
//
//                for (int i = row - 1; i >= 0; i--) {
//                    if (shape[i][col] == '*')
//                        starCounterL++;
//                }
//                for (int i = row - 1; i <= shape[0].length; i++) {
//                    if (shape[i][col] == '*')
//                        starCounterR++;
//                }
//                if (starCounterL > 0 && starCounterR > 0) {
//                    inside = true;
//                }
//
//                for (int i = 0; i < shape[0].length; i++) {
//                    for (int x = 0; x < shape.length; x++) {
//                        System.out.print(shape[x][i]);
//                    }
//                    System.out.println("");
//                }
//                System.out.print("inside: " + inside);
//            } //
    }

        public static void floodFill (char[][] shape, boolean fillInside, int row, int col) {
            System.out.println("pointer at " + row + " " + col);
            boolean inside = isInside(shape, row, col);
            if (col >= shape[0].length) {
                return;
            } else {
                if (fillInside && inside) {
                    shape[row][col] = '*';
                }
                if (!fillInside && !inside) {
                    shape[row][col] = '*';
                }
                floodFill(shape, inside, row, col + 1);
                floodFill(shape, inside, row + 1, col);
            }
            filledShape = shape;

        }

        public static boolean isInside (char[][] shape, int row, int col){
            if (shape[row - 1][col - 1] != '*') { // - 1 to account for index starting at 0 | determines if index is inside the shape
                int distanceToLeft = row - 1;
                int distanceToRight = shape[0].length - row;
                int starCounterL = 0, starCounterR = 0;

                for (int i = row - 1; i >= 0; i--) {
                    if (shape[i][col] == '*')
                        starCounterL++;
                }
                for (int i = row - 1; i <= shape[0].length; i++) {
                    if (shape[i][col] == '*')
                        starCounterR++;
                }
                if (starCounterL > 0 && starCounterR > 0) {
                    return true;
                }
            }
            return false;
        }

        public static char[][] readIn () {
            char[][] picture;
            int numRows, numCols, row, col;
            // you can change this line as using Scanner to get file name or just hardcode the file name
            String fileName = JOptionPane.showInputDialog
                    (null, "Enter the file name:  ");
            try {
                Scanner file = new Scanner(new File(fileName));
                numRows = file.nextInt();
                numCols = file.nextInt();

                picture = new char[numRows][numCols];

                for (int r = 0; r < picture.length; r++)
                    for (int c = 0; c < picture[0].length; c++)
                        picture[r][c] = '_';

                while (file.hasNext()) {
                    row = file.nextInt();
                    col = file.nextInt();
                    picture[row][col] = '*';
                }
                file.close();

                return picture;
            } catch (FileNotFoundException e) {
                System.out.println("FloodFill: readIn(): FileNotFoundException!!");
            }

            return null;
        }


}
