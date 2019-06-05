package Lesson_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int row;
        int col;
        Scanner sc = new Scanner(System.in);

        row = sc.nextInt();
        col = sc.nextInt();

        String [][] myArray = new String[row][col];
    }

    private static void createArray(String [][] myArray, int row, int col) {
            if (row != 4 || col != 4) throw new MyArraySizeException(row, col);
            System.out.println("Create Array ");
            for (int i = 0; i < myArray.length; i++) {
                for (int j = 0; j < myArray[i].length; j++) {
                    System.out.println("New row " + i + " column " + j);
                    myArray[i][j] = sc.next();
                }
            }
    }
}