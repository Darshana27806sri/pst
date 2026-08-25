Problem Description

A cloud analytics platform receives millions of sensor readings. Each reading contains a sensor ID and temperature value. Using stream processing concepts, perform the following 

operations:

Filter temperatures greater than 50.
Group readings by sensor ID.
Compute average temperature per sensor.
Sort sensors based on average temperature in descending order.

Program:s
import java.util.*;
import java.util.stream.*;
public class Main {
    static class Reading {
        String sensorId;
        double temperature;
        Reading(String sensorId, double temperature) {
            this.sensorId = sensorId;
            this.temperature = temperature;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Reading> readings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String sensorId = sc.next();
            double temperature = sc.nextDouble();
            readings.add(new Reading(sensorId, temperature));
        }readings.stream()
                .filter(r -> r.temperature > 50)              
                .collect(Collectors.groupingBy(
                        r -> r.sensorId,
                        Collectors.averagingDouble(r -> r.temperature)
                ))             
       readings.stream()
                .filter(r -> r.temperature > 50)               
                .collect(Collectors.groupingBy(
                        r -> r.sensorId,
                        Collectors.averagingDouble(r -> r.temperature)
                ))              
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(entry ->
                        System.out.println(entry.getKey() + " " + entry.getValue())
                );
    sc.close();
