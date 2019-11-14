# include<iostream>
# include<vector>

int main() {
        int numTests;
        std::cin >> numTests;
        for (int i = 0; i < numTests; i++) {
                int numCars;
                int prevCarThrough = 0;
                std::cin >> numCars;
                std::vector<int> lineup1(numCars);
                std::vector<int> lineup2;
                for (int j = 0; j < numCars; j++) {
                        int car;
                        std::cin >> car;
                        lineup1.push_back(car);
                }
                while (lineup1.size() > 0) {
                        if (lineup1.back() == prevCarThrough+1) {
                                prevCarThrough++;
                                lineup1.pop_back();
                        }
                        else if (lineup2.size() > 0 && lineup2.back() == prevCarThrough+1) {
                                lineup2.pop_back();
                                prevCarThrough++;
                        } else {
                                lineup2.push_back(lineup1.back());
                                lineup1.pop_back();
                        }
                }
                while (lineup2.size() > 0) {
                        if (lineup2.back() == prevCarThrough+1) {
                                prevCarThrough++;
                                lineup2.pop_back();
                        } else {
                                break;
                        }

                }
                if (prevCarThrough == numCars) {
                        std::cout << "Y" << std::endl;
                } else {
                        std::cout << "N" << std::endl;
                }

        }

}
