import java.util.Arrays;
import java.util.Iterator;

public class AnalogArrayList<T> {
    private final int DEFAULT_CAPACITY = 16; // початковий розмір масиву
    private final int REDUCTION_SIZE = 4; // розмір масиву для зменшення
    private Object[] arrayObjects = new Object[DEFAULT_CAPACITY]; // масив зі стартовим розміром
    private int pointer = 0; // вказівник на межу масиву

    public boolean add(T elementOfArray) { // додавання елемента в масив
        if (pointer == arrayObjects.length - 1) { // якщо досягли межі масиву, то
            Object[] newSizeArrayObjects = new Object[arrayObjects.length * 2]; // збільшуємо розмір масиву вдвічі
            System.arraycopy(arrayObjects, 0, newSizeArrayObjects, 0, pointer); // здійснюємо копіювання
            // заповненого масиву в новий збільшений масив
            arrayObjects = newSizeArrayObjects; // замінюємо посилання на масиви
        }
        arrayObjects[pointer] = elementOfArray; // останньому елементу присвоюємо значення доданого елемента
        pointer++; // інкрементуємо вказівник межі масиву
        return true;
    }

    public boolean remove(int index) { // видалення елемента масиву за індексом
        for (int i = index; i < pointer; i++) { // циклом від вказаного індексу до межі масиву
            arrayObjects[i] = arrayObjects[i + 1]; // всі елементи справа від видаленого переміщуємо вліво
        }
        arrayObjects[pointer] = null; // останньому елементу присвоюємо значення null
        pointer--; // декрементуємо вказівник межі масиву

        if (arrayObjects.length > DEFAULT_CAPACITY && pointer < arrayObjects.length / REDUCTION_SIZE) { // якщо елементів
            // у масиві менше, ніж його довжина в REDUCTION_SIZE разів, то зменшуємо масив удвічі (для економії пам'яті).
            Object[] newSizeArrayObjects = new Object[arrayObjects.length / 2]; // зменшуємо розмір масиву удвічі
            System.arraycopy(arrayObjects, 0, newSizeArrayObjects, 0, pointer); // здійснюємо копіювання
            // заповненого масиву в новий зменшений масив
            arrayObjects = newSizeArrayObjects; // замінюємо посилання на масиви
        }
        return true;
    }

    public int size() { // метод повернення розміру масиву
        return pointer; // розмір дорівнює вказівнику межі масиву
    }

    public T get(int index) { // повернення елемента масиву за індексом
        T obj = null; // оголошуємо посилання типу класу T
        if (index > pointer || index < 0) { // якщо вказаний індекс більше межі масиву або від'ємний, то
            obj = (T) new String("IndexOutOfBoundsException"); // посиланню obj присвоюємо значення рядкового літерала
        } else { // інакше
            obj = (T) arrayObjects[index]; // посиланню obj присвоюємо значення об'єкта масиву за цим індексом
        }
        return (T) obj; // повертаємо вміст посилальної змінної (приведення типу до Generics для елемента масиву за індексом)
    }

    public void print() { // метод для виведення масиву на консоль
        Iterator<Object> iterator = Arrays.stream(arrayObjects).iterator(); // отримуємо ітератор для масиву
        while (iterator.hasNext()) { // перевіряємо, чи є ще елементи в масиві
            var object = iterator.next(); // отримуємо поточний елемент і переходимо до наступного
            if (object != null)
                System.out.println(object); // перевіряємо, чи елемент не null - друкуємо цей елемент
        }
    }

    public void print2() { // другий метод для виведення вмісту масиву на консоль
        for (int i = 0; i < arrayObjects.length; i++) { // циклом проходимо по масиву arrayObjects
            if (arrayObjects[i] != null) { // якщо елемент масиву не дорівнює null, то
                System.out.println(arrayObjects[i]); // друкуємо цей елемент
            }
        }
        System.out.println(); // роздільник - новий рядок
    }

    public boolean contains(T elementOfArray) { // метод для перевірки наявності об'єктів у масиві
        for (Object element : arrayObjects) { // циклом for-each (для кожного елемента в масиві) проходимо по масиву
            if (element.equals(elementOfArray)) { // якщо елемент масиву дорівнює порівнюваному елементу, то
                return true;
            }
        }
        return false;
    }
}
