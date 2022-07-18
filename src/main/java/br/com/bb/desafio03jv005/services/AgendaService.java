package br.com.bb.desafio03jv005.services;

import br.com.bb.desafio03jv005.models.Agenda;
import br.com.bb.desafio03jv005.models.Evento;

import java.time.LocalDate;
import java.time.LocalTime;

public class AgendaService {
    private final LocalDate dataInicio = LocalDate.of(LocalDate.now().getYear(), 07, 20);
    private final LocalDate dataFim = LocalDate.of(LocalDate.now().getYear(), 10, 31);
    private final LocalTime horaInicio = LocalTime.of(10, 00);

    private final int diasProximo = 10;
    private final int horasInicoProximoEventoAMaisQueAnterior = 2;
    private final int horasDuracao = 6;

    public void gerarAgenda(Evento evento) throws CloneNotSupportedException {
        LocalDate data = dataInicio;
        while (data.compareTo(dataFim) <= 0) {
            if(agendaVazia(evento))
                evento.setAgenda(new Agenda(data, horaProximoInicio(evento), horaProximoInicio(evento).plusHours(horasDuracao), evento.getLocal()));
            evento.setAgenda(updateAgenda(getLast(evento).clone(), evento));
            data = dataInicio(evento);
        }
    }

    private LocalTime horaProximoInicio(Evento evento){
        if(agendaVazia(evento)){
            return horaInicio;
        }

        return horaInicioProximo(getLast(evento)).plusHours(horasInicoProximoEventoAMaisQueAnterior);
    }

    private LocalTime horaInicioProximo(Agenda agenda){
        return agenda.getHoraInicio();
    }

    private LocalDate dataInicio(Evento evento){
        if(agendaVazia(evento)){
            return  dataInicio;
        }

        return dataInicioProximo(getLast(evento)).plusDays(diasProximo);
    }

    private LocalDate dataInicioProximo(Agenda agenda){
        return agenda.getData();
    }

    private boolean agendaVazia(Evento evento){
        if(evento.getAgenda().size() == 0)
            return true;
        return false;
    }

    private Agenda getLast(Evento evento){
       return evento.getAgenda().get(evento.getAgenda().size() - 1);
    }

    private Agenda updateAgenda(Agenda agenda, Evento evento){
        agenda.setData(agenda.getData().plusDays(diasProximo));
        agenda.setHoraInicio(agenda.getHoraInicio().plusHours(horasInicoProximoEventoAMaisQueAnterior));
        agenda.setHoraFim(agenda.getHoraFim().plusHours(horasDuracao));
        agenda.gerarCodigoSessao(evento.getLocal());
        return agenda;
    }
}
