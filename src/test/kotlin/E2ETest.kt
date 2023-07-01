import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse

class E2ETest {

    private val orchestratorService = OrchestratorService(
        inventoryService = InventoryService(),
        ticketingService = TicketingService(),
        notificationService = NotificationService(),
    )

    private val bookingService = BookingService(
        orchestratorService = orchestratorService,
    )

    @Test
    fun `requested successful`() {
        val result = bookingService.book(99)

        assertTrue(result)
    }

    @Test
    fun `not enough seats remaining`() {
        val result = bookingService.book(101)

        assertFalse(result)
    }
}