public class SinglyLinkedList<E> {
    // Элемент списка (узел)
    private static class Node<E> {
        E data;      // Значение узла
        Node<E> next; // Следующий узел

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    // Головной узел списка
    private Node<E> head;

    // Размер списка
    private int size;

    // Добавление элемента в начало списка
    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // Добавление элемента в конец списка
    public void addLast(E element) {
        Node<E> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    // Получение элемента по индексу
    public E get(int index) {
        checkIndex(index);
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // Проверка индекса на валидность
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index!");
        }
    }

    // Удаление элемента по индексу
    public E remove(int index) {
        checkIndex(index);
        if (index == 0) {
            E removedItem = head.data;
            head = head.next;
            size--;
            return removedItem;
        }
        Node<E> prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        E removedItem = prev.next.data;
        prev.next = prev.next.next;
        size--;
        return removedItem;
    }

    // Возвращает размер списка
    public int size() {
        return size;
    }

    // Проверка пустоты списка
    public boolean isEmpty() {
        return size == 0;
    }

    // Преобразует список в строку
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;
        while (current != null) {
            result.append(current.data);
            if (current.next != null) {
                result.append(", ");
            }
            current = current.next;
        }
        result.append("]");
        return result.toString();
    }

    // Точка входа
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);

        System.out.println(list); // Output: [5, 10, 20, 30]
        System.out.println("Размер списка: " + list.size()); // Output: 4

        Integer secondElement = list.get(1);
        System.out.println("Второй элемент: " + secondElement); // Output: 10

        list.remove(1);
        System.out.println(list); // Output: [5, 20, 30]
    }
}