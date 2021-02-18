package lesson05;

import java.util.Arrays;

public class Main {

    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {

        stopwatchOne();

        stopwatchTwo();

    }

    private static void stopwatchOne() {

        float[] arr = new float[size];
        Arrays.fill(arr, 1);

        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("Время выполнения первого метода: " + (System.currentTimeMillis() - a));

    }


    private static void stopwatchTwo() {

        float[] arr = new float[size];
        Arrays.fill(arr, 1);

        float[] newArrOne = new float[h];
        float[] newArrTwo = new float[h];

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, newArrOne, 0, h);
        System.arraycopy(arr, h, newArrTwo, 0, h);

        Thread threadOne = new Thread(() -> {
            for (int i = 0; i < newArrOne.length; i++) {
                newArrOne[i] = (float) (newArrOne[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread threadTwo = new Thread(() -> {
            for (int i = 0; i < newArrTwo.length; i++) {
                newArrTwo[i] = (float) (newArrTwo[i] * Math.sin(0.2f + (i + h) / 5) * Math.cos(0.2f + (i + h) / 5) * Math.cos(0.4f + (i + h) / 2));
            }
        });
        
        threadOne.start();
        threadTwo.start();

        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(newArrOne, 0, arr, 0, h);
        System.arraycopy(newArrTwo, 0, arr, h, h);

        System.out.println("Время выполнения второго метода: " + (System.currentTimeMillis() - a));

    }
}
