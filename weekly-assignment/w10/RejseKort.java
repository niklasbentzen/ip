public class RejseKort {
    int balance;
    boolean checkedIn;
    int checkedInTimeStamp;
    int maxX;
    int minX;
    int maxY;
    int minY;

    public RejseKort() {
        this.balance = 100;
        this.checkedIn = false;
    }

    public void depositMoney(int dkk) {
        if (dkk >= 0) {
            balance += dkk;
            System.out.println(dkk + " DKK deposited. New balance: " + balance + " DKK");
        } else {
            System.out.println("Error: Cannot deposit negative amount");
        }
    }

    public boolean isCheckedIn(int timeStamp) {
        return getTimeSinceLastCheckIn(timeStamp) >= 0 && getTimeSinceLastCheckIn(timeStamp) <= 120 && checkedIn;
    }

    public void checkIn(int x, int y, int timeStamp) {
        if (balance >= 100) {
            if (isCheckedIn(timeStamp)) {
                System.out.println("Continued journey (" + getTimeSinceLastCheckIn(timeStamp) + " minutes since last check in)");
            } else {
                checkedIn = true;
                maxX = x; minX = x; maxY = y; minY = y;
                System.out.println("Checked in");
            }
            checkedInTimeStamp = timeStamp;
            setXY(x, y);
        } else {
            // not enough money in balance, less than 100
            int neededMoney = 100 - balance;
            System.out.println("Not enough money in account to check in. " +
                    "Please deposit at least " + neededMoney + " DKK");
        }
    }
    public void checkOut(int x, int y, int timeStamp) {

        setXY(x, y);
        int price = 12 + ((maxX - minX + maxY - minY)*3);
        if (price < 12) price = 12;
        else if (price > 50) price = 50;

        if (checkedIn && isCheckedIn(timeStamp)) {
            balance -= price; //calculating new balance
            checkedIn = false;

            maxX = 0; minX = 0; maxY = 0; minY = 0;

            System.out.println("Checked out! " +
                    getTimeSinceLastCheckIn(timeStamp) + " minutes since last check in. " +
                    "Price is " + price + " DKK, " +
                    "remaining balance is " + balance + " DKK");
        } else System.out.println("Error: Cannot check out; Not currently checked in");
    }

    private void setXY(int x, int y) {
        if (maxX < x) maxX = x;
        if (minX > x) minX = x;
        if (maxY < y) maxY = y;
        if (minY > y) minY = y;
    }

    private int getTimeSinceLastCheckIn(int timeStamp) {
        return timeStamp - checkedInTimeStamp;
    }
}
