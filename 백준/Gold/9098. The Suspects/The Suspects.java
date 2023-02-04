import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] root, size;

    static int find(int x) {
        if(root[x]!=x)
            root[x] = find(root[x]);
        return root[x];
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x==y)
            return;
        if(x<y){
            root[y] = x;
            size[x]+=size[y];
        }
        else {
            root[x] = y;
            size[y]+=size[x];
        }
    }

    public static void main(String[] args)  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n,m,k,x,y;

        while(true) {
            st = new StringTokenizer(br.readLine()," ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if(n==0 && m==0)
                break;

            root = new int[n];
            size = new int[n];

            for(int i = 0;i<n;i++) {
                root[i] = i;
                size[i] = 1;
            }

            for(int i = 0;i<m;i++) {
                st = new StringTokenizer(br.readLine()," ");

                k = Integer.parseInt(st.nextToken());
                x = Integer.parseInt(st.nextToken());

                while(--k>0) {
                    y = Integer.parseInt(st.nextToken());
                    union(x,y);
                }
            }

            sb.append(size[0]).append("\n");
        }

        System.out.println(sb.toString());

    }

}