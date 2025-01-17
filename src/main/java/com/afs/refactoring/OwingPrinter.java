package com.afs.refactoring;

import java.util.List;

public class OwingPrinter {
    void printOwing(String name, List<Order> orders) {
        int outstanding = calculatingOutstanding(orders);

        printTemplate(name, outstanding);
    }

    private void printTemplate(String name, int outstanding) {

        System.out.println ("*****************************");
        System.out.println ("****** Customer totals ******");
        System.out.println ("*****************************");
        System.out.println("name: " + name);
        System.out.println("amount: " + outstanding);
    }

    private int calculatingOutstanding(List<Order> orders) {
        return orders.stream()
                .mapToInt(order -> order.getAmount())
                .sum();
    }

}

class Order {
    private final int amount;

    public Order(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
