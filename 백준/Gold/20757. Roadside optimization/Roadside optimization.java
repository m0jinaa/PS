import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] root;

    static int find(int x) {
        if(root[x]!=x)
            root[x] = find(root[x]);
        return root[x];
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x==y)
            return false;
        if(x<y)
            root[y] = x;
        else 
            root[x] = y;
        return true;
    }

    public static void main(String[] args)  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n,cnt,x,y;
        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            st = new StringTokenizer(br.readLine()," ");
            n = Integer.parseInt(st.nextToken());
            cnt = 0;
            root = new int[n];

            for(int i = 0;i<n;i++) {
                root[i] = i;
            }

            for(int i = 0;i<n;i++) {
                st = new StringTokenizer(br.readLine()," ");

                for(int j = 0;j<n;j++) {
                    x = Integer.parseInt(st.nextToken());
                    if(x==1 && union(i,j))
                        cnt++;

                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb.toString());

    }

}