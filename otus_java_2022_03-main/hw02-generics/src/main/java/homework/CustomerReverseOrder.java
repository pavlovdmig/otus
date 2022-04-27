package homework;


import java.util.ArrayDeque;
import java.util.Deque;

public class CustomerReverseOrder {

    //todo: 2. надо реализовать методы этого класса
    //надо подобрать подходящую структуру данных, тогда решение будет в "две строчки"
    private final ArrayDeque<Customer> costumer;

    public CustomerReverseOrder() {

        this.costumer = new ArrayDeque<Customer>();
    }

    public void add(Customer customer) {
        costumer.add(customer);
    }

    public Customer take() {
        return  costumer.pollLast();
    }
}
