# 💱 Projekt 2: Konwerter Walut (Java Swing)

Aplikacja okienkowa napisana w języku Java, umożliwiająca przeliczanie kwot w PLN na waluty obce: USD, EUR, GBP, HUF, CZK.

---

## 🛠️ Charakterystyka Techniczna

*   **Język programowania:** Java (wersja 21)
*   **Interfejs użytkownika:** Okienkowy (GUI - biblioteka **Swing**)
*   **Elementy obiektowości:** 
    *   Klasa `KonwerterLogika` separująca algorytmy od interfejsu.
    *   **Konstruktor** inicjalizujący mapę kursów walut (`HashMap`).
    *   Metody hermetyzujące proces przeliczania.

---

## 📝 Opis Działania

Program pobiera kwotę w PLN od użytkownika oraz pozwala na wybór docelowej waluty z listy rozwijanej. Po kliknięciu "Przelicz", wynik wyświetlany jest w dolnej części okna.

### Obsługa błędów:
1.  **Błąd twardy (NumberFormatException):** Blok `try-catch` zapobiega awarii programu po wpisaniu tekstu zamiast liczb.
2.  **Błąd miękki (Walidacja):** Program sprawdza, czy wpisana kwota nie jest ujemna. W przypadku błędu wyświetla okno ostrzegawcze `JOptionPane`.

---

## 📸 Przebieg działania

| Scenariusz | Opis |
| :--- | :--- |
| **Prawidłowe obliczenia** | [] |
| **Obsługa błędu (tekst)** | [] |
| **Obsługa błędu (ujemna kwota)** | [] |

---
**Autor:** Kevin Evans
**Termin oddania:** 29 marzec 2026
