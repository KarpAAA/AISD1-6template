package Program;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class SortingClass {

    public static void sortAscending(ArrayList<Integer> array){

        boolean flagStop = false;
        while(!flagStop){
            flagStop = true;
            for(int i=0;i < array.size()-1;++i){
                if(array.get(i)>array.get(i+1)){
                    int temp = array.get(i);
                    array.set(i,array.get(i+1));
                    array.set(i+1,temp);
                    flagStop = false;
                }
            }
        }

    }
    public static void sortDescending(ArrayList<Integer> array){

        boolean flagStop = false;
        while(!flagStop){
            flagStop = true;
            for(int i=0;i < array.size()-1;++i){
                if(array.get(i)<array.get(i+1)){
                    int temp = array.get(i);
                    array.set(i,array.get(i+1));
                    array.set(i+1,temp);
                    flagStop = false;
                }
            }
        }
    }

    public static void sortingArrayByStepsTest(ArrayList<Integer> array){

        try {
            FileWriter file =  new FileWriter("Experiment.txt");


            boolean flagStop = false;
            while(!flagStop){
                flagStop = true;
                for(int i=0;i < array.size()-1;++i){
                    if(array.get(i)>array.get(i+1)){
                        int temp = array.get(i);
                        array.set(i,array.get(i+1));
                        array.set(i+1,temp);
                        flagStop = false;
                    }
                }
                file.append(array.toString() + "\n");
            }
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    private static String showOneArray(int[]arr){
        StringBuilder sRes = new StringBuilder();
        sRes.append("[");
        for(int i=0;i<arr.length;++i){
            sRes.append(" " + arr[i]);
        }
        sRes.append("]\n");
        return sRes.toString();
    }

    public static void variantTask(int a,int b){
        int[][] array = new int[a][b];

        Random random = new Random();

        for(int i=0;i<array.length;++i){
            array[i] = random.ints(array[i].length, 10,1000).toArray();
        }

        try {
            FileWriter file =  new FileWriter("Task.txt");
            //Printing start matrix
            for(int i=0;i< array.length;++i){
                file.append(showOneArray(array[i]));
            }

            //Sorting
            boolean flagStop = false;
            while(!flagStop){
                flagStop = true;
                for(int i=0;i < array.length-1;++i){
                    if(array[i][0]>array[i+1][0]){
                        int[] temp = array[i];
                        array[i] = array[i+1];
                        array[i+1] = temp;
                        flagStop = false;
                    }
                }

            }

            //Printing sorted bt task matrix
            file.append("\n\n\n\n\n\nSorted\n");
            for(int i=0;i< array.length;++i){
                file.append(showOneArray(array[i]));
            }
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void measuringTime(){

        try {
            FileWriter file =  new FileWriter("Experiment1000.txt");

            Random random = new Random();
            int[][] array= new int[1000][];
            for(int i=0;i<array.length;++i){
                array[i] = random.ints(50, 10,100000).toArray();
            }
            Long timeStart = System.nanoTime();
            for(int j=0;j<array.length;++j){
                boolean flagStop = false;
                while(!flagStop){
                    flagStop = true;
                    for(int i=0;i < array[j].length-1;++i){
                        if(array[j][i]>array[j][i+1]){
                         int temp = array[j][i];
                         array[j][i] = array[j][i+1];
                         array[j][i+1] = temp;
                         flagStop = false;
                        }
                    }

                }
                file.append(showOneArray(array[j]));
            }
            Long timeSpent = System.nanoTime() - timeStart;
            file.append("\n\n\n\n" +timeSpent/(1e+9) +"\n\n\n\n");
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
