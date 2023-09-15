package observer_method_pattern;

public class Guardian implements Observer {
    public void notify(String tweet){
        if(tweet != null && tweet.contains("queen")){
            System.out.println("Breaking news in Seoul!"+tweet);
        }
    }
    
}
