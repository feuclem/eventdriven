import bus.MessageBus
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class E2ETest {

    private val messageBus = MessageBus()

    private val bookingService = BookingService(messageBus = messageBus)
    private val inventoryService = InventoryService(messageBus = messageBus)
    private val notificationService = NotificationService(messageBus = messageBus)
    private val ticketingService = TicketingService(messageBus = messageBus)

    @Test
    fun `requested successful`() {
        bookingService.book(99)

        assertEquals(inventoryService.totalAvailableSeats, 1)
    }

    @Test
    fun `not enough seats remaining`() {
        bookingService.book(101)

        assertEquals(inventoryService.totalAvailableSeats, 100)
    }
}