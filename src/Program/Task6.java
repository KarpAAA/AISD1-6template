package Program;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Task6 implements Task{
    @Override
    public void variantTask(ArrayList<Integer> arrayList) {



        try {
            FileWriter file = new FileWriter("Task.txt");
            //Printing start array
            file.append("Start array\n[");
            for (int i = 0; i < arrayList.size(); ++i) {
                file.append(" " + arrayList.get(i));
            }
            file.append("]");

            //MakingTask

            for (int i = 0; i < arrayList.size(); ++i) {
                if(arrayList.get(i)<0) arrayList.set(i,(int) Math.sin(arrayList.get(i)));
            }

            //Printing array
            file.append("\n\n\nTask completed\n[");
            for (int i = 0; i < arrayList.size(); ++i) {
                file.append(" " + arrayList.get(i));
            }
            file.append("]");
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sorting(ArrayList<Integer> list, SortingClass.SortingFacilities method, SortingClass.PrintFile printNecessary) throws IOException {
        SortingClass.sortShell(list, method, printNecessary);
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

            for(int k=0;k<array.length;++k) {
                int N = array[k].length;
                boolean ifSwapWas = false;
                for (int h = N / 2; h >= 1; h /= 2) {
                    for (int i = 0; i < N; ++i) {
                        if (N > i + h) {
                            if (array[k][i] > array[k][i + h]) {
                                int temp = array[k][i];
                                array[k][i] =  array[k][i+h];
                                array[k][i+h] = temp;
                                ifSwapWas = true;
                            }
                        }

                        if (ifSwapWas) {
                            for (int j = i; j >= 0; --j) {
                                if (j - h < 0) break;
                                else {
                                    if (array[k][j] < array[k][j - h]) {
                                        int temp = array[k][j];
                                        array[k][j] = array[k][j - h];
                                        array[k][j - h] = temp;
                                    }
                                }
                            }
                            ifSwapWas = false;
                        }
                    }

                }
                file.append(Arrays.toString(array[k])+"\n");
            }

            long timeSpent = System.nanoTime() - timeStart;
            file.append("\n\n\n\n" + timeSpent / (1e+9) + "\n\n\n\n");
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
