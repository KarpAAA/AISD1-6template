package Program;

import java.io.FileWriter;
import java.io.IOException;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Task9 implements Task{
    @Override
    public void variantTask(ArrayList<Integer> arrayList) {
        //Задано одномірний масив дійсних чисел.
        //Впорядкувати елементи, розташовані між першим і останнім від'ємним елементом по зростанню.


        Random random = new Random();
        ArrayList<Integer> arrTask = new ArrayList<>();
        for (int i = 0; i < 1000; ++i) {
            arrTask.add(random.nextInt(10000 + 10000) - 10000);
        }

        int indexOfFirst = arrTask.indexOf(arrTask.stream().filter( value -> value<0).findFirst().get());
        Collections.reverse(arrTask);
        int number = arrTask.stream().filter( value -> value<0).findFirst().get();
        Collections.reverse(arrTask);
        int indexOfLast = arrTask.indexOf(number);

        ArrayList<Integer> arrTaskCopy = new ArrayList<>();
        for(int i= indexOfFirst;i<indexOfLast;++i){
           arrTaskCopy.add(arrTask.get(i));
        }

        SortingClass.countingSort(arrTaskCopy,
                arrTaskCopy.stream().min(Comparator.naturalOrder()).get(),
                arrTaskCopy.stream().max(Comparator.naturalOrder()).get());

        try( FileWriter file = new FileWriter("Task.txt")) {
           file.append(arrTaskCopy.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void sorting(ArrayList<Integer> arrayList, SortingClass.SortingFacilities method, SortingClass.PrintFile printNecessary) throws IOException {
        var min = arrayList.stream().min(Comparator.naturalOrder());
        var max = arrayList.stream().max(Comparator.naturalOrder());
        if( min.isEmpty() || max.isEmpty()) return;




        SortingClass.countingSort(arrayList,min.get(),max.get());
    }

    @Override
    public void timeMeasuring() {
        try {
            FileWriter file = new FileWriter("Experiment1000.txt");

            Random random = new Random();
            ArrayList<Integer> arrList = new ArrayList<>();
            for (int i = 0; i < 1000; ++i) {
                arrList.add(random.nextInt(10000));
            }

            long timeStart = System.nanoTime();

            for (int i = 0; i < arrList.size(); ++i) {
                SortingClass.countingSort(arrList,
                        arrList.stream().min(Comparator.naturalOrder()).get(),
                        arrList.stream().max(Comparator.naturalOrder()).get());
            }

            for (int i = 0; i < 1000; ++i) {
                file.append(arrList.get(i).toString()).append("\t");
                if (i % 50 == 0 && i != 0) file.append("\n");
            }


            long timeSpent = System.nanoTime() - timeStart;
            file.append("\n\n\n\n" + timeSpent / (1e+9) + "\n\n\n\n");
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
