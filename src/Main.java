import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Container<Integer> container=new Container<>(1);
        container.append(2);
        container.append(3);
        container.addToHead(0);
        container.addToHead(-1);
        container.append(4);
        container.printContainer();
        System.out.println();


        container.removeFromHead();
        int ind= container.search(1);
        container.removeByIndex(ind);
        int ind1= container.search(4);
        container.removeByIndex(ind1);
        int ind2= container.search(2);
        container.removeByIndex(ind2);

        container.printContainer();
        System.out.println();

    }
}