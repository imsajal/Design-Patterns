package Practice.adapter;

interface Element{

    void getElement();

    void selectElement();
}

class ChromeDriver implements Element{

    @Override
    public void getElement() {
        System.out.println(" ELe get from chrom driver");
    }

    @Override
    public void selectElement() {
        System.out.println("select ele from chrome driver");
    }
}

class IEDriver{

    public void findElement() {
        System.out.println(" ELe get from IE driver");
    }


    public void clickElement() {
        System.out.println("select ele from IE driver");
    }

}

class WebDriverAdapter implements  Element{

    IEDriver ieDriver;

    WebDriverAdapter(IEDriver ieDriver){
       this. ieDriver = ieDriver ;
    }


    @Override
    public void getElement() {
         ieDriver.findElement();
    }

    @Override
    public void selectElement() {
        ieDriver.clickElement();
    }
}

public class AdapterDesignPattern {


    public static void main(String[] args) {

        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.selectElement();
        chromeDriver.getElement();

        WebDriverAdapter webDriverAdapter = new WebDriverAdapter(new IEDriver());

        webDriverAdapter.getElement();
        webDriverAdapter.selectElement();



    }

}