import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {
    private Node<T> head; // переменная типа Node<T>, которая указывает на первый элемент списка (головной узел);
    private int size; //  хранит количество элементов в списке;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }
    /*
    Выше определяется конструктор класса MyLinkedList, который инициализирует поля head и size значением null и 0 соответственно.
    Таким образом, при создании нового объекта класса MyLinkedList, список будет пустым и его размер будет равен 0.
     */

    /*
    Метод "add" добавляет новый элемент в конец связанного списка.
    Создается новый узел с заданными данными, затем проверяется,
    есть ли уже элементы в списке (если head == null, значит список пустой) и, если нет, то новый узел становится
    первым элементом списка (head = newNode). Если же список не пустой, то происходит перебор элементов списка
    до тех пор, пока не будет найден последний узел (у которого значение поля next == null),
    после чего новый узел добавляется в конец списка (current.next = newNode).
    В конце метода увеличивается размер списка на 1.
     */
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
/*
Метод "remove" удаляет узел с заданными данными из связанного списка.
Если список пустой (head == null), то метод просто возвращает управление.
Если первый элемент списка содержит заданные данные (head.data.equals(data)), то он удаляется из списка (head = head.next),
размер списка уменьшается на 1 и метод завершается.
В противном случае, происходит перебор элементов списка до тех пор,
пока не будет найден узел с заданными данными (current.next.data.equals(data)),
после чего этот узел удаляется из списка (current.next = current.next.next),
размер списка уменьшается на 1 и метод завершается.
 */
    public void remove(T data) {
        if (head == null) {
            return;
        }
        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return;
        }
        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }
    }
/*
Метод "size()" возвращает размер (количество элементов) связанного списка.
Он просто возвращает значение переменной size, которая увеличивается каждый раз при добавлении
нового элемента в список и уменьшается при удалении элемента из списка.
 */
    public int size() {
        return size;
    }

    /*
    Метод iterator() интерфейса Iterable, который возвращает итератор для перебора элементов связанного списка.
    В данном случае, итератор реализуется в виде анонимного класса, который имеет доступ
    к полям класса LinkedList (head, size) и позволяет последовательно обходить элементы списка,
    начиная с его головы (head).
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;
/*
Метод "hasNext()" возвращает true, если текущий элемент не равен null, то есть следующий элемент в списке.
 */

            @Override
            public boolean hasNext() {
                return current != null;
            }
/*
Метод "next()" возвращает значение данных текущего элемента и переходит к следующему элементу списка.
 */
            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}