package Lesson_2;

public class MyArraySizeException extends RuntimeException {
    int row, col;

    public MyArraySizeException(int row, int col) {
        super("");
        this.row = row;
        this.col = col;
    }
}
