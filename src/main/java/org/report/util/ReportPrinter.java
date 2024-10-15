package org.report.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

// Utility class for handling report printing
public class ReportPrinter {

    private ReportPrinter(){
    }

    // Method to print the number of unique customerId for each entity (contractId/geozone)
    public static void printUniqueCustomerCount(String entityName, Map<String, Set<String>> entityToCustomers) {
        System.out.println("Number of unique customerId for each " + entityName + ":");
        for (Map.Entry<String, Set<String>> entry : entityToCustomers.entrySet()) {
            String entityId = entry.getKey();
            int uniqueCustomers = entry.getValue().size();
            System.out.println(entityName + " " + entityId + ": " + uniqueCustomers);
        }
        System.out.println();
    }

    // Method to print the average build duration for each geozone
    public static void printAverageBuildDuration(Map<String, List<Integer>> geozoneToDurations) {
        System.out.println("Average buildduration for each geozone:");
        for (Map.Entry<String, List<Integer>> entry : geozoneToDurations.entrySet()) {
            String geozone = entry.getKey();
            List<Integer> durations = entry.getValue();
            double averageDuration = durations.stream().mapToInt(Integer::intValue).average().orElse(0);
            System.out.printf("Geozone %s: %.2f\n", geozone, averageDuration);
        }
        System.out.println();
    }

    // Method to print the list of unique customerId for each geozone
    public static void printUniqueCustomerList(String entityName, Map<String, Set<String>> entityToCustomers) {
        System.out.println("List of unique customerId for each " + entityName + ":");
        for (Map.Entry<String, Set<String>> entry : entityToCustomers.entrySet()) {
            String entityId = entry.getKey();
            Set<String> customers = entry.getValue();
            System.out.println(entityName + " " + entityId + ": " + customers);
        }
        System.out.println();
    }
}
