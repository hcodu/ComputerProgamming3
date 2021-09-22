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

        eraseObject(arr, ogArr, 3, 2); //tRi work, tL works, bL works, bRi works
        for(int r = 0; r < arr.length; r++) {
            for(int c = 0; c < arr[0].length; c++) {
                System.out.print(arr[r][c]);
            }
            System.out.println("");
        }

    }

    public static void eraseObject(char[][] arr, char[][] og, int row, int col) {
        int r1, c1; //User inputs starting at 1, java starts at 0
        r1 = row - 1;
        c1 = col - 1;
        System.out.println("pointer at " + r1 + " , " + c1);
        //Base cases, checks border, returns if all surrounding are _
        if((r1 == arr.length - 1)) { //If on the bottom row
            if(c1 == 0 && (og[r1 - 1][c1] == '_' && og[r1][c1 + 1] == '_')) {//Checks bottom left corner and above and right are blank, returns if all _
                System.out.print("terminated1");
                return;
            }
            else if(c1 == arr.length - 1 && (og[r1][c1 - 1] == '_' && og[r1 - 1][c1] == '_')) { //Checks bottom right corner and above and left are blank, returns if all _
                System.out.print("terminated2");
                return;
            }
            else if(og[r1][c1 - 1] == '_' && og[r1][c1 + 1] == '_' && og[r1 - 1][c1] == '_') { //Checks bottom row above, to the left and right, returns if all _
                System.out.print("terminated3");
                return;
            }
            System.out.print("Test");
        }
        else if((r1 == 0)) { //If on top row
            if(c1 == 0 && (og[r1 + 1][c1] == '_' && og[r1][c1 + 1] == '_')) { //Checks top left corner below and to the right, returns if all _
                System.out.print("terminated4");
                return;
            }
            else if(c1 == arr[0].length - 1 && (og[r1 + 1][c1] == '_' && og[r1][c1 -1] == '_')) { //Checks top right corner below and to the left, returns if all _
                System.out.print("terminated5");
                return;
            }
            else if(og[r1][c1 - 1] == '_' && og[r1][c1 + 1] == '_' && og[r1 + 1][c1] == '_') { //Checks top row below, to the left and right, returns if all _
                System.out.println("terminated6");
                return;
            }
         }
        else if(c1 == 0) {
                if(og[r1 - 1][c1] == '_' && og[r1 + 1][c1] == '_' && og[r1][c1 + 1] == '_') { //Checks left side, above, below, to the right, returns if all _
                System.out.print("terminated7");
                return;
            }
        }
        else if(c1 == arr[0].length - 1) {
            if(og[r1 - 1][c1] == '_' && og[r1 + 1][c1] == '_' && og[r1][c1 - 1] == '_') { //Checks ride side, above, below, to the left, returns if all _
                System.out.print("terminated8");
                return;
            }
        }
        else if(og[r1][c1 - 1] == '_' && og[r1][c1 + 1] == '_' && og[r1 + 1][c1] == '_' && og[r1 -1][c1] == '_') { //Checks all 4 directions, returns if all _
            System.out.print("terminated 9");
            return;
        }


        if(og[r1][c1] == '@') {
            if((r1 == arr.length - 1)) { //If on bottom row
                if(c1 == 0 && (og[r1 - 1][c1] == '@' || og[r1][c1 + 1] == '@')) {//Checks bottom left corner and above and right are blank, returns if all _
                    arr[r1][c1] = '_';
                    eraseObject(arr, og, row - 1, col);
                    eraseObject(arr, og, row, col + 1);
                }
                else if(c1 == arr.length - 1 && (og[r1][c1 - 1] == '@' || og[r1 - 1][c1] == '@')) { //Checks bottom right corner and above and left are blank, returns if all _
                   arr[r1][c1] = '_';
                   eraseObject(arr, og, row - 1, col);
                   eraseObject(arr, og, row, col - 1);
                }
                else if(og[r1][c1 - 1] == '@' || og[r1][c1 + 1] == '@' || og[r1 - 1][c1] == '@') { //Checks bottom row above, to the left and right, returns if all _
                    arr[r1][c1] = '_';
                    eraseObject(arr, og, row - 1, col);
                    eraseObject(arr, og, row, col - 1);
                    eraseObject(arr, og, row, col + 1);
                }
            }

            else if((r1 == 0)) { //If on top row
                if(c1 == 0 && (og[r1 + 1][c1] == '@' || og[r1][c1 + 1] == '@')) { //Checks top left corner below and to the right, returns if all _
                    arr[r1][c1] = '_';
                    eraseObject(arr, og, row + 1, col);
                    eraseObject(arr, og, row, col + 1);
                }
                else if(c1 == arr[0].length - 1 && (og[r1 + 1][c1] == '@' || og[r1][c1 -1] == '@')) { //Checks top right corner below and to the left, returns if all _
                    arr[r1][c1] = '_';
                    eraseObject(arr, og, row - 1, col);
                    eraseObject(arr, og, row, col - 1);
                }
                else if(og[r1][c1 - 1] == '@' || og[r1][c1 + 1] == '@' || og[r1 + 1][c1] == '@') { //Checks top row below, to the left and right, returns if all _
                    arr[r1][c1] = '_';
                    eraseObject(arr, og, row + 1, col);
                    eraseObject(arr, og, row, col + 1);
                    eraseObject(arr, og, row, col - 1);
                }
            }

            else if(c1 == 0) { //If on left side
                if(og[r1 - 1][c1] == '@' || og[r1 + 1][c1] == '@' || og[r1][c1 + 1] == '@') { //Checks left side, above, below, to the right, recurs if all @
                    arr[r1][c1] = '_';
                    eraseObject(arr, og, row - 1, col);
                    eraseObject(arr, og, row + 1, col);
                    eraseObject(arr, og, row, col + 1);
                }
            }

            else if(c1 == arr[0].length - 1) { //If on right side
                if(og[r1 - 1][c1] == '@' || og[r1 + 1][c1] == '@' || og[r1][c1 - 1] == '@') { //Checks ride side, above, below, to the left, returns if all _
                    arr[r1][c1] = '_';
                    eraseObject(arr, og, row - 1, col);
                    eraseObject(arr, og, row + 1, col);
                    eraseObject(arr, og, row, col - 1);
                }
            }

            else if(og[r1][c1 - 1] == '@' || og[r1][c1 + 1] == '@' || og[r1 + 1][c1] == '@' || og[r1 -1][c1] == '@') { //Checks all 4 directions, returns if all _
                arr[r1][c1] = '_';
                System.out.println("pointer at " + r1 + " , " + c1);
                eraseObject(arr, og, row, col + 1); //Recurs one to the right
                eraseObject(arr, og, row, col - 1); //Recurs one to the left
                eraseObject(arr, og, row + 1, col); //Recurs one below
                eraseObject(arr, og, row - 1, col); //Recurs one above
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
