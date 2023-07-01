class BookingService(
    private val orchestratorService: OrchestratorService,
) {

    fun book(numberOfSeats: Int): Boolean {
        println("booking requested")
        return orchestratorService.handle(numberOfSeats)
    }

}