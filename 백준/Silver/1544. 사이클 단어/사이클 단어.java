import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;

        HashSet<String> set = new HashSet<>();

        int n = Integer.parseInt(br.readLine());

        String word;
        int len;
        while(n-->0) {
            word = br.readLine();

            if(set.contains(word))
                continue;
            answer++;

            len = word.length();

            for(int i = 0;i<len;i++) {
                set.add(word.substring(i).concat(word.substring(0, i)));
            }
        }

        System.out.println(answer);
    }

}