import java.util.Arrays;
import java.util.Iterator;

public class AnalogArrayList<T> {
    private final int DEFAULT_CAPACITY = 16; //начальный размер массива
    private final int REDUCTION_SIZE = 4; //размер массива для уменьшения
    private Object[] arrayObjects = new Object[DEFAULT_CAPACITY]; //массив со стартовым размером
    private int pointer = 0; //указатель на предельную границу массива

    public boolean add(T elementOfArray) {//добавление элемента в массив
        if (pointer == arrayObjects.length - 1) { //если достигли предела границы массива, то
            Object[] newSizeArrayObjects = new Object[arrayObjects.length * 2]; //увеличиваем размер массива в два раза
            System.arraycopy(arrayObjects, 0, newSizeArrayObjects, 0, pointer);//осуществляем копирование
            //заполненного массива в новый увеличенный массив
            arrayObjects = newSizeArrayObjects; //подменяем ссылки на массивы
        }
        arrayObjects[pointer] = elementOfArray;//крайнему элементу присваиваем значение добавленного элемента
        pointer++;//инкрементируем указатель предельной границы массива
        return true;
    }

    public boolean remove(int index) { //удаление элемента массива по индексу
        for (int i = index; i < pointer; i++) { //циклом от указанного индекса до указателя предельной границы массива
            arrayObjects[i] = arrayObjects[i + 1];//все элементы справа от удаляемого перемещаем в левую сторону
        }
        arrayObjects[pointer] = null;//последнему элементу присваиваем значение null
        pointer--;//декрементируем указатель предельной границы массива

        if (arrayObjects.length > DEFAULT_CAPACITY && pointer < arrayObjects.length / REDUCTION_SIZE) { //если элементов
            //в массиве меньше, чем его длина в REDUCTION_SIZE раз, то уменьшаем массив в 2 раза (для экономии памяти). Но
            //уменьшение массива до номинального размера.
            Object[] newSizeArrayObjects = new Object[arrayObjects.length / 2]; //уменьшаем размер массива в два раза
            System.arraycopy(arrayObjects, 0, newSizeArrayObjects, 0, pointer);//осуществляем копирование
            //заполненного массива в новый уменьшенный массив
            arrayObjects = newSizeArrayObjects; //подменяем ссылки на массивы
        }
        return true;
    }

    public int size() {//метод возврата размера массива
        return pointer;//размер равен предельному указателю предельной границы массива
    }

    public T get(int index) { //возвращаем элемент из массива по индексу
        T obj = null;//обьявляем ссылку типа класса Т
        if (index > pointer || index < 0) {//если указанный индекс элемента будет больше предельной границы массива или иметь
            //отрицательное значение, то
            obj = (T) new String("IndexOutOfBoundsException");//ссылке obj присваиваем значение = строковому литералу
        } else {//иначе
            obj = (T) arrayObjects[index];//ссылке obj присваиваем значение = обьекту массива под данным индексом
        }
        return (T) obj;//возвращаем содержимое ссыл.переменной (приведение типа к Generics для элемента массива по индексу)

    }

    public void print() {//метод для вывода на консоль массива
        Iterator<Object> iterator = Arrays.stream(arrayObjects).iterator();//получаем итератор для массива
        while (iterator.hasNext()) {//проверяем есть ли еще элементы в массиве
            var object = iterator.next();//получаем текущий элемент и переходим на следующий
            if (object != null)
                System.out.println(object);//проверяем чтобы элемент не был null - печатаем данный элемент
        }
    }

    public void print2() {//второй метод для вывода на консоль содержимого массива
        for (int i = 0; i < arrayObjects.length; i++) {//циклом проходим по массиву arrayObjects
            if (arrayObjects[i] != null) {//если элемент массива не равен null, то
                System.out.println(arrayObjects[i]);//печатаем данный элемент
            }
        }
        System.out.println();//разделитель - новая строка
    }

    public boolean contains(T elementOfArray) {//метод для сравнения обьектов в массиве
        for (Object element : arrayObjects) {//циклом for-each (для каждого элемента из массива) проходим по массиву
            if (element.equals(elementOfArray)) {//если элемент массива будет равен сравниваемому элементу, то
                return true;
            }
        }
        return false;
    }
}
