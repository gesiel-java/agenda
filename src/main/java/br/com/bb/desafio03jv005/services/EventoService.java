package br.com.bb.desafio03jv005.services;

import br.com.bb.desafio03jv005.models.Agenda;
import br.com.bb.desafio03jv005.models.Evento;

public class EventoService {
    public void printEvento(Evento evento){
        System.out.println("Local do evento: " + evento.getLocal());
        for (Agenda agenda: evento.getAgenda()) {
            System.out.println(agenda);
        }
    }
}
