package Servers;

import Interface.UserIntarface;
import Model.Address;
import Model.Announcements;
import Model.User;

import java.util.Arrays;

public class UserService implements UserIntarface {
    private User[] user;
    private Address[] addresses;
    private Announcements[] announcements;

    public UserService(User[] user, Announcements[] announcements) {
        this.user = user;
        this.announcements = announcements;
    }

    public UserService(Address[] addresses, Announcements[] announcements) {
        this.addresses = addresses;
        this.announcements = announcements;
    }

    @Override
    public void getAllUser() {
        System.out.println(Arrays.toString(user));
    }

    @Override
    public void getAnnouncementsByUserId(int id) {
        for (Announcements a : announcements) {
            for (User u : user) {
                if (a.getOwner().getId() == u.getId() && u.getId() == id) {
                    System.out.println(a);
                }
            }
        }
    }
    @Override
    public void getAnnouncementsByAddress(Address address) {
        for (Announcements a : announcements) {
            if (a.getAddress() != null && a.getAddress().equals(address)) {
                System.out.println(a);
            }
        }
        System.out.println(address);
    }
}
