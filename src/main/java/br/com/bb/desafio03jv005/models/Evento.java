package br.com.bb.desafio03jv005.models;

import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String Local;
    private List<Agenda> agenda;

    public Evento(String local) {
        Local = local;
        agenda = new ArrayList<Agenda>();
    }

    public String getLocal() {
        return Local;
    }

    public void setLocal(String local) {
        Local = local;
    }

    public List<Agenda> getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda.add(agenda);
    }
}
