import bus.Event
import bus.Event.Companion.BOOKING_REQUESTED
import bus.Listener
import bus.MessageBus

data class InventoryService(
    private val messageBus: MessageBus,
) : Listener {

    var totalAvailableSeats: Int = 100

    init {
        messageBus.subscribe(this)
    }

    override fun onMessage(msg: Any) {
        val event: Event = msg as Event
        if (BOOKING_REQUESTED == event.name) {
            decrementCapacity(event.value)
        }
    }

    private fun decrementCapacity(numberOfSeats: Int) =
        if (numberOfSeats <= totalAvailableSeats) {
            totalAvailableSeats -= numberOfSeats
            messageBus.send(Event(Event.ENOUGH_SEATS, numberOfSeats))
        } else {
            println("not enough available seats")
            messageBus.send(Event(Event.NOT_ENOUGH_SEATS, numberOfSeats))
        }
}