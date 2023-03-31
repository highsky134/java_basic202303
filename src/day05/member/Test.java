package day05.member;

public class Test {
    public static void main(String[] args) {

        MemberRepository mr = new MemberRepository();

        Member access = new Member("a12@gol.com", "7777",
                "접근자", 4, Gender.MALE, 24);

        mr.addMember(access);
        mr.addMember(access);

        mr.showMembers();

//        boolean flag = mr.isDuplicateEmail("abc@def.com");
//        System.out.println("flag = " + flag);



    }
}
