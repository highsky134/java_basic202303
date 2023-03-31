package day05.member;

// 역할: 회원 저장소 역할
public class MemberRepository {
    Member[] memberList;

    public MemberRepository() {
        this.memberList = new Member[3];
        memberList[0] = new Member("abc@def.com", "1234",
                "김객체", 1, Gender.MALE, 50);
        memberList[1] = new Member("zzz@ggg.com", "4321",
                "반복문", 2, Gender.FEMALE, 30);
        memberList[2] = new Member("test@googol.com", "6666",
                "생성자", 3, Gender.FEMALE, 40);
    }

    /**
     * 모든 회원정보를 출력해주는 메서드
     */
    void showMembers() {
        System.out.printf("============= 현재 회원정보 (총 %d명) ==============\n", memberList.length);

        for (Member m : memberList) {
            System.out.println(m.inform());
        }

    }

    /**
     * 회원가입기능
     *
     * @param newMember : 새롭게 회원가입하는 회원의 정보
     * @return : 회원가입 성공 여부
     * 성공시 true, 이메일이 중복되어 실패시 false
     */
    boolean addMember(Member newMember) {
        // 이메일이 중복인가?
        if (isDuplicateEmail(newMember.email)) return false;

        // 실제로 멤버를 추가하는 코드
        Member[] temp = new Member[memberList.length + 1];
        for (int i = 0; i < memberList.length; i++) {
            temp[i] = memberList[i];
        }
        temp[temp.length - 1] = newMember;
        memberList = temp;

        return true;
    }

    /**
     * 이메일의 중복여부를 확인하는 기능
     *
     * @param targetEmail : 검사 대상 이메일
     * @return : 중복되었을 시 true, 사용가능할 시 false
     */
    boolean isDuplicateEmail(String targetEmail) {

        for (Member m: memberList) {
            if (targetEmail.equals(m.email)) {
                return true;
            }
        }
        return false;
    }

    // 마지막 회원의 번호를 알려주는 기능
    int getLastMemberId() {
        return memberList[memberList.length-1].memberId;
    }


    /**
     *  이메일을 통해 특정 회원 객체를 반환하는 기능
     * @param email : 찾고 싶은 회원의 이메일
     * @return : 찾은 회원의 객체정보, 못찾으면 null 반환
     */
    Member findByEmail(String email) {
        for (Member m : memberList) {
            if (email.equals(m.email)) return m;
        }
        return null;
    }

    /**
     *  이메일과 비밀번호를 통해 객체를 삭제 하고 결과를 반환하는 기능
     *
     */

    boolean deleteMember(String email, String password) {

        return false;
    }

}