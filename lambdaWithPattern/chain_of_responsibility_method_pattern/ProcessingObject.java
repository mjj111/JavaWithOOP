package chain_of_responsibility_method_pattern;

public abstract class ProcessingObject<T> {
    protected ProcessingObject<T> succesor;
    public void setSuccessor(ProcessingObject<T> successor){
        this.succesor = successor;
    }

    public T handle(T input){
        T r = handleWork(input);
        if(succesor != null){
            return succesor.handle(r);
        }
        return r;
    }
    abstract protected T handleWork(T input);
}
