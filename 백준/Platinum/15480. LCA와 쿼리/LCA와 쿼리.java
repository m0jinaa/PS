import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    static int n, k;
    static int[][] parent;
    static int[] depth;
    static ArrayList<Integer>[] graph;

    static void dfs(int x, int d) {
        depth[x] = d;

        for (int i : graph[x]) {
            if (depth[i] != 0)
                continue;
            parent[i][0] = x;
            dfs(i, d + 1);
        }
    }

    static void setParent() {
        for (int i = 0; i < k; i++) {
            for (int j = 1; j <= n; j++) {
                if (parent[j][i] != 0 && parent[parent[j][i]][i] != 0) {
                    parent[j][i + 1] = parent[parent[j][i]][i];
                }
            }
        }
    }

    static int lca(int a, int b) {
        if (depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        int v;
        for(int i = k-1;i>=0;i--) {
            v = (int)Math.pow(2, i);
            if(v<=depth[b]-depth[a]) {
                b = parent[b][i];
            }
        }
        if(a==b) {
            return a;
        }

        for(int i = k-1;i>=0;i--) {
            if(parent[a][i]!=parent[b][i]) {

                a = parent[a][i];
                b = parent[b][i];
            }
        }


        return parent[a][0];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        k = (int) Math.ceil(Math.log10(n) / Math.log10(2));
        graph = new ArrayList[n + 1];
        parent = new int[n + 1][k];
        depth = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        int a, b;
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1, 1);

        setParent();

        int m = Integer.parseInt(br.readLine());
        int r,u,v;
        int answer,t;
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine()," ");
            
            r = Integer.parseInt(st.nextToken());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            
            answer = lca(r,v);
            
            t = lca(v,u);
            
            answer = depth[answer]>=depth[t]?answer:t;
            
            t = lca(r,u);
            
            answer = depth[answer]>=depth[t]?answer:t;            
            
            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString());

    }
}