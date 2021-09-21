package Floodfill;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Floodfill {
    private static char[][] ogShape;

    public static void main(String[] args) {
        boolean inside = false;
        boolean startFound = false;
        char[][] shape = readIn("shape.txt"); //I added a string parameter to pass the file name opposed to typing it every time
        ogShape = readIn("shape.txt"); //I added a string parameter to pass the file name opposed to typing it every time

        for (int r = 0; r < shape.length; r++) { //Prints array
            for (int c = 0; c < shape[0].length; c++) {
                System.out.print(shape[r][c]);
            }
            System.out.println("");
        }
        System.out.println("");

        String row1, col1;
        int row, col;
        row1 = JOptionPane.showInputDialog("Enter row");
        col1 = JOptionPane.showInputDialog("Enter col");
        row = Integer.parseInt(row1);
        col = Integer.parseInt(col1);

        inside = isInside(ogShape, row, col);



        if(shape[row - 1][col - 1] != '*') {
            floodFill(shape, ogShape, inside, 1, 1);
        }

        for (int r = 0; r < shape.length; r++) { //Prints array
            for (int c = 0; c < shape[0].length; c++) {
                System.out.print(shape[r][c]);
            }
            System.out.println("");
        }
    }

    public static void floodFill (char[][] shape, char[][] ogShape, boolean fillInside, int row, int col) {
        boolean inside = isInside(ogShape, row, col); //determines if pointer is in or out of shape
        if (col >= shape[0].length || row >= shape.length) { //End condition, either bound of the array
            if(fillInside) { //User point is inside
                if(inside) { //Pointer is inside
                    shape[row - 1][col - 1] = '*';
                }
            }
            if(!fillInside) { //User point is outside
                if(!inside) { //Pointer is outside
                    shape[row - 1][col - 1] = '*';
                }
            }
            return;
        }
        else {
            if(fillInside) { //User point is inside
                if(inside) { //Pointer is inside
                    shape[row - 1][col - 1] = '*';
                }
            }
            if(!fillInside) { //User point is outside
                if(!inside) { //Pointer is outside
                    shape[row - 1][col - 1] = '*';
                }
            }
            floodFill(shape, ogShape, fillInside, row, col + 1); //Recurs moving pointer one to the right
            floodFill(shape, ogShape, fillInside, row + 1, col); //Recurs moving pointer one down
        }
    }

    public static boolean isInside (char[][] shape, int row, int col){
            if (shape[row - 1][col - 1] != '*') { // - 1 to account for index starting at 0 | determines if index is inside the shape
                int distanceToLeft = col - 1;
                int distanceToRight = shape[0].length - col;
                int starCounterL = 0, starCounterR = 0;

                for (int i = col - 1; i >= 0; i--) { //Goes from point to left bound, counting stars
                    if (shape[row - 1][i] == '*')
                        starCounterL++;
                }
                for (int i = col - 1; i < shape[0].length; i++) { //Goes from point to right bound, counting stars
                    if (shape[row - 1][i] == '*')
                        starCounterR++;
                }
                if (starCounterL > 0 && starCounterR > 0) { //If there is a star on both sides, the point is inside
                    return true;
                }
            }
        return false;
        }

    public static char[][] readIn(String fileName) {
        char[][] picture;
        int numRows, numCols, row, col;
        // you can change this line as using Scanner to get file name or just hardcode the file name

        try
        {
            Scanner file = new Scanner(new File(fileName));
            numRows = file.nextInt();
            numCols = file.nextInt();

            picture = new char[numRows][numCols];

            for(int r = 0; r < picture.length; r++)
                for(int c = 0; c < picture[0].length; c++)
                    picture[r][c] = '_';

            while (file.hasNext()) {
                row = file.nextInt();
                col = file.nextInt();
                picture[row][col]='*';
            }
            file.close();

            return picture;
        }
        catch(FileNotFoundException e) {
            System.out.println("FloodFill: readIn(): FileNotFoundException!!");
        }
        return null;
    } //I added a string parameter to pass the file name opposed to typing
}