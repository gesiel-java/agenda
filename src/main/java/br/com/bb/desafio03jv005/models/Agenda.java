package br.com.bb.desafio03jv005.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Agenda implements Cloneable{
    private LocalDate data;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private String numeroSessao;

    public Agenda(LocalDate data, LocalTime horaInicio, LocalTime horaFim, String eventoName) {
        this.data = data;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        gerarCodigoSessao(eventoName);
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }

    public void gerarCodigoSessao(String eventoName){
        this.numeroSessao = sigla(eventoName) + gerarLongTimStamp();
    }

    private Long gerarLongTimStamp(){
        ZoneId zone = ZoneId.of("America/Sao_Paulo");
        LocalDateTime localTime =  LocalDateTime.of(data.getYear(), data.getMonth(), data.getDayOfMonth(), horaInicio.getHour(),
                horaInicio.getMinute(), horaInicio.getSecond());
        return localTime.toEpochSecond(zone.getRules().getOffset(localTime));
    }

    @Override
    public Agenda clone() throws CloneNotSupportedException {
        return (Agenda) super.clone();
    }

    private String dataFormatada(){
        final Locale localeBrasil = new Locale("pt", "BR");
        final DateTimeFormatter dataNascimentoFormatterOut =
                DateTimeFormatter.ofPattern("dd/MM/yyy - EEEE", localeBrasil);
       return dataNascimentoFormatterOut.format(data);

    }

    private String sigla(String eventoNome){
        if(eventoNome.contains(" ")) {
            StringBuilder sigla = new StringBuilder();
            List<String> letras = Arrays.asList(eventoNome.split(" "));
            letras.stream().map(nome -> nome.charAt(0)).forEach(letra -> sigla.append(String.valueOf(letra)));
            return sigla.toString();
        }

        return eventoNome;
    }

    @Override
    public String toString() {
        return "{" +
                "codigoSessao= " + numeroSessao +
                ", data=" + dataFormatada() +
                ", horaInicio=" + horaInicio +
                ", horaFim=" + horaFim +
                '}';
    }
}
