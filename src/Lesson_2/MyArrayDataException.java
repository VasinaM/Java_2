package Lesson_2;

public class MyArrayDataException extends RuntimeException {
    private int i;
    private int j;

    public MyArrayDataException (int i, int j){
        super("Тип данных должен быть int, яцейка [" + i + "],[" + j + "]");
        this.i = i;
        this.j = j;
    }
}
