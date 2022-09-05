package Program;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Task7 implements Task {
    @Override
    public void variantTask(ArrayList<Integer> arrayList) {
        int a = 100;
        int b = 100;
        int[][] array = new int[a][b];

        Random random = new Random();

        for (int i = 0; i < array.length; ++i) {
            array[i] = random.ints(array[i].length, 10, 1000).toArray();
        }

        try {
            FileWriter file = new FileWriter("Task.txt");
            //Printing start matrix
            for (int i = 0; i < array.length; ++i) {
                file.append(AdditionalUtilities.showOneArray(array[i]));
            }

            //Printing matrix changed by task condition
            for (int i = 0; i < array.length; ++i) {
                int min = array[i][0];
                int minIndex = 0;
                for (int j = 0; j < array[i].length; ++j) {
                    if (min > array[i][j]) {
                        min = array[i][j];
                        minIndex = j;
                    }
                }
                array[i][minIndex] = (int) Math.log(Math.abs(array[i][minIndex]));
            }

            file.append("\n\n\n\n\n\nChanged Matrix\n");
            for (int i = 0; i < array.length; ++i) {
                file.append(AdditionalUtilities.showOneArray(array[i]));
            }

            //Sorting bt task

            int[] minElementsArr = new int[array.length];
            int k = 0;
            for (int i = 0; i < array.length; ++i) {
                int min = array[i][0];
                for (int j = 0; j < array[i].length; ++j) {
                    if (min > array[j][0]) min = array[j][0];
                }
                minElementsArr[k++] = min;
            }

            sortingColumns(array,minElementsArr,0,minElementsArr.length-1);

            //Printing sorted by task matrix
            file.append("\n\n\n\n\n\nSorted\n");
            for (int i = 0; i < array.length; ++i) {
                file.append(AdditionalUtilities.showOneArray(array[i]));
            }
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void swapRowsRealization(int array[][], int row1, int row2) {

        for (int i = 0; i < array[0].length; ++i) {
            int temp = array[i][row1];
            array[i][row1] = array[i][row2];
            array[i][row2] = temp;
        }
    }

    @Override
    public void sorting(ArrayList<Integer> list, SortingClass.SortingFacilities method, SortingClass.PrintFile printNecessary) throws IOException {
        SortingClass.quickSort(list, method, printNecessary);
    }

    @Override
    public void timeMeasuring() {
        try {
            FileWriter file = new FileWriter("Experiment1000.txt");

            Random random = new Random();
            int[][] array = new int[1000][];
            for (int i = 0; i < array.length; ++i) {
                array[i] = random.ints(50, 10, 100000).toArray();
            }
            long timeStart = System.nanoTime();


            for (int i = 0; i < array.length; ++i) {
                quickSortRealization(array[i], 0, array[i].length - 1);
                file.append(AdditionalUtilities.showOneArray(array[i]));
            }


            long timeSpent = System.nanoTime() - timeStart;
            file.append("\n\n\n\n" + timeSpent / (1e+9) + "\n\n\n\n");
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private static void sortingColumns(int[][] array, int[] minArr, int from, int to) {
        if (from < to) {
            int leftIndex = from;
            int rightIndex = to;

            int beginningElement = from;

            while (leftIndex <= rightIndex) {

                while (array[0][beginningElement] > array[0][leftIndex]) leftIndex++;

                while (array[0][beginningElement] < array[0][rightIndex]) rightIndex--;

                if (leftIndex <= rightIndex) {
                    swapRowsRealization(array,leftIndex,rightIndex);


                    leftIndex++;
                    rightIndex--;

                }

            }
            int dividingIndex = leftIndex;

            sortingColumns(array,minArr, from, dividingIndex - 1);
            sortingColumns(array,minArr, dividingIndex, to);
        }
    }

    private static void quickSortRealization(int[] arr, int from, int to) {

        if (from < to) {
            int dividingIndex = division(arr, from, to);

            quickSortRealization(arr, from, dividingIndex - 1);
            quickSortRealization(arr, dividingIndex, to);
        }
    }

    private static int division(int[] arr, int from, int to) {

        int leftIndex = from;
        int rightIndex = to;

        int beginningElement = from;

        while (leftIndex <= rightIndex) {

            while (arr[beginningElement] > arr[leftIndex]) leftIndex++;

            while (arr[beginningElement] < arr[rightIndex]) rightIndex--;

            if (leftIndex <= rightIndex) {
                int temp = arr[leftIndex];
                arr[leftIndex] = arr[rightIndex];
                arr[rightIndex] = temp;

                leftIndex++;
                rightIndex--;

            }

        }

        return leftIndex;
    }
}
