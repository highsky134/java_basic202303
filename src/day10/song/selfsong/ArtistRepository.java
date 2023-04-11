package day10.song.selfsong;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 입력된 것들로 기능을 처리해주는 클래스
public class ArtistRepository {
    // 아티스트를 이름과 노래 목록들로 관리 한다 key, value
    private static Map<String, Artist> artistList;

    static {
        artistList = new HashMap<>();
    }
    // 여기서 내가 간과 했던 부분 기능이 추가하기가 있는데 여기서 추가할때는
    // Artist 객체를 가져와 그곳의 필드에 값을 줘야 하는데
    // 무작정 추가하려 생각해서 어려웠음
    // 객체를 가져오는 함수부터 만드어도 괜찮을듯

    public void addNewSong(String name, String songName) {
        // 여기서 객체를 어쨋든 찾아와야 함 그렇다면?
        // 객체를 만들면서 songList도 초기화함
        // songList가 없어서 추가하기 어려웠는데 Artist 객체를 만들면서 songList도 초기화함으로
        // 객체 생성이 완료되어 getSongList를 쓸수 있게되었음
        Artist artist = new Artist(name, new HashSet<>());
        artist.getSongList().add(songName); // 노래 추가

        artistList.put(name, artist);
    }

    // 기존의 가수에 노래를 추가하는 기능
    public boolean addSong(String name, String songName) {
        Artist artist = findArtistByName(name);

        // add()의 리턴값은 boolean임 중복을 허용하지 않기때문에
        // add를 성공했으면 true 실패했으면 false를 반환함
        return artist.getSongList().add(songName);
    }

    // 가입이 되어있는 가수 인지를 판단하는 기능
    public boolean isRegistered(String name) {
        return artistList.containsKey(name);
    }

    // 이름으로 아티스트 객체를 반환해주는 기능 -> 단순하게 객체를 가오기만 해  굳이 비교를 왜해?
    public Artist findArtistByName(String name) {
        // artistList는 map이고 get(key)의 리턴값 V는 여기서는 Artist객체다
        return artistList.get(name);
    }

    public int count() {
        return artistList.size();
    }

    public Set<String> getSongList(String name) {
        Artist artist = findArtistByName(name);
        return artist.getSongList();
    }
}
