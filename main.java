class myclass {
    public static void main(String[] args) {
        DynamicArray<Integer> ar = new DynamicArray<>(10);

        ar.addElement(1);
        ar.addElement(12);
        System.out.println(ar);

        System.out.println(ar.indexElement(12));

    }
}