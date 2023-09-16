package observer_method_pattern;

public class LeMode implements Observer{
    public void notify(String tweet){
        if(tweet != null && tweet.contains("wine")){
            System.out.println("Breaking news in YeongJu! "+tweet);
        }
    }
}
