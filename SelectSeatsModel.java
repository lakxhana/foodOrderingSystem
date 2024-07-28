public class SelectSeatsModel{
    private boolean[][] seats;

    public SelectSeatsModel(int rows, int cols) {
        seats = new boolean[rows][cols];
    }

    public void bookSeat(int row, int col) {
        seats[row][col] = true;
    }

    public void unbookSeat(int row, int col) {
        seats[row][col] = false;
    }

    public boolean isSeatBooked(int row, int col) {
        return seats[row][col];
    }
}
