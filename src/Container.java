public class Container <T>
{
    private Node<T> head;
    private Node<T> tail;
    private int size=0;

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

    public boolean isEmpty()
    {
        if(head==null)
            return true;
        return false;
    }

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

    public void print()
    {
        Node<T> curr=head;
        while(curr!=null)
        {
            System.out.print(curr+" ");
            curr=curr.next;
        }
        System.out.println();
    }

    public void printReverse()
    {
        Node<T> curr=tail;
        while(curr!=null)
        {
            System.out.print(curr+" ");
            curr=curr.prev;
        }
        System.out.println();
    }

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

    private void remove(Node<T>del)
    {
        del.prev.next=del.next;
        del.next.prev=del.prev;
        del.next=null;
        del.prev=null;
        --size;
    }

    public void clearContainer()
    {
        head=null;
        tail=null;
    }
}
