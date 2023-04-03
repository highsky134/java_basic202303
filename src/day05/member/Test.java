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

        // 비밀번호 변경 수정 테스트
//        String targetEmail = "zzz@ggg.com";
//        boolean updateFlag = mr.changePassword(targetEmail, "9999");
//
//        if (updateFlag) {
//            Member updateMember = mr.findByEmail(targetEmail);
//            System.out.println("updateMember = " + updateMember.password);
//        } else {
//            System.out.println("이메일 오류");
//        }

        // 삭제 테스트
        mr.removeMember("zzz@ggg.com");
        mr.showMembers();

    }
}
