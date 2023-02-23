import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static Food[] foods;
    static int n;
    static class Food implements Comparable<Food>{
        int spicy, sweet;

        public Food(int spicy, int sweet) {
            super();
            this.spicy = spicy;
            this.sweet = sweet;
        }

        @Override
        public int compareTo(Food f) {
            // TODO Auto-generated method stub
            return this.spicy-f.spicy;
        }
    }
    static int getLow(int x) {
        int s = 0;
        int e = n-1;

        int ans=n;
        int m;

        while(s<=e) {
            m = (s+e)/2;
            if(foods[m].spicy>=x) {
                ans = Math.min(ans, m);
                e = m-1;
            }
            else
                s = m+1;
        }
        return ans;
    }

    static int getHigh(int x) {
        int s = 0;
        int e = n-1;

        int ans=-1;
        int m;

        while(s<=e) {
            m = (s+e)/2;
            if(foods[m].spicy<=x) {
                ans = Math.max(ans, m);
                s = m+1;
            }
            else
                e = m-1;
        }
        return ans;
    }

    static int getCnt(int u, int v, int x, int y) {
        int s = getLow(u);
        int e = getHigh(v);
        int cnt = 0;

        for(int i = s;i<=e;i++) {
            if(x<=foods[i].sweet && foods[i].sweet<=y) {
                cnt++;
            }
        }

        return cnt;     
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        foods = new Food[n];

        int a,b;

        for(int i = 0;i<n;i++) {
            st = new StringTokenizer(br.readLine()," ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            foods[i] = new Food(a,b);
        }

        Arrays.sort(foods);

        int u,v,x,y;

        for(int i = 0;i<q;i++) {
            st = new StringTokenizer(br.readLine()," ");
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            sb.append(getCnt(u,v,x,y)).append("\n");
        }

        System.out.println(sb.toString());
    }

}