package dorofeev;

public class Task8 {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] arrayString = {"Moscow", "Omsk", "Kazan", "Saint-Petersburg", "Novosibirsk", "Barnaul"};

        System.out.println("Вывод значений по условию x % 2 == 0: " + Main.filter(array, x -> (x % 2 == 0)));
        System.out.println("Вывод значений по условию x > 5: " + Main.filter(array, x -> x > 5));
        System.out.println("Вывод значений по условию x.length > 7: " + Main.filter(arrayString, x -> x.length() > 7));
    }
}
