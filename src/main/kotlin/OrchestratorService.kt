data class OrchestratorService(
    private val inventoryService: InventoryService,
    private val ticketingService: TicketingService,
    private val notificationService: NotificationService,
) {

    fun handle(numberOfSeats: Int): Boolean {
        return if (inventoryService.decrementCapacity(numberOfSeats)) {
            ticketingService.printTicket(numberOfSeats)
            true
        } else {
            notificationService.notifyBySms()
            false
        }
    }

}