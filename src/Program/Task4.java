package Program;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Task4 implements Task {
    @Override
    public void variantTask() {
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

            //Sorting
            boolean flagStop = false;
            while (!flagStop) {
                flagStop = true;
                for (int i = 0; i < array.length - 1; ++i) {
                    if (array[i][0] > array[i + 1][0]) {
                        int[] temp = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = temp;
                        flagStop = false;
                    }
                }

            }

            //Printing sorted bt task matrix
            file.append("\n\n\n\n\n\nSorted\n");
            for (int i = 0; i < array.length; ++i) {
                file.append(AdditionalUtilities.showOneArray(array[i]));
            }
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sorting(ArrayList<Integer> list, SortingClass.SortingFacilities method, SortingClass.PrintFile printNecessary) throws IOException {
        SortingClass.sortBubble(list, method, printNecessary);
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

            for (int j = 0; j < array.length; ++j) {
                boolean flagStop = false;
                while (!flagStop) {
                    flagStop = true;
                    for (int i = 0; i < array[j].length - 1; ++i) {
                        if (array[j][i] > array[j][i + 1]) {
                            int temp = array[j][i];
                            array[j][i] = array[j][i + 1];
                            array[j][i + 1] = temp;
                            flagStop = false;
                        }
                    }

                }
                file.append(AdditionalUtilities.showOneArray(array[j]));
            }
            long timeSpent = System.nanoTime() - timeStart;
            file.append("\n\n\n\n" + timeSpent / (1e+9) + "\n\n\n\n");
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
