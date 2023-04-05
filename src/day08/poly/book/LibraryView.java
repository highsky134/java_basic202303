package day08.poly.book;

import day05.member.Gender;

import static day05.member.Gender.*;
import static juice.Utility.input;

public class LibraryView {

    private static LibraryRepository repository;

    // static 데이터는 생성자에서 초기화 하면 안됨
    // static필드의 초기화는 static initializer를 사용
    // 객체를 생성하지 않아도 호출이 가능 하기때문에 프로그램 실행시
    // 자동으로 초기화 해주는 static initializer 사용
    static {
        repository = new LibraryRepository();
    }

    public LibraryView() {
//        this.repository = new LibraryRepository();
    }

    public static void start() {
        makeNewBookUser();

        while (true) {
            showMainScreen();
            selectMenu();
        }
    }

    // 메뉴 번호를 입력받고 분기를 나눠주는 메서드
    private static void selectMenu() {
        String menuNum = input(" - 메뉴 번호: ");
        switch (menuNum) {
            case "1":
                // 마이페이지: 가입한 회원정보 출력
                // 정보내놔
                BookUser user = repository.findBookUser();
                System.out.println("\n ******* 회원 정보 *******");
                System.out.println("# 회원명: "+user.getName());
                System.out.println("# 나이: "+user.getAge());
                System.out.println("# 성별: "+user.getGenderToString());
                System.out.println("# 쿠폰개수: "+user.getCouponCount());
                break;
            case "2":
                String[] infoList = repository.getBookInfoList();
                System.out.println("============ 모든 도서 정보 =============");
                // 디테일 : 책 종류가 몇개인지
                for (int i = 0; i < infoList.length; i++) {
                    String info = infoList[i];
                    System.out.println(info);
                }
                break;
            case "3":
                // 사용자에게 검색어를 입력받는다.
                String keyword = input("\n# 검색어: ");

                // 저장소에게 해당 검색어를 주면서 검색에 걸린 책 정보를 내놓으라고 해야함
                String[] bookInfoList = repository.searchBookInfoList(keyword);
                if (bookInfoList.length > 0) {
                    System.out.printf("\n============ [%s] 검색 결과 =============\n", keyword);
                    for (String info : bookInfoList) {
                        System.out.println(info);
                    }
                } else {
                    System.out.println("# 검색 결과가 없습니다.");
                }
                break;
            case "4":
//              // 대여가능한 도서 목록을 번호와 함께 보여주기
                String[] rentalList = repository.getBookInfoList();
                System.out.println("============ 대여가능 도서 정보 =============");
                int bookNum = 1;
                for (String info : rentalList) {
                    System.out.printf("%d. %s\n", bookNum++, info);
                }

                // 대여할 도서 번호 입력 받기
                int rentNum = Integer.parseInt(input("- 대여할 도서 번호 입력"));
                RentStatus rentStatus = repository.rentBook(rentNum);

                if (rentStatus == RentStatus.RENT_SUCCESS_WITH_COUPON) {
                    System.out.println("# 성공적으로 요리책이 쿠폰발급과 함께 대여되었습니다.");
                } else if (rentStatus == RentStatus.RENT_SUCCESS) {
                    System.out.println("# 도서가 성공적으로 대여되었습니다.");
                } else {
                    System.out.println("# 도서 대여에 실패했습니다.");
                }

                break;
            case "5":
                String inputAuthor = input("# 검색할 저자명 입력: ");
                // 저장소에게 저자명 주면서 검색에 걸린 책 정보를 받아오는 메서드
                // 하나만 검색하는 기능으로 만들어보았음
                String info = repository.searchBookAuthor(inputAuthor);
                if (info != null) {
                    System.out.print("\n============ 검색 결과 =============\n");
                    System.out.println(info);
                } else {
                    System.out.println("해당 저자가 지은 도서가 없습니다.");
                }
                break;
            case "9":
                System.out.println("프로그램을 종료 합니다.");
                System.exit(0);
                break;
            default:
                System.out.println("\n# 메뉴번호를 똑바로 입력하라고~~");
        }
    }

    // 회원정보 입력처리
    private static void makeNewBookUser() {
        System.out.println("# 회원 정보를 입력해주세요.");
        String name = input("# 이름: ");
        int age = Integer.parseInt(input("# 나이: "));
        Gender gender = inputGender();

        // 입력받은 데이터 객체로 포장
        BookUser userInfo = new BookUser(name, age, gender, 0);
        // 입력받은 유저객체를 저장소로 보내기
        repository.register(userInfo);

    }

    // 정확하게 성별을 입력할때 까지 반복 입력 받는 메서드
    private static Gender inputGender() {
        while (true) {
            String inputGender = input("# 성별(M/F): ");
            Gender gender;
            switch (inputGender.toUpperCase().charAt(0)) {
                case 'M':
                    return MALE;
                case 'F':
                    return FEMALE;
                default:
                    System.out.println("\n# 성별을 잘못 입력했습니다.");
            }
        }
    }

    public static void showMainScreen() {
        System.out.println("============= 도서 메뉴 ===============");
        System.out.println("# 1. 마이페이지");
        System.out.println("# 2. 도서 전체 조회");
        System.out.println("# 3. 도서 검색");
        System.out.println("# 4. 도서 대여하기"); // 책 종류 구분 부터 해야됨
        System.out.println("# 5. 도서 저자이름으로 검색");
        System.out.println("# 9. 프로그램 종료하기");

    }

}
