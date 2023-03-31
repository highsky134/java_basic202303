package day05;

public class Player {

    String nickName;
    int level;
    int hp;

    // 생성자

    public Player() {
        this("이름없음"); // 2번 생성자를 호출함
//        System.out.println("1번 생성자 호출!");
    }

    public Player(String nickName) {
        this(nickName,1,50); // 나의 또 다른 생성자 3번 생성자 호출
//        System.out.println("2번 생성자 호출!");
    }

    public Player(String nickName, int level, int hp) {
        this.nickName = nickName;
        this.level = level;
        this.hp = hp;
    }

    // 기능 - 메서드
    void levelUp() {

    }

    void attack(Player target) {
        if (this == target) return; // 내가 나를 타겟팅 못하게

        System.out.println("target의 주소 : "+ target);
        System.out.println("this의 주소 : "+ this);

        // 맞은 녀석의 체력을 10 감소 시킨다
        int damage = (int)(Math.random() * 6 + 10);
        target.hp -= damage;

        // 전투로그를 출력
        // "가해자가 피해자를 공격해서 xxx의 피해를 입힘"
        System.out.printf("%s님이 %s님을 공격해서 %d의 피해를 입힘!\n",this.nickName, target.nickName, damage);
    }
}

