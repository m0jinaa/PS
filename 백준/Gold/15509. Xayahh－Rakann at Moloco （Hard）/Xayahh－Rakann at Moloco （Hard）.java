import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int[] root;
    static int[] size;
    static boolean[][] v;
    static int n,k,m;
    
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
        else if(x<y) {
            root[y] = x;
            size[x]+=size[y];
        }
        else {
            root[x] = y;
            size[y]+=size[x];
        }
    }

    public static boolean checkPossible(ArrayList<Integer> list) {

    	Collections.sort(list);
        int w = list.size();
        
        if(w==0 || list.get(0)>k)
            return false;
        
        
        v = new boolean[k+1][2];
        
        Arrays.fill(v[0], true);
        
        v[list.get(0)][0] = true;

        int val;
        for(int i = 1;i<w;i++) {
            val = list.get(i);
            for(int j = 1;j<=k;j++) {
                if(j<val)
                    v[j][i%2] = v[j][1-(i%2)];
                else
                    v[j][i%2] = v[j-val][1-(i%2)]||v[j][1-(i%2)];
            }
            if(v[k][i%2])
                return true;
        }

        return false;

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        root = new int[n+1];
        size = new int[n+1];

        for(int i = 1;i<=n;i++) {
            root[i] = i;
            size[i] = 1;
        }
        int a,b;
        for(int i = 0;i<m;i++) {
            st = new StringTokenizer(br.readLine()," ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            union(a, b);

        }

        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 1;i<=n;i++)
            if(find(i)==i)
                list.add(size[i]);

        System.out.println(checkPossible(list)?"SAFE":"DOOMED");
    }
}