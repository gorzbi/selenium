public class DataProvider {

    @Test (dataProvider = "getData") // nazwa jak nazwa objektu z DataProvider
    public void test(String username, String password) { // przekazujemy parametry jakie mają być wprowadzane
      
      System.out.println("Username to "+username);
      System.out.println("Password to "+password);
        // test uruchomi się tyle razy ile w data provider jest podanych wartości
    }
  
  @DataProvider
  public Object[][] getData() { // jest to tablica dwuwymiarowa nawet gdy ma jeden parametr, w przykładzie są dwa parametry username i password
   return new Object[][] ("user1","pass1"),("user2","pass2"); // ilość różnych przykładów
  }

}
