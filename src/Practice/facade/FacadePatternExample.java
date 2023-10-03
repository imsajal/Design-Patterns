package Practice.facade;
import java.sql.Driver;

class Chrome{

    static void getHtmlReport(){
        System.out.println("This is html report from chrome broweser");
    }
    static void getJunitReport(){
        System.out.println("This is junit report from chrome broweser");
    }
}

class Firefox{

    static void getHtmlReport(){
        System.out.println("This is html report from firefox broweser");
    }
    static void getJunitReport(){
        System.out.println("This is junit report from firefox broweser");
    }
}

class Facade{

    static void getReport(String browser, String reportType){
        switch (browser){
            case "firefox":
                switch(reportType){
                    case "html": Firefox.getHtmlReport();
                        break;
                    case "junit": Firefox.getJunitReport();
                        break;
                }
                break;
            case "chrome":
                switch(reportType){
                    case "html": Chrome.getHtmlReport();
                        break;
                    case "junit": Chrome.getJunitReport();
                        break;
                }

        }



    }

}


public class FacadePatternExample {

    public static void main(String[] args) {
       Facade.getReport("chrome","junit");
        Facade.getReport("chrome","html");
        Facade.getReport("firefox","junit");
        Facade.getReport("firefox","html");
    }

}