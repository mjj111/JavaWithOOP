package chain_of_responsibility_method_pattern;

public class SpellCheckProcessing extends ProcessingObject<String>{
    public String handleWork(String text){
        return text.replaceAll("lamda", "lambda"); // 람다 스팰링을 고쳐준다. 
    }
    
}
