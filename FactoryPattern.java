


import java.util.*;
import factory_method_pattern.*;

/*
 * 팩토리 패턴은  부모 클래스에 알려지지 않은 구체 클래스를 생성하는 패턴이며. 
 * 자식 클래스가 어떤 객체를 생성할지를 결정하도록 하는 패턴이기도 하다.
 *  부모 클래스 코드에 구체 클래스 이름을 감추기 위한 방법으로도 사용한다.
 */
public class FactoryPattern {
    public static void main(String[] args) {
        
        // 생성 패턴인 팩토리 패턴을 통한 객체 생성 
        FruitFactory fruitFactory = new FruitFactory();
        Fruit apple = fruitFactory.createFruit("Apple", 150);
        Fruit banana = fruitFactory.createFruit("Banana", 120);
        Fruit orange = fruitFactory.createFruit("Orange", 180); 
        ArrayList<Fruit> fruits = new ArrayList<>(Arrays.asList(apple, banana, orange));

        
        //자바8 람다 표현식을 활용한 정렬
        fruits.sort(Comparator.comparing(Fruit::getWeight));

        System.out.println("람다를 사용한 오름차순 결과");
        for (Fruit fruit : fruits) {
            System.out.println("Fruit weight: " + fruit.getWeight());
        }
    }
}





