# HepsiburadaProject
Bu proje,  "Cross Browser ve Paralel Koşumlu" testleri içermektedir. Testler, "Chrome ve Firefox" tarayıcılarında çalıştırılabilir ve paralel olarak execute edilebilir.

---

# Proje Yapısı
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── pages
│   │   │   │   ├── HomePage.java
│   │   │   │   ├── CategoryPage.java
│   │   │   │   ├── ProductPage.java
│   │   │   │   ├── CartPage.java
│   │   │   ├── utilities
│   │   │   │   ├── ConfigurationReader.java
│   │   │   │   ├── Driver.java
│   ├── test
│   │   ├── java
│   │   │   ├── tests
│   │   │   │   ├── CrossBrowserTest.java
│   ├── resources
│   │   ├── config.properties
├── pom.xml
└── README.md

pom.xml dosyasında bulunan ana bağımlılıklar şunlardır:

Selenium WebDriver
TestNG
WebDriverManager (Driver yönetimi için)
Cucumber (Opsiyonel)
JUnit (Paralel test desteği için)

