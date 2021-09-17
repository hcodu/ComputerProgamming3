package EraseObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EraseObject {
    public static void main(String[] args) {
        char[][] arr = readIn("digital.txt");

        for(int r = 0; r < arr.length; r++) {
            for(int c = 0; c < arr[0].length; c++) {
                System.out.print(arr[r][c]);
            }
            System.out.println("");
        }


    }

    public static void eraseObject(char[][] arr, int row, int col) {
        int counter = 0;
        int r1 = row - 1;
        int c1 = col - 1;
        if (arr[r1 - 1][col] == '@' || arr[r1 + 1][col] == '@' || arr[r1][c1 + 1] == '@' || arr[r1][c1 - 1] == '@') { //Checks all directions for @'s
            //

        }
    }

        public static char[][] readIn (String file1) {
            char[][] picture;
            int numRows, numCols;
            int row, col;
            // you can change this line as using Scanner to get file name or just hardcode the file name

            try {
                Scanner file = new Scanner(new File(file1));
                numRows = file.nextInt();

                picture = new char[20][20];

                for (int r = 0; r < picture.length; r++)
                    for (int c = 0; c < picture[0].length; c++)
                        picture[r][c] = '_';

                while (file.hasNext()) {
                    row = file.nextInt();
                    col = file.nextInt();
                    picture[row - 1][col - 1] = '@';
                }
                file.close();

                return picture;
            } catch (FileNotFoundException e) {
                System.out.println("FloodFill: readIn(): FileNotFoundException!!");
            }
            return null;
        } //I added a string parameter to pass the file name opposed to typing

}
