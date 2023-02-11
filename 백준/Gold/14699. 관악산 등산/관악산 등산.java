import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] height = new int[n + 1];

        st = new StringTokenizer(br.readLine(), " ");

        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            height[i] = Integer.parseInt(st.nextToken());
            graph[i] = new ArrayList<Integer>();
        }

        int a,b;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()," ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(height[a]>height[b])
                graph[b].add(a);
            else if(height[b]>height[a])
                graph[a].add(b);
        }

        boolean[] v = new boolean[n+1];

        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0;i<n;i++) {
            arr.add(i+1);
        }

        Collections.sort(arr,new Comparator<Integer>() {

            @Override
            public int compare(Integer a, Integer b) {
                return height[b]-height[a];
            }

        });
        int[] ans = new int[n+1];
        for(int i:arr) {
            for(int j:graph[i]) {
                ans[i] = Math.max(ans[i], ans[j]);
            }
            ans[i]+=1;
        }

        for(int i = 1;i<=n;i++) {
            sb.append(ans[i]).append("\n");
        }

        System.out.println(sb.toString());

    }

}