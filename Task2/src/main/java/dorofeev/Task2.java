package dorofeev;

public class Task2 {
    public static void main(String[] args) {
        int[] arrayRandomNumber = new int[100000];
        SupportClass.initializingArray(arrayRandomNumber);

        SupportClass.timerWithSearch(ModeSearch.linear, arrayRandomNumber, 5);
        SupportClass.timerWithSearch(ModeSearch.binary, arrayRandomNumber, 5);
        SupportClass.timerWithSearch(ModeSearch.jump, arrayRandomNumber, 5);
    }
}
