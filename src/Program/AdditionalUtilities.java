package Program;


public class AdditionalUtilities {

    public static String showOneArray(int[] arr) {
        StringBuilder sRes = new StringBuilder();
        sRes.append("[");
        for (int i = 0; i < arr.length; ++i) {
            sRes.append(" " + arr[i]);
        }
        sRes.append("]\n");
        return sRes.toString();
    }

}
