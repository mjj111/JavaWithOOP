package advanced_stream;

import java.util.*;
import java.util.stream.Collectors;

public class OrderOfStream {
    public static void main(String[] args){
        List<String> second = List.of("a", "sff", "eefga");
        List<String> secondResult = second.stream()
            .filter(el -> {
                System.out.println("filter() was called.");
                return el.contains("a");
            })
            .map(el -> {
                System.out.println("map() was called.");
                return el.toUpperCase();
            })
            .collect(Collectors.toList());

        //스트림은 중간연산 하나에 모든 요소들이 거치고 다음 연산으로 가는 것이 아니라,
        //한 요소씩 모든 중간연산을 흐르고, 다음 요소가 모든 중간연산에 흐르는 흐름대로 작동한다. 
        
        //한 번 사용한 스트림은 재사용 불가.
         
        
    }
}