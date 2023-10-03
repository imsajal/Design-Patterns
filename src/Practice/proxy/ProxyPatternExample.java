package Practice.proxy;

interface DatabaseExecutor{

    void executeDatabase(String query);

}

class DatabaseExecutorImpl implements DatabaseExecutor{

    @Override
    public void executeDatabase(String query) {
        System.out.println("Executing the query " + query);
    }
}

class DatabaseExecutorProxy implements DatabaseExecutor{

    boolean isAdmin;

    DatabaseExecutorImpl databaseExecutor;

    DatabaseExecutorProxy(String username, String password){

        if("admin" == username && "admin" == password){
            isAdmin = true;
        }
        databaseExecutor = new DatabaseExecutorImpl();
    }
    @Override
    public void executeDatabase(String query) {
        if(isAdmin){
            databaseExecutor.executeDatabase(query);
        }
        else if(query == "delete")
        {
            System.out.println("Error");
        }
        else{
            databaseExecutor.executeDatabase(query);
        }
    }
}
public class ProxyPatternExample {

    public static void main(String[] args) throws Exception {

      DatabaseExecutorProxy databaseExecutorProxy = new DatabaseExecutorProxy("admin", "admin");
      DatabaseExecutorProxy databaseExecutorProxy1 = new DatabaseExecutorProxy("nadmin", "nadmin");

      databaseExecutorProxy1.executeDatabase("delete");
      databaseExecutorProxy1.executeDatabase("select");
      databaseExecutorProxy.executeDatabase("delete");

    }

}