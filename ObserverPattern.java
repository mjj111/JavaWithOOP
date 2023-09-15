

import observer_method_pattern.*;

/*
 * 옵서버 패턴은 객체의 상태 변화를 관찰하는 관찰자들, 
 * 즉 옵저버들의 목록을 객체에 등록하여 상태 변화가 있을 때마다,
 * 메서드 등을 통해 객체가 직접 목록의 각 옵저버에게 통지하도록 하는 디자인 패턴이다.
 * 주로 분산 이벤트 핸들링 시스템을 구현하는 데 사용된다.
 */
public class ObserverPattern {
    public static void main(String[] args){
        Feed f = new Feed();
        f.registerObserver(new BusanTimes());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMode());
        f.notifyObservers("I really wanna drink wine");


    //자바8 람다 표현식을 활용한 옵저버 패턴
        f.registerObserver((String s)->{
            if(s != null && s.contains("부경대")){
                System.out.println("Breaking news in 부경대! "+s);
            }
        });
        f.notifyObservers("부경대에서 제일 열심히 공부하는 남자, 김명준");
    }
}
