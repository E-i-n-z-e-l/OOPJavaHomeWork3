public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("Один");
        list.add("Два");
        list.add("Три");
        list.add("Четыре");
        list.add("Пять");
        list.add("Шесть");
        list.add("Семь");
        list.add("Восемь");
        list.add("Девять");

        for (String item : list) {
            System.out.println(item);
        }

        list.remove("Два");
        System.out.println("\n===========================================================================\n");
        for (String item : list) {
            System.out.println(item);
        }
    }


}
