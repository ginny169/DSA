package org.example.java324.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmployeeImportance {

    public static void main(String[] args){
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, 5, Arrays.asList(2, 3)));
        employees.add(new Employee(2, 3, Collections.emptyList()));
        employees.add(new Employee(3, 4, Collections.emptyList()));

        int result = dfs(employees, 3);
        System.out.println(result);
    }

    public int getImportance(List<Employee> employees, int id) {
        return dfs(employees,id);
    }

    public static int dfs(List<Employee> employees, int id) {
        int index = -1;
        for (int i = 0; i< employees.size(); i++){
            if (employees.get(i).id==id){
                index = i;
            }
        }
        int result = employees.get(index).importance;
        List<Integer> subIDs = employees.get(index).subordinates;
        if (subIDs.size() == 0) return result;
        for (int i = 0; i < subIDs.size(); i++) {
            result = result + dfs(employees, subIDs.get(i));
        }
        return result;
    }

    public static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates){
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }
}
