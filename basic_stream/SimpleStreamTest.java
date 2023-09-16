package basic_stream;
import java.util.Arrays;

/*
 * 왜 사이즈가 커질 수록 스트림의 속도가 빨라지는가? 
 * 쉽게 얘기하면 
 * 간단한 경우(단순 roop 로직)라면 상관없지만,
 * 로직이 복잡해질수록 코드의 양이 많아져 여러 로직이 섞이게 되고,
 *  메소드를 나눌 경우 루프를 여러 번 도는 경우가 발생한다.
 */
public class SimpleStreamTest {
    public static void main(String[] args) {
        int testSize = 1000000000;
        int[] numbers = new int[testSize];
        for (int i = 0; i < 1000; i++) {
            numbers[i] = i + 1;
        }

        System.out.println("\n테스트 크기 :" + testSize+"\n");
        // 람다와 스트림을 사용하여 짝수 필터링 및 합계 계산
        long startTime = System.currentTimeMillis();
        long sum = Arrays.stream(numbers)
                .parallel() // 병렬 스트림 활성화
                .filter(n -> n % 2 == 0) // 짝수만 필터링
                .sum(); // 합계 계산
        long endTime = System.currentTimeMillis();

        System.out.println("스트림 사용 ");
        System.out.println("합계 : " + sum);
        System.out.println("소요 시간(밀리초) : " + (endTime - startTime));



        // 반복문을 사용하여 짝수 필터링 및 합계 계산
        long loopStartTime = System.currentTimeMillis();
        long loopSum = 0 ;
        for (int i : numbers){
            if(i %2 == 0){
                loopSum +=i;
            }
        }
        long loopEndTime = System.currentTimeMillis();

        System.out.println("\n반복문 사용 ");
        System.out.println("합계 : " + loopSum);
        System.out.println("소요 시간(밀리초) : " + (loopEndTime - loopStartTime));

        System.out.printf("\n스트림과 람다를 통한 성능 개선 비율 :  %f", (double)(loopEndTime - loopStartTime)/(endTime - startTime));
    }
}