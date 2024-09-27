public class Main
{
    public static void main(String[] args)
    {
        Node<String>a=new Node<>("hello");
        Node<String>a1=new Node<>("hello");
        Node<String>b=new Node<>("everyone");
        Node<String>c=new Node<>("!!!");

        a.next=b;
        a1.next=b;

        System.out.println(a.equals(a1));

    }
}