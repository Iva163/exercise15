package ru.netology.manager;

import ru.netology.domain.Ticket;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.matches(from, to)) {
            return true;
        } else {
            return false;
        }
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];

        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }


}
