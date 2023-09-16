package basic_stream.create;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class CreatingStream {
    public static void main(String[] args){
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> stream = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);

        // Array
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> stream = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = 
        Arrays.stream(arr, 1, 3);
        
        //Collection
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> stream = list.stream();
        Stream<String> parallelStream = list.parallelStream(); // 병렬 처리 스트림
    
        // builder() 
        Stream<String> builderStream = 
        Stream.<String>builder()
        .add("Eric").add("Elena").add("Java")
        .build(); // [Eric, Elena, Java]

        // generate()
        Stream<String> generatedStream = 
        Stream.generate(() -> "gen").limit(5); // [el, el, el, el, el]

        // iterate()
        Stream<Integer> iteratedStream = 
        Stream.iterate(30, n -> n + 2).limit(5);
    
        //기본 타입형
        IntStream intStream = IntStream.range(1, 5); // [1, 2, 3, 4]
        LongStream longStream = LongStream.rangeClosed(1, 5); // [1, 2, 3, 4, 5]
        Stream<Integer> boxedIntStream = IntStream.range(1, 5).boxed();

        //문자열 스트링
        IntStream charsStream = "Stream".chars();
        Stream<String> stringStream = 
        Pattern.compile(", ").splitAsStream("Eric, Elena, Java");


        //병렬 스트림 
        Stream<Product> parallelStream = productList.parallelStream();

        // 병렬 여부 확인
        boolean isParallel = parallelStream.isParallel();

        boolean isMany = parallelStream
                                .map(product -> product.getAmount() * 10)
                                .anyMatch(amount -> amount > 200);

        Arrays.stream(arr).parallel();

        
    }
}
