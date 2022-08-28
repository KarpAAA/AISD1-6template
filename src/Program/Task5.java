package Program;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Task5 implements Task{

    @Override
    public void variantTask(ArrayList<Integer> arrayList) {

        int max = arrayList.get(0);
        for (int k : arrayList) {
            if (max < k) max = k;
        }


        int[] arrMap= new int[max+1];
        for(int i=0;i < arrayList.size();++i){
            int value = arrayList.get(i);
            arrMap[value]++;
        }


        int maxPovtors = 0;
        int index = 0;
        for(int i=0;i< arrMap.length;++i){
            if(maxPovtors<arrMap[i]){
                maxPovtors = arrMap[i];
                index = i;
            }
        }

        int[] resArray = new int[arrayList.size()-maxPovtors];

        int counter = 0;
        for(int i=0;i < arrayList.size();++i){
            if(arrayList.get(i)!=index)resArray[counter++] = arrayList.get(i);
        }
        arrayList.clear();

        for(int i=0;i < resArray.length;++i){
            arrayList.add(resArray[i]);
        }


    }

    @Override
    public void sorting(ArrayList<Integer> list, SortingClass.SortingFacilities method, SortingClass.PrintFile printNecessary) throws IOException {
        SortingClass.sortSecond(list,method,printNecessary);
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
                for (int i = 0; i < array[k].length; ++i) {
                    int min =  array[k][i];
                    int minIndex = i;
                    for (int j = i; j < array[k].length; ++j) {
                            if (min > array[k][j]) {
                                min = array[k][j];
                                minIndex = j;
                            }
                    }
                    int temp = array[k][i];
                    array[k][i] = min;
                    array[k][minIndex] = temp;

                }
                file.append(AdditionalUtilities.showOneArray(array[k]));
            }

            long timeSpent = System.nanoTime() - timeStart;
            file.append("\n\n\n\n" + timeSpent / (1e+9) + "\n\n\n\n");
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
