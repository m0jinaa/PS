import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> locationX = new HashMap<>();
        HashMap<String, Integer> locationY = new HashMap<>();

        String name;
        int x, y;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            name = st.nextToken();
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            locationX.put(name, x);
            locationY.put(name, y);
        }

        st = new StringTokenizer(br.readLine(), " ");

        int befX = -1, befY = -1;

        int answer = 0;
        int dist;

        for (int i = 0; i < n; i++) {
            name = st.nextToken();

            x = locationX.get(name);
            y = locationY.get(name);

            if (i != 0) {
                dist = Math.abs(x - befX) + Math.abs(y - befY);

                answer += dist;
            }

            befX = x;
            befY = y;
        }

        System.out.println(answer);
    }
}