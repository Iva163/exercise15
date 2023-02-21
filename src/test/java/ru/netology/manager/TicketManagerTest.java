package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.domain.TicketByTimeAscComparator;

public class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager tickets = new TicketManager(repository);

    TicketByTimeAscComparator timeAscComparator = new TicketByTimeAscComparator();

    Ticket ticket1 = new Ticket(11, 3322, "DME", "LED", 110);
    Ticket ticket2 = new Ticket(153, 2817, "DME", "LED", 90);
    Ticket ticket3 = new Ticket(45, 2602, "DME", "LED", 115);
    Ticket ticket4 = new Ticket(22, 3987, "KUF", "SVO", 120);
    Ticket ticket5 = new Ticket(48, 3970, "KUF", "SVO", 110);
    Ticket ticket6 = new Ticket(89, 3570, "KUF", "SVO", 115);
    Ticket ticket7 = new Ticket(449, 2700, "DME", "LED", 100);
    Ticket ticket8 = new Ticket(45, 2701, "DME", "LED", 100);
    Ticket ticket9 = new Ticket(46, 2701, "DME", "LED", 90);

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

    }

    @Test
    public void shouldFindAllC() {

        Ticket[] expected = {ticket2, ticket9, ticket7, ticket8, ticket1, ticket3};
        Ticket[] actual = tickets.findAll("DME", "LED", timeAscComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdC() {
        tickets.removeById(48);

        Ticket[] expected = {ticket6, ticket4};
        Ticket[] actual = tickets.findAll("KUF", "SVO", timeAscComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAll() {

        Ticket[] expected = {ticket3, ticket7, ticket8, ticket9, ticket2, ticket1};
        Ticket[] actual = tickets.findAll("DME", "LED");

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
