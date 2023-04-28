import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Set<String> dance = new HashSet<>();

        dance.add("ChongChong");

        int n = Integer.parseInt(br.readLine());

        String a, b;

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            a = st.nextToken();
            b = st.nextToken();

            if(dance.contains(a) || dance.contains(b)) {
                dance.add(a);
                dance.add(b);
            }
        }

        System.out.println(dance.size());

    }
}