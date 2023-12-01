#include <iostream>
#include <vector>
#include<algorithm>

using namespace std;

vector<int> parent(1000);

struct path { int a, b, w; };

bool cmp(path x, path y) {
	return x.w > y.w;
}

int find(int x) {
	if (parent[x] == x) return x;
	else return parent[x] = find(parent[x]);
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL), cout.tie(NULL);
	int tc; cin >> tc;

	int N, M, s, t;

	while (tc-- > 0) {
		cin >> N >> M >> s >> t;
		parent.resize(N + 1);

		for (int i = 1; i <= N; i++) parent[i] = i;

		vector<path> paths(M);

		for (int i = 0; i < M; i++)
			cin >> paths[i].a >> paths[i].b >> paths[i].w;

		sort(paths.begin(), paths.end(), cmp);

		for (int i = 0; i < M; i++) {
			int a = paths[i].a, b = paths[i].b, w = paths[i].w;

			if (find(a) != find(b)) parent[find(a)] = find(b);

			if (find(s) == find(t)) {
				cout << w << "\n";
				break;
			}
		}
	}
	
	return 0;
}