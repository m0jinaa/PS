import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int ind;
    static HashMap<String, Integer> map;
    static int[] v;
    static ArrayList<Integer>[] troubleWith;
    static LinkedList<Integer> q;

    static int getInd(String x) {
        map.putIfAbsent(x, ind++);

        return map.get(x);
    }

    public static boolean bfs(int x) {
        q.clear();
        q.add(x);
        v[x] = 0;

        int now;

        boolean answer = true;

        end: while (!q.isEmpty()) {
            now = q.poll();

            for (int y : troubleWith[now]) {
                if (v[y] == -1) {
                    v[y] = 1 - v[now];
                    q.add(y);
                } else if (v[y] != 1 - v[now]) {
                    answer = false;
                    break end;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        int n, max, a, b;
        boolean answer;
        map = new HashMap<>();
        q = new LinkedList<>();

        for (int t = 1; t <= tc; t++) {
            n = Integer.parseInt(br.readLine());
            max = 2 * n;

            ind = 1;
            map.clear();
            answer = true;
            v = new int[max + 1];
            troubleWith = new ArrayList[max + 1];

            for (int i = 1; i <= max; i++) {
                troubleWith[i] = new ArrayList<>();
            }

            while (n-- > 0) {
                st = new StringTokenizer(br.readLine(), " ");

                a = getInd(st.nextToken());
                b = getInd(st.nextToken());

                troubleWith[a].add(b);
                troubleWith[b].add(a);

            }

            Arrays.fill(v, -1);

            for (int i = 1; i < ind; i++) {
                if (v[i] == -1 && !bfs(i)) {
                    answer = false;
                    break;
                }
            }

            sb.append("Case #").append(t).append(": ").append(answer ? "Yes\n" : "No\n");
        }

        System.out.print(sb.toString());
    }
}