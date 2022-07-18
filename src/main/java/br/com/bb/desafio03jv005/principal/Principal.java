package br.com.bb.desafio03jv005.principal;

import br.com.bb.desafio03jv005.models.Evento;
import br.com.bb.desafio03jv005.services.AgendaService;
import br.com.bb.desafio03jv005.services.EventoService;

public class Principal {
    public static void main(String[] args) throws CloneNotSupportedException {
        Evento eventoSP = new Evento("São Paulo");
        Evento eventoParis = new Evento("Paris");
        AgendaService agendaService = new AgendaService();

        agendaService.gerarAgenda(eventoSP);
        agendaService.gerarAgenda(eventoParis);

        EventoService eventoService = new EventoService();

        eventoService.printEvento(eventoSP);
        eventoService.printEvento(eventoParis);
    }
}
