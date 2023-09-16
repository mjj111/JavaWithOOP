import chain_of_responsibility_method_pattern.HeaderTextProcessing;
import chain_of_responsibility_method_pattern.ProcessingObject;
import chain_of_responsibility_method_pattern.SpellCheckProcessing;

/*
 * 책임 연쇄 패턴은 명령 객체와 일련의 처리 객체를 포함하는 디자인 패턴이다.
 *  각각의 처리 객체는 명령 객체를 처리할 수 있는 연산의 집합이고,
 *  체인 안의 처리 객체가 핸들할 수 없는 명령은 다음 처리 객체로 넘겨진다. 
 */
public class ChainOfResponsibilityPattern {
    public static void main(String[] args){
        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckProcessing();
        p1.setSuccessor(p2);// 두 작업 처리 객체를 연결
        String result = p1.handle("\n패턴에 lamda넣으니까 재밌다 헤헤");
        System.out.println(result);

    }
}
