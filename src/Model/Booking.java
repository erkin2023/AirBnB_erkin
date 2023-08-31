package Model;

public class Booking {
    private User bookdeUser;
    private Announcements annocncement;

    public Booking(User bookdeUser, Announcements annocncement) {
        if (bookdeUser == null) {
            throw new IllegalArgumentException("Booked user cannot be null");
        }
        if (annocncement == null) {
            throw new IllegalArgumentException("Announcement cannot be null");
        }

        this.bookdeUser = bookdeUser;
        this.annocncement = annocncement;
    }


    public User getBookdeUser() {
        return bookdeUser;
    }

    public void setBookdeUser(User bookdeUser) {
        this.bookdeUser = bookdeUser;
    }

    public Announcements getAnnocncement() {
        return annocncement;
    }

    public void setAnnocncement(Announcements annocncement) {
        this.annocncement = annocncement;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookdeUser='" + bookdeUser + '\'' +
                ", annocncement='" + annocncement + '\'' +
                '}';
    }
}

