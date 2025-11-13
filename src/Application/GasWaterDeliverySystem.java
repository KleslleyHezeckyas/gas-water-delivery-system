package Application;

import java.util.Locale;
import java.util.Scanner;
import Entities.Delivery;

public class GasWaterDeliverySystem {

    public static void main (String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Delivery[] entregas = new Delivery[50];
        int cont = 0;

        while(true){
            System.out.println("\n=== SISTEMA DE ENTREGAS DE GÁS E ÁGUA ===");
            System.out.println("1 - Registrar entega (saída)");
            System.out.println("2 - Registrar retorno (quantos gás foram vendidos)");
            System.out.println("3 - Listar entregas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int op = sc.nextInt();
            sc.nextLine();

            if (op == 1){
                System.out.print("Nome do entregador: ");
                String nome = sc.nextLine();
                System.out.print("Quantos gás levou: ");
                int gasLevado = sc.nextInt();
                System.out.println("Quantas águas levou: ");
                int agualevado = sc.nextInt();

                entregas[cont++] = new Delivery(nome, gasLevado, agualevado);
                System.out.println("Saída registrada com sucesso!");
            }else if (op == 2) {
                if (cont == 0) {
                    System.out.println("Nenhuma entrega registrada ainda! ");
                    continue;
                }
                System.out.println("\n--- ENTREGAS REGISTRADAS ---");
                for (int i = 0; i < cont; i++) {
                    System.out.println((i + 1) + ". " + entregas[i].getNome() +
                            " | Gás Levado: " + entregas[i].getGasLevado() +
                            " | Vendido: " + entregas[i].getGasVendido());
                }
                System.out.print("\nInforme o número da entrega para registrar retorno: ");
                int idx = sc.nextInt();

                if (idx <= 0 || idx > cont) {
                    System.out.println("Entrega inválida!");
                    continue;
                }

                Delivery entrega = entregas[idx - 1];

                if (entrega.getGasLevado() >= 10) {
                    System.out.println("Essa entrega já foi marcada como totalemnte vendida (>=10 gás)");
                } else {
                    System.out.print("Quantos gás foram vendidos: ");
                    int vendidos = sc.nextInt();
                    entrega.registrarRetorno(vendidos);
                    System.out.println("Retorno registrado com sucesso");
                }

            }else if (op == 3){
                System.out.println("\n--- LISTA DE ENTREGAS ---");
                for (int i = 0; i < cont; i++){
                    System.out.println((i + 1 ) + ". " + entregas[i]);
                }

            }else if (op == 0){
                System.out.println("Encerrando sistema...");
            }else{
                System.out.println("Opção inválida!");
            }
        }


    }
}