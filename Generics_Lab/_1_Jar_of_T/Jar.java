package Generics_Lab._1_Jar_of_T;

import java.util.ArrayDeque;

public class Jar <T>{

    private ArrayDeque<T> jarStack;

    public Jar () {
        this.jarStack = new ArrayDeque<>();
    }

    public void add (T element) {
        jarStack.push(element);
    }

    public T remove () {
        if (!jarStack.isEmpty()) {
            return jarStack.pop();
        }
        return null;
    }

    public ArrayDeque<T> getJarStack() {
        return jarStack;
    }

}
