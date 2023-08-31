import Interface.BookingInterface;
import Model.Address;
import Model.Announcements;
import Model.Types;
import Model.User;
import Servers.AnnouncementsService;
import Servers.BookingService;
import Servers.UserService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\u001B[32mЗеленый текст\u001B[0m");
        System.out.println("Обычный текст");

        User user1 = new User("Наталия", "Федорова", "natalia@example.com", LocalDate.of(1985, 8, 20));
        User user2 = new User("Алексей", "Иванов", "alex@example.com", LocalDate.of(1992, 4, 12));
        User user3 = new User("Елена", "Смирнова", "elena@example.com", LocalDate.of(1988, 11, 5));
        User user4 = new User("Максим", "Петров", "maxim@example.com", LocalDate.of(1996, 7, 30));
        User user5 = new User("Анна", "Козлова", "anna@example.com", LocalDate.of(1987, 12, 18));

        User[] users = {user1, user2, user3, user4, user5};

        // Address
        Address addressAnnouncements1 = new Address("California", "Los Angeles", "1234 Elm Street");
        Address addressAnnouncements2 = new Address("New York", "Manhattan", "5678 Oak Avenue");
        Address addressAnnouncements3 = new Address("London", "United Kingdom", "9 Primrose Lane");
        Address addressAnnouncements4 = new Address("Paris", "France", "345 Royal Street");
        Address addressAnnouncements5 = new Address("Sydney", "New South Wales", "789 Palm Avenue");
        Address [] addresses ={addressAnnouncements1,addressAnnouncements2,addressAnnouncements3,addressAnnouncements4,addressAnnouncements5};

// Announcements
        Announcements announcement1 = new Announcements("Spacious apartment with a great view",
                LocalDate.of(2023, 3, 1), "Luxury Apartment",
                Types.Apartament, user1, false, 4, 2300, addressAnnouncements1);

        Announcements announcement2 = new Announcements("Cozy house with a garden",
                LocalDate.of(2023, 3, 2), "Charming House",
                Types.House, user2, true, 3, 1800, addressAnnouncements2);

        Announcements announcement3 = new Announcements("Modern apartment in the city center",
                LocalDate.of(2023, 3, 3), "Urban Living",
                Types.Apartament, user3, true, 2, 1900, addressAnnouncements3);

        Announcements announcement4 = new Announcements("Historical mansion with elegant decor",
                LocalDate.of(2023, 3, 4), "Grand Mansion",
                Types.House, user4, false, 10, 850, addressAnnouncements4);

        Announcements announcement5 = new Announcements("Stylish penthouse with a rooftop terrace",
                LocalDate.of(2023, 3, 5), "Penthouse Paradise",
                Types.Apartament, user5, true, 1, 3500, addressAnnouncements5);


        Announcements[] announcements = {announcement1, announcement2, announcement3, announcement4, announcement5};

        System.out.println(Arrays.toString(announcements));
        Scanner scan  = new Scanner(System.in);

        AnnouncementsService announcementsService = new AnnouncementsService(announcements);
        BookingInterface bookingInterface = new BookingService(announcements, users);
        UserService userService = new UserService(users, announcements);
        UserService userService2 = new UserService(addresses, announcements);
        while(true){
            System.out.println("\u001B[32m1. Добавить свое объявление\u001B[0m\n" +
                    "\u001B[32m2. Удалить объявление по его айди\u001B[0m\n" +
                    "\u001B[32m3. Обновление объявление\u001B[0m\n" +
                    "\u001B[32m4. Найти объявление по его айди\u001B[0m\n" +
                    "\u001B[32m5. Получить все объявления\u001B[0m\n" +
                    "\u001B[32m6. Сортировка объявлений по их рейтингам\u001B[0m\n" +
                    "\u001B[32m7. Сортировка объявление по их цене\u001B[0m\n" +
                    "\u001B[32m8. Вывести тип домов по его названию\u001B[0m\n" +
                    "\u001B[32m9. Забронировать дом/квартиру\u001B[0m\n" +
                    "\u001B[32m10. Разбронировать дом/квартиру\u001B[0m\n" +
                    "\u001B[32m11. Вывести всех пользователей\u001B[0m\n" +
                    "\u001B[32m12. Вывести дом/квартиру по айди пользователя\u001B[0m\n" +
                    "\u001B[32m13. Вывести дом/квартиру по его аддресу\u001B[0m");

            int x = scan.nextInt();
            switch (x){
                case 1:
                    System.out.println("Выбрано действие (1)");
                    System.out.println("Чтобы создать новое объявление вам нужно");

                    System.out.print("Напишите ваше описание: ");
                    String decryption = scan.nextLine();
                    scan.next();

                    System.out.print("Напишите ваш титульный лист: ");
                    String titulList = scan.nextLine();
                    scan.next();

                    System.out.print("Напишите тип (Apartment или House): ");
                    String types = scan.next();
                    Types typesChoice = Types.valueOf(types);

                    System.out.print("Введите рейтинг (1 - 5): ");
                    int ratingChoice = scan.nextInt();
                    if(ratingChoice < 1 || ratingChoice > 5){
                        System.out.println("Вы неверно ввели рейтинг");
                        break;
                    }
                    System.out.print("Напишите сумму на день: ");
                    int priceDay = scan.nextInt();

                    System.out.println();
                    System.out.println("Теперь заполните информацию о себе");
                    System.out.print("Напишите ваше имя: ");
                    String nameF = scan.nextLine();
                    scan.next();
                    System.out.print("Напишите вашу фамилию: ");
                    String nameL = scan.nextLine();
                    scan.next();
                    System.out.print("Напишите вашу почту: ");
                    String emailT = scan.next();
                    User userTest = new User(nameF, nameL, emailT, LocalDate.of(1988, 12, 3));

                    Announcements announcementAdd = new Announcements(decryption, LocalDate.now(), titulList,
                            typesChoice, userTest, false,ratingChoice, priceDay, addressAnnouncements5);

                    announcementsService.createAnnouncement(100L, announcementAdd);
                    System.out.println();

                    break;
                case 2:
                    System.out.println("Выбрано действие (2)");

                    System.out.print("Напишите айди: ");
                    long idDel = scan.nextLong();

                    announcementsService.deleteAnnouncementById(idDel);
                    break;
                case 3:
                    System.out.println("Выбрано действие (3)");
                    System.out.println("Чтобы обновить объявление вам нужно");

                    System.out.print("Напишите айди объявления: ");
                    long idUpdate = scan.nextLong();

                    System.out.print("Напишите новый титульный лист: ");
                    String titulNew = scan.next();

                    Announcements announcementTest = new Announcements("Stylish penthouse with a rooftop terrace",
                            LocalDate.of(2023, 3, 5), titulNew,
                            Types.Apartament, user5, true, 1, 3500, addressAnnouncements5);

                    announcementsService.updateAnnouncementById(idUpdate, announcementTest);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Выбрано действие (4)");

                    System.out.print("Напиши айди объявление: ");
                    long idById = scan.nextLong();

                    announcementsService.getAnnouncementById(idById);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Выбрано действие (5)");

                    announcementsService.getAllAnnouncements();

                    System.out.println();
                    break;
                case 6:
                    System.out.println("Выбрано действие (6)");
                    announcementsService.sortAnnouncementsByRating();
                    System.out.println();
                    break;
                case 7:
                    System.out.println("Выбрано действие (7)");

                    announcementsService.sortByPrice();
                    System.out.println();
                    break;
                case 8:
                    System.out.println("Выбрано действие (8)");
                    System.out.print("Напишите тип (Apartment или House): ");
                    String typesE = scan.next();
                    typesChoice = Types.valueOf(typesE);

                    announcementsService.filterByType(typesChoice);
                    System.out.println();
                    break;
                case 9:
                    System.out.println("Выбрано действие (9)");

                    System.out.print("Напишите свой айди чтобы вы могли забронировать: ");
                    int bookedUser = scan.nextInt();

                    System.out.print("Напишите айди, который хотите забронировать: ");
                    long booked = scan.nextInt();

                    bookingInterface.bookAnnouncement(bookedUser, booked);
                    break;
                case 10:
                    System.out.println("Выбрано действие (10");

                    System.out.print("Напишите свой айди чтобы вы могли разбронировать: ");
                    int bookedUser1 = scan.nextInt();

                    System.out.print("Напишите айди, который хотите разбронировать: ");
                    int booked2 = scan.nextInt();

                    bookingInterface.unBookAnnouncement(bookedUser1, booked2);
                    break;
                case 11:
                    System.out.println("Выбрано действие (11)");
                    userService.getAllUser();
                    System.out.println();
                    break;
                case 12:
                    System.out.println("Выбрано действие (12)");
                    System.out.println("Чтобы получить информацию  доме/квартире");

                    System.out.print("Введите айди пользователя: ");
                    int idBadr = scan.nextInt();

                    userService.getAnnouncementsByUserId(idBadr);
                    break;
                case 13:
                    System.out.println("Выбрано действие (13)");
                    System.out.println("Вы получили дом/квартиру которая находится по адресу: " + addressAnnouncements1);
                    userService2.getAnnouncementsByAddress(addressAnnouncements1);
                    break;
            }
        }
    }
}