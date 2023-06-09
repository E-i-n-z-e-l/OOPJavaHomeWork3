/*
Класс Node
 */

public class Node<T> {
/*
 <T> - обобщенный (generic) класс, который может работать с любым типом данных.
 При создании объекта класса Node<T>, нужно указать конкретный тип данных,
 который будет использоваться в качестве параметра T.
*/
    T data; //  Это переменная типа T, которая будет хранить данные в узле.
    Node<T> next; // это ссылка на следующий узел в списке, который также является экземпляром класса Node с параметром типа T.
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
/*
Выше определяются поля класса Node. В конструкторе создается новый узел с данными типа T,
которые передаются в параметре data и ссылкой на следующий узел, которая устанавливается в null.
 */
}
