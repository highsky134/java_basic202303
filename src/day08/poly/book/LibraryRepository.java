package day08.poly.book;

import day04.array.StringList;
import day05.member.Gender;

import static day08.poly.book.RentStatus.*;
import static juice.Utility.input;
import static juice.Utility.push;

// 도서관리 시스템 데이터 처리
public class LibraryRepository {

    // 회원 1명
    private static BookUser bookUser;

    // 도서들의 정보
    private static Book[] bookList;

    static {
        bookList = new Book[]{
                new CookBook("백종원의 집합", "백종원", "tvN", true),
                new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false),
                new CookBook("최현석 날 따라해밥", "최현석", "소금책", true),
                new CartoonBook("한번 더 해요 두번 더 해요 세번 더 해요", "미티", "원모어", 18),
                new CartoonBook("원펀맨", "One", "대원씨아이", 15),
                new CartoonBook("루피의 원피스", "루피", "japan", 12)
        };
    }

    // 유저를 등록하는 기능
    void register(BookUser userInfo) {
        bookUser = userInfo;
    }

    // 마이페이지 기능
    /*
        여기에 있는 bookUser 정보 리턴
     */
    BookUser findBookUser() {
        return bookUser;
    }

    // 모든 책의 정보를 알려주는 메서드
    public String[] getBookInfoList() {
        String[] infoList = new String[bookList.length];
        for (int i = 0; i < infoList.length; i++) {
            infoList[i] = bookList[i].info();
        }
        return infoList;
    }


    // 검색어를 받으면 해당 검색어를 포함하는 제목을 가진 책 정보들을 반환
    public String[] searchBookInfoList(String keyword) {
        StringList list = new StringList();
        for (Book book : bookList) {
            String title = book.getTitle();
            if (title.contains(keyword)) {
                // 검색어에 걸린 책의 정보 문자열
                String info = book.info();
                list.push(info);
            }
        }
        return list.getsArr();
    }
    public String searchBookAuthor(String inputAuthor) {
        for (Book book : bookList) {
            String author = book.getAuthor();
            if(author.equals(inputAuthor)) {
                return book.info();
            }
        }
        return null;
    }


    // 도서 번호를 받아 해당 도서를 대여해주는 기능
    public RentStatus rentBook(int rentNum) {

        // 대여를 원하는 책 추출
        Book wishBook = bookList[rentNum - 1];

        // 도서 분류 확인
        if (wishBook instanceof CookBook) {
            CookBook cookBook = (CookBook) wishBook; // 다운 캐스팅
            // 쿠폰 유무를 확인
            if (cookBook.isCoupon()) {
                bookUser.setCouponCount(bookUser.getCouponCount()+1);
                return RENT_SUCCESS_WITH_COUPON;
            } else {
                return RENT_SUCCESS;
            }
        } else if (wishBook instanceof CartoonBook) {
            // 연령제한을 확인
            if (bookUser.getAge() >= ((CartoonBook) wishBook).getAccessAge()) {
                // 빌릴 수 있는 경우
                return RENT_SUCCESS;
            } else {
                return RENT_FAIL;
            }
        }
        return RENT_FAIL;


    }
}
