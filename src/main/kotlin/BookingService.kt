import bus.Event
import bus.Event.Companion.BOOKING_REQUESTED
import bus.MessageBus


class BookingService(
    private val messageBus: MessageBus,
) {

    fun book(numberOfSeats: Int) {
        println("booking requested")
        messageBus.send(message = Event(BOOKING_REQUESTED, numberOfSeats))
    }

}