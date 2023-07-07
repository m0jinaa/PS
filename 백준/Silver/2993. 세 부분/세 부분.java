import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static char[] word;
    static int n;
    static String answer;
    static int[] selected;
    static StringBuilder sb;

    static void assemble(int ind, int s) {
        if (ind == 2) {
            int bef = -1;
            for (int i = 0; i < 3; i++) {
                for (int j = selected[i]; j > bef; j--) {
                    sb.append(word[j]);
                }
                bef = selected[i];
            }
            String w = sb.toString();
            sb.setLength(0);
            answer = answer.compareTo(w) > 0 ? w : answer;
        } else if (s >= n - 1) {
            return;
        } else {
            selected[ind] = s;
            assemble(ind + 1, s + 1);

            assemble(ind, s + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        word = br.readLine().toCharArray();
        n = word.length;

        answer = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        selected = new int[3];
        selected[2] = n - 1;

        assemble(0, 0);

        System.out.println(answer);

    }
}