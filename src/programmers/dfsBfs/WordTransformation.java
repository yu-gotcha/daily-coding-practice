package programmers.dfsBfs;
/* DFS/BFS: 단어 변환 */
public class WordTransformation {
    static int answer = 52;
    public static void main(String[] args) {
        String begin = "hit", target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        String[] words2 = {"hot", "dot", "dog", "lot", "log"};

        System.out.println(solution(begin, target, words2));
    }

    public static int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        dfs(words, 0, begin, target, visited);
        return answer > 51 ? 0: answer;
    }

    public static void dfs(String[] words, int count, String current, String target, boolean[] visited) {
        if(current.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if(!visited[i] && convertable(current, words[i])) {
                visited[i] = true;
                dfs(words, count + 1, words[i], target, visited);
                visited[i] = false;
            }
        }
    }

    public static boolean convertable(String a, String b) {
        int match = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) match++;
        }
        return match == a.length() - 1;
    }
}
