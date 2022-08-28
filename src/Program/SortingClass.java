package Program;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class SortingClass {

    enum SortingFacilities {
        ASCENDING, DESCENDING
    }

    enum PrintFile {
        YES, NO
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

    public static void sortSecond(ArrayList<Integer> list, SortingFacilities method, PrintFile printNecessary) throws IOException {
        FileWriter file = null;
        if (printNecessary == PrintFile.YES) {
            file = new FileWriter("StepByStepPrinting.txt");
        }

        for(int i =0;i<list.size();++i){
            int minMax = list.get(i);
            int minMaxIndex = i;
            for(int j =i;j<list.size();++j){
                if(method == SortingClass.SortingFacilities.ASCENDING){
                    if(minMax>list.get(j)){
                        minMax = list.get(j);
                        minMaxIndex = j;
                    }
                }
                else if(method == SortingClass.SortingFacilities.DESCENDING){
                    if(minMax<list.get(j)){
                        minMax = list.get(j);
                        minMaxIndex = j;
                    }
                }

            }
            int temp = list.get(i);
            list.set(i,minMax);
            list.set(minMaxIndex,temp);
            if (file != null) file.append(list.toString() + "\n");
        }

        if (file != null) file.close();

    }




}
