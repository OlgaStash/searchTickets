package ru.netology.manager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private static Ticket first = new Ticket(1, 2800, "LED", "MOW", 85);
    private static Ticket second = new Ticket(2, 4000, "LED", "MOW", 75);
    private static Ticket third = new Ticket(3, 38000, "VKO", "DJB", 126000);
    private static Ticket fourth = new Ticket(4, 3000, "LED", "MOW", 95);
    private static Ticket five = new Ticket(5, 6000, "LED", "GOJ", 65);
    private static Ticket six = new Ticket(6, 8000, "LED", "IST", 250);

    private static TicketRepository repository = new TicketRepository();
    private static TicketManager manager = new TicketManager(repository);

    @BeforeAll
    public static void sepUpAll() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(five);
        repository.save(six);
        System.out.println(repository);
    }

    @Test
    public void shouldSearchByFromAndTo() {
        Ticket[] actual = manager.searchBy("LED", "MOW");
        Ticket[] expected = {first, second, fourth};
     assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByFromAndToNotExist() {
        Ticket[] actual = manager.searchBy("MOW", "DJB");
        Ticket[] expected = {};
        assertArrayEquals(expected, actual);
    }
}