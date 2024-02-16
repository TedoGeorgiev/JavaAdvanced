package Generics_Lab._3_Generic_Scale;



public class Scale <T extends Comparable<T>> {

    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        //compareTo
        int result = left.compareTo(right);
        if (result < 0) {
            return right;
        }

        if (result > 0) {
            return left;
        }

        return null;
    }

}
