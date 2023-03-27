import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static Node[][] parent;
    static int[] depth;
    static ArrayList<Node>[] graph;

    static class Node{
        int x, d;

        public Node(int x, int d) {
            super();
            this.x = x;
            this.d = d;
        }
    }

    static void dfs(int x, int d) {
        depth[x] = d;

        for (Node node : graph[x]) {
            if (depth[node.x] != 0)
                continue;
            parent[node.x][0] = new Node(x,node.d);
            dfs(node.x, d + 1);
        }
    }

    static void setParent() {
        for (int i = 0; i < k; i++) {
            for (int j = 1; j <= n; j++) {
                if (parent[j][i] != null && parent[parent[j][i].x][i] != null) {
                    parent[j][i + 1] = new Node(parent[parent[j][i].x][i].x,parent[j][i].d+parent[parent[j][i].x][i].d);
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

        int answer = 0;
        int v;
        for(int i = k-1;i>=0;i--) {
            v = (int)Math.pow(2, i);
            if(v<=depth[b]-depth[a]) {
                answer+=parent[b][i].d;
                b = parent[b][i].x;
            }
        }
        if(a==b) {
            return answer;
        }

        for(int i = k-1;i>=0;i--) {
            if(parent[a][i]!=null && parent[b][i]!=null &&parent[a][i].x!=parent[b][i].x) {
                answer+= parent[a][i].d+parent[b][i].d;

                a = parent[a][i].x;
                b = parent[b][i].x;
            }
        }

        answer+=parent[a][0].d+parent[b][0].d;

        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        k = (int) Math.ceil(Math.log10(n) / Math.log10(2));
        graph = new ArrayList[n + 1];
        parent = new Node[n + 1][k];
        depth = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Node>();
        }
        int a, b, c;
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b,c));
            graph[b].add(new Node(a,c));
        }

        dfs(1, 1);

        setParent();

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine()," ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            sb.append(lca(a, b)).append("\n");
        }

        System.out.println(sb.toString());

    }
}