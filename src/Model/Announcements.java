package Model;

import java.time.LocalDate;

public class Announcements {
    private static int idd = 1;
    private int id;
    private String descripion;
    private LocalDate data;
    private String title;
    private Types types;
    private User owner;
    private boolean isBooked = false;
    private int rating;
    private int price_per_day;
    private Address address;

    public Announcements(String descripion, LocalDate data, String title, Types types, User owner, boolean isBooked, int rating, int price_per_day, Address address) {
        if (descripion == null || descripion.isEmpty()) {
            throw new IllegalArgumentException("Описание не может быть пустым");
        }
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Заголовок не может быть пустым");
        }
        if (owner == null) {
            throw new IllegalArgumentException("Владелец объявления не может быть null");
        }
        if (rating < 0) {
            throw new IllegalArgumentException("Рейтинг должен быть в диапазоне от 1 до 5");
        }
        if (price_per_day <= 0) {
            throw new IllegalArgumentException("Цена за день должна быть положительным числом");
        }

        this.id = idd++;
        this.descripion = descripion;
        this.data = data;
        this.title = title;
        this.types = types;
        this.owner = owner;
        this.isBooked = isBooked;
        this.rating = rating;
        this.price_per_day = price_per_day;
        address.setIdAddress(id);
    }

    public static int getIdd() {
        return idd;
    }

    public static void setIdd(int idd) {
        Announcements.idd = idd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripion() {
        return descripion;
    }

    public void setDescripion(String descripion) {
        this.descripion = descripion;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Types getTypes() {
        return types;
    }

    public void setTypes(Types types) {
        this.types = types;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getPrice_per_day() {
        return price_per_day;
    }

    public void setPrice_per_day(int price_per_day) {
        this.price_per_day = price_per_day;
    }

    @Override
    public String toString() {
        return "\nAnnouncements - " +
                "id: " + id + "\n" +
                "Descripion: " + descripion + "\n" +
                "Data: " + data + "\n" +
                "Title: " + title + "\n" +
                "Types: " + types +
                ", IsBooked: " + isBooked +
                ", Rating: " + rating + "\n" +
                "Owner: " + owner  + "\n" +
                "Price_per_day - " + price_per_day + "\n" +
                "Address: " + address + "\n";
    }
}


