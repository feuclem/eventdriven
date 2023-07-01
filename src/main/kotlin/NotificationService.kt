import bus.Event
import bus.Listener
import bus.MessageBus

data class NotificationService(
    private val messageBus: MessageBus,
): Listener {

    init {
        messageBus.subscribe(this)
    }

    override fun onMessage(msg: Any) {
        val event: Event = msg as Event
        if (Event.NOT_ENOUGH_SEATS == event.name) {
            notifyBySms()
        }
    }

    private fun notifyBySms() {
        println("problem in your booking")
    }
}