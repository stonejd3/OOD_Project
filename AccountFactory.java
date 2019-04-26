public class AccountFactory {

    private static AccountFactory accountFactory;
    public Account account;
    private int nextAccountId;
    private int defaultBalance = 500;

    private AccountFactory(){}

    private int getNextAccountId(){
        nextAccountId += 1;
        return nextAccountId;

    }

    public static synchronized AccountFactory getFactory(){
        if(accountFactory == null)
            accountFactory = new AccountFactory();
        return accountFactory;
    }

    public Account getAccount(){

        return new Account(getNextAccountId(), defaultBalance);

    }

}
