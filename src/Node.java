public class Node<T>{
    private T value;
    public Node next;
    public Node prev;

    public T getValue()
    {
        return value;
    }
    public void setValue(T value)
    {
        this.value=value;
    }

    public Node()
    {
        value=null;
        prev=null;
        next=null;
    }

    public Node(T value)
    {
        this.value=value;
        next=null;
        prev=null;
    }
    public String toString()
    {
        return value.toString();
    }

    public boolean equals(Object obj)
    {
        if(this==obj)
            return true;
        if(this.getClass()!=obj.getClass() || obj == null)
            return false;

        Node other=(Node)obj;
        if(this.value.equals(other.value) && this.prev==other.prev && this.next==other.next)
            return true;
        return false;
    }
}
