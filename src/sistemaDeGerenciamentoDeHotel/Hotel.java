package sistemaDeGerenciamentoDeHotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hotel {
    private List<Quarto> quartos;
    private List<Reserva> reservas;

    public Hotel() {
        quartos = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    public void cadastrarQuarto(int numero, String tipo, double precoDiario) {
        Quarto quarto = new Quarto(numero, tipo, precoDiario);
        quartos.add(quarto);
        System.out.println("Quarto cadastrado com sucesso!");
    }

    public void realizarReserva(String nomeHospede, LocalDate dataCheckIn, LocalDate dataCheckOut, int numeroQuartos, String tipoQuarto) {
        for (Quarto quarto : quartos) {
            if (quarto.getTipo().equals(tipoQuarto) && quarto.isDisponivel()) {
                Reserva reserva = new Reserva(nomeHospede, dataCheckIn, dataCheckOut, numeroQuartos, tipoQuarto);
                reservas.add(reserva);
                quarto.setDisponivel(false);
                System.out.println("Reserva realizada com sucesso!");
                return;
            }
        }
        System.out.println("Não há quartos disponíveis do tipo " + tipoQuarto);
    }

    public void checkIn(int numeroQuarto) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numeroQuarto) {
                if (!quarto.isDisponivel()) {
                    System.out.println("Check-in realizado no quarto " + numeroQuarto);
                    return;
                } else {
                    System.out.println("Quarto está disponível.");
                    return;
                }
            }
        }
        System.out.println("Quarto não encontrado.");
    }

    public void checkOut(int numeroQuarto) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numeroQuarto) {
                quarto.setDisponivel(true);
                System.out.println("Check-out realizado no quarto " + numeroQuarto);
                return;
            }
        }
        System.out.println("Quarto não encontrado.");
    }

    public void relatorioOcupacao() {
        int ocupados = 0;
        for (Quarto quarto : quartos) {
            if (!quarto.isDisponivel()) {
                ocupados++;
            }
        }
        System.out.println("Número de quartos ocupados: " + ocupados);
    }

    public void relatorioHistorico() {
        for (Reserva reserva : reservas) {
            System.out.println("Hospede: " + reserva.getNomeHospede() + ", Tipo de Quarto: " + reserva.getTipoQuarto());
        }
    }

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
			    System.out.println("Escolha uma opção:");
			    System.out.println("1. Cadastrar Quarto");
			    System.out.println("2. Realizar Reserva");
			    System.out.println("3. Check-in");
			    System.out.println("4. Check-out");
			    System.out.println("5. Relatório de Ocupação");
			    System.out.println("6. Relatório de Histórico");
			    System.out.println("0. Sair");
			    int opcao = scanner.nextInt();
			    scanner.nextLine(); 
			    switch (opcao) {
			        case 1:
			            System.out.print("Número do Quarto: ");
			            int numero = scanner.nextInt();
			            scanner.nextLine(); 
			            System.out.print("Tipo do Quarto: ");
			            String tipo = scanner.nextLine();
			            System.out.print("Preço Diário: ");
			            double preco = scanner.nextDouble();
			            hotel.cadastrarQuarto(numero, tipo, preco);
			            break;
			        case 2:
			            System.out.print("Nome do Hóspede: ");
			            String nome = scanner.nextLine();
			            System.out.print("Data de Check-in (YYYY-MM-DD): ");
			            LocalDate checkIn = LocalDate.parse(scanner.nextLine());
			            System.out.print("Data de Check-out (YYYY-MM-DD): ");
			            LocalDate checkOut = LocalDate.parse(scanner.nextLine());
			            System.out.print("Número de Quartos: ");
			            int numQuartos = scanner.nextInt();
			            scanner.nextLine(); 
			            System.out.print("Tipo de Quarto: ");
			            String tipoQuarto = scanner.nextLine();
			            hotel.realizarReserva(nome, checkIn, checkOut, numQuartos, tipoQuarto);
			            break;
			        case 3:
			            System.out.print("Número do Quarto para Check-in: ");
			            int numeroCheckIn = scanner.nextInt();
			            hotel.checkIn(numeroCheckIn);
			            break;
			        case 4:
			            System.out.print("Número do Quarto para Check-out: ");
			            int numeroCheckOut = scanner.nextInt();
			            hotel.checkOut(numeroCheckOut);
			            break;
			        case 5:
			            hotel.relatorioOcupacao();
			            break;
			        case 6:
			            hotel.relatorioHistorico();
			            break;
			        case 0:
			            System.out.println("Saindo...");
			            return;
			        default:
			            System.out.println("Opção inválida.");
			    }
			}
		}
    }
}
