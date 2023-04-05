package day07.inherit;

// 수퍼 클래스 (부모 클래스) : 객체의 공통 기능과 속성을 설계
public class Player {
    String nickName; // 캐릭터 이름
    int level;
    int hp;
    int exp;

    // 부모의 생성자


    public Player(String nickName) {
        System.out.println("Player의 생성자 호출!");
        this.nickName = nickName;
        this.level = 1;
        this.hp = 50;
    }

    public void showStatus() {
        System.out.println("\n=========== Character's Info ============");
        System.out.println("# name: " + nickName);
        System.out.println("# level: " + level);
        System.out.println("# hp: " + hp);
    }

    public void damage() {
        int rd = (int)(Math.random() * 6 + 10);
        this.hp -= rd;
        System.out.printf("%s님이 %d의 피해를 입었습니다.(남은 체력: %d)\n", nickName, rd, this.hp);
    }

    // 스킬별 데미지가 다르다면 범위를 받아오는 damage 메서드 사용 (오버로딩)
    public void damage(int min, int max) {
        int rd = (int)(Math.random() * max + min);
        this.hp -= rd;
        System.out.printf("%s님이 %d의 피해를 입었습니다.(남은 체력: %d)\n", nickName, rd, this.hp);
    }
}
