Feature: Hepsiburada UI Testi
  Scenario: Sepete ürün ekleme ve doğrulama
    Given Kullanici Hepsiburada ana sayfasina gider
    When Kullanici Tablet kategorisine gider
    And Kullanici filtreleri uygular
    And Kullanici en yuksek fiyatli urunu secer
    And Kullanici urunu sepete ekler
    Then Kullanici urunun sepete eklendigini dogrular