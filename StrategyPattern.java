


import strategy_method_pattern.*;

/*
 * 전략 패턴은 실행 중에 알고리즘을 선택할 수 있게 하는 행위 소프트웨어 디자인 패턴이다. 
 * 전략 패턴은 특정한 계열의 알고리즘들을 정의하고 각 알고리즘을 캡슐화하며
 *  이 알고리즘들을 해당 계열 안에서 상호 교체가 가능하게 만든다
 */
public class StrategyPattern {
    public static void main(String[] args){
        //기존의 코드를 사용한 전략패턴 
        Validator numericValidator = new Validator(new IsNumeric());
        boolean b1 = numericValidator.validate("123");
        Validator loweValidator = new Validator(new IsAllLowerCase());
        boolean b2 = loweValidator.validate("lowersentence");
        System.out.println(b1);
        System.out.println(b2);

        //자바8 람다 표현식을 활용한 전략패턴
        System.out.println(new Validator((String s)-> s.matches("[a-z]+")).validate("lowesentence"));
        System.out.println( new Validator((String s)-> s.matches("\\d+")).validate("123"));

    }
}
