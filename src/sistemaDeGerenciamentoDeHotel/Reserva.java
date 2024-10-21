package sistemaDeGerenciamentoDeHotel;

import java.time.LocalDate;

public class Reserva {
    private String nomeHospede;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;
    private int numeroQuartos;
    private String tipoQuarto;

    public Reserva(String nomeHospede, LocalDate dataCheckIn, LocalDate dataCheckOut, int numeroQuartos, String tipoQuarto) {
        this.nomeHospede = nomeHospede;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.numeroQuartos = numeroQuartos;
        this.tipoQuarto = tipoQuarto;
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public LocalDate getDataCheckIn() {
        return dataCheckIn;
    }

    public LocalDate getDataCheckOut() {
        return dataCheckOut;
    }

    public int getNumeroQuartos() {
        return numeroQuartos;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }
}
