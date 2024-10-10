#include <stdio.h>
#include <queue>
#include <set>

using namespace std;

long long l, a;
int n, k;
const long long dx[] = {-1, 1}; 
queue<pair<long long, long long>> q; 
set<long long> v; 

bool inRange(long long x) {
    return 0 <= x && x <= l;
}

int main() {
    scanf("%lld%d%d", &l, &n, &k);
    
    for (int i = 0 ; i < n ; i++) {
        scanf("%lld", &a);
        v.insert(a);
        q.push({ a, 0 });
    }
    long long x,d,nx;
    
    while (!q.empty() && k-- > 0) {
        x = q.front().first;
        d = q.front().second;
        q.pop();
       
        printf("%lld\n", d);
        
        for (int i = 0 ; i < 2 ; i++) {
            nx = x + dx[i];
            
            if (inRange(nx) && !v.count(nx)) {
                v.insert(nx);
                q.push({ nx, d + 1 });
            }
        }
    }
}