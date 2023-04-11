package day05.member;

import java.time.LocalDate;

// 역할 : 1명의 회원정보를 묶어주는 역할
// Java Bean
public class Member {
    public String email;
    public String password;
    public String memberName;
    public int memberId;
    public Gender gender;
    public int age;

    // 회원가입일
    LocalDate regDate;

    public Member(String email, String password, String memberName, int memberId, Gender gender, int age) {
        this.email = email;
        this.password = password;
        this.memberName = memberName;
        this.memberId = memberId;
        this.gender = gender;
        this.age = age;
    }

    // 회원정보를 문자열로 만들어서 리턴하는 메서드
    public String inform() {
        String convertGender = (gender == Gender.MALE) ? "남성" : "여성";

        return String.format("# %d번 | %s | %s | %s | %d세",
                this.memberId, this.email, this.memberName, convertGender, this.age);
    }

}
