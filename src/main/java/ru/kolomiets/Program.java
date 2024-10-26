package ru.kolomiets;

import java.util.UUID;

public class Program {
    public Program() {
    }

    public static void main(String[] args) throws IllegalAccessException {
        Employee user = new Employee("Kolomiets", "kolom@gmail.com");
        UUID pk = UUID.randomUUID();
        user.setId(pk);
        
        QueryBuilder queryBuilder = new QueryBuilder();
        String deleteQuery = queryBuilder.buildDeleteQuery(Employee.class, pk);
        System.out.printf("Delete Query: %s\n", deleteQuery);
    }
}
