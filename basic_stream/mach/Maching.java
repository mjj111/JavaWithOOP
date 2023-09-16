package basic_stream.mach;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Maching {
    public void main(String[] args){

        //연결하기 
        Stream<String> stream1 = Stream.of("Java", "Scala", "Groovy");
        Stream<String> stream2 = Stream.of("Python", "Go", "Swift");
        Stream<String> concatd = Stream.concat(stream1, stream2);


        //가공하기 Filtering
        List<String> names = Arrays.asList("Eric", "Elena", "Java");
        Stream<String> streams = names.stream().filter(name -> name.contains("a")); // [Elena, Java]


        //Mapping
        Stream<String> streama = names.stream() .map(String::toUpperCase);
        Stream<Integer> stream = productList.stream().map(Product::getAmount);
        

        List<List<String>> list = 
            Arrays.asList(Arrays.asList("a"), 
            Arrays.asList("b"));

        List<String> flatList = 
            list.stream()
            .flatMap(Collection::stream)
            .collect(Collectors.toList());

        //flatMap을 사용해서 중첩 구조를 제거
        List<String> flatListd = 
            list.stream()
            .flatMap(Collection::stream)
            .collect(Collectors.toList());

        students.stream()
            .flatMapToInt(student -> 
                IntStream.of(student.getKor(), 
                             student.getEng(), 
                             student.getMath()))
                                .average().ifPresent(avg -> 
                                        System.out.println(Math.round(avg * 10)/10.0));
        
        IntStream.of(14, 11, 20, 39, 23)
        .sorted()
        .boxed()
        .collect(Collectors.toList());

        List<String> lang = 
            Arrays.asList("Java", "Scala", "Groovy", "Python", "Go", "Swift");

        lang.stream()
        .sorted()
        .collect(Collectors.toList());
        // [Go, Groovy, Java, Python, Scala, Swift]

        lang.stream()
        .sorted(Comparator.reverseOrder())
        .collect(Collectors.toList());
        // [Swift, Scala, Python, Java, Groovy, Go]
                                                                      
        lang.stream()
            .sorted(Comparator.comparingInt(String::length))
            .collect(Collectors.toList());
            // [Go, Java, Scala, Swift, Groovy, Python]

        lang.stream()
            .sorted((s1, s2) -> s2.length() - s1.length())
            .collect(Collectors.toList());
            // [Groovy, Python, Scala, Swift, Java, Go]
        
        //peek
        int sum = IntStream.of(1, 3, 5, 7, 9)
            .peek(System.out::println)
            .sum();
    }
    
}
