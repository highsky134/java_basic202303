package day05.member;

// 역할: 회원 저장소 역할 // -> 추가 기능 해볼? 가입된 회원 10명이면 1번 메뉴 안보이게 등
public class MemberRepository {

    public static final int NOT_FOUND = -1;

    //가입된 회원 배열
    Member[] memberList;

    // 삭제된 회원 배열 : 복구용 백업 회원
    Member[] removeMember;

    public MemberRepository() {
        this.memberList = new Member[3];
        this.removeMember = new Member[0];
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
        return !isEmpty() ? memberList[memberList.length-1].memberId : 0;
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
     *  이메일을 통해 해당 계정 삭제하는 기능
     */
    void removeMember(String email) {
        // 인덱스 찾기
        int idx = findIndexByEmail(email);

        // 삭제 전 회원정보 백업
        pushRemoveMember(findByEmail(email));
        System.out.println("삭제된 멤버 " +removeMember[0].memberName);
        // 앞으로 땡기기
        for (int i = idx; i < memberList.length-1; i++) {
            memberList[i] = memberList[i+1];
        }

        // 배열 마지막 칸 없애기 // 추가 기능 삭제된 배열 모으기?
        Member[] temp = new Member[memberList.length - 1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = memberList[i];
        }
        memberList = temp;

    }

    // 삭제 시 일정 기간 데이터 보존을 위한 백업용 회원 목록
    void pushRemoveMember(Member member) {
        Member[] temp = new Member[removeMember.length + 1];

        for (int i = 0; i < removeMember.length; i++) {
            temp[i] = removeMember[i];
        }
        temp[temp.length-1] = member;

        removeMember = temp;
        temp = null;


    }


    /**
     * 이메일을 통해 저장된 회원의 인덱스값을 알아내는 메서드
     * @param email : 탐색 대상의 이메일
     * @return : 찾아낸 인덱스, 못찾으면 -1 리턴
     */
    int findIndexByEmail(String email) {
        for (int i = 0; i < memberList.length; i++) {
            if (memberList[i].email.equals(email))
                return i;
        }
        return NOT_FOUND;
    }


    /**
     * 비밀번호를 수정하는 기능
     * @param email : 수정 대상의 이메일
     * @param newPassword : 변경할 새로운 비밀번호
     */
    boolean changePassword(String email, String newPassword) {

        // 인덱스 탐색
        int index = findIndexByEmail(email);

        if (index == NOT_FOUND) return false;

        //수정 진행
        memberList[index].password = newPassword;
        return true;

    }

    // 멤버가 비었는지 확인
    boolean isEmpty() {
        return memberList.length == 0;
    }

}



















