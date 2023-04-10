package day10.song.selfsong;

import java.util.Set;

import static juice.Utility.input;
import static juice.Utility.makeLine;

public class ArtistView {

    public static ArtistRepository ar;

    static {
        ar = new ArtistRepository();
    }

    public void mainView() {
        System.out.println("\n***** 음악 관리 프로그램 *****\n");
        System.out.printf("# 현재 등록된 가수: %d명\n", ar.count());
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
    // 노래 추가 기능 case 1
    private void insertProcess() {
        System.out.println("\n# 노래 등록을 시작합니다.");
        String name = input("- 가수명: ");
        String songName = input("- 곡명: ");

        // 여기서 신규인지, 기존인지 판단하면 된다니까?
        if (!ar.isRegistered(name)) {
            //신규
            ar.addNewSong(name, songName);
        } else {
            // 기존 노래 추가 여기서 추가된 노래인지를 판단해줘야함
            boolean flag = ar.addSong(name, songName);
            // add의 성공여부로 판단할수 있음
            if (flag) {
                System.out.printf("# %s님의 노래목록에 %s곡이 추가되었습니다", name, songName);
            } else {
                System.out.printf("# [%s]은(는) 이미 등록된 노래입니다", songName);
            }
        }
    }

    // 검색 기능 case 2
    private void searchProcess() {
        // 검색 기능
        // 이름을 입력받아 해당 가수가 있는지 확인하고 그 목록을 보여주면됨
        System.out.println("# 검색할 가수명을 입력하세요.");
        String name = input("- 가수명: ");

        if (ar.isRegistered(name)) {
            // 해당 가수가 가지고있는 Set<String> songList 가져오면됨
            // 근데 여기에 findArtistByName(name)으로 객체를 가져오면 안됨
            // 왜냐? 여기는 입출력을 담당하는 View이기 때문에!
            Set<String> songList = ar.getSongList(name);
            System.out.printf("\n# %s님의 노래 목록\n", name);
            makeLine();
            int i = 1;
            for (String song : songList) {
                System.out.printf("* %d. %s\n",i,song);
                i++;
            }
        } else {
            System.out.println("해당 가수는 존재하지 않습니다.");
        }
    }



    public void start() {

        while (true) {
            mainView();
            selectMenu();
        }
    }
}
