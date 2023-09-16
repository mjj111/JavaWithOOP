import java.util.function.Consumer;
import template_method_pattern.*;

/*
 * 템플릿 메소드 패턴은 소프트웨어 공학에서 동작 상의 알고리즘의 프로그램 뼈대를 정의하는 행위 디자인 패턴이다.
 *  알고리즘의 구조를 변경하지 않고 알고리즘의 특정 단계들을 다시 정의할 수 있게 해준다
 */

public class TemplatePattern {
    /*
     * 본래는 OnlineBanking을 상속받고 안에 구현되지 않은 추상 메서드 makeCustomerHappy를 구현해야한다. 
     * 그러나 람다를 통해 메서드를 추가하여 구현할 수 있도록 본래의 processCustomer에 인수를 하나 더 추가하였다. 
     */
    public static void processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy.accept(c);
    }


    //자바8 람다 표현식을 활용한 탬플릿 패턴
    public static void main(String[] args) {
        processCustomer(1337, (Customer c) -> {
            System.out.println("Hello " + c.getName());
        });
    }
    
}
