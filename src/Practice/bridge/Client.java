package Practice.bridge;

abstract class TV{

    Remote remote;

    abstract void switchOn();
    abstract void switchOff();

}

class SonyTv extends TV{

    SonyTv(Remote remote){
        this.remote = remote;
    }

    @Override
    void switchOn() {
        System.out.println(" Sony tv");
        remote.on();
    }

    @Override
    void switchOff() {
        System.out.println(" Sony tv");
        remote.off();
    }
}

class AppleTv extends TV{

    AppleTv(Remote remote){
        this.remote = remote;
    }

    @Override
    void switchOn() {
        System.out.println(" Apple tv");
        remote.on();
    }

    @Override
    void switchOff() {
        System.out.println(" Apple tv");
        remote.off();
    }
}

interface Remote{

    void on();
    void off();
}

class OldRemote implements Remote{

    @Override
    public void on() {
        System.out.println("On with old remote");
    }

    @Override
    public void off() {
        System.out.println("Off with old remote");
    }
}

class NewRemote implements Remote{

    @Override
    public void on() {
        System.out.println("On with new remote");
    }

    @Override
    public void off() {
        System.out.println("Off with new remote");
    }
}

public class Client {
    public static void main(String[] args) {

         SonyTv sonyTv = new SonyTv(new OldRemote());
         sonyTv.switchOn();
         sonyTv.switchOff();

        SonyTv sonyTvNew = new SonyTv(new NewRemote());
        sonyTvNew.switchOn();
        sonyTvNew.switchOff();

        AppleTv appleTv = new AppleTv(new OldRemote());
        appleTv.switchOn();
        appleTv.switchOff();

        AppleTv appleTvNew = new AppleTv(new NewRemote());
        appleTvNew.switchOn();
        appleTvNew.switchOff();

    }
}