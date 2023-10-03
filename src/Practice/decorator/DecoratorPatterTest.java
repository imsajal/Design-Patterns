package Practice.decorator;

interface Dress{
    void assemble();
}



class BasicDress implements Dress{

    @Override
    public void assemble() {
        System.out.println("Added Basic Dress Features");
    }
}

class DressDecorator implements Dress{

    Dress dress;

    DressDecorator(Dress dress){
        this.dress = dress;
    }

    @Override
    public void assemble() {
        dress.assemble();
    }
}

class SportyDress extends DressDecorator{

    SportyDress(Dress dress){
        super(dress);
    }
    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Added sporty dress fetures");
    }
}

class CasualDress extends DressDecorator{

    CasualDress(Dress dress){
        super(dress);
    }
    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Added casual dress fetures");
    }
}

class FancyDress extends DressDecorator{

    FancyDress(Dress dress){
        super(dress);
    }
    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Added Fancy dress fetures");
    }
}

public class DecoratorPatterTest {

    public static void main(String[] args) {

      //

        Dress casualBasic = new CasualDress(new BasicDress());
        casualBasic.assemble();

        System.out.println("-----------");

        Dress fancyCasualBasic = new FancyDress(new CasualDress(new BasicDress()));
        fancyCasualBasic.assemble();

        System.out.println("--------------");

        Dress sportyFancyCasualBasic = new SportyDress(new FancyDress(new CasualDress(new BasicDress())));
        sportyFancyCasualBasic.assemble();



    }
}