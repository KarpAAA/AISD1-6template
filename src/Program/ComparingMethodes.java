package Program;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ComparingMethodes {

    static int[] sizes = {1024,4096,16384, 65536,262144,1048576,4194304};

    private static class Timings{
        long[] bubble = new long[sizes.length];
        long[] shell = new long[sizes.length];
        long[] chosing = new long[sizes.length];
        long[] counting = new long[sizes.length];
        long[] quick = new long[sizes.length];
        long[] merge = new long[sizes.length];
    }


    public static void hugeComparing(){

        Timings timings = new Timings();
        int index = 0;
        Random random = new Random();
        ArrayList<ArrayList<Integer>> array = new ArrayList<>();
        for(int i=0;i<6;++i){
            array.add( new ArrayList<Integer>());
        }

        for (int i = 0; i < 1024; ++i) {
            int nextRandomed = random.nextInt(1024);
            for(int j=0;j<6;++j){
                array.get(j).add(nextRandomed);
            }
        }

        try {
            timings.bubble[index] = System.nanoTime();
            SortingClass.sortBubble(array.get(0), SortingClass.SortingFacilities.ASCENDING, SortingClass.PrintFile.NO);
            timings.bubble[index] = System.nanoTime() - timings.bubble[index];

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try(FileWriter file = new FileWriter("MakingSomeTests.txt")) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
