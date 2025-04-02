public class Mapa {

  // zbiór składający się z klucz (unikatowy) + wartość (integer, string)

    public static void main(String[] args) { 

      Map <Integer, String> student = new HashMap<>();
      student.put(1, "Adam");
      student.put(2, "Kasia");
      student.put(3, "Bartek");
      student.remove(1); // usuwa weartość z klucza

      System.out.println (student.get(1)); // pobranie wartości dla klucza
      System.out.println (student.containsKey(1)); // czy zawiera klucz
      System.out.println (student.containsValue("Bartek")); // czy zawiera wartość
      System.out.println (student.isEmpty()); // czy jest puste
      System.out.println (student.size()); // ilość elementów     


      Map <Integer, String> inny = new HashMap<>();
      inny.putAll(student); // dodanie do inny wszystkich elementów student

      for(Integer key : student.keySet()) { // iteracja po całej kolekcji wg klucza
        System.out.println (key); // wypisze klucze
        System.out.println (student.get(key)); // wypisze wartości wg klucza
      }

      
      for(String student : student.values()) { // iteracja po całej kolekcji wg wartości
        System.out.println (student); // wypisze wartości
      }

    }

}
