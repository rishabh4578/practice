package org.example.ReferenceCodesSnippets;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Function;

public class FunctionAsParam {

    public static void main(String[] args) {
        Employee emp = new Employee("Rishabh", 25);
        String empMessage = MonitoringUtility.executeAndPrintDuration(empParam -> {
            String message = empParam.getAge() >= 20 ? "Congratulations" : "Sorry";
            return String.format("%s %s", message, empParam.getName());
        }, emp);
        System.out.println(empMessage);
    }

    class MonitoringUtility {
        public static <T, U> U executeAndPrintDuration(Function<T, U> function, T t) {
            Instant start = Instant.now();
            U result;
            try {
                result = function.apply(t);
            } finally {
                System.out.println(String.format("Execution took %s ms.",
                        Duration.between(start, Instant.now()).toMillis()));
            }
            return result;
        }
    }

    static class Employee {
        private String name;
        private int age;

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

}
