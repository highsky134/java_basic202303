package day07.inherit;

import juice.Utility;

import static juice.Utility.makeLine;

public class Mage extends Player{

    int mana;

    public Mage(String nickName) {
        super(nickName);
        this.mana = 100;
    }

    // 썬더볼트
    public void thunderBolt(Player... targets) {
        System.out.printf("# %s님 썬더볼트 시전!!!\n",this.nickName);
        makeLine();

        for (Player target : targets) {
            if (target == this) continue;
            target.damage();
        }
    }



    @Override
    public void showStatus() {
        super.showStatus();
        System.out.println("# mana : " + mana);
    }
}
