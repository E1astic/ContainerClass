import org.example.Container;
import org.example.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContainerTest
{
    private Container<Integer> container;

    @BeforeEach
    void init()
    {
        container=new Container<>(1, 2);
    }
    @Test
    void addToHead()
    {
        Node<Integer> expected=new Node<>(0);
        expected.next=container.getHead();
        container.addToHead(0);

        Assertions.assertEquals(expected, container.getHead());
    }
    @Test
    void append()
    {
        Node<Integer> expected=new Node<>(3);
        expected.prev=container.getTail();
        container.append(3);

        Assertions.assertEquals(expected, container.getTail());
    }
    @Test
    void insert()
    {
        Node<Integer> expected=new Node<>(55);
        expected.prev=container.getHead();
        expected.next=container.getTail();
        container.insert(1, 55);

        Assertions.assertEquals(expected, container.getHead().next);
    }
    @Test
    void search_contains()
    {
        int ind=container.search(2);
        Assertions.assertEquals(1, ind);
    }
    @Test
    void search_notContains()
    {
        int ind=container.search(10);
        Assertions.assertEquals(-1, ind);
    }
    @Test
    void getByIndex()
    {
        Assertions.assertEquals(1, container.getByIndex(0));
    }
    @Test
    void removeByIndex()
    {
        container.insert(1,3);  // текущий список - [1, 3, 2]
        Node<Integer> expected=new Node<>(1);
        expected.next=container.getTail();

        container.removeByIndex(1);
        Assertions.assertEquals(expected, container.getHead());
    }
    @Test
    void removeFromHead()
    {
        Node<Integer> expected=new Node<>(2);
        container.removeFromHead();
        Assertions.assertEquals(expected, container.getHead());
    }
    @Test
    void removeFromTail()
    {
        Node<Integer> expected=new Node<>(1);
        container.removeFromTail();
        Assertions.assertEquals(expected, container.getHead());
    }

}
