public class AnalogQueue {
    private int queueLength = 3; //створили змінну для встановлення розміру Черги (для нашого випадку)
    private int[] queueElements = new int[queueLength]; //створюємо масив типу int - імітація нашої Черги
    int firstElement = -1; //встановлюємо початковий індекс для переднього елемента Черги = -1
    int lastElement = -1; //встановлюємо початковий індекс для заднього елемента Черги = -1

    public boolean isQueueFull() { //метод перевірки - повна черга чи ні
        if (lastElement == queueLength - 1) { //якщо індекс останнього елемента = кількості місць у черзі, то
            return true; //повернути істину
        } else { //інакше
            return false; //повернути хибу
        }
    }

    public boolean isQueueEmpty() { //метод перевірки - порожня черга чи ні
        if (firstElement == -1 && lastElement == -1) { //якщо індекси переднього та заднього елементів не змінені, то
            return true; //повернути істину
        } else { //інакше
            return false; //повернути хибу
        }
    }

    public void inQueue(int queueElementValue) { //метод додавання значення в кінець Черги
        if (isQueueFull()) { //якщо черга заповнена
            System.out.println("Наша черга заповнена!"); //друкуємо текстове повідомлення
        } else if (firstElement == -1 && lastElement == -1) { //інакше, якщо передній та задній елементи не змінені, то
            lastElement = 0; //задньому елементу присвоюємо індекс 0
            firstElement = 0; //передньому елементу присвоюємо індекс 0
            queueElements[lastElement] = queueElementValue; //черзі [задньому елементу] присвоюємо значення-параметр 
        } else { //інакше
            lastElement++; //збільшуємо індекс заднього елемента на 1
            queueElements[lastElement] = queueElementValue;  //черзі [задньому елементу] присвоюємо значення-параметр 
        }
    }

    public boolean add(int object) { //метод додавання елемента в Чергу
        this.inQueue(object); //викликаємо метод inQueue()
        return true; //повертаємо істину
    }

    public void fromQueue() { //метод для видалення елемента з Черги (завжди передній елемент)
        if (isQueueEmpty()) { //якщо Черга порожня, то
            System.out.println("Наша черга порожня!"); //друкуємо текстове повідомлення
        } else if (firstElement == lastElement) { //інакше, якщо індекси переднього та заднього елементів рівні, то
            firstElement = -1; //передньому елементу встановлюємо початкове значення індексу
            lastElement = -1; //задньому елементу встановлюємо початкове значення індексу
        } else { //інакше
            firstElement++; //збільшуємо індекс переднього елемента на 1
        }
    }

    public boolean remove() { //метод видалення елемента з Черги (завжди видаляється передній елемент)
        this.fromQueue(); //викликаємо метод fromQueue()
        return true; //повертаємо істину
    }

    public void print() { //метод виведення у консоль списку елементів нашої Черги
        if (isQueueEmpty()) { //якщо Черга порожня, то
            System.out.println("Наша черга порожня!"); //друкуємо текстове повідомлення
        } else { //інакше
            for (int i = firstElement; i <= lastElement ; i++) { //циклом проходимо від переднього елемента до заднього
                System.out.println(queueElements[i]); //виводимо на екран кожен елемент Черги за відповідним індексом
            }
        }
    }

    public void printFirstElementInQueue() { //метод виведення у консоль переднього елемента Черги
        System.out.println("Перший елемент у Черзі: " + queueElements[firstElement]);
    }

    public void printLastElementInQueue() { //метод виведення у консоль заднього елемента Черги
        System.out.println("Останній елемент у Черзі: " + queueElements[lastElement]);
    }
}
