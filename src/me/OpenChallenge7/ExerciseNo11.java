package me.OpenChallenge7;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

class Order {
    String action;
    String variable;
    String value;

    public Order(String action, String variable, String value) {
        this.action = action;
        this.variable = variable;
        this.value = value;
    }

    public String toString() {
        return String.format("[%s, %s, %s]", this.action, this.variable, this.value);
    }
}

class Computer {
    Set<String> actionSet = Set.of("mov", "add", "sub", "jn0", "prt");
    HashMap<String, Integer> memory;
    Vector<Order> orders;
    Scanner scanner;

    public Computer() {
        this.orders = new Vector<>();
        this.memory = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    private Order validateInput(String inputString) {
        String[] order = inputString.split(" ");

        if (order.length != 3) {
            return null;
        }

        String action = order[0];
        try {
            if (!actionSet.contains(action)) {
                return null;
            }
        } catch (ClassCastException cce) {
            return null;
        } catch (NullPointerException npe) {
            return null;
        }

        return new Order(action, order[1], order[2]);
    }

    private void inputOrders(String inputString) {
        Order order = this.validateInput(inputString);
        if (order == null) {
            System.err.println("입력을 확인하세요!");
        } else {
            this.orders.add(order);
        }
    }

    private String memoryToString() {
        String result = "";
        Iterator<String> si = this.memory.keySet().iterator();

        while (si.hasNext()) {
            String key = si.next();
            result += key.toUpperCase() + ":" + this.memory.get(key) + " ";
        }

        return result;
    }

    private Integer checkValue(Order order) {
        Integer value;
        try {
            value = Integer.parseInt(order.value);
        } catch (NumberFormatException e) {
            Integer memValue = this.memory.get(order.value);
            if (memValue != null) {
                value = memValue;
            } else {
                return null;
            }
        }
        return value;
    }

    private void runOrders() {
        int orderCount = 0;

        loop:
        while (true) {
            Order order = this.orders.get(orderCount);

            switch (order.action) {
                case "mov":
                    try {
                        this.memory.put(order.variable, Integer.parseInt(order.value));
                    } catch (NumberFormatException nfe) {
                        System.err.println("명령을 확인해 주십시오. " + order);
                    }
                    break;
                case "add":
                    Integer memValueForAdd = this.memory.get(order.variable);
                    if (memValueForAdd == null) {
                        System.err.println("저장된 변수" + order.variable + "가 없습니다!");
                    } else {
                        Integer value = this.checkValue(order);
                        if (value == null) {
                            System.err.println("저장된 변수" + order.value + "가 없습니다!");
                        } else {
                            this.memory.put(order.variable, memValueForAdd + value);
                        }
                    }
                    break;
                case "sub":
                    Integer memValueForSub = this.memory.get(order.variable);
                    if (memValueForSub == null) {
                        System.err.println("저장된 변수" + order.variable + "가 없습니다!");
                    } else {
                        Integer value = this.checkValue(order);
                        if (value == null) {
                            System.err.println("저장된 변수" + order.value + "가 없습니다!");
                        } else {
                            this.memory.put(order.variable, memValueForSub - value);
                        }
                    }
                    break;            
                case "jn0":
                    Integer memValueForJn0 = this.memory.get(order.variable);
                    if (memValueForJn0 == null) {
                        System.err.println("저장된 변수" + order.variable + "가 없습니다!");
                    } else {
                        if (this.memory.get(order.variable) == 0) {
                            break;
                        } else {
                            orderCount = Integer.parseInt(order.value) - 1;
                        }
                    }
                    break; 
                case "prt":
                    Integer memValueForPrt = this.memory.get(order.variable);
                    if (memValueForPrt == null) {
                        System.err.println("저장된 변수" + order.variable + "가 없습니다!");
                    } else {
                        System.out.println(order);
                        System.out.println(this.memoryToString());
                        System.out.println(String.format("출력할 결과는 %d. 프로그램 실행 끝", memValueForPrt));
                    }
                    this.orders.clear();
                    this.memory.clear();
                    break loop;
            }
            orderCount += 1;
        }
    }

    public void run() {
        System.out.println("수퍼컴이 작동합니다. 프로그램을 입력해주세요.");
        System.out.println("GO를 입력하면 작동합니다. EXIT를 입력하면 종료합니다.");

        while (true) {
            System.out.print(">> ");
            String inputString = this.scanner.nextLine();

            if (inputString.equals("exit") | inputString.equals("EXIT")) {
                System.out.println("종료합니다...");
                this.scanner.close();
                break;
            }

            if (inputString.equals("go") | inputString.equals("GO")) {
                this.runOrders();
                continue;
            }

            this.inputOrders(inputString);
        }
    }

}

public class ExerciseNo11 {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.run();
    }
}
