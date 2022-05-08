package dorofeev;

import java.util.concurrent.ThreadLocalRandom;

public final class Vector {
    private final double x;
    private final double y;
    private final double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getLengthVector() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double getLengthVector(double x, double y, double z) {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double getLengthVector(Vector vector) {
        return Math.sqrt(vector.x * vector.x + vector.y * vector.y + vector.z * vector.z);
    }

    public double getScalarProduct(double x, double y, double z) {
        return (this.x * x + this.y * y + this.z * z);
    }

    public double getScalarProduct(Vector vector) {
        return vector == null ? -1 : (vector.x * this.x + vector.y * this.y + vector.z * this.z);
    }

    public double getAngleBetweenVector(Vector vector) {
        return vector == null ? -1 : getScalarProduct(vector) / (getLengthVector() * getLengthVector(vector));
    }

    public Vector getSum(double x, double y, double z) {
        return new Vector(
                this.x + x,
                this.y + y,
                this.z + z
        );
    }

    public Vector getSum(Vector vector) {
        return new Vector(
                this.x + vector.x,
                this.y + vector.y,
                this.z + vector.z
        );
    }

    public Vector getDifference(double x, double y, double z) {
        return new Vector(
                this.x - x,
                this.y - y,
                this.z - z
        );
    }

    public Vector getDifference(Vector vector) {
        return new Vector(
                this.x - vector.x,
                this.y - vector.y,
                this.z - vector.z
        );
    }

    public static Vector[] getRandomArrayVector(int size, int leftBorder, int rightBorder) {
        Vector[] arrayVector = new Vector[size];
        for (int i = 0; i < size; i++) {
            arrayVector[i] = createRandomVector(leftBorder, rightBorder);
        }
        return arrayVector;
    }

    private static Vector createRandomVector(int leftBorder, int rightBorder) {
        return new Vector(
                ThreadLocalRandom.current().nextDouble(leftBorder, rightBorder + 1),
                ThreadLocalRandom.current().nextDouble(leftBorder, rightBorder + 1),
                ThreadLocalRandom.current().nextDouble(leftBorder, rightBorder + 1)
        );
    }

    @Override
    public String toString() {
        return "Vector coordinates:\nx = " + x + "\ny = " + y + "\nz = " + z;
    }
}
