import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int array_length = 100000;
        int[] array_qs = new int[array_length];
        int[] array_mqs = new int[array_length];
        MultithreadingQuickSort mqs = new MultithreadingQuickSort(array_mqs, 0, array_length - 1);

        //Заполнение массива рандомными числами
        for (int i = 0; i < array_length; i++) {
            array_qs[i] = new Random().nextInt(10000);
            array_mqs[i] = array_qs[i];
        }

        long time = System.currentTimeMillis();
        QuickSort.quickSort(array_qs, 0, array_length-1);
        System.out.println(System.currentTimeMillis() - time);
        System.out.println();
//        for (int i = 0; i < array_length; i++) {
//            System.out.println(array_qs[i]);
//        }

        time = System.currentTimeMillis();
        MultithreadingQuickSort.quickSort(array_mqs, 0, array_length-1);
        System.out.println(System.currentTimeMillis() - time);
//        for (int i = 0; i < array_length; i++) {
//            System.out.println(array_mqs[i]);
//        }
    }
}
