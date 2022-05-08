package dorofeev;

import java.util.Arrays;

public class BinarySearch implements TypeSearch {
    @Override
    public int search(int[] currentArray, int desiredNumber) {
        int[] tempArrays = Arrays.copyOf(currentArray, currentArray.length);
        Arrays.sort(tempArrays);
        int low = 0;
        int high = tempArrays.length - 1;
        while (high >= low) {
            int mid = (high + low) / 2;
            if (desiredNumber < tempArrays[mid])
                high = mid - 1;
            else if (desiredNumber == tempArrays[mid]) {
                return mid;
            } else
                low = mid + 1;
        }
        return -1;
    }
}