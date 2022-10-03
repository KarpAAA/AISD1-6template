package Program;

import java.io.FileWriter;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class SortingClass {

    enum SortingFacilities {
        ASCENDING, DESCENDING
    }

    enum PrintFile {
        YES, NO
    }

    public static void sortShell(ArrayList<Integer> array, SortingFacilities method, PrintFile printNecessary) throws IOException {
        FileWriter file = null;
        if (printNecessary == PrintFile.YES) {
            file = new FileWriter("StepByStepPrinting.txt");
        }
        boolean ifSwapWas = false;
        int N = array.size();

        for (int h = N / 2; h >= 1; h /= 2) {
            for (int i = 0; i < N; ++i) {
                if (N > i + h) {

                    if (method == SortingFacilities.ASCENDING) {
                        if (array.get(i) > array.get(i + h)) {
                            int temp = array.get(i);
                            array.set(i, array.get(i + h));
                            array.set(i + h, temp);
                            ifSwapWas = true;
                        }
                    } else {
                        if (array.get(i) < array.get(i + h)) {
                            int temp = array.get(i);
                            array.set(i, array.get(i + h));
                            array.set(i + h, temp);
                            ifSwapWas = true;
                        }
                    }
                }

                if (ifSwapWas) {
                    for (int j = i; j >= 0; --j) {
                        if (j - h < 0) break;
                        else {

                            if (method == SortingFacilities.ASCENDING) {
                                if (array.get(j) < array.get(j - h)) {
                                    int temp = array.get(j);
                                    array.set(j, array.get(j - h));
                                    array.set(j - h, temp);
                                }
                            } else {
                                if (array.get(j) > array.get(j - h)) {
                                    int temp = array.get(j);
                                    array.set(j, array.get(j - h));
                                    array.set(j - h, temp);
                                }
                            }
                        }
                    }
                    ifSwapWas = false;
                } else {
                    if (N <= i + h) break;
                }
                if (printNecessary == PrintFile.YES) file.append(array.toString() + "\n");
            }
        }


        if (file != null) file.close();
    }

    public static void sortBubble(ArrayList<Integer> array, SortingFacilities method, PrintFile printNecessary) throws IOException {
        FileWriter file = null;
        if (printNecessary == PrintFile.YES) {
            file = new FileWriter("StepByStepPrinting.txt");
        }
        boolean flagStop = false;
        while (!flagStop) {
            flagStop = true;
            for (int i = 0; i < array.size() - 1; ++i) {
                if (method == SortingFacilities.ASCENDING) {
                    if (array.get(i) > array.get(i + 1)) {
                        int temp = array.get(i);
                        array.set(i, array.get(i + 1));
                        array.set(i + 1, temp);
                        flagStop = false;
                    }
                } else if (method == SortingFacilities.DESCENDING) {
                    if (array.get(i) < array.get(i + 1)) {
                        int temp = array.get(i);
                        array.set(i, array.get(i + 1));
                        array.set(i + 1, temp);
                        flagStop = false;
                    }
                }

            }
            if (file != null) file.append(array.toString() + "\n");
        }
        if (file != null) file.close();

    }

    public static void sortChosing(ArrayList<Integer> list, SortingFacilities method, PrintFile printNecessary) throws IOException {
        FileWriter file = null;
        if (printNecessary == PrintFile.YES) {
            file = new FileWriter("StepByStepPrinting.txt");
        }

        for (int i = 0; i < list.size(); ++i) {
            int minMax = list.get(i);
            int minMaxIndex = i;
            for (int j = i; j < list.size(); ++j) {
                if (method == SortingClass.SortingFacilities.ASCENDING) {
                    if (minMax > list.get(j)) {
                        minMax = list.get(j);
                        minMaxIndex = j;
                    }
                } else if (method == SortingClass.SortingFacilities.DESCENDING) {
                    if (minMax < list.get(j)) {
                        minMax = list.get(j);
                        minMaxIndex = j;
                    }
                }

            }
            int temp = list.get(i);
            list.set(i, minMax);
            list.set(minMaxIndex, temp);
            if (file != null) file.append(list.toString() + "\n");
        }

        if (file != null) file.close();

    }

    public static void quickSort(ArrayList<Integer> list, SortingFacilities method, PrintFile printNecessary) throws IOException {
        FileWriter file = new FileWriter("StepByStepPrinting.txt");
        file.close();
        quickSortRealization(list, 0, list.size() - 1, printNecessary);
    }
    private static void quickSortRealization(ArrayList<Integer> list, int from, int to, PrintFile printNecessary) throws IOException {

        if (from < to) {
            int dividingIndex = division(list, from, to, printNecessary);

            quickSortRealization(list, from, dividingIndex - 1, printNecessary);
            quickSortRealization(list, dividingIndex, to, printNecessary);
        }
    }
    private static int division(ArrayList<Integer> list, int from, int to, PrintFile printNecessary) throws IOException {
        FileWriter file = null;
        if (printNecessary == PrintFile.YES) {
            file = new FileWriter("StepByStepPrinting.txt", true);
        }
        int leftIndex = from;
        int rightIndex = to;

        int beginningElement = from;

        while (leftIndex <= rightIndex) {

            while (list.get(beginningElement) > list.get(leftIndex)) leftIndex++;

            while (list.get(beginningElement) < list.get(rightIndex)) rightIndex--;

            if (leftIndex <= rightIndex) {
                int temp = list.get(leftIndex);
                list.set(leftIndex, list.get(rightIndex));
                list.set(rightIndex, temp);

                leftIndex++;
                rightIndex--;
                file.append(list.toString() + "\n");
            }

        }
        if (file != null) file.close();
        return leftIndex;
    }

    public static void mergeSort(ArrayList<Integer> array, int n) {

        if (n < 2) return;
        int middleIndex = n / 2;

        ArrayList<Integer> leftArray = new ArrayList<Integer>();
        ArrayList<Integer> rightArray = new ArrayList<Integer>();


        for (int i = 0; i < middleIndex; i++) {
            leftArray.add(array.get(i));
        }
        for (int i = middleIndex; i < n; i++) {
            rightArray.add(array.get(i));
        }

        mergeSort(leftArray, middleIndex);
        mergeSort(rightArray, n - middleIndex);

        merge(leftArray, rightArray, array, middleIndex, n - middleIndex);

    }
    private static void merge(ArrayList<Integer> leftArray, ArrayList<Integer> rightArray, ArrayList<Integer> array, int leftSize, int rightSize) {

        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (leftArray.get(i) <= rightArray.get(j)) {
                array.set(k++, leftArray.get(i++));
            } else {
                array.set(k++, rightArray.get(j++));
            }
        }
        while (i < leftSize) {
            array.set(k++, leftArray.get(i++));
        }
        while (j < rightSize) {
            array.set(k++, rightArray.get(j++));
        }

    }


    public static void countingSort(ArrayList<Integer> array, int min, int max) {


        int[] count = new int[max - min + 1];

        for (int i = 0; i < array.size(); i++) {
            count[array.get(i) - min]++;
        }
        int index = 0;

        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                array.set(index++, i + min);
            }
        }


    }

}
