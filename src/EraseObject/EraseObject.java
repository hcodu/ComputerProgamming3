package EraseObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EraseObject {
    public static void main(String[] args) {
        char[][] arr = readIn("digital.txt");
        char[][] ogArr = readIn("digital.txt");

        for(int r = 0; r < arr.length; r++) {
            for(int c = 0; c < arr[0].length; c++) {
                System.out.print(arr[r][c]);
            }
            System.out.println("");
        }

        eraseObject(arr, ogArr, 1, 1);
    }

    public static void eraseObject(char[][] arr, char[][] og, int row, int col) {
        int r1, c1;
        r1 = row - 1;
        c1 = col - 1;
        if((r1 == arr.length)) { //If on the bottom row
            if(c1 == 0 && (arr[r1 - 1][c1] == '_' && arr[r1][c1 + 1] == '_')) { //Checks bottom left corner and above and right are blank, return
                return;
            }
            if(c1 == arr.length && (arr[r1][c1 - 1] == '_' && arr[r1 - 1][c1] == '_')) { //Checks bottom right corner and above and left are blank, return
                return;
            }
        }
        if((r1 == 0)) {
            if(c1 == 0 && (arr[r1 + 1][c1] == '_' && arr[r1][c1 + 1] == '_')) { //Checks top left corner below and to the right, return
                return;
            }
            if(c1 == arr[0].length && (arr[r1 - 1][c1] == '_' && arr[r1][c1 -1] == '_')) { //Checks top right corner below and to the left, return
                return;
            }
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
