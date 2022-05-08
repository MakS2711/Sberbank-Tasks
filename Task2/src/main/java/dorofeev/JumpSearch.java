package dorofeev;

import java.util.Arrays;

public class JumpSearch implements TypeSearch {
    @Override
    public int search(int[] currentArray, int desiredNumber) {
        int[] tempArray = Arrays.copyOf(currentArray, currentArray.length);
        Arrays.sort(tempArray);
        int blocSize = (int) Math.sqrt(tempArray.length);
        int lastIndex = blocSize - 1;
        while (lastIndex < tempArray.length && desiredNumber > tempArray[lastIndex])
            lastIndex += blocSize;

        for (int i = lastIndex - blocSize + 1; i <= lastIndex; i++) {
            if (desiredNumber == tempArray[i])
                return i;
        }
        return -1;
    }
}
