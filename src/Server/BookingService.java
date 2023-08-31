package Servers;

import Interface.BookingInterface;
import Model.Announcements;
import Model.User;

public class BookingService implements BookingInterface {
    private User[] users;
    private Announcements[] announcements;

    public BookingService(Announcements[] announcements, User[] users) {
        this.announcements = announcements;
        this.users = users;
    }
    @Override
    public void unBookAnnouncement(int id, int id1) {
        try {
            for (Announcements announcement : announcements) {
                if (announcement.getId() == id1 && announcement.isBooked()) {
                    for (User user : users) {
                        if (user.getId() == id) {
                            announcement.setBooked(false);
                            System.out.println("Объявление успешно разбронировано: " + announcement);
                            return;
                        }
                    }
                    System.out.println("Пользователь с указанным ID не найден");
                    break;
                }
            }
            throw new Exception("Объявление с данным айди не найдено или не забронировано");
        } catch (Exception e) {
            System.out.println("Произошла ошибка при разбронировании объявления: " + e.getMessage());
            System.out.println();
        }
    }


    @Override
    public void bookAnnouncement(int userId, Long announcementId) {
        try {
            for (Announcements announcement : announcements) {
                if (announcement.getId() == announcementId && !announcement.isBooked()) {
                    for (User user : users) {
                        if (user.getId() == userId) {
                            announcement.setBooked(true);
                            System.out.println("Объявление успешно забронирован: " + announcement);
                            return;
                        }
                    }
                    System.out.println("Пользователь с указанным ID не найден");
                    break;
                }
            }
            throw new Exception( "Объявление с указанным ID не найден или уже забронирован");
        } catch (Exception e) {
            System.out.println("Произошла ошибка при бронировании объявления: " + e.getMessage());
            System.out.println();
        }
    }
}
