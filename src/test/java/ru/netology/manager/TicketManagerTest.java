package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

public class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager tickets = new TicketManager(repository);

    Ticket ticket1 = new Ticket(11, 3322, "DME", "LED", 100);
    Ticket ticket2 = new Ticket(153, 2817, "DME", "LED", 90);
    Ticket ticket3 = new Ticket(45, 2602, "DME", "LED", 100);
    Ticket ticket4 = new Ticket(22, 3987, "KUF", "SVO", 120);
    Ticket ticket5 = new Ticket(48, 3970, "KUF", "SVO", 110);
    Ticket ticket6 = new Ticket(89, 3570, "KUF", "SVO", 115);
    Ticket ticket7 = new Ticket(449, 2700, "DME", "LED", 100);
    Ticket ticket8 = new Ticket(45, 2701, "DME", "LED", 100);
    Ticket ticket9 = new Ticket(46, 2701, "DME", "LED", 100);
    Ticket ticket10 = new Ticket(156, 3218, "KUF", "LED", 144);

    @BeforeEach
    public void setup() {
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);
        tickets.add(ticket7);
        tickets.add(ticket8);
        tickets.add(ticket9);
        tickets.add(ticket10);

    }

    @Test
    public void shouldFindAll() {
        Ticket[] expected = {ticket3, ticket7, ticket8, ticket9, ticket2, ticket1};
        Ticket[] actual = tickets.findAll("DME", "LED");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllOne() {
        Ticket[] expected = {ticket10};
        Ticket[] actual = tickets.findAll("KUF", "LED");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllNotExist() {
        Ticket[] expected = new Ticket[0];
        Ticket[] actual = tickets.findAll("LED", "DME");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldRemoveById() {
        tickets.removeById(48);

        Ticket[] expected = {ticket6, ticket4};
        Ticket[] actual = tickets.findAll("KUF", "SVO");

        Assertions.assertArrayEquals(expected, actual);
    }


}
