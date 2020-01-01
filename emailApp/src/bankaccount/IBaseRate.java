package bankaccount;

public interface IBaseRate {

    //method which return base rate
    default double getBaseRate() {
        return 2.5;
    }
}
