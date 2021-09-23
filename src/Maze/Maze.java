package Maze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {
    public static void main(String[] args) {
        char[][] maze = readIn("mazeData.txt");
        display(maze);
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

    public static void display(char[][] arr) {
        for(int r = 0; r < arr.length; r++) {
            for(int c = 0; c < arr[0].length; c++) {
                System.out.print(arr[r][c]);
            }
            System.out.println("");
        }
    }

    public static void findExit(char[][] arr, int row, int col) {
        if(row - 1 == 0 || row == arr.length) {
            return;
        }
    }

}
