class InventoryService {

    private var totalAvailableSeats: Int = 100

    fun decrementCapacity(numberOfSeats: Int): Boolean =
        if (numberOfSeats <= totalAvailableSeats) {
            totalAvailableSeats -= numberOfSeats
            true
        } else {
            println("not enough available seats")
            false
        }
}