package chain_of_responsibility_method_pattern;

public class HeaderTextProcessing extends ProcessingObject<String>{
    public String handleWork(String text){
        return "From 김명준"+ text;
    }
    
}
