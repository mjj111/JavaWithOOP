package basic_stream.result;

import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Resulting {
    public void main(String[] args){
        long count = IntStream.of(1, 3, 5, 7, 9).count();
        long sum = LongStream.of(1, 3, 5, 7, 9).sum();

        OptionalInt min = IntStream.of(1, 3, 5, 7, 9).min();
        OptionalInt max = IntStream.of(1, 3, 5, 7, 9).max();

        DoubleStream.of(1.1, 2.2, 3.3, 4.4, 5.5)
            .average()
            .ifPresent(System.out::println);

        OptionalInt reduced = 
        IntStream.range(1, 4) // [1, 2, 3]
        .reduce((a, b) -> {
            return Integer.sum(a, b);
        });

        int reducedTwoParams = 
            IntStream.range(1, 4) // [1, 2, 3]
            .reduce(10, Integer::sum);
        
        Integer reducedParams = Stream.of(1, 2, 3)
            .reduce(10, // identity
                Integer::sum, // accumulator
                (a, b) -> {
                    System.out.println("combiner was called");
                    return a + b;
                });

        Integer reducedParallel = Arrays.asList(1, 2, 3)
            .parallelStream()
            .reduce(10,
                Integer::sum,
                (a, b) -> {
                    System.out.println("combiner was called");
                    return a + b;
                });

        //Collecting
        List<Product> productList = 
            Arrays.asList(new Product(23, "potatoes"),
                new Product(14, "orange"),
                new Product(13, "lemon"),
                new Product(23, "bread"),
                new Product(13, "sugar"));

        //Collectors.toList()
        List<String> collectorCollection =
            productList.stream()
                .map(Product::getName)
                .collect(Collectors.toList());
            // [potatoes, orange, lemon, bread, sugar]

        //Collectors.joining()
        String listToString = 
            productList.stream()
            .map(Product::getName)
            .collect(Collectors.joining());
            // potatoesorangelemonbreadsugar

        String listToString = 
        productList.stream()
            .map(Product::getName)
            .collect(Collectors.joining(", ", "<", ">"));
        // <potatoes, orange, lemon, bread, sugar>


        //Collectors.averageingInt()
        Double averageAmount = 
             productList.stream()
                .collect(Collectors.averagingInt(Product::getAmount));

        //Collectors.summingInt()
        Integer summingAmount = 
        productList.stream()
            .collect(Collectors.summingInt(Product::getAmount));
        
        Integer summingAmount = 
            productList.stream()
                .mapToInt(Product::getAmount)
                .sum(); // 86
        
        //Collectors.summarizingInt()
        IntSummaryStatistics statistics = 
            productList.stream()
            .collect(Collectors.summarizingInt(Product::getAmount));        
            // 개수 getCount()
            // 합계 getSum()
            // 평균 getAverage()
            // 최소 getMin()
            // 최대 getMax()

        //Collectors.groupingBy()
        Map<Integer, List<Product>> collectorMapOfLists =
             productList.stream()
            .collect(Collectors.groupingBy(Product::getAmount));
        
        //Collectors.partitioningBy()
        Map<Boolean, List<Product>> mapPartitioned = 
            productList.stream()
            .collect(Collectors.partitioningBy(el -> el.getAmount() > 15));
        
        //Collectors.collectingAndThen()
        Set<Product> unmodifiableSet = 
            productList.stream()
            .collect(Collectors.collectingAndThen(Collectors.toSet(),
                                                    Collections::unmodifiableSet));    
        
        //Collector.of()
        Collector<Product, ?, LinkedList<Product>> toLinkedList = 
        Collector.of(LinkedList::new, 
               LinkedList::add, 
               (first, second) -> {
                 first.addAll(second);
                 return first;
               });
        
        //Matching
        List<String> names = Arrays.asList("Eric", "Elena", "Java");

        boolean anyMatch = names.stream()
        .anyMatch(name -> name.contains("a"));
        boolean allMatch = names.stream()
        .allMatch(name -> name.length() > 3);
        boolean noneMatch = names.stream()
        .noneMatch(name -> name.endsWith("s"));

        //Iterating
        names.stream().forEach(System.out::println);

   }
}
