#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct statue {
	int q;
	int p;

};

bool compare1(const statue& s1, const statue& s2) {
	if (s1.q == s2.q) {
		return s1.p < s2.p;
	}
	else {
		return s1.q > s2.q;
	}
}

bool compare2(const statue& s1, const statue& s2) {
	if (s1.p == s2.p) {
		return s1.q > s2.q;
	}
	else {
		return s1.p < s2.p;
	}
}
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n; cin >> n;

	vector<statue> quality;
	vector<statue> price;

	int p, q;

	for (int i = 0; i < n; i++) {
		cin >> q >> p;
		quality.push_back({ q,p });
		price.push_back({ q,p });
	}

	sort(quality.begin(), quality.end(), compare1);
	sort(price.begin(), price.end(), compare2);

	cout << quality.at(0).q <<" "<< quality.at(0).p << " " << quality.at(1).q << " " << quality.at(1).p<<"\n";
	cout << price.at(0).q << " " << price.at(0).p << " " << price.at(1).q << " " << price.at(1).p<<"\n";
}