#include <iostream>
#include <cstdlib>

int gamesLeft[5][5];
int playGame(team1, team2) {
	
}

int main() {
	
	// i follow the vegetable garden
	
	gamesLeft[1][2] = 1;
	gamesLeft[1][3] = 1;
	gamesLeft[1][4] = 1;
	gamesLeft[2][3] = 1;
	gamesLeft[2][4] = 1;
	gamesLeft[3][4] = 1;

	int t, g;
	std::cin >> t;
	std::cin >> g;
	int a, b, sa, sb;
	for (int i = 0; i < g, i++) {
		scanf(" %d%d%d%d", &a, &b, &sa, &sb);
		gamesLeft[a][b] = 0; 
	}
	for (int i = 1; i < 4; i++) {
		for (int j = 1; j < 5; j++) {
			if (gamesLeft[i][j] = 1) {
				
			}
		}
	}
	
}
