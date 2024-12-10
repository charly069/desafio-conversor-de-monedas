import java.util.ArrayList;
import java.util.List;

public class HistorialConversiones {
    private final List<Moneda> historial;

    public HistorialConversiones() {
        this.historial = new ArrayList<>();
    }

    public void agregarConversion(Moneda moneda) {
        historial.add(moneda);
    }

    public void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("No se han realizado conversiones.");
            return;
        }

        System.out.println("\nHistorial de Conversiones:");
        for (int i = 0; i < historial.size(); i++) {
            System.out.printf("Conversión %d:\n%s\n\n", i + 1, historial.get(i));
        }
    }
}
