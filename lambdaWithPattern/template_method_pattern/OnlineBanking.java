package template_method_pattern;


public abstract class OnlineBanking {
    // 온라인 뱅킹 알고리즘이 해야 할 일
    public void processCustomer(int id){
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy(c);
    }

    /* OnlineBanking의 processCustomer를 통해 일을 하고,
     * 고객을 만족 시키는 행위는 구현해야한다. 
    */
    abstract void makeCustomerHappy(Customer c);
    
    }
