----------------------tworzeie fake api-------------------------

I. zainstalować json-server
w cmd: npm install -g json-server
1. weryfikacja czy jest
w cmd: json-server -v
2. dostępy:
http://localhost:3000
GET /posts
POST /posts
GET /comments?postId=1 itd.

II. tworzenie fake data base
1. w danym folderze uruchomić git bash
2. komenda: npx json-server --watch db.json // ta komenda też uruchamia server gdy db.json już istnieje
- utworzy plik db.json z jakimiś danymi post/comments

-------------------------------dependencje------------------------

import ważnych funkcji

io.restassured.RestAssured.*
io.restassured.matcher.RestAssuredMatchers.*
org.hamcrest.Matchers.*
io.restassured.module.jsv.JsonSchemaValidator.*s

dependencje:

    <dependencies>

        <!-- ta dependencja najlepiej przed junit/testng -->
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>5.5.1</version>
        </dependency>

        <!-- pobieranie danych z json -->
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>json-path</artifactId>
            <version>5.5.1</version>
        </dependency>

        <!-- pobieranie danych z xml -->
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>xml-path</artifactId>
            <version>5.5.1</version>
        </dependency>

        <!-- walidacja czy json odpowiada strukturze json -->
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>json-schema-validator</artifactId>
            <version>5.5.1</version>
        </dependency>

        <!-- generator fake data -->
        <dependency>
             <groupId>com.github.javafaker</groupId>
             <artifactId>javafaker</artifactId>
             <version>1.0.2</version>
        </dependency>

    </dependencies>