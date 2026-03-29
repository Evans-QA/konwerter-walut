import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

// KLASA LOGIKI (OOP)
class KonwerterLogika {
    private Map<String, Double> kursy;

    public KonwerterLogika() {
        kursy = new HashMap<>();
        // Kursy: ile waluty za 1 PLN
        kursy.put("USD", 0.25);
        kursy.put("EUR", 0.23);
        kursy.put("GBP", 0.20);
        kursy.put("HUF", 90.50);
        kursy.put("CZK", 5.80);
    }

    public double przelicz(double kwotaPln, String waluta) {
        return kwotaPln * kursy.get(waluta);
    }

    public String[] getWaluty() {
        return kursy.keySet().toArray(new String[0]);
    }
}

// KLASA OKNA
public class CurrencyApp extends JFrame {
    private JTextField poleKwoty;
    private JComboBox<String> listaWalut;
    private JLabel wynikLabel;

    public CurrencyApp() {
        KonwerterLogika logika = new KonwerterLogika();

        setTitle("Konwerter Walut PLN");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1, 5, 5));

        add(new JLabel("Kwota w PLN:", SwingConstants.CENTER));
        poleKwoty = new JTextField();
        add(poleKwoty);

        add(new JLabel("Wybierz walutę:", SwingConstants.CENTER));
        listaWalut = new JComboBox<>(logika.getWaluty());
        add(listaWalut);

        JButton przycisk = new JButton("Przelicz");
        wynikLabel = new JLabel("Wynik: -", SwingConstants.CENTER);

        // --- POPRAWIONA OBSŁUGA KLIKNIĘCIA ---
        przycisk.addActionListener(e -> {
            try {
                // 1. Pobieramy tekst i zamieniamy przecinek na kropkę
                String tekst = poleKwoty.getText().replace(",", ".");
                double kwota = Double.parseDouble(tekst);

                // 2. SPRAWDZENIE CZY KWOTA JEST UJEMNA (Walidacja)
                if (kwota < 0) {
                    JOptionPane.showMessageDialog(this,
                            "Błąd: Kwota nie może być ujemna!",
                            "Błędne dane",
                            JOptionPane.WARNING_MESSAGE);
                    return; // Przerywamy działanie metody, nie liczymy dalej
                }

                // 3. Jeśli kwota jest OK, liczymy
                String waluta = (String) listaWalut.getSelectedItem();
                double wynik = logika.przelicz(kwota, waluta);
                wynikLabel.setText(String.format("%.2f PLN = %.2f %s", kwota, wynik, waluta));

            } catch (NumberFormatException ex) {
                // Obsługa błędu twardego (wpisanie liter)
                JOptionPane.showMessageDialog(this,
                        "Błąd: Wpisz poprawną liczbę!",
                        "Błąd formatu",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        add(przycisk);
        add(wynikLabel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CurrencyApp());
    }
}