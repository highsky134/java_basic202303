package day07.inherit;

public class Mage extends Player{

    int mana;

    public Mage(String nickName) {
        super(nickName);
        this.mana = 100;
    }

    // 썬더볼트
    public void thunderBolt() {

    }

    @Override
    public void showStatus() {
        super.showStatus();
        System.out.println("# mana : " + mana);
    }
}
