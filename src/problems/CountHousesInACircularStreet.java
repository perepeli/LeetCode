package problems;

interface Street {
    public void openDoor();
    public void closeDoor();
    public boolean isDoorOpen();
    public void moveRight();
    public void moveLeft();
}
public class CountHousesInACircularStreet {

    public int houseCount(Street street, int k) {
        int counter = 0;

        while(counter < k) {
            if(street.isDoorOpen()) {
                street.closeDoor();
                counter = 0;
            } else {
                counter++;
            }
            street.moveRight();
        }

        int result = 0;

        while(!street.isDoorOpen() && result < k) {
            street.openDoor();
            street.moveRight();
            result++;
        }

        return result;
    }
}
