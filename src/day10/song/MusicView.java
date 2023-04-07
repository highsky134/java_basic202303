package day10.song;

import java.util.Set;

import static juice.Utility.input;
import static juice.Utility.makeLine;

public class MusicView {

    private final static MusicRepo mr;

    static {
        mr = new MusicRepo();
    }
    public void mainView() {
        System.out.println("\n***** 음악 관리 프로그램 *****\n");
        System.out.printf("# 현재 등록된 가수: %d명\n", mr.count());
        System.out.println("# 1. 노래 등록하기");
        System.out.println("# 2. 노래 정보 검색");
        System.out.println("# 3. 프로그램 종료");
        makeLine();

    }
    public void selectMenu() {
        String type = input(">> ");
        switch (type) {
            case "1":
                insertProcess();
                break;
            case "2":
                searchProcess();
                break;
            case "3":
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
                break;
            default:
                System.out.println("번호를 다시 입력해주세요");
        }
    }

    // 1번 메뉴
    public void insertProcess() {
        System.out.println("\n# 노래 등록을 시작합니다.");
        String name = input("- 가수명: ");
        String title = input("- 곡명: ");

        // 신규 가수인 경우
        if (!mr.isRegistered(name)) {
            mr.inputNewSong(name, title);
            System.out.printf("# 아티스트 %s님이 신규 등록되었습니다.\n", name);
        } else { // 기존가수인 경우
            boolean flag = mr.addNewSong(name,title);
            if(flag) {
                System.out.printf("# %s님의 노래목록에 %s곡이 추가 되었습니다.",name, title);
            } else {
                System.out.printf("#[%s]은(는) 이미 등록된 노래입니다.",title);
            }
        }
    }
    // 2번 메뉴
    private void searchProcess() {
        System.out.println("# 검색할 가수명을 입력하세요.");
        String name = input("- 가수명: ");

        if(mr.isRegistered(name)){
            //등록된 경우
            System.out.printf("# %s님의 노래목록\n", name);
            makeLine();
            Set<String> songList = mr.getSongList(name);
            int i = 0;
            for (String song : songList) {
                System.out.printf("* %d. %s\n", i+1, song);
                i++;
            }
        } else {
            System.out.println("# 해당 가수는 등록되지 않았습니다.");
        }
    }

    public void start() {
        while (true) {
            mainView();
            selectMenu();
        }
    }
}
