package bus

interface Listener {
    fun onMessage(msg: Any)
}

class MessageBus {
    private val subs: MutableList<Listener> = ArrayList()

    fun subscribe(listener: Listener) {
        subs.add(listener)
    }

    fun send(message: Any) {
        for (listener in subs) {
            listener.onMessage(message)
        }
    }
}