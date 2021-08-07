package programmers.hash;

import java.util.*;
import java.util.stream.Collectors;

/* 베스트 앨범 */
public class BestAlbum {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        ranking(genres, plays);
    }

    public static int[] ranking(String[] genres, int[] plays) {
        Map<String, Integer> genre = new HashMap<>(); // <장르, 재생 횟수>
        List<Music> musicList = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < genres.length; i++) {
            genre.put(genres[i], genre.getOrDefault(genres[i], 0) + plays[i]);
            musicList.add(new Music(i, plays[i], genres[i]));
        }

        // 장르별 랭킹 구하기
        List<Map.Entry<String, Integer>> ranking = new ArrayList<>(genre.entrySet());
        ranking.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        // 곡별 랭킹 구하기
        musicList.sort((a, b) -> Integer.compare(b.play, a.play));
        musicList.sort((a, b) -> String.CASE_INSENSITIVE_ORDER.compare(a.genre, b.genre));
        System.out.println(musicList.stream().map(Music::printMusic).collect(Collectors.toList()));

        while(!ranking.isEmpty()) {
            int count = 0;
            String genreName = ranking.remove(0).getKey();
            System.out.println(genreName);
            for(Music music : musicList) {
                if(music.genre.equals(genreName)) {
                    answer.add(music.id);
                    count++;
                }
                System.out.println(music.printMusic() + ", " + genreName);
                if(count == 2) break;
            }
        }

        System.out.println(Arrays.toString(answer.toArray()));
        return answer.stream().mapToInt(a -> a).toArray();
    }

    static class Music {
        int id;
        int play;
        String genre;

        public Music(int id, int play, String genre) {
            this.id = id;
            this.play = play;
            this.genre = genre;
        }

        public String printMusic() {
            return this.id + " " + this.genre + " " + this.play;
        }
    }
}
