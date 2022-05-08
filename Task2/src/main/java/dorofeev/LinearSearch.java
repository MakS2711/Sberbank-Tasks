package dorofeev;

public class LinearSearch implements TypeSearch {

    @Override
    public int search(int[] currentArray, int desiredNumber) {
        for (int i = 0; i < currentArray.length; i++) {
            if (currentArray[i] == desiredNumber)
                return i;
        }
        return -1;
    }
}
