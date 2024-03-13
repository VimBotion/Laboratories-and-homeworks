#include <iostream>
#include <iomanip>
#include <string>

struct City {
    std::string name;
    int cityCode;
};

struct Supplier {
    std::string name;
    std::string address;
    std::string phone;
    int supplierCode;
    int cityCode;
};

struct Article {
    std::string name;
    int minStock;
    int currentStock;
    double price;
    int articleCode;
    int supplierCode;
};

const int MAX_CITIES = 20;
const int MAX_SUPPLIERS = 20;
const int MAX_ARTICLES = 50;

void enterCity(City cities[MAX_CITIES], int &citiesCount);
void enterSuppliers(Supplier suppliers[MAX_SUPPLIERS], int &suppliersCount, City cities[MAX_CITIES], int citiesCount);
void enterArticle(Article articles[MAX_ARTICLES], int &articlesCount, Supplier suppliers[MAX_SUPPLIERS], int suppliersCount);
void registerConsumption(Article articles[MAX_ARTICLES], int articlesCount);
void inquireArticle(Article articles[MAX_ARTICLES], int articlesCount);
void listArticles(Article articles[MAX_ARTICLES], int articlesCount);
void listArticlesBySupplier(Article articles[MAX_ARTICLES], int articlesCount, Supplier suppliers[MAX_SUPPLIERS], int suppliersCount);
void calculateInventoryValue(Article articles[MAX_ARTICLES], int articlesCount);

int main() {
    int citiesCount = 0;
    int suppliersCount = 0;
    int articlesCount = 0;

    City cities[MAX_CITIES];
    Supplier suppliers[MAX_SUPPLIERS];
    Article articles[MAX_ARTICLES];

    int option;
    do {
        std::cout << "\t MENU\n";
        std::cout << "1. Enter City\n";
        std::cout << "2. Enter Suppliers\n";
        std::cout << "3. Enter Articles\n";
        std::cout << "4. Register Consumption of an Article\n";
        std::cout << "5. Inquire Articles\n";
        std::cout << "6. List of Articles\n";
        std::cout << "7. List of Articles by Supplier\n";
        std::cout << "8. Inventory Value\n";
        std::cout << "9. Exit\n";

        std::cin >> option;

        switch (option) {
            case 1:
                enterCity(cities, citiesCount);
                break;
            case 2:
                enterSuppliers(suppliers, suppliersCount, cities, citiesCount);
                break;
            case 3:
                enterArticle(articles, articlesCount, suppliers, suppliersCount);
                break;
            case 4:
                registerConsumption(articles, articlesCount);
                break;
            case 5:
                inquireArticle(articles, articlesCount);
                break;
            case 6:
                listArticles(articles, articlesCount);
                break;
            case 7:
                listArticlesBySupplier(articles, articlesCount, suppliers, suppliersCount);
                break;
            case 8:
                calculateInventoryValue(articles, articlesCount);
                break;
            case 9:
                std::cout << "Thank you for using the program!\n";
                break;
            default:
                std::cout << "Enter a valid option!\n";
                break;
        }
    } while (option != 9);

    return 0;
}

void enterCity(City cities[MAX_CITIES], int &citiesCount) {
    if (citiesCount < MAX_CITIES) {
        std::string cityName;
        std::cout << "Enter the name of the city: \n";
        std::cin >> cityName;

        bool cityExists = false;
        for (int i = 0; i < citiesCount; ++i) {
            if (cities[i].name == cityName) {
                cityExists = true;
                break;
            }
        }

        if (!cityExists) {
            cities[citiesCount].name = cityName;
            cities[citiesCount].cityCode = citiesCount;
            ++citiesCount;
        } else {
            std::cout << "The city already exists.\n";
        }
    } else {
        std::cout << "The maximum number of cities, " << MAX_CITIES << ", has been reached.\n";
    }
}

void enterSuppliers(Supplier suppliers[MAX_SUPPLIERS], int &suppliersCount, City cities[MAX_CITIES], int citiesCount) {
    if (suppliersCount < MAX_SUPPLIERS) {
        std::string supplierName;
        std::cout << "Enter the name of the supplier:\n";
        std::cin >> supplierName;

        bool supplierExists = false;
        for (int i = 0; i < suppliersCount; ++i) {
            if (suppliers[i].name == supplierName) {
                supplierExists = true;
                break;
            }
        }

        if (!supplierExists) {
            suppliers[suppliersCount].name = supplierName;
            suppliers[suppliersCount].supplierCode = suppliersCount;
            std::cout << "Available Cities:\n";
            for (int i = 0; i < citiesCount; ++i) {
                std::cout << i << ". " << cities[i].name << '\n';
            }
            std::cout << "Select the city code for the supplier:\n";
            std::cin >> suppliers[suppliersCount].cityCode;
            ++suppliersCount;
        } else {
            std::cout << "The supplier already exists.\n";
        }
    } else {
        std::cout << "The maximum number of suppliers, " << MAX_SUPPLIERS << ", has been reached.\n";
    }
}

void enterArticle(Article articles[MAX_ARTICLES], int &articlesCount, Supplier suppliers[MAX_SUPPLIERS], int suppliersCount) {
    if (articlesCount < MAX_ARTICLES) {
        std::string articleName;
        std::cout << "Enter the name of the article: \n";
        std::cin >> articleName;

        bool articleExists = false;
        for (int i = 0; i < articlesCount; ++i) {
            if (articles[i].name == articleName) {
                articleExists = true;
                break;
            }
        }

        if (!articleExists) {
            articles[articlesCount].name = articleName;
            std::cout << "Available Suppliers:\n";
            for (int i = 0; i < suppliersCount; ++i) {
                std::cout << i << ". " << suppliers[i].name << '\n';
            }
            std::cout << "Select the supplier code for the article:\n";
            std::cin >> articles[articlesCount].supplierCode;
            do {
                std::cout << "Enter the minimum stock of the article: \n";
                std::cin >> articles[articlesCount].minStock;
                std::cout << "Enter the current stock of the article: \n";
                std::cin >> articles[articlesCount].currentStock;
                std::cout << "Enter the price of the article: \n";
                std::cin >> articles[articlesCount].price;
            } while (articles[articlesCount].minStock < 0 || articles[articlesCount].currentStock < 0 || articles[articlesCount].price < 0);

            articles[articlesCount].articleCode = articlesCount;
            ++articlesCount;
        } else {
            std::cout << "The article already exists.\n";
        }
    } else {
        std::cout << "The maximum number of articles, " << MAX_ARTICLES << ", has been reached.\n";
    }
}

void registerConsumption(Article articles[MAX_ARTICLES], int articlesCount) {
    int articleCode;
    int consumedQuantity;
    std::cout << "Enter the article code: \n";
    std::cin >> articleCode;

    int articleIndex = -1;
    for (int i = 0; i < articlesCount; ++i) {
        if (articles[i].articleCode == articleCode) {
            articleIndex = i;
            break;
        }
    }

    if (articleIndex != -1) {
        std::cout << "Enter the consumed quantity: \n";
        std::cin >> consumedQuantity;

        if (consumedQuantity <= articles[articleIndex].currentStock) {
            articles[articleIndex].currentStock -= consumedQuantity;
            std::cout << "Consumption registered successfully.\n";
        } else {
            std::cout << "The consumed quantity exceeds the current stock.\n";
        }
    } else {
        std::cout << "No article found with the provided code.\n";
    }
}

void inquireArticle(Article articles[MAX_ARTICLES], int articlesCount) {
    int articleCode;
    std::cout << "Enter the article code: \n";
    std::cin >> articleCode;

    int articleIndex = -1;
    for (int i = 0; i < articlesCount; ++i) {
        if (articles[i].articleCode == articleCode) {
            articleIndex = i;
            break;
        }
    }

    if (articleIndex != -1) {
        std::cout << std::setw(20) << "NAME: " << articles[articleIndex].name << '\n';
        std::cout << std::setw(20) << "MIN STOCK: " << articles[articleIndex].minStock << '\n';
        std::cout << std::setw(20) << "CURRENT STOCK: " << articles[articleIndex].currentStock << '\n';
        std::cout << std::setw(20) << "PRICE: " << articles[articleIndex].price << '\n';
        std::cout << std::setw(20) << "ARTICLE CODE: " << articles[articleIndex].articleCode << '\n';
        std::cout << std::setw(20) << "SUPPLIER CODE: " << articles[articleIndex].supplierCode << '\n';
    } else {
        std::cout << "No article found with the provided code.\n";
    }
}

void listArticles(Article articles[MAX_ARTICLES], int articlesCount) {
    std::cout << "List of Articles:\n";
    for (int i = 0; i < articlesCount; ++i) {
        std::cout << std::setw(20) << "NAME: " << articles[i].name << '\n';
        std::cout << std::setw(20) << "MIN STOCK: " << articles[i].minStock << '\n';
        std::cout << std::setw(20) << "CURRENT STOCK: " << articles[i].currentStock << '\n';
        std::cout << std::setw(20) << "PRICE: " << articles[i].price << '\n';
        std::cout << std::setw(20) << "ARTICLE CODE: " << articles[i].articleCode << '\n';
        std::cout << std::setw(20) << "SUPPLIER CODE: " << articles[i].supplierCode << '\n';

        if (articles[i].currentStock < articles[i].minStock) {
            std::cout << std::setw(20) << "Requires purchase\n";
        }

        std::cout << "--------------------------------------------\n";
    }
}

void listArticlesBySupplier(Article articles[MAX_ARTICLES], int articlesCount, Supplier suppliers[MAX_SUPPLIERS], int suppliersCount) {
    std::cout << "List of Articles by Supplier:\n";
    for (int i = 0; i < suppliersCount; ++i) {
        std::cout << "Supplier: " << suppliers[i].name << '\n';

        for (int j = 0; j < articlesCount; ++j) {
            if (articles[j].supplierCode == i) {
                std::cout << std::setw(20) << "NAME: " << articles[j].name << '\n';
                std::cout << std::setw(20) << "MIN STOCK: " << articles[j].minStock << '\n';
                std::cout << std::setw(20) << "CURRENT STOCK: " << articles[j].currentStock << '\n';
                std::cout << std::setw(20) << "PRICE: " << articles[j].price << '\n';
                std::cout << std::setw(20) << "ARTICLE CODE: " << articles[j].articleCode << '\n';
                std::cout << std::setw(20) << "SUPPLIER CODE: " << articles[j].supplierCode << '\n';

                if (articles[j].currentStock < articles[j].minStock) {
                    std::cout << std::setw(20) << "Requires purchase\n";
                }

                std::cout << "--------------------------------------------\n";
            }
        }
    }
}

void calculateInventoryValue(Article articles[MAX_ARTICLES], int articlesCount) {
    double totalValue = 0.0;
    for (int i = 0; i < articlesCount; ++i) {
        totalValue += articles[i].currentStock * articles[i].price;
    }
    std::cout << "Inventory Value: $" << std::fixed << std::setprecision(2) << totalValue << '\n';
}
