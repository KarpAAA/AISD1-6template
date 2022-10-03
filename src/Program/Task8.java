package Program;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Task8 implements Task {

    private static class Student implements Comparable {
        String name;
        int averageMark;

        Student(String name, int averageMark) {
            this.name = name;
            this.averageMark = averageMark;
        }

        @Override
        public String toString() {
            return "\nStudent{" +
                    "name='" + name + '\'' +
                    ", averageMark=" + averageMark +
                    '}';
        }

        @Override
        public int compareTo(Object o) {
            return this.name.compareTo(((Student) o).name);
        }
    }

    ArrayList<Student> getDefaultStudentsList() {
        ArrayList<Student> studentList = new ArrayList<>();
        String[] arrayNames = {"Ivan", "Natalia", "Artem", "Volodymyr", "Yaroslav", "Mark",
                "Vasyl", "Danylo", "Max", "Mikhailo", "Khristina", "Oksana", "Olga", "Kira",
                "Anastasia", "Oleksandra", "Daria", "Tetyana", "Yana", "Nikol", "Yaryna",
                "Sophia", "Elia", "Nika", "Olena", "Solomia", "Evelina", "Nestor", "Yaromyr"};
        Random rand = new Random();
        for (int i = 0; i < 1000; ++i) {
            studentList.add(new Student(arrayNames[rand.nextInt(arrayNames.length - 1)], rand.nextInt(12)));
        }
        return studentList;
    }


    @Override
    public void variantTask(ArrayList<Integer> arrayList) {
        ArrayList<Student> studentList = getDefaultStudentsList();
        try {
            FileWriter file = new FileWriter("Task.txt");
            //Printing start array
            file.append("Starting list\n");
            studentList.stream().forEach(
                    student -> {
                        try {
                            file.append(student.toString());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );
            file.append("\n\n");

            //MakingTask
            studentList = (ArrayList<Student>) studentList.stream().filter(student -> student.averageMark > 4).collect(Collectors.toList());

            mergeSort(studentList, studentList.size());

            //Printing array

            file.append("Task DONE list\n");
            studentList.stream().forEach(
                    student -> {
                        try {
                            file.append(student.toString());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );
            file.append("\n\n");
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void sorting(ArrayList<Integer> list, SortingClass.SortingFacilities method, SortingClass.PrintFile printNecessary) throws IOException {
        SortingClass.mergeSort(list, list.size());
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
                SortingClass.mergeSort(arrList, arrList.size());
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

    public static void mergeSort(ArrayList<Student> array, int n) {

        if (n < 2) return;
        int middleIndex = n / 2;

        ArrayList<Student> leftArray = new ArrayList<Student>();
        ArrayList<Student> rightArray = new ArrayList<Student>();


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

    private static void merge(ArrayList<Student> leftArray, ArrayList<Student> rightArray, ArrayList<Student> array, int leftSize, int rightSize) {

        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            /*<=*/

            if (leftArray.get(i).compareTo(rightArray.get(j)) < 0) {
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

}

