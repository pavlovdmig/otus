package homework;


        import java.util.*;

        import static java.util.Collections.copy;


public class CustomerService {

    private final TreeMap<Customer, String> treeMap;

    public CustomerService() {
        this.treeMap = new TreeMap<>(Comparator.comparingLong(Customer::getScores));
    }


    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны

    public Map.Entry<Customer, String> getSmallest() {
        //Возможно, чтобы реализовать этот метод, потребуется посмотреть как Map.Entry сделан в jdk
        Map.Entry<Customer, String> firstEntry = treeMap.firstEntry();
        return copy(firstEntry.getKey(),firstEntry.getValue());

    }
    public Map.Entry<Customer, String> getNext(Customer customer) {
        try {
            Map.Entry<Customer, String> higherEntry = treeMap.higherEntry(customer);
            return copy(higherEntry.getKey(), higherEntry.getValue());
        }
        catch (NullPointerException e){
            return null;
        }
    }
    public void add(Customer customer, String data) {
        treeMap.put(customer,data);
    }
    public Map.Entry<Customer, String> copy(Customer customer, String string) {
        return Map.entry(new Customer(customer), string);
    }
}


