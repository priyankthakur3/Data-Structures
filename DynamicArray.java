
@SuppressWarnings("unchecked")

public class DynamicArray<T> {
    private T[] arr;
    private int lenArr = 0; // length of array
    private int capArr = 0; // capacity of array

    // initialize default array to size of 10 if no length is specified
    public DynamicArray() {
        capArr = 10;
        arr = (T[]) new Object[capArr];
    }

    // initialize Array with User defined Capacity
    public DynamicArray(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Uneven Capacity" + capacity);
        this.capArr = capacity;
        arr = (T[]) new Object[capArr];
    }

    // method to check array length

    public int arrLength() {
        return lenArr;
    }

    // check if array is empty
    public boolean isEmpty() {
        return arrLength() == 0;
    }

    // purge array method
    public void arrClear() {
        arr = null;
    }

    // return index of element
    public int indexElement(Object elm) {
        for (int i = 0; i < lenArr; i++) {
            if (elm == null) {
                if (arr[i] == null)
                    return i;
            } else {
                if (elm.equals(arr[i]))
                    return i;
            }
        }
        return -1;
    }

    // set element at particular index
    public void setElement(int index, T arrElement) {
        if (index > lenArr)
            throw new IndexOutOfBoundsException();
        arr[index] = arrElement;
    }

    public void addElement(T element) {
        // check if length of array is less than capacity
        // if less then increase length
        if (lenArr > capArr) {
            capArr = (capArr + 1) * 2; // double capacity of array

            T new_arr[] = (T[]) new Object[capArr];
            for (int i = 0; i < lenArr; i++)
                new_arr[i] = arr[i];
            arr = new_arr;
        }

        // append new element

        arr[lenArr++] = element;
    }

    @Override
    public String toString() {
        String temp = "";
        if (lenArr == 0)
            return "[]";
        else {
            temp = temp + "[";
            for (int i = 0; i < lenArr; i++) {
                System.out.println(arr[i]);
            }
        }
        temp = temp + "]";
        return temp;
    }

}