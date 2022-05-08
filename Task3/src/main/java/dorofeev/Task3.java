package dorofeev;



public class Task3 {
    public static void main(String[] args) {
        Vector vector = new Vector(1, 2, 3);
        System.out.println("Длина вектора: " + vector.getLengthVector() + "\n");
        System.out.println("Скалярное произведение вектора: " + vector.getScalarProduct(1, 2, 3)+ "\n");
        System.out.println("Угол между векторами: " + vector.getAngleBetweenVector(new Vector(1, 2, 3))+ "\n");
        System.out.println("Сумма векторов:\n" + vector.getSum(new Vector(1, 2, 3))+ "\n");
        System.out.println("Разность векторов:\n" + vector.getDifference(new Vector(1, 2, 3))+ "\n");

        int count = 4;
        Vector[] tempArrayVector = Vector.getRandomArrayVector(count, 0, 10);
        System.out.println("Вывод " + count + " случайных векторов: ");
        for (int i = 0; i < tempArrayVector.length; i++) {
            System.out.println(tempArrayVector[i] + "\n");
        }
    }
}
