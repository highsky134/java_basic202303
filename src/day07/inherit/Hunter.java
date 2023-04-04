package day07.inherit;

public class Hunter extends Player {

    int concentration; // 집중력

    public Hunter(String nickName) {
        super(nickName);
        this.concentration = 100;
    }

    // 야수소환
    public void summonBeast() {

    }

    @Override
    public void showStatus() {
        super.showStatus();
        System.out.println("concentration = " + concentration);
    }
}
