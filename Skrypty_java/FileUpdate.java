package org.example;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileUpdate {

    public static void main(String[] args) throws IOException {

        String filePath = "text.txt";

        // Tekst, który chcesz dodać do pliku
        String newText = "Nowa linijka tekstu.";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // Dodanie nowej linijki tekstu do pliku
            writer.newLine(); // Dodanie nowej linii po tekście
            writer.write(newText);
            writer.newLine();

            System.out.println("Plik został zaktualizowany pomyślnie.");

        } catch (IOException e) {
            System.err.println("Wystąpił błąd podczas aktualizacji pliku: " + e.getMessage());
        }
    }
}
