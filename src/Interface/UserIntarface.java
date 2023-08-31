package Interface;

import Model.Address;

public interface UserIntarface {
    void getAllUser();

    void getAnnouncementsByUserId(int id);

    void getAnnouncementsByAddress(Address address);
}
