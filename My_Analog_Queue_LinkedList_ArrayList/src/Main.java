public class Main {
    public static void main(String[] args) {
        System.out.println("\n" + "\t" + "\t" + "class AnalogQueue" + "\n" + "/                |                \\");
        AnalogQueue analogQueue = new AnalogQueue();
        analogQueue.add(1);
        analogQueue.add(2);
        analogQueue.add(3);
        analogQueue.add(4); //Ця операція виводить рядок, що черга заповнена, т.к. ми встановили ліміт на розмір
        // черги рівний 3 елементам
        analogQueue.print();
        analogQueue.printFirstElementInQueue();
        analogQueue.printLastElementInQueue();
        analogQueue.remove();
        System.out.println("Print after remove and add");
        analogQueue.print();

        System.out.println("\n" + "\t" + "\t" + "class AnalogLinkedList" + "\n" + "/                |                \\");
        AnalogLinkedList_2<String> analogLinkedList_2 = new AnalogLinkedList_2<>();
        analogLinkedList_2.add("I am first element of linkedList!");
        analogLinkedList_2.add("I am second element of linkedList!");
        System.out.println(analogLinkedList_2.get(0));
        analogLinkedList_2.print();
        analogLinkedList_2.remove(0);
        analogLinkedList_2.print();
        analogLinkedList_2.add("I was first element of linkedList! Now I am - second element!");
        analogLinkedList_2.print();
        System.out.println(analogLinkedList_2.get(1).contains("9"));

        System.out.println("\n" + "\t" + "\t" + "class AnalogArrayList" + "\n" + "/                |                \\");
        AnalogArrayList<String> analogArrayList1 = new AnalogArrayList<>();
        AnalogArrayList<String> analogArrayList2 = new AnalogArrayList<>();
        analogArrayList1.add("one");
        analogArrayList1.add("two");
        analogArrayList1.add("three");
        analogArrayList1.add("four");
        System.out.println("Print List1: ");
        analogArrayList1.print();
        analogArrayList1.remove(3);
        System.out.println("\n" + "Print List1 after remove element with index #3(position #4): ");
        analogArrayList1.print();
        analogArrayList2.add("one");
        analogArrayList2.add("two");
        analogArrayList2.add("one");
        System.out.println("\n" + "Print List2: ");
        analogArrayList1.print2();
        System.out.println("Size of List1 - " + analogArrayList1.size());
        System.out.println("Size of List2 - " + analogArrayList2.size());
        System.out.println("\n" + "Get element with index number 2 of List1 - " + analogArrayList1.get(2));
        System.out.println("Get element with index number 0 of List2 - " + analogArrayList2.get(0));
        System.out.println("Get element with index number 4 of List2 - " + analogArrayList1.get(4));
        System.out.println("\n" + "Contains two elements from two lists: " + analogArrayList1.get(0).contains(analogArrayList2.get(2)));
        System.out.println("Contains two elements from two lists: " + analogArrayList1.get(0).contains(analogArrayList2.get(1)));

    }
}
