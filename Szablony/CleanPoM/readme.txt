@BeforeSuite – uruchamiane raz przed całą suite testów, np. połączenie z bazą danych.
@BeforeTest – uruchamiane przed blokiem testowym w pliku XML, który może zawierać wiele klas.
@BeforeClass – uruchamiane raz przed wszystkimi metodami testowymi w danej klasie.
@BeforeMethod – uruchamiane przed każdą metodą testową oznaczoną jako @Test

Pliki:
I. main:

1. java:
a) paczka dane:
- klasa z danymi
b) paczka pages:
- klasy z page -> elementy i metody
c) paczka settings:
- klasa DriverFactory
- klasa DriverType
- klasa Konfiguracja

d) paczka Tools

2. resources

II. tests:

1. java
a) paczka testów
- klasa test1 (może zawierać w sobie testy)
- klasa test2 (może zawierać w sobie testy)
a) paczka testów
- klasa test1 (może zawierać w sobie testy)
- klasa test2 (może zawierać w sobie testy)

