package Servers;


import Interface.AnnouncementsInterface;
import Model.Announcements;
import Model.Types;

import java.util.Arrays;

public class AnnouncementsService implements AnnouncementsInterface {
    private Announcements[] announcements;

    public AnnouncementsService(Announcements[] announcements) {
        this.announcements = announcements;
    }

    public Announcements[] getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(Announcements[] announcements) {
        this.announcements = announcements;
    }

    @Override
    public void createAnnouncement(Long id, Announcements name) {
        boolean x = false;
        for (Announcements a :announcements) {
            if(a.getId() != id){
                x = true;
                break;
            }
        }
        if(x){
            Announcements[] announcementsBase;
            announcementsBase = Arrays.copyOf(announcements, announcements.length + 1);
            announcementsBase[announcements.length] = name;
            setAnnouncements(announcementsBase);
            System.out.println("Данное объявление успешно выставлено");
        }

        System.out.println("Обновленный список объявлений: " + Arrays.toString(announcements));
    }
    //
    @Override
    public void deleteAnnouncementById(Long id) {
        Announcements[] announcements1 = new Announcements[announcements.length - 1];
        boolean x = false;
        int index = 0;

        for (Announcements announcements2 : announcements) {
            if (announcements2.getId() != id) {
                x = true;
                announcements1[index] = announcements2;
                index++;
            }
        }
        if(x){
            System.out.println("Объявление успешно удалено");
            setAnnouncements(announcements1);
            System.out.println(Arrays.toString(announcements));
        }
    }
    //
    @Override
    public void updateAnnouncementById(Long id, Announcements newAnnouncement) {
        boolean found = false;
        int index = 0;
        for (Announcements a : announcements) {
            if (a.getId() == id) {
                found = true;
                announcements[index] = newAnnouncement;
                System.out.println("Объявление успешно обновлено:\n" + newAnnouncement);
                break;
            }
            index++;
        }

        if (!found) {
            System.out.println("Объявление с указанным ID не найдено.");
        }
    }
    //
    @Override
    public void getAnnouncementById(Long id) {
        boolean x =false;
        for (Announcements announcement : announcements) {
            if (announcement.getId() == id) {
                x = true;
                System.out.println("Объявление успешно найдено: " + announcement);
                break;
            }
        }
        if(x){
            System.out.println("Объявление не найдено");
        }
    }
    //
    @Override
    public void getAllAnnouncements() {
        System.out.println("Все объявления в базе данных: " + Arrays.toString(announcements));
    }
    //
    @Override
    public void sortAnnouncementsByRating() {

        Arrays.sort(announcements, (a2, a1) -> Integer.compare(a1.getRating(), a2.getRating()));

        System.out.println("Объявления, отсортированные по рейтингу (по убыванию):");
        for (Announcements a : announcements) {
            System.out.println(a);
        }
    }
    //
    @Override
    public void sortByPrice() {
        Arrays.sort(announcements, (a1, a2) -> Integer.compare(a1.getPrice_per_day(), a2.getPrice_per_day()));

        System.out.println("Объявления, отсортированные по цене (по возрастанию):");
        for (Announcements a : announcements) {
            System.out.println(a);
        }
    }
    //
    @Override
    public void filterByType(Types typesChoice) {
        for (Announcements a:announcements) {
            if(a.getTypes() == typesChoice){
                System.out.println(a);
            }
        }
    }
}
