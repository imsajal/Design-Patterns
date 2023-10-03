package Practice;

class pojo{

    private static pojo instance;

    private pojo(){}

    public static pojo getInstance(){

        synchronized(pojo.class){
            if(instance == null) {
                instance = new pojo();
                return instance;
            }
        }
        return instance;
    }
}

public class SingletonExample {

    public static void main(String[] args) {
        System.out.println(pojo.getInstance());
        System.out.println(pojo.getInstance());
        System.out.println(pojo.getInstance());

    }
}