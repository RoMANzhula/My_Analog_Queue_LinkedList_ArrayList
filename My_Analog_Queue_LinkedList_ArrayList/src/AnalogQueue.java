public class AnalogQueue {
    private int queueLength = 3; //создали переменную для установки размерности Очереди (для нашего случая)
    private int[] queueElements = new int[queueLength]; //создаем массив типа int - имитация нашей Очереди
    int firstElement = -1; //устанавливаем начальный индекс для переднего элемента Очереди = -1
    int lastElement = -1; //устанавливаем начальный индекс для заднего элемента Очереди = -1

    public boolean isQueueFull() { //метод проверки - полная очередь или нет
        if (lastElement == queueLength - 1) { //если индекс последнего элемента = количеству мест в очереди, то
            return true; //вернуть истина
        } else { //иначе
            return false; //вернуть ложь
        }
    }

    public boolean isQueueEmpty() { //метод проверки - пустая очередь или нет
        if (firstElement == -1 && lastElement == -1) { //если индексы передней и задней части очереди остались без
            //изменений, то
            return true; //вернуть истина
        } else { //иначе
            return false; //вернуть ложь
        }
    }

    public void inQueue(int queueElementValue) { //метод добавления по значению в конец Очереди
        if (isQueueFull()) { //если очередь заполнена
            System.out.println("Our Queue is full!"); //печатаем строковый литерал
        } else if (firstElement == -1 && lastElement == -1) { //иначе если передний и задний элементы остались без
            // изменений, то
            lastElement = 0; //заднему элементу присваиваем индекс 0
            firstElement = 0; //переднему элементу присваиваем индекс 0
            queueElements[lastElement] = queueElementValue; //очереди [заднему элементу] присваиваем значение-параметр (как
            // потенциальный аргумент добавляемого элемента в Очередь
        } else { //иначе
            lastElement++; //увеличиваем индекс заднего элемента на 1
            queueElements[lastElement] = queueElementValue;  //очереди [заднему элементу] присваиваем значение-параметр (как
            // потенциальный аргумент добавляемого элемента в Очередь
        }
    }

    public boolean add(int object) { //метод добавления элемента в Очередь
        this.inQueue(object); //вызываем метод inQueue()
        return true; //вернуть истина
    }

    public void fromQueue() { //метод для удаления элемента из Очереди (всегда передний элемент)
        if (isQueueEmpty()) { //если Очередь пустая, то
            System.out.println("Our Queue is empty!"); //печатаем строковый литерал
        } else if (firstElement == lastElement) { //иначе если индексы переднего и заднего элементов равны, то
            firstElement = -1; //переднему элементу устанавливаем номинальное значение индекса
            lastElement = -1; //заднему элементу устанавливаем номинальное значение индекса
        } else { //иначе
            firstElement++; //индекс переднего элемента увеличиваем на 1
        }
    }

    public boolean remove() { //метод удаления элемента из очереди (всегда удаляется передний элемент)
        this.fromQueue(); //вызываем метод fromQueue()
        return true; //вернуть истина
    }

    public void print() { //метод вывода в консоль перечня элементов нашей Очереди
        if (isQueueEmpty()) { //если Очередь пустая, то
            System.out.println("Our Queue is empty!"); //печатаем строковый литерал
        } else { //иначе
            for (int i = firstElement; i <= lastElement ; i++) { //циклом проходимся от переднего элемента очереди до
                // заднего(включительно)
                System.out.println(queueElements[i]); //выводим на печать каждый элемент Очереди под соответствующим
                // индексом
            }
        }
    }

    public void printFirstElementInQueue() { //метод вывода в консоль переднего элемента Очереди
        System.out.println("First element in Queue is: " + queueElements[firstElement]);
    }

    public void printLastElementInQueue() { //метод вывода в консоль заднего элемента Очереди
        System.out.println("Last element in Queue is: " + queueElements[lastElement]);
    }
}