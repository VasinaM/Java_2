package lesson2_5;

import java.util.Arrays;

public class Main {

    static final int size = 100;
    static final int h = size/2;

    private static float [] arrayCreate () {

        float[] array = new float[size];
        Arrays.fill(array, 1); //нашла, что так можно заполнять массив
        return array;
    }


    public static void main(String[] args) {

        array1(arrayCreate());
        array2(arrayCreate());

    }

    private static void array1 (float[] array) {

        long a = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(Arrays.toString(array));
        System.out.println(System.currentTimeMillis() - a);
    }

    private static void array2 (float[] array) {


        float[] arrayOne = new float[h];
        float[] arrayTwo = new float[h];

        long b = System.currentTimeMillis();

        System.arraycopy(array, 0, arrayOne, 0, h);
        System.arraycopy(array, h, arrayTwo, 0, h);


        long t = System.currentTimeMillis();
        Thread partArray1 = new Thread(() -> {  //идея предложила, я не отказалась

            for (int i = 0; i < arrayOne.length; i++) {
                arrayOne[i] = (float)(arrayOne[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        partArray1.start();

        long f = System.currentTimeMillis();
        Thread partArray2 = new Thread(() -> {

            for (int i = 0; i < arrayTwo.length; i++) {
                arrayTwo[i] = (float)(arrayTwo[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        partArray2.start();


        try {

            partArray1.join();
            partArray2.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        long d = System.currentTimeMillis();
        System.arraycopy(arrayOne, 0, array, 0, h);
        System.arraycopy(arrayTwo, 0, array, h, h);

        System.out.println(Arrays.toString(array));
        System.out.println(System.currentTimeMillis() - b);
        
        System.out.println(System.currentTimeMillis() - d);
        System.out.println(System.currentTimeMillis() - t);
        System.out.println(System.currentTimeMillis() - f);
    }
}
