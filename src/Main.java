import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        //ДОБАВЛЕНИЕ
        Container<String> container=new Container<>();
        container.append("first");
        container.addToHead("second");
        container.append("third");
        System.out.print("after inserts: ");
        container.print();

        //УДАЛЕНИЕ
        container.removeByIndex(0);
        int indFirst=container.search("first");
        if(indFirst!=-1)
            container.removeByIndex(indFirst);
        System.out.print("after removes: ");
        container.print();

        //ДОБАВЛЕНИЕ
        container.addToHead("fourth");
        container.append("fifth");
        System.out.print("after inserts: ");
        container.print();
        System.out.print("revers after inserts: ");
        container.printReverse();

        //ПОИСК
        int indThird=container.search("third");
        if(indThird!=-1)
            container.insert(indThird, "777");
        container.print();

        //ОЧИСТКА
        System.out.print("before clear: ");
        System.out.println(container.isEmpty());
        container.clearContainer();
        System.out.print("after clear: ");
        System.out.println(container.isEmpty());
        container.print();


    }
}