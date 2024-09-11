// rozwiązanie problemu z uruchamianiem na chrome

W @BeforeSuite / @Before

    public void start() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
      }
