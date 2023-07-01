package bus

data class Event(val name: String, val value: Int) {

    companion object {
        const val BOOKING_REQUESTED = "BOOKING_REQUESTED"
        const val ENOUGH_SEATS = "ENOUGH_SEATS"
        const val NOT_ENOUGH_SEATS = "NOT_ENOUGH_SEATS"
    }
}