import bus.Event
import bus.Listener
import bus.MessageBus

data class TicketingService(
    private val messageBus: MessageBus,
): Listener {

    init {
        messageBus.subscribe(this)
    }

    override fun onMessage(msg: Any) {
        val event: Event = msg as Event
        if (Event.ENOUGH_SEATS == event.name) {
            printTicket(event.value)
        }
    }

    private fun printTicket(numberOfSeats: Int) {
        println("$numberOfSeats ticked printed")
    }
}