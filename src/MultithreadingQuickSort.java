import java.util.Arrays;

public class MultithreadingQuickSort implements Runnable {
    int[] array;
    int low;
    int high;

    public MultithreadingQuickSort(int[] array, int low, int high) {
        this.array = array;
        this.low = low;
        this.high = high;
    }

    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;//завершить выполнение если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j) {
            if (low - j > 20) {
                Thread thr = new Thread(new MultithreadingQuickSort(array, i, high));
                thr.start();
            } else {
                quickSort(array, low, j);
            }
        }

        if (high > i) {
            if (high - i > 20) {
                Thread thr = new Thread(new MultithreadingQuickSort(array, i, high));
                thr.start();
            } else {
                quickSort(array, i, high);
            }
        }
    }

    @Override
    public void run() {
        quickSort(array, low, high);
    }
}
