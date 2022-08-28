package Program;

import java.io.IOException;
import java.util.ArrayList;

public interface Task {
    void variantTask();
    void sorting(ArrayList<Integer> list,SortingClass.SortingFacilities method, SortingClass.PrintFile printNecessary) throws IOException;
    void timeMeasuring();
}
