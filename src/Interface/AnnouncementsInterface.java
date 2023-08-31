package Interface;

import Model.Announcements;
import Model.Types;

public interface AnnouncementsInterface {

    void createAnnouncement(Long id, Announcements name);

    //
    void deleteAnnouncementById(Long id);
    void updateAnnouncementById(Long id, Announcements newAnnouncement);
    void getAnnouncementById(Long id);
    void getAllAnnouncements();
    void sortAnnouncementsByRating();
    void sortByPrice();
    void filterByType(Types typesChoice);
}
