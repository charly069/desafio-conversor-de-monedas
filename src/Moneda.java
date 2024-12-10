public record Moneda(String base_code,
                     String target_code,
                     double conversion_rate,
                     double conversion_result) {
//
    @Override
    public String toString() {
        return String.format(
                "\n" +
                        "- Moneda Base: %s\n" +
                        "- Moneda Objetivo: %s\n" +
                        "- Tasa de Conversión: %.4f\n" +
                        "- Resultado de la Conversión: %.2f",
                base_code, target_code, conversion_rate, conversion_result
        );
    }
}


