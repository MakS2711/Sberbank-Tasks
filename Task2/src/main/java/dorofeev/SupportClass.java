package dorofeev;

enum ModeSearch {
    linear,
    binary,
    jump
}

public final class SupportClass {
    private SupportClass() {
    }

    public static void initializingArray(int[] currentArray) {
        final int LEFT_BORDER = 0;
        final int RIGHT_BORDER = 1000;

        for (int i = 0; i < currentArray.length; i++) {
            currentArray[i] = LEFT_BORDER + (int) (Math.random() * RIGHT_BORDER);
        }
    }

    /**
     * @param currentModeSearch Метод поиска (linear, binary, jump)
     * @param currentArray      Текущий массив
     * @param desiredNumber     Искомое значение
     */
    public static void timerWithSearch(ModeSearch currentModeSearch, int[] currentArray, int desiredNumber) {
        TypeSearch typeSearch;
        long start = System.currentTimeMillis();

        typeSearch = switch (currentModeSearch) {
            case linear -> new LinearSearch();
            case binary -> new BinarySearch();
            case jump -> new JumpSearch();
            default -> throw new IllegalArgumentException("The passed mode is not supported.");
        };

        System.out.println("The desired number " + desiredNumber + " located by index: "
                + typeSearch.search(currentArray, desiredNumber));

        long finish = System.currentTimeMillis();
        System.out.println("Time has passed, ms: " + (finish - start));
    }
}


