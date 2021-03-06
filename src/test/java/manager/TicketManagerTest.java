package manager;

import domain.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);
    private Ticket first = new Ticket(1, 2000, "LED", "MOV", 320);
    private Ticket second = new Ticket(2, 3000, "DME", "EGO", 230);
    private Ticket third = new Ticket(3, 2500, "LED", "MOV", 450);
    private Ticket forth = new Ticket(4, 2200, "MOV", "EGO", 200);
    private Ticket fifth = new Ticket(5, 3500, "LED", "MOV", 180);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
    }

    @Test
    public void shouldTicketsFitSearchMoreOne() {
        Ticket[] expected = new Ticket[]{first, third, fifth};
        Ticket[] actual = manager.findAll("LED", "MOV");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTicketsFitSearchNo() {
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.findAll("LED", "DME");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTicketFitSearchOne() {
        Ticket[] expected = new Ticket[]{forth};
        Ticket[] actual = manager.findAll("MOV", "EGO");
        assertArrayEquals(expected, actual);
    }

}