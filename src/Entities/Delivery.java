
package Entities;

public class Delivery {
    private String nome;
    private int gasLevado;
    private int gasVendido;
    private int aguaLevado;
    private int gasRestante;

    public Delivery(String nome, int gasLevado, int aguaLevado) {
        this.nome = nome;
        this.gasLevado = gasLevado;
        this.aguaLevado = aguaLevado;

        if (gasLevado >= 10) {
            this.gasVendido = gasLevado;
            this.gasRestante = 0;
        } else {
            this.gasVendido = 0;
            this.gasRestante = gasLevado;
        }
    }

    // ======== ADICIONE ESTES MÉTODOS ========

    public String getNome() {
        return nome;
    }

    public int getGasLevado() {
        return gasLevado;
    }

    public int getGasVendido() {
        return gasVendido;
    }

    public int getAguaLevado() {
        return aguaLevado;
    }

    public int getGasRestante() {
        return gasRestante;
    }

    // =========================================

    public void registrarRetorno(int vendidos) {
        if (gasLevado < 10) {
            this.gasVendido = vendidos;
            this.gasRestante = gasLevado - vendidos;
        }
    }

    @Override
    public String toString() {
        return String.format(
                "Entregador: %s | Gás: %d levados, %d vendidos, %d restantes | Água: %d",
                nome, gasLevado, gasVendido, gasRestante, aguaLevado
        );
    }
}
