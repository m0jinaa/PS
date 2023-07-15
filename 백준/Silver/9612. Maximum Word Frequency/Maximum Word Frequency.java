import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main{
    static class Word implements Comparable<Word> {
        String w;
        int cnt;

        public Word(String w, int cnt) {
            super();
            this.w = w;
            this.cnt = cnt;
        }

        public void increase() {
            this.cnt++;
        }

        @Override
        public int compareTo(Word word) {
            if (this.cnt != word.cnt) {
                return word.cnt - this.cnt;
            } else {
                return word.w.compareTo(this.w);
            }
        }

        @Override
        public String toString() {
            return w + " " + cnt;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();

        int ind = 0;

        Word[] list = new Word[n];

        String w;

        while (n-- > 0) {
            w = br.readLine();

            if (map.containsKey(w)) {
                list[map.get(w)].increase();
            } else {
                list[ind] = new Word(w, 1);
                map.put(w, ind++);
            }
        }

        Arrays.sort(list, 0, ind);

        System.out.println(list[0].toString());

    }
}