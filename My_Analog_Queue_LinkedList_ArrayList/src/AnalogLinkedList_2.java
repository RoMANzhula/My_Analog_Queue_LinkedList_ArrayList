public class AnalogLinkedList_2<T> {
    private int size; // оголошуємо приховане поле класу типу int - буфер для зберігання даних, що інформує про розмір двозв'язного списку (ініціалізація за замовчуванням = 0) із відповідною назвою
    private Node<T> firstNode; // оголошуємо приховане поле класу типу класу Node<Generics> - першийВузол (ініціалізація за замовчуванням = null)
    private Node<T> lastNode; // оголошуємо приховане поле класу типу класу Node<Generics> - останнійВузол (ініціалізація за замовчуванням = null)

    private static class Node<T> { // створюємо клас об'єктів Вузол для нашого двозв'язного списку
        Node<T> previous; // посилання на попередній вузол
        T elementData; // дані елемента, що зберігаються у вузлі
        Node<T> next; // посилання на наступний вузол

        public Node(Node<T> previous, T elementData, Node<T> next) { // конструктор ініціалізації вузлів
            this.previous = previous; // ініціалізуємо поле класу
            this.elementData = elementData; // ініціалізуємо поле класу
            this.next = next; // ініціалізуємо поле класу
        }
    }

    private void checkElementIndex(int index) { // метод для перевірки коректності індексу елемента списку
        if (!isElementIndex(index)) { // якщо індекс поза межами допустимого, то
            throw new IndexOutOfBoundsException("Index: " + index + "; Size: " + this.size); // кидаємо нове виключення класу "Вихід за межі індексу" (із коментарем)
        }
    }

    private boolean isElementIndex(int index) { // прапорець для перевірки коректності індексу елемента списку
        return index >= 0 && index < size; // повертає true, якщо умова виконується
    }

    private Node<T> nodeSearch(int index) { // пошук вузла за індексом
        checkElementIndex(index); // перевіряємо коректність індексу (щоб не виходив за межі)

        // щоб не проходити весь список від початку до кінця, використовуємо двійковий пошук із допомогою "побітового зсуву вправо"
        if (index < (size >> 1)) { // знаходимо першу половину з початку списку (ліва сторона)
            Node<T> nodeSearchElement = this.firstNode; // створюємо посилання типу класу Вузол на перший вузол у списку
            for (int i = 0; i < index; i++) { // проходимо по цій половині списку за зростанням
                nodeSearchElement = nodeSearchElement.next; // присвоюємо посиланню на перший вузол посилання на наступний вузол
            }
            return nodeSearchElement; // повертаємо знайдений вузол за індексом
        } else { // знаходимо другу половину з кінця списку (права сторона)
            Node<T> nodeSearchElement = this.lastNode; // створюємо посилання типу класу Вузол на останній вузол у списку
            for (int i = size - 1; i > index; i--) { // проходимо по цій половині за спаданням
                nodeSearchElement = nodeSearchElement.previous; // присвоюємо посиланню на останній вузол посилання на попередній вузол
            }
            return nodeSearchElement; // повертаємо знайдений вузол за індексом
        }
    }

    public T get(int index) {
        return this.nodeSearch(index).elementData; // знаходимо вузол за індексом і повертаємо дані цього вузла
    }

    public void addFirst(T object) {
        Node<T> nodeBuffer = new Node<>(null, object, null); // створили новий об'єкт Вузол для зберігання даних елемента (із нульовими посиланнями на попередній і наступний вузли)
        if (this.size == 0) { // додаємо перший вузол у порожній список
            this.firstNode = nodeBuffer;
            this.lastNode = nodeBuffer;
            size++; // змінюємо розмір списку з 0 на 1
        } else { // додаємо новий елемент на початок непорожнього списку
            this.firstNode.previous = nodeBuffer; // посиланню першого вузла на попередній вузол присвоюємо значення нового вузла
            nodeBuffer.next = this.firstNode; // посиланню нового вузла на наступний вузол присвоюємо значення вузла, що раніше був першим
            this.firstNode = nodeBuffer; // тепер новий вузол стає першим
            size++; // збільшуємо розмір списку на 1
        }
    }

    public void addLast(T object) {
        Node<T> nodeBuffer = new Node<>(null, object, null); // створили новий об'єкт Вузол для зберігання даних елемента
        if (this.size == 0) { // якщо розмір двозв'язного списку дорівнює 0
            this.addFirst(object); // викликаємо метод додавання першого елемента
        } else {
            this.lastNode.next = nodeBuffer; // посиланню останнього вузла на наступний вузол присвоюємо значення нового вузла
            nodeBuffer.previous = this.lastNode; // посиланню нового вузла на попередній вузол присвоюємо значення останнього вузла
            this.lastNode = nodeBuffer; // тепер новий вузол стає останнім
            size++; // збільшуємо розмір списку на 1
        }
    }

    public boolean add(T object) { // метод додавання елемента у двозв'язний список
        this.addLast(object); // нові елементи завжди додаються в кінець списку
        return true; // повертаємо true
    }

    public void removeFirst() { // метод видалення першого вузла списку
        Node<T> deleteFirstNode = this.firstNode; // створюємо об'єкт вузла, що вказує на перший вузол
        this.firstNode = deleteFirstNode.next; // перший вузол тепер вказує на наступний вузол
        this.firstNode.previous = null; // попереднє значення першого вузла встановлюємо у null
        deleteFirstNode.next = null; // посилання видаленого вузла на наступний встановлюємо у null
        deleteFirstNode.elementData = null; // дані видаленого вузла встановлюємо у null
        size--; // зменшуємо розмір списку на 1
    }

    public void removeLast() { // метод видалення останнього вузла списку
        Node<T> deleteLastNode = this.lastNode; // створюємо об'єкт вузла, що вказує на останній вузол
        this.lastNode = deleteLastNode.previous; // останній вузол тепер вказує на попередній вузол
        this.lastNode.next = null; // наступне значення останнього вузла встановлюємо у null
        deleteLastNode.previous = null; // посилання видаленого вузла на попередній вузол встановлюємо у null
        deleteLastNode.elementData = null; // дані видаленого вузла встановлюємо у null
        size--; // зменшуємо розмір списку на 1
    }

    public void remove(int index){ //метод для видалення елемента з двозв'язного списку за індексом елемента
    checkElementIndex(index); //перевіряємо правильність індексу (щоб не виходив за межі)

    if (index == 0) { //якщо вузол під індексом 0
        this.removeFirst(); //викликаємо метод для видалення першого елемента
    } else if (index == (this.size - 1)) { //або якщо вузол останній у списку
        this.removeLast(); //викликаємо метод для видалення останнього елемента
    } else { //інакше
        Node<T> deleteNode = this.nodeSearch(index); //створюємо об'єкт вузла = вузол за потрібним індексом
        deleteNode.previous.next = deleteNode.next; //знаходимо попередника, який вказує на наступника
        deleteNode.next.previous = deleteNode.previous; //знаходимо наступника, який вказує на попередника
        deleteNode.previous = null; //обнуляємо посилання видаленого вузла на попередній вузол
        deleteNode.elementData = null; //обнуляємо дані видаленого вузла
        deleteNode.next = null; //обнуляємо посилання видаленого вузла на наступний вузол
        this.size--; //зменшуємо розмір списку на 1
    }
}

public void print() { //метод для друку вмісту двозв'язного списку
    for (int i = 0; i < size; i++) { //проходимо циклом по списку
        System.out.println(this.get(i)); //виводимо на друк кожен елемент списку за допомогою методу get()
    }
}

public boolean contains(T element) { //метод для перевірки, чи міститься елемент у списку
    for (int i = 0; i < size; i++) { //проходимо циклом по списку
        if (get(i).equals(element)) { //якщо отриманий елемент дорівнює шуканому
            return true; //повертаємо true
        }
    }
    return false; //інакше повертаємо false
}
