import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[] stone = new int[n];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            stone[i] = Integer.parseInt(st.nextToken());
        }

        int s = Integer.parseInt(br.readLine()) - 1;

        boolean[] v = new boolean[n];

        LinkedList<Integer> list = new LinkedList<>();

        list.add(s);

        v[s] = true;
        int now;
        int answer = 1;
        int k, nx;
        while (!list.isEmpty()) {
            now = list.poll();
            nx = now - stone[now];
            if (nx >= 0 && !v[nx]) {
                v[nx] = true;
                answer++;
                list.add(nx);
            }

            nx = now + stone[now];
            if (nx < n && !v[nx]) {
                v[nx] = true;
                answer++;
                list.add(nx);
            }
        }

        System.out.println(answer);
    }
}