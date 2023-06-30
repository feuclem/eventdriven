data class BookingService(
    private val inventoryService: InventoryService,
    private val ticketingService: TicketingService,
    private val notificationService: NotificationService,
) {

    fun book(numberOfSeats: Int): Boolean {
        return if (inventoryService.decrementCapacity(numberOfSeats)) {
            println("booking requested")
            ticketingService.printTicket(numberOfSeats)
            true
        } else {
            notificationService.notifyBySms()
            false
        }
    }

}