#include <iostream>
#include <cmath>

using namespace std;

#define ll long long

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int t;
	cin >> t;

	ll n;

	int floor;
	ll room;

	while (t-- > 0) {
		cin >> n;

		while (n) {
			floor = (int)ceil(log2(n + 1));
			room = n - ((ll)pow(2, floor - 1) - 1);

			cout << floor;
			cout.width(18);
			cout.fill('0');
			cout<<room<<"\n";

			n /= 2;
		}
	}
	return 0;
}