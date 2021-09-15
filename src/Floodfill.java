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

        inside = isInside(shape, row, col);
        floodFill(shape, inside, 1, 1);
        System.out.println(inside);



        for (int r = 0; r < shape.length; r++) {
            for (int c = 0; c < shape[0].length; c++) {
                System.out.print(shape[r][c]);
            }
            System.out.println("");
        }
    }

        public static void floodFill (char[][] shape, boolean fillInside, int row, int col) {
            if (col >= shape[0].length || row >= shape.length) {
                return;
            }
            else {
                System.out.println("pointer at " + row + " " + col);

                boolean inside = isInside(shape, row, col);
                if (fillInside && inside) {
                    shape[row - 1][col - 1] = '*';
                }
                if (!fillInside && !inside) {
                    shape[row - 1][col - 1] = '*';
                }
                floodFill(shape, inside, row, col + 1);
                floodFill(shape, inside, row + 1, col);
            }
            filledShape = shape;

        }

        public static boolean isInside (char[][] shape, int row, int col){
            if (shape[row - 1][col - 1] != '*') { // - 1 to account for index starting at 0 | determines if index is inside the shape
                int distanceToLeft = col - 1;
                int distanceToRight = shape[0].length - col;
                int starCounterL = 0, starCounterR = 0;

                for (int i = col - 1; i >= 0; i--) {
                    if (shape[row - 1][i] == '*')
                        starCounterL++;
                }
                for (int i = col - 1; i < shape[0].length; i++) {
                    if (shape[row - 1][i] == '*')
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
