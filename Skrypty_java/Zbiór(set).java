public class Zbiór {

    public static void main(String[] args) {

      // zbiór przyjmuje tylko unikatowe wartości, więc nie liczy dublikatów
      Set<String> owoce = new HashSet<>();
      owoce.add("jabłko");
      owoce.add("jabłko"); // drugiego już nie policzy
      owoce.add("granat");

      System.out.println(owoce.contains("jabłko"));
      System.out.println(owoce.size());
      System.out.println(owoce.isEmpty());

      Set<String> wege = new HashSet<>();
      wege.add("pomidor");
      wege.add("burak");

      wege.addAll(owoce); // do tablicy wege doda wszystkie elementy tablicy owoce
    }
}
