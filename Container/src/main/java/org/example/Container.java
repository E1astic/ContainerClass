package org.example;

public class Container <T>
{
    private Node<T> head;
    private Node<T> tail;
    private int size=0;

    public Node<T> getHead()
    {
        return head;
    }

    public Container()
    {
        head=null;
        tail=null;
    }

    public Container(Node<T> head)
    {
        this.head=head;
        this.tail=this.head;
        size=1;
    }

    public Container(Node<T> head, Node<T> tail)
    {
        this.head=head;
        this.tail=tail;
        size=2;
    }

    public Container(T head)
    {
        this.head=new Node<>(head);
        this.tail=this.head;
        size=1;
    }

    public Container(T head, T tail)
    {
        this.head=new Node<>(head);
        this.tail=new Node<>(tail);
        size=2;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        if(head==null)
            return true;
        return false;
    }

    @Override
    public String toString()
    {
        StringBuilder result=new StringBuilder("[");
        Node<T>curr=head;
        while(curr!=null)
        {
            if(curr.next==null)
                result.append(curr.getValue().toString()+"]");
            else
                result.append(curr.getValue()+", ");

            curr=curr.next;
        }
        return result.toString();
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this==obj)
            return true;
        if(this.getClass()!=obj.getClass() || obj==null)
            return false;

        Container<T> other=null;
        try
        {
            other = (Container<T>) obj;
        }
        catch(Exception e)
        {
            return false;
        }

        if(this.size()!=other.size())
        {
            return false;
        }

        Node<T>currHead=this.getHead();
        Node<T>otherHead=other.getHead();

        while(currHead!=null)
        {
            if(!currHead.getValue().equals(otherHead.getValue()))
            {
                return false;
            }
            currHead=currHead.next;
            otherHead=otherHead.next;
        }

        return true;
    }

    // добавление элемента в начало списка
    public void addToHead(T val)
    {
        Node<T>node=new Node<>(val);
        if(isEmpty())
        {
            head=node;
            tail=head;
        }
        else
        {
            node.next=head;
            head.prev=node;
            head=node;
        }
        ++size;
    }

    // добавление элемента в конец списка
    public void append(T val)
    {
        if(isEmpty())
        {
            head = new Node<>(val);
            tail=head;
        }
        else
        {
            Node<T>node=new Node<>(val);
            tail.next=node;
            node.prev=tail;
            tail=node;
        }
        ++size;
    }

    // добавление элемента по индексу
    public void insert(int ind, T val)
    {
        if(ind>=size || ind<0)
            throw new IndexOutOfBoundsException();

        if(ind==0)
        {
            addToHead(val);
            return;
        }
        if(ind==size-1)
        {
            append(val);
            return;
        }

        Node<T>node=new Node<>(val);

        int i=0;
        Node<T>curr=head;
        while(i<ind)
        {
            curr=curr.next;
            ++i;
        }

        node.next=curr;
        node.prev=curr.prev;
        curr.prev=node;
        node.prev.next=node;
    }

    // поиск элемента (возвращает индекс при его существовании, иначе возвращает -1)
    public int search(T val)
    {
        int ind=0;
        Node<T>curr=head;
        while(curr!=null)
        {
            if(curr.getValue().equals(val))
                return ind;
            curr = curr.next;
            ++ind;
        }
        return -1;
    }

    // получение элемента по индексу
    public T getByIndex(int ind)
    {
        if(ind>=size || ind<0)
            throw new ArrayIndexOutOfBoundsException();
        int i=0;
        Node<T>curr=head;
        while(i<ind)
        {
            curr=curr.next;
            ++i;
        }

        return curr.getValue();
    }

    // удаление элемента по индексу
    public void removeByIndex(int ind)
    {
        if(ind>=size || ind<0)
            throw new IndexOutOfBoundsException();

        if(ind==0)
        {
            removeFromHead();
            return;
        }
        else if(ind==size-1)
        {
            removeFromTail();
            return;
        }

        int i=0;
        Node<T>curr=head;
        while(i<ind)
        {
            curr=curr.next;
            ++i;
        }
        remove(curr);
    }

    // удаление элемента из головы
    public void removeFromHead()
    {
        if(head!=null)
        {
            if(head.next!=null)
            {
                head=head.next;
                head.prev=null;
            }
            else
            {
                head=null;
            }
            --size;
        }
    }

    // удаление элемента из хвоста
    public void removeFromTail()
    {
        if(tail!=null)
        {
            if(tail.prev!=null)
            {
                tail=tail.prev;
                tail.next=null;
            }
            else
            {
                tail=null;
            }
            --size;
        }
    }

    // приватный метод удаления элемента (не первого и не последнего)
    private void remove(Node<T>del)
    {
        del.prev.next=del.next;
        del.next.prev=del.prev;
        del.next=null;
        del.prev=null;
        --size;
    }

    // очистка контейнера
    public void clearContainer()
    {
        head=null;
        tail=null;
    }
}
