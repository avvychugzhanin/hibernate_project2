package org.example;

import org.example.hibernate_test.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.mindrot.jbcrypt.BCrypt;

public class Test {
    static int KolvoElementovClassa;
    static int identificator;
    static String password_0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String inputMenu;
        String inputMenu2;

        do {
            System.out.println("Введите:\n1 - для регистрации;\n2 - для авторизации;\n0 - для выхода");
            inputMenu = scanner.nextLine();

            if (inputMenu.equals("1")) {
                System.out.println("Регистрация");
                System.out.println("Для продолжения регистрации нажмите 1, для отказа продолжать регистрацию нажмите любое значение, отличное от 1");

                inputMenu2 = scanner.nextLine();
                if (inputMenu2.equals("1")) {

                    Configuration configuration10 = new Configuration()
                            .addAnnotatedClass(Users.class)
                            .addAnnotatedClass(Product.class)
                            .addAnnotatedClass(Category.class)
                            .addAnnotatedClass(Order.class)
                            .addAnnotatedClass(Status.class);

                    SessionFactory factory10 = configuration10.buildSessionFactory();
                    Session session10 = null;

                    try {
                        session10 = factory10.getCurrentSession();
                        session10.beginTransaction();

                        List<Users> users = new ArrayList<>();

                        users = session10.createQuery("from Users").getResultList();

                        KolvoElementovClassa = users.size();
                        session10.getTransaction().commit();
                    } finally {
                        session10.close();
                        factory10.close();
                    }

                    Configuration configuration20 = new Configuration()
                            .addAnnotatedClass(Users.class)
                            .addAnnotatedClass(Product.class)
                            .addAnnotatedClass(Category.class)
                            .addAnnotatedClass(Order.class)
                            .addAnnotatedClass(Status.class);

                    SessionFactory factory20 = configuration20.buildSessionFactory();
                    Session session20 = null;
                    try {
                        session20 = factory20.getCurrentSession();

                        String a1;
                        String a2;
                        Users user = new Users();
                        do {
                            do {

                                System.out.println("Введите фамилию.  Формат - первая буква - заглавная."); // Формат  первая буква - заглавная

                                while (!user.setSurname(scanner.nextLine())) ;

                                System.out.println("Вы ввели фамилию: " + user.getSurname());
                                System.out.println("Если фамилия введена неправильно - нажмите 0, если все правильно - введите любое значение, отличное от 0");
                                System.out.println("_______________________________________________________________________________");
                                a1 = scanner.nextLine();
                            }
                            while (a1.equals("0"));
                            System.out.println("Фамилия зафиксирована");
                            System.out.println("Зафиксированная фамилия - " + user.getSurname());
                            System.out.println("_______________________________________________________________________________");
//_____________________________________________________________________________________________________________________________
                            do {

                                System.out.println("Введите имя.  Формат - первая буква - заглавная."); // Формат  первая буква - заглавная

                                while (!user.setName(scanner.nextLine())) ;

                                System.out.println("Вы ввели имя: " + user.getName());
                                System.out.println("Если имя введено неправильно - нажмите 0, если все правильно - введите любое значение, отличное от 0");
                                System.out.println("_______________________________________________________________________________");
                                a1 = scanner.nextLine();
                            }
                            while (a1.equals("0"));
                            System.out.println("Имя зафиксировано");
                            System.out.println("Зафиксированная имя - " + user.getName());
                            System.out.println("_______________________________________________________________________________");
//_____________________________________________________________________________________________________________________________
                            do {
                                System.out.println("Введите отчество.  Формат - первая буква - заглавная.");

                                while (!user.setPatronymic(scanner.nextLine())) ;
                                System.out.println("Вы ввели отчество: " + user.getPatronymic());
                                System.out.println("Если отчество введено неправильно - нажмите 0, если все правильно - введите любое значение, отличное от 0");
                                System.out.println("_______________________________________________________________________________");
                                a1 = scanner.nextLine();
                            }
                            while (a1.equals("0"));
                            System.out.println("Отчество зафиксировано");
                            System.out.println("Зафиксированное отчество - " + user.getPatronymic());
                            System.out.println("_______________________________________________________________________________");

//_____________________________________________________________________________________________________________________________
                            do {

                                boolean nonunicemail;

                                do {
                                    nonunicemail = false;

                                    System.out.println("Введите email (значение не может быть пустым)"); // Формат  первая буква - заглавная

                                    while (!user.setEmail(scanner.nextLine().toLowerCase())) ;

                                    Configuration configuration30 = new Configuration()
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);

                                    SessionFactory factory30 = configuration30.buildSessionFactory();

                                    Session session30 = null;
                                    try {
                                        session30 = factory30.getCurrentSession();
                                        session30.beginTransaction();

                                        List<Users> users = new ArrayList<>();

                                        users = session30.createQuery("from Users").getResultList();
                                        for (Users us3 : users) {
                                            if (us3.getEmail().equals(user.getEmail())) {
                                                nonunicemail = true;
                                                System.out.println("Пользователь с таким email уже добавлен. Введите другое значение email ");
                                            }
                                        }
                                        session30.getTransaction().commit();


                                    } finally {
                                        session30.close();
                                        factory30.close();
                                    }
                                }
                                while (nonunicemail);

                                System.out.println("Вы ввели email: " + user.getEmail());

                                System.out.println("Если email введен неправильно - нажмите 0, если все правильно - введите любое значение, отличное от 0");
                                System.out.println("_______________________________________________________________________________");

                                a1 = scanner.nextLine();

                            }
                            while (a1.equals("0"));
                            System.out.println("email зафиксирован");
                            System.out.println("Зафиксированный email - " + user.getEmail());
                            System.out.println("_______________________________________________________________________________");
//_____________________________________________________________________________________________________________________________
                            do {

                                boolean nonunic_telephone_number;

                                do {
                                    nonunic_telephone_number = false;


                                    System.out.println("Введите номер телефона в формате 8-ХХХ-ХХХ-ХХ-ХХ или +7-ХХХ-ХХХ-ХХ-ХХ, значение не может быть пустым");

                                    while (!user.setTelephone_number(scanner.nextLine())) ;


                                    Configuration configuration40 = new Configuration()
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);

                                    SessionFactory factory40 = configuration40.buildSessionFactory();

                                    Session session40 = null;
                                    try {
                                        session40 = factory40.getCurrentSession();
                                        session40.beginTransaction();

                                        List<Users> users = new ArrayList<>();

                                        users = session40.createQuery("from Users").getResultList();
                                        for (Users us3 : users) {
                                            if (us3.getTelephone_number().equals(user.getTelephone_number())) {
                                                nonunic_telephone_number = true;
                                                System.out.println("Пользователь с таким номером телефона уже зарегистрирован. Введите другое значение номера телефона ");
                                            }
                                        }
                                        session40.getTransaction().commit();


                                    } finally {
                                        session40.close();
                                        factory40.close();
                                    }
                                }
                                while (nonunic_telephone_number);
                                System.out.println("Вы ввели номер телефона: " + user.getTelephone_number() + " (если номер телефона был введен в формате 8-ХХХ-ХХХ-ХХ-ХХ, то он преобразован в формат +7-ХХХ-ХХХ-ХХ-ХХ для универсальности)");
                                System.out.println("Если номер телефона введен неправильно - нажмите 0, если все правильно - введите любое значение, отличное от 0");
                                System.out.println("_______________________________________________________________________________");
                                a1 = scanner.nextLine();

                            }
                            while (a1.equals("0"));
                            System.out.println("номер телефона зафиксирован");
                            System.out.println("Зафиксированный номер телефона -" + user.getTelephone_number());
                            System.out.println("_______________________________________________________________________________");


//_____________________________________________________________________________________________________________________________
                            if (KolvoElementovClassa == 0) {
                                user.setRole("администратор");
                            } else {
                                user.setRole("пользователь");
                            }
//_____________________________________________________________________________________________________________________________

                            do {

                                boolean nonuniclogin;

                                do {
                                    nonuniclogin = false;

                                    System.out.println("Введите логин (значение не может быть пустым)");

                                    while (!user.setLogin(scanner.nextLine())) ;

                                    Configuration configuration50 =
                                            new Configuration()
                                                    .addAnnotatedClass(Users.class)
                                                    .addAnnotatedClass(Product.class)
                                                    .addAnnotatedClass(Category.class)
                                                    .addAnnotatedClass(Order.class)
                                                    .addAnnotatedClass(Status.class);

                                    SessionFactory factory50 = configuration50.buildSessionFactory();

                                    Session session50 = null;
                                    try {
                                        session50 = factory50.getCurrentSession();
                                        session50.beginTransaction();

                                        List<Users> users = new ArrayList<>();

                                        users = session50.createQuery("from Users").getResultList();
                                        for (Users us3 : users) {
                                            if (us3.getLogin().equals(user.getLogin())) {
                                                nonuniclogin = true;
                                                System.out.println("Пользователь с таким логином уже добавлен. Введите другое значение логина");
                                            }
                                        }
                                        session50.getTransaction().commit();

                                    } finally {
                                        session50.close();
                                        factory50.close();
                                    }
                                }
                                while (nonuniclogin);

                                System.out.println("Вы ввели login: " + user.getLogin());

                                System.out.println("Если login введен неправильно - нажмите 0, если все правильно - введите любое значение, отличное от 0");
                                System.out.println("_______________________________________________________________________________");
                                a1 = scanner.nextLine();

                            }
                            while (a1.equals("0"));
                            System.out.println("Логин зафиксирован");
                            System.out.println("Зафиксированный логин - " + user.getLogin());
                            System.out.println("_______________________________________________________________________________");
//_____________________________________________________________________________________________________________________________
                            do {

                                System.out.println("Введите пароль");

                                String password100 = scanner.nextLine();
                                password_0 = password100;
                                String salt = BCrypt.gensalt();

                                String hashedPassword = BCrypt.hashpw(password100, salt);

                                while (!user.setPassword(hashedPassword)) ;
                                System.out.println("Вы ввели пароль: " + password_0);
                                System.out.println("Если пароль введен неправильно - нажмите 0, если все правильно - введите любое значение, отличное от 0");
                                System.out.println("_______________________________________________________________________________");
                                a1 = scanner.nextLine();
                            }
                            while (a1.equals("0"));
                            System.out.println("Пароль зафиксирован");

                            System.out.println("_________________________________________________________________________________________________");
//_____________________________________________________________________________________________________________________________
                            System.out.println("_________________________________________________________________________________________________");
                            System.out.println("Итоговая проверка введенных данных регистрации:");
                            System.out.println("Вы ввели фамилию: " + user.getSurname());
                            System.out.println("Вы ввели имя: " + user.getName());
                            System.out.println("Вы ввели отчество: " + user.getPatronymic());
                            System.out.println("Вы ввели номер телефона: " + user.getTelephone_number());
                            System.out.println("Вы ввели адрес электронной почты: " + user.getEmail());
                            System.out.println("Вы ввели login: " + user.getLogin());
                            System.out.println("Вы ввели пароль: " + password_0);

                            System.out.println("Если необходимо откорректировать данные регистрации (есть ошибка) - нажмите 0, если все правильно - введите любое значение, отличное от 0");

                            a2 = scanner.nextLine();
                        }

                        while (a2.equals("0"));

                        System.out.println("_______________________________________________________________________________");
                        System.out.println("Данные о пользователе зафиксированы");
//_____________________________________________________________________________________________________________________________

                        session20.beginTransaction();
                        session20.persist(user);

                        session20.getTransaction().commit();

                        System.out.println("Регистрация пользователя завершена, информация о пользователе записана в базу данных");
                        System.out.println(user);

                    } finally {
                        session20.close();
                        factory20.close();
                    }
                }

//_____________________________________________________________________________________________________________________________
            } else if (inputMenu.equals("2")) {

                System.out.println("Авторизация");

                System.out.println("Для продолжения авторизации нажмите 2, для отказа продолжать авторизацию нажмите любое значение, отличное от 2");

                inputMenu2 = scanner.nextLine();
                if (inputMenu2.equals("2")) {

                    System.out.println("Введите login или email или номер телефона (в формате 8-ХХХ-ХХХ-ХХ-ХХ или +7-ХХХ-ХХХ-ХХ-ХХ)");

                    String login = scanner.nextLine();
                    System.out.println("Вы ввели - " + login);

                    if (login.matches("(\\+7|8)-\\d{3}-\\d{3}-\\d{2}-\\d{2}")) {
                        if (login.length() == 16) {
                            login = login.substring(3);
                        } else if ((login.length() == 15)) {
                            login = login.substring(2);
                        }
                    }

                    System.out.println("Введите пароль");
                    String passwordAuth = scanner.nextLine();

                    Configuration configuration60 = new Configuration()
                            .addAnnotatedClass(Users.class)
                            .addAnnotatedClass(Product.class)
                            .addAnnotatedClass(Category.class)
                            .addAnnotatedClass(Order.class)
                            .addAnnotatedClass(Status.class);

                    SessionFactory factory60 = configuration60.buildSessionFactory();

                    Session session60 = null;
                    try {
                        session60 = factory60.getCurrentSession();
                        session60.beginTransaction();

                        List<Users> users = new ArrayList<>();

                        users = session60.createQuery("from Users").getResultList();
                        if ((findUser1(login, passwordAuth, users)) || (findUser2(login, passwordAuth, users)) || (findUser3(login, passwordAuth, users))) {

                        } else {
                            System.out.println("Вы НЕ АВТОИЗОВАНЫ");
                        }
                        session60.getTransaction().commit();
                    } finally {
                        session60.close();
                        factory60.close();
                    }
                }
            } else if (inputMenu.equals("0")) {
            } else {
                System.out.println("Ни одно из условий не подошло");
            }
        }

        while (!inputMenu.equals("0"));
        System.out.println("Выход из программы осуществлен");

    }

    public static boolean findUser1(String login1, String password, List<Users> users) {


        for (Users us3 : users) {
            if ((us3.getLogin().equals(login1)) && (BCrypt.checkpw(password, us3.getPassword()))) {
                System.out.println("Здравствуйте " + us3.getName() + " " + us3.getSurname() + "! " + "Вы авторизованы. Ваша роль - " + us3.getRole() + ".");

                identificator = us3.getId();
                rabota_autoriz(users);

                return true;
            }
        }
        return false;
    }

    public static boolean findUser2(String email, String password2, List<Users> users) {

        for (Users us3 : users) {
            if ((us3.getEmail().equals(email)) && (BCrypt.checkpw(password2, us3.getPassword()))) {
                System.out.println("Здравствуйте " + us3.getName() + " " + us3.getSurname() + "! " + "Вы авторизованы. Ваша роль - " + us3.getRole() + ".");

                identificator = us3.getId();
                rabota_autoriz(users);

                return true;
            }
        }
        return false;
    }

    public static boolean findUser3(String telephone_number, String password3, List<Users> users) {

        for (Users us3 : users) {
            if ((us3.getTelephone_number().substring(3).equals(telephone_number)) && (BCrypt.checkpw(password3, us3.getPassword()))) {
                System.out.println("Здравствуйте " + us3.getName() + " " + us3.getSurname() + "! " + "Вы авторизованы. Ваша роль - " + us3.getRole() + ".");

                identificator = us3.getId();
                rabota_autoriz(users);

                return true;
            }
        }
        return false;
    }


    public static boolean rabota_autoriz(List<Users> users) {
        Scanner scanner2 = new Scanner(System.in);

        String z;
        for (Users us3 : users) {

            if (us3.getId() == identificator) {
                if (us3.getRole().equals("администратор")) {
                    System.out.println("Для работы в меню администратора нажмите любую цифру, отличную от 0");

                    z = scanner2.nextLine();

                    while (!z.equals("0")) {
                        do {
                            System.out.println("Введите:" +
                                    "\n1 - для просмотра списка всех категорий товаров;" +
                                    "\n2 - для добавление категории товаров;" +
                                    "\n3 - для добавления товара (товар можно добавить, если создана соответствующая категория товаров);" +
                                    "\n4 - для удаления товара по артикулу в списке (со списком товаров (который в т.ч. содержит артикул товара) можно ознакомиться, если нажать 5 в меню администратора);" +
                                    "\n5 - для просмотра информации о всех товарах;" +
                                    "\n6 - для просмотра информации о всех зарегистрированных пользователях;" +
                                    "\n7 - для смены роли пользователю (с информацией о пользователях (в т.ч. о том - у какого пользователя какая роль) можно ознакомиться, если нажать 6 в меню администратора);" +
                                    "\n8 - для просмотра списка заказов;" +
                                    "\n9 - для поиска заказа по номеру;" +
                                    "\n10 - для смены статуса заказа;" +
                                    "\n0 - для выхода из меню администратора");
                            z = scanner2.nextLine();
                            switch (z) {
                                case "1":
                                    Configuration configuration70 = new Configuration()
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);

                                    SessionFactory factory70 = configuration70.buildSessionFactory();

                                    Session session70 = null;

                                    try {
                                        session70 = factory70.getCurrentSession();
                                        session70.beginTransaction();
                                        List<Category> categoryList = new ArrayList<>();

                                        categoryList = session70.createQuery("from Category").getResultList();

                                        for (Category category : categoryList) {
                                            System.out.println(category);
                                        }
                                        session70.getTransaction().commit();

                                        System.out.println("Выше выведена информация о всех категориях товаров из базы данных");
                                    } finally {
                                        session70.close();
                                        factory70.close();
                                    }

                                    break;

                                case "2":

                                    System.out.println("Добавление категории товаров");
                                    Category category = new Category();

                                    String a1;
                                    do {
                                        System.out.println("Введите наименование категории товара");


                                        boolean nonuniclogin;
                                        do {
                                            nonuniclogin = false;

                                            while (!category.setName(scanner2.nextLine())) ;

                                            Configuration configuration80 = new Configuration()
                                                    .addAnnotatedClass(Users.class)
                                                    .addAnnotatedClass(Product.class)
                                                    .addAnnotatedClass(Category.class)
                                                    .addAnnotatedClass(Order.class)
                                                    .addAnnotatedClass(Status.class);

                                            SessionFactory factory80 = configuration80.buildSessionFactory();

                                            Session session80 = null;
                                            try {
                                                session80 = factory80.getCurrentSession();
                                                session80.beginTransaction();

                                                List<Category> categories = new ArrayList<>();

                                                categories = session80.createQuery("from Category").getResultList();
                                                for (Category categ : categories) {
                                                    if (categ.getName().equals(category.getName())) {
                                                        nonuniclogin = true;
                                                        System.out.println("Такая категория товаров уже добавлена. Введите другое значение категории товаров");
                                                    }
                                                }
                                                session80.getTransaction().commit();

                                            } finally {
                                                session80.close();
                                                factory80.close();
                                            }
                                        }
                                        while (nonuniclogin);

                                        System.out.println("Вы ввели наименование категории: " + category.getName());

                                        System.out.println("Если наименование категории введено неправильно - нажмите 0, если все правильно - введите любое значение, отличное от 0");
                                        a1 = scanner2.nextLine();

                                    }
                                    while (a1.equals("0"));
                                    System.out.println("Наименование категории зафиксировано.");
                                    System.out.println("Зафиксированное наименование категории - " + category.getName());


                                    Configuration configuration90 = new Configuration()
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);

                                    SessionFactory factory90 = configuration90.buildSessionFactory();

                                    Session session90 = null;
                                    try {
                                        session90 = factory90.getCurrentSession();

                                        session90.beginTransaction();
                                        session90.persist(category);

                                        session90.getTransaction().commit();


                                    } finally {
                                        session90.close();
                                        factory90.close();
                                    }

                                    break;


                                case "3": // добавление товара

                                    String categor = null;
                                    Product product = new Product();

                                    Configuration configuration100 = new Configuration()
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);

                                    SessionFactory factory100 = configuration100.buildSessionFactory();

                                    Session session100 = null;
                                    String a2;
                                    try {
                                        session100 = factory100.getCurrentSession();
                                        session100.beginTransaction();
                                        do {

                                            Category category1 = null;

                                            Configuration configuration110 = new Configuration()
                                                    .addAnnotatedClass(Users.class)
                                                    .addAnnotatedClass(Product.class)
                                                    .addAnnotatedClass(Category.class)
                                                    .addAnnotatedClass(Order.class)
                                                    .addAnnotatedClass(Status.class);

                                            SessionFactory factory110 = configuration110.buildSessionFactory();

                                            Session session110 = null;
                                            Scanner catego = new Scanner(System.in);
                                            try {
                                                session110 = factory110.getCurrentSession();
                                                session110.beginTransaction();

                                                int value;

                                                do {
                                                    boolean isTrue = false;

                                                    do {
                                                        System.out.println("Введите id категории товара");

                                                        while (!catego.hasNextInt()) { // проверка на тип int
                                                            catego.next();
                                                            System.out.println("Вы ввели не значение типа int, попробуйте еще раз");
                                                        }
                                                        value = catego.nextInt();

                                                        List<Category> categories = session110.createQuery("from Category").getResultList();

                                                        for (Category cat : categories) {
                                                            if (cat.getId() == value) {

                                                                isTrue = true;
                                                            }
                                                            if (isTrue) {

                                                                categor = cat.getName();

                                                                break;
                                                            }
                                                        }
                                                        if (isTrue == false) {
                                                            System.out.println("Отсутствует категория товара с указанным Вами id");
                                                        }
                                                    }

                                                    while (!isTrue);
                                                    category1 = session110.get(Category.class, value);
                                                    System.out.println("Вы ввели значение id = " + value + " ,что соответствует категории - " + categor); // вывод текста если введенное значение соответствует true

                                                    System.out.println("Если значение id введено неправильно - введите 0, иначе введите любое значение целого числа типа int, отличное от 0");
                                                    //проверка на тип "int", если хотим изменить введенное значение
                                                    while (!catego.hasNextInt()) {
                                                        catego.next();
                                                        System.out.println("Вы ввели не значение типа int, попробуйте еще раз");
                                                    }
                                                }
                                                while (catego.nextInt() == 0);

                                                product.setCat(category1);
                                                session110.getTransaction().commit();

                                            } finally {
                                                session110.close();
                                                factory110.close();
                                            }

//________________________________________________________________________________________________________________________________________________________________________________

                                            Scanner vvod_productname = new Scanner(System.in);
                                            do {

                                                System.out.println("Введите наименование товара (формат  - значение не должно быть пустым)"); // Формат  - значение не должно быть пустым

                                                while (!product.setProduct_name(vvod_productname.nextLine())) ;

                                                System.out.println("Вы ввели наименование товара: " + product.getProduct_name());
                                                System.out.println("Если наименование товара введено неправильно - нажмите 0, если все правильно - введите любое значение, отличное от 0");
                                                System.out.println("_______________________________________________________________________________");
                                                a1 = vvod_productname.nextLine();
                                            }
                                            while (a1.equals("0"));
                                            System.out.println("Наименование товара зафиксировано");
                                            System.out.println("Зафиксированное наименование товара - " + product.getProduct_name());
                                            System.out.println("_______________________________________________________________________________");
//__________________________________________________________________________________________________________________________________________________________________________________

                                            Scanner sn = new Scanner(System.in);
                                            String isNull;
                                            do {
                                                do {
                                                    System.out.println("Введите цену товара (значение должно быть положительным и типа double)");
                                                    while (!catego.hasNextDouble()) {
                                                        catego.next();
                                                        System.out.println("Вы ввели не значение типа double, попробуйте еще раз");
                                                    }
                                                }
                                                while (!product.setProduct_price(catego.nextDouble()));

                                                System.out.println("Вы ввели цену: " + product.getProduct_price());
                                                System.out.println("Если цена введена неправильно - нажмите - 0, если все правильно - введите любое значение, отличное от 0");
                                                isNull = sn.nextLine();
                                            }

                                            while (isNull.equals("0"));
                                            System.out.println("Цена товара зафиксирована");
                                            System.out.println("Зафиксированная цена товара - " + product.getProduct_price());
                                            System.out.println("_________________________________________________________________________________________________");

//__________________________________________________________________________________________________________________________________________________________________________________


                                            Scanner inputArticul = new Scanner(System.in);

                                            do {
                                                boolean isUnic = false;

                                                do {
                                                    int count = 0;
                                                    Configuration configuration120 = new Configuration()
                                                            .addAnnotatedClass(Users.class)
                                                            .addAnnotatedClass(Product.class)
                                                            .addAnnotatedClass(Category.class)
                                                            .addAnnotatedClass(Order.class)
                                                            .addAnnotatedClass(Status.class);

                                                    SessionFactory factory120 = configuration120.buildSessionFactory();

                                                    Session session120 = null;

                                                    try {
                                                        session120 = factory120.getCurrentSession();
                                                        session120.beginTransaction();
                                                        System.out.println("Введите артикул товара (формат ввода: первые 2 символа - заглавные буквы, остальные 4 символа - цифры)");


                                                        while (!product.setCode(inputArticul.nextLine())) ;


                                                        List<Product> productList = session120.createQuery("from Product").getResultList();

                                                        for (Product p : productList) {

                                                            if (p.getCode().equals(product.getCode())) {
                                                                count++;
                                                            }
                                                        }
                                                        if (count == 0) {
                                                            isUnic = true;
                                                        }

                                                        if (isUnic == false) {
                                                            System.out.println("Товар с указанным артикулом уже создан. Необходимо ввести другое значение артикула. ");
                                                        } else {
                                                            System.out.println("Вы ввели уникальное значение артикула");
                                                        }
                                                        session120.getTransaction().commit();

                                                    } finally {
                                                        session120.close();
                                                        factory120.close();
                                                    }
                                                }

                                                while (!isUnic);
                                                System.out.println("Вы ввели " + product.getCode());
                                                System.out.println("Если значение введено ошибочно (если необходимо откорректировать значение) - введите 0, если все верно - введите любое значение, отличное от 0");

                                            }
                                            while (inputArticul.nextLine().equals("0"));
                                            System.out.println("Артикул товара зафиксирован");
                                            System.out.println("Зафиксированный артикул товара - " + product.getCode());


                                            System.out.println("______________________________________________________________________________________________________________");
                                            System.out.println("Итоговая проверка введенных данных о товаре:");
                                            System.out.println("Вы ввели категорию товара: - " + categor);
                                            System.out.println("Вы ввели наименование товара: " + product.getProduct_name());
                                            System.out.println("Вы ввели цену: " + product.getProduct_price());
                                            System.out.println("Вы ввели артикул товара: " + product.getCode());

                                            System.out.println("Если необходимо откорректировать данные о товаре (есть ошибка) - нажмите 0, если все правильно - введите любое значение, отличное от 0");
                                            System.out.println("_________________________________________________________________________________________________");

                                            a2 = inputArticul.nextLine();

                                        } while (a2.equals("0"));

                                        System.out.println("_______________________________________________________________________________");
                                        System.out.println("Данные о товаре зафиксированы");

                                        session100.persist(product);
                                        session100.getTransaction().commit();
                                        System.out.println("Регистрация товара завершена, информация о товаре записана в базу данных");

                                    } finally {
                                        session100.close();
                                        factory100.close();
                                    }

                                    break;

                                case "4":

                                    Product product1000 = new Product();

                                    if (!deleteProdArtikul(product1000.getCode())) {
                                        System.out.println("Товара с таким артикулом нет в списке товаров");
                                    }

                                    break;

                                case "5"://информация о всех товарах из базы данных

                                    Configuration configuration130 = new Configuration()
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);

                                    SessionFactory factory130 = configuration130.buildSessionFactory();

                                    Session session130 = null;
                                    try {
                                        session130 = factory130.getCurrentSession();
                                        session130.beginTransaction();
                                        List<Product> productSses = new ArrayList<>();

                                        productSses = session130.createQuery("from Product").getResultList();
                                        for (Product prod2 : productSses) {
                                            System.out.println(prod2);
                                        }
                                        session130.getTransaction().commit();

                                        System.out.println("Выше выведена информация о всех товарах из базы данных");
                                    } finally {
                                        session130.close();
                                        factory130.close();
                                    }

                                    break;

                                case "6":
                                    //  "Информация о зарегистрированных пользователях:"

                                    Configuration configuration140 = new Configuration().
                                            addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);

                                    SessionFactory factory140 = configuration140.buildSessionFactory();

                                    Session session140 = null;
                                    try {
                                        session140 = factory140.getCurrentSession();
                                        session140.beginTransaction();

                                        List<Users> us = new ArrayList<>();
                                        us = session140.createQuery("from Users").getResultList();
                                        for (Users us32 : us) {
                                            System.out.println(us32);
                                        }
                                        session140.getTransaction().commit();

                                        System.out.println("Выше выведена информация о всех зарегистрированных пользователях из базы данных");
                                    } finally {
                                        session140.close();
                                        factory140.close();
                                    }
                                    break;

                                case "7":
                                    System.out.println("Смена роли пользователю: (с информацией о пользователях (в т.ч.о том - у какого пользователя какая роль) можно ознакомиться, если нажать 4 в меню администратора)");
                                    if (!smenaRoli(us3.getId(), us3.getRole(), users)) {
                                        System.out.println("Пользователя с таким id нет среди зарегистрированных пользователей");
                                    }
                                    break;

                                case "8":

                                    Configuration configuration150 = new Configuration()
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);

                                    SessionFactory factory150 = configuration150.buildSessionFactory();

                                    Session session150 = null;
                                    try {
                                        session150 = factory150.getCurrentSession();
                                        session150.beginTransaction();

                                        double price = 0;
                                        List<Order> orderList = new ArrayList<>();
                                        orderList = session150.createQuery("from Order").getResultList();

                                        orderList.sort(new Comparator<Order>() {
                                            @Override
                                            public int compare(Order o1, Order o2) {
                                                return (o1.getdAndT().compareTo(o2.getdAndT())); //Сортировка по дате заказа
                                            }
                                        });

                                        System.out.println("ИНФОРМАЦИЯ ОБО ВСЕХ ЗАКАЗАХ:");
                                        System.out.println();
                                        // Лист, чтобы разместить номера заказов без повтора
                                        LinkedHashSet<String> hashList = new LinkedHashSet<>();
                                        // Получаю номера всех заказов
                                        for (Order o : orderList) {
                                            // Заполняю поэлементно Hash лист
                                            hashList.add(o.getNumber());
                                        }

                                        for (String hl : hashList) {
                                            for (Order order : orderList) {
                                                if (hl.equals(order.getNumber())) {
                                                    System.out.println("Номер заказа: " + order.getNumber());
                                                    System.out.println("Статус заказа: " + order.getStatus());

                                                    DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd.MM.yy, HH:mm");
                                                    String text = dtf1.format(order.getdAndT());
                                                    System.out.println("Дата и время заказа: " + text);
                                                    System.out.println("id заказчика - " + order.getUser().getId() + ", ФИО заказчика - " + order.getUser().getSurname() + " " + order.getUser().getName() + " " + order.getUser().getPatronymic());

                                                    System.out.println("Список товаров заказа:");
                                                    price = 0;
                                                    for (Order order1 : orderList) {
                                                        if (order1.getNumber().equals(hl)) {
                                                            System.out.println("id товара - " + order1.getProduct().getId() + " , артикул товара - " + order1.getProduct().getCode() + ", наименование товара - " + order1.getProduct().getProduct_name() + ", цена товара - " + order1.getProduct().getProduct_price());
                                                            price = order1.getProduct().getProduct_price() + price;
                                                        }
                                                    }

                                                    System.out.println("Итоговая цена заказа: " + price);
                                                    break;
                                                }
                                            }
                                            System.out.println();
                                        }

                                        System.out.println("Итого количество заказов у всех пользователей: " + hashList.size());

                                        session150.getTransaction().commit();

                                    } finally {
                                        session150.close();
                                        factory150.close();
                                    }
                                    System.out.println();

                                    break;

                                case "9":

                                    boolean isorderin = false;
                                    int counterin = 0;

                                    Configuration configuration160 = new Configuration()
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);

                                    SessionFactory factory160 = configuration160.buildSessionFactory();

                                    Session session160 = null;
                                    try {
                                        session160 = factory160.getCurrentSession();
                                        session160.beginTransaction();

                                        double price = 0;
                                        List<Order> orderList = new ArrayList<>();
                                        orderList = session160.createQuery("from Order").getResultList();

                                        System.out.println("Введите символы окончания номера заказа");

                                        String path = scanner2.nextLine();

                                        // Лист, чтобы разместить номера заказов без повтора
                                        HashSet<String> hashList = new HashSet<>();
                                        // Получаю номера всех заказов
                                        for (Order o : orderList) {
                                            // Заполняю поэлементно Hash лист
                                            hashList.add(o.getNumber());
                                        }

                                        for (Order o : orderList) {
                                            if (o.getNumber().endsWith(path)) {
                                                counterin++;
                                            }
                                        }

                                        if (counterin == 0) {
                                            isorderin = false;
                                        } else {
                                            isorderin = true;
                                        }

                                        if (isorderin == false) {
                                            System.out.println("Нет заказов с номером, заканчивающимся на символы " + path);
                                        } else {
                                            for (String hl : hashList) {
                                                for (Order order : orderList) {
                                                    if (hl.equals(order.getNumber()) && hl.endsWith(path)) {
                                                        System.out.println("Номер заказа: " + order.getNumber());
                                                        System.out.println("Статус заказа: " + order.getStatus());

                                                        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd.MM.yy, HH:mm");
                                                        String text = dtf1.format(order.getdAndT());
                                                        System.out.println("Дата и время заказа: " + text);
                                                        System.out.println("id заказчика - " + order.getUser().getId() + ", ФИО заказчика - " + order.getUser().getSurname() + " " + order.getUser().getName() + " " + order.getUser().getPatronymic());

                                                        System.out.println("Список товаров заказа:");
                                                        price = 0;
                                                        for (Order order1 : orderList) {
                                                            if (order1.getNumber().equals(hl)) {
                                                                System.out.println("id товара - " + order1.getProduct().getId() + " , артикул товара - " + order1.getProduct().getCode() + ", наименование товара - " + order1.getProduct().getProduct_name() + ", цена товара - " + order1.getProduct().getProduct_price());
                                                                price = order1.getProduct().getProduct_price() + price;
                                                            }
                                                        }

                                                        System.out.println("Итоговая цена заказа: " + price);
                                                        break;
                                                    }
                                                }
                                            }
                                        }

                                        session160.getTransaction().commit();

                                    } finally {
                                        session160.close();
                                        factory160.close();
                                    }
                                    System.out.println();

                                    break;

                                case "10":

                                    int counter = 0;
                                    String teknumber = null;
                                    boolean sovpadstatus = false;
                                    String temp = null;
                                    Status status = null;
                                    Status tekstatus = null;

                                    Configuration configuration170 = new Configuration()
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);

                                    SessionFactory factory170 = configuration170.buildSessionFactory();

                                    Session session170 = null;
                                    System.out.println("Введите символы окончания номера заказа");

                                    String path = scanner2.nextLine();

                                    String numbstat;
                                    boolean znach = false;
                                    boolean isorder = false;

                                    try {
                                        session170 = factory170.getCurrentSession();
                                        session170.beginTransaction();

                                        List<Order> orderList = new ArrayList<>();
                                        orderList = session170.createQuery("from Order").getResultList();

                                        for (Order o : orderList) {
                                            if (o.getNumber().endsWith(path)) {
                                                tekstatus = o.getStatus();
                                                counter++;
                                            }
                                        }
                                        if (counter != 0) {
                                            isorder = true;
                                        } else {
                                            isorder = false;
                                        }
                                        if (isorder) {
                                            for (Order o : orderList) {
                                                if (o.getNumber().endsWith(path)) {
                                                    teknumber = o.getNumber();
                                                }
                                            }
                                        }

                                        if (isorder == false) {
                                            System.out.println("Нет заказов с номером, заканчивающимся на символы " + path);
                                        }
                                        // Если Правда
                                        else {
                                            System.out.println("Есть заказ с номером, заканчивающимся на символы " + path);
                                            System.out.print("Это заказ с номером " + teknumber);
                                            System.out.println(" и статусом - " + tekstatus);
                                            do {
                                                System.out.println("Для изменения текущего статуса заказа введите кодовое значение нового статуса  (1 - принят, 2 - оформлен, 3 - ожидает или 4 - получен), на который будет изменен текущий статус:");
                                                numbstat = scanner2.nextLine();
                                                if (numbstat.equals("1") || numbstat.equals("2") || numbstat.equals("3") || numbstat.equals("4")) {
                                                    znach = true;
                                                }
                                                if (znach == false) {
                                                    System.out.println("Введите корректное значение");
                                                }
                                            }
                                            while (znach == false);

                                            if (numbstat.equals("1")) {
                                                status = Status.Принят;
                                            } else if (numbstat.equals("2")) {
                                                status = Status.Оформлен;
                                            } else if (numbstat.equals("3")) {
                                                status = Status.Ожидает;
                                            } else if (numbstat.equals("4")) {
                                                status = Status.Получен;
                                            }

                                            for (Order o : orderList) {
                                                if (o.getNumber().endsWith(path)) {

                                                    if (o.getStatus().equals(status)) {
                                                        sovpadstatus = true;
                                                        System.out.println("Текущее значение статуса совпадает со значением статуса, которое Вы хотите присвоить. Выберите другое значение нового статуса товара.");
                                                        break;
                                                    }
                                                }
                                            }
                                            for (Order o : orderList) {

                                                if (o.getNumber().endsWith(path)) {
                                                    if (o.getStatus().equals(status) == false) {
                                                        temp = o.getNumber();
                                                        o.setStatus(status);
                                                    }
                                                }
                                            }
                                        }

                                        if (isorder && sovpadstatus == false) {
                                            System.out.println("У товара с номером " + temp + " статус заказа изменен на - " + status);
                                        }

                                        session170.getTransaction().commit();

                                    } finally {
                                        session170.close();
                                        factory170.close();
                                    }

                                    break;

                                default:
                                    System.out.println("Введите корректное значение");
                                    break;
                            }
                        }
                        while (!z.equals("0"));
                    }
                } else if (us3.getRole().equals("пользователь")) {
                    System.out.println("Для работы в меню пользователя нажмите любую цифру, отличную от 0");

                    String z2 = scanner2.nextLine();

                    while (!z2.equals("0")) {
                        do {
                            System.out.println("Введите:" +
                                    "\n1 - для просмотра категорий товаров;" +
                                    "\n2 - для просмотра списка товаров;" +
                                    "\n3 - для фильтрации товаров по категории и по цене;" +
                                    "\n4 - для добавления товаров в корзину; " +
                                    "\n5 - для просмотра списка товаров в корзине;" +
                                    "\n6 - для удаления товара из корзины;" +
                                    "\n7 - для оформления заказа;" +
                                    "\n8 - для просмотра списка заказов;" +
                                    "\n0 - для выхода из меню пользователя");
                            z2 = scanner2.nextLine();
                            switch (z2) {

                                case "1":

                                    Configuration configuration180 = new Configuration()
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);

                                    SessionFactory factory180 = configuration180.buildSessionFactory();

                                    Session session180 = null;
                                    try {
                                        session180 = factory180.getCurrentSession();
                                        session180.beginTransaction();
                                        List<Category> categoryList = new ArrayList<>();

                                        categoryList = session180.createQuery("from Category").getResultList();

                                        System.out.println("Введите" +
                                                "\n1 - для просмотра списка категорий, отсортированных по ID;" +
                                                "\n2 - для просмотра списка категорий, отсортированных по алфавиту" +
                                                "\n3 - для поиска категории товаров по первым символам наименования категории"
                                        );
                                        Scanner scn = new Scanner(System.in);
                                        String r = scanner2.nextLine();
                                        switch (r) {
                                            case "1":
                                                categoryList.sort((o1, o2) -> {
                                                    return (int) (o1.getId() - o2.getId()); //Сортировка по id категории
                                                });
                                                for (Category category : categoryList) {
                                                    System.out.println(category);
                                                }
                                                break;

                                            case "2":
                                                categoryList.sort((o1, o2) -> {
                                                    return o1.getName().compareTo(o2.getName());   //Сортировка по алфавиту
                                                });
                                                for (Category category : categoryList) {
                                                    System.out.println(category);
                                                }
                                                break;

                                            case "3":
                                                boolean isorderin3 = false;
                                                int counterin3 = 0;
                                                System.out.println("Введите символы, с которых начинается наименование категории товаров");

                                                String path2 = scanner2.nextLine().toLowerCase();

                                                for (Category category1 : categoryList) {
                                                    if (category1.getName().toLowerCase().startsWith(path2)) {
                                                        counterin3++;
                                                    }
                                                }

                                                if (counterin3 == 0) {
                                                    isorderin3 = false;
                                                } else {
                                                    isorderin3 = true;
                                                    System.out.println("Найдена категория товаров с наименованием, начинающемся на символы - " + path2);
                                                }

                                                if (isorderin3 == false) {
                                                    System.out.println("Нет категорий товаров с наименованием, ночинающемся на символы " + path2);
                                                } else {
                                                    for (Category category2 : categoryList) {
                                                        if (category2.getName().toLowerCase().startsWith(path2)) {
                                                            System.out.println("Наименование категории - " + category2.getName() + ", " + " ID категории - " + category2.getId());
                                                        }
                                                    }
                                                }

                                                break;

                                            default:
                                                System.out.println("Вы ввели некорректное значение");
                                                break;
                                        }

                                        session180.getTransaction().commit();

                                        //System.out.println("Выше выведена информация о всех категориях товаров из базы данных");
                                    } finally {
                                        session180.close();
                                        factory180.close();
                                    }

                                    break;

                                    /*

                                case "2"://для поиска категории товаров по первым символам наименования категории

                                    boolean isorderin2 = false;
                                    int counterin2 = 0;

                                    Configuration configuration281 = new Configuration()
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);

                                    SessionFactory factory281 = configuration281.buildSessionFactory();

                                    Session session281 = null;
                                    try {
                                        session281 = factory281.getCurrentSession();
                                        session281.beginTransaction();

                                        List<Category> categoryListList = new ArrayList<>();
                                        categoryListList = session281.createQuery("from Category").getResultList();

                                        System.out.println("Введите символы, с которых начинается наименование категории товаров");

                                        String path2 = scanner2.nextLine().toLowerCase();

                                        for (Category category1 : categoryListList) {
                                            if (category1.getName().toLowerCase().startsWith(path2)) {
                                                counterin2++;
                                            }
                                        }

                                        if (counterin2 == 0) {
                                            isorderin2 = false;
                                        } else {
                                            isorderin2 = true;
                                            System.out.println("Найдена категория товаров с наименованием, начинающемся на символы - " + path2);
                                        }

                                        if (isorderin2 == false) {
                                            System.out.println("Нет категорий товаров с наименованием, ночинающемся на символы " + path2);
                                        } else {
                                            for (Category category2 : categoryListList) {
                                                if (category2.getName().toLowerCase().startsWith(path2)) {
                                                    System.out.println("Наименование категории - " + category2.getName() + ", " + " ID категории - " + category2.getId());
                                                }
                                            }
                                        }

                                        session281.getTransaction().commit();

                                    } finally {
                                        session281.close();
                                        factory281.close();
                                    }
                                    System.out.println();

                                    break;
                                */
                                case "2"://просмотр списка товаров

                                    Configuration configuration190 = new Configuration()
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);

                                    SessionFactory factory190 = configuration190.buildSessionFactory();

                                    Session session190 = null;
                                    try {
                                        session190 = factory190.getCurrentSession();
                                        session190.beginTransaction();
                                        List<Product> productSses = new ArrayList<>();

                                        productSses = session190.createQuery("from Product").getResultList();
                                        for (Product prod2 : productSses) {
                                            System.out.println(prod2);
                                        }
                                        session190.getTransaction().commit();

                                        System.out.println("Выше выведена информация о всех товарах из базы данных");
                                    } finally {
                                        session190.close();
                                        factory190.close();
                                    }
                                    break;

                                case "3"://для фильтрации товаров по категории и по цене
                                    Scanner scanner3 = new Scanner(System.in);
                                    boolean isCategory = false;
                                    String nameCategory;
                                    int findIdProd;
                                    int cc = 0; //счетчик

                                    Configuration configuration230 = new Configuration()
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);

                                    SessionFactory factory230 = configuration230.buildSessionFactory();

                                    Session session230 = null;

                                    try {
                                        session230 = factory230.getCurrentSession();
                                        session230.beginTransaction();

                                        System.out.println("Поиск подходящих товаров по категории и по цене");

                                        do {
                                            System.out.println("Введите id категории товара");
                                            // Проверка на тип int
                                            while (!scanner3.hasNextInt()) {
                                                scanner3.next();
                                                System.out.println("Вы ввели не целое число (не значение типа int), попробуйте еще раз");
                                            }
                                            findIdProd = scanner3.nextInt();

                                            List<Category> categoryList1 = session230.createQuery("from Category").getResultList();
                                            for (Category cat : categoryList1) {
                                                if (cat.getId() == findIdProd) {

                                                    isCategory = true;
                                                }
                                                if (isCategory) {
                                                    nameCategory = cat.getName();
                                                    System.out.println("Вы ввели значение, id = " + findIdProd + ", что соответствует категории  - " + nameCategory);
                                                    break;
                                                }
                                            }
                                            if (isCategory == false) {
                                                System.out.println("Отсутствует категория с указанным Вами id");
                                            }
                                        }
                                        while (!isCategory);

                                    } finally {
                                        session230.close();
                                        factory230.close();
                                    }

                                    //_______________________________________________________________________________

                                    System.out.println("Введите стартовую цену товара");

                                    while (!scanner3.hasNextDouble()) {
                                        scanner3.next();
                                        System.out.println("Вы ввели не значение типа double, попробуйте еще раз");
                                    }
                                    Double startPriceProd = scanner3.nextDouble();

                                    System.out.println("Введите верхнюю границу цены товара");

                                    while (!scanner3.hasNextDouble()) {
                                        scanner3.next();
                                        System.out.println("Вы ввели не значение типа double, попробуйте еще раз");
                                    }
                                    Double endPriceProd = scanner3.nextDouble();

                                    Configuration configuration240 = new Configuration()
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);

                                    SessionFactory factory240 = configuration240.buildSessionFactory();

                                    Session session240 = null;
                                    try {
                                        session240 = factory240.getCurrentSession();
                                        session240.beginTransaction();
                                        List<Product> productSses = new ArrayList<>();

                                        productSses = session240.createQuery("from Product").getResultList();
                                        for (Product prod2 : productSses) {
                                            if ((prod2.getProduct_price() >= startPriceProd) && (prod2.getProduct_price() <= endPriceProd) && (prod2.getCat().id == findIdProd)) {
                                                cc++;
                                                System.out.println(prod2);
                                            }
                                        }
                                        if (cc == 0) {
                                            System.out.println("Нет товаров, соответствующих указанным условиям");
                                        }
                                        session240.getTransaction().commit();

                                    } finally {
                                        session240.close();
                                        factory240.close();
                                    }

                                    break;


                                case "4":

                                    System.out.println("Добавление товара в корзину");
                                    String tovarname = null;
                                    int count = 0;
                                    int n = 0;
                                    String art;

                                    System.out.println("Введите артикул товара, который хотите добавить в корзину");
                                    art = scanner2.nextLine();
                                    Users user;

                                    Configuration configuration200 = new Configuration()
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);

                                    SessionFactory factory200 = configuration200.buildSessionFactory();
                                    Session session200 = null;
                                    try {
                                        session200 = factory200.getCurrentSession();
                                        session200.beginTransaction();
                                        user = session200.get(Users.class, identificator);

                                        List<Product> productList = session200.createQuery("from Product").getResultList();


                                        for (Product pruductOfUser : user.getProductList()) {
                                            if (pruductOfUser.getCode().equals(art)) {
                                                n++;
                                            }
                                        }

                                        if (n > 0) {
                                            System.out.println("Данный товар уже находится в корзине");
                                        } else {
                                            for (Product p : productList) {
                                                if (p.getCode().equals(art)) {
                                                    count++;
                                                    tovarname = p.getProduct_name();
                                                    user.addUserToProduct(p);
                                                }
                                            }
                                            if (count == 0) {
                                                System.out.println("Товара с данным артикулом не существует");
                                            }
                                        }

                                        session200.getTransaction().commit();

                                        if (count != 0) {
                                            System.out.println("Товар с артикулом " + art + " и названием " + tovarname + " добавлен в корзину");
                                        }

                                    } finally {
                                        session200.close();
                                        factory200.close();
                                    }

                                    break;

                                case "5"://для просмотра списка товаров в корзине
                                    System.out.println("Просмотр списка товаров в корзине");

                                    double sum = 0;
                                    Users user1;

                                    Configuration configuration210 = new Configuration()
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);

                                    SessionFactory factory210 = configuration210.buildSessionFactory();
                                    Session session210 = null;
                                    try {
                                        session210 = factory210.getCurrentSession();
                                        session210.beginTransaction();
                                        user1 = session210.get(Users.class, identificator);

                                        if (user1.getProductList().isEmpty()) {
                                            System.out.println("Корзина пуста");
                                        } else {

                                            System.out.println("У Вас в корзине лежат следующие товары:");

                                            for (Product product : user1.getProductList()) {
                                                sum = sum + product.getProduct_price();
                                                System.out.println(product);
                                            }
                                            System.out.println("Итоговая цена  = " + sum);
                                        }
                                        session210.getTransaction().commit();

                                    } finally {
                                        session210.close();
                                        factory210.close();
                                    }

                                    break;

                                case "6"://для удаления товара из корзины
                                    System.out.println("Удаление товара из корзины");

                                    String tovarname2 = null;

                                    int v = 0; //счетчик
                                    int zz = 0;
                                    String art2;

                                    System.out.println("Введите артикул товара, который хотите удалить из корзины");
                                    art2 = scanner2.nextLine();

                                    Users user2;

                                    Configuration configuration220 = new Configuration()
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);

                                    SessionFactory factory220 = configuration220.buildSessionFactory();
                                    Session session220 = null;
                                    try {
                                        session220 = factory220.getCurrentSession();
                                        session220.beginTransaction();
                                        user2 = session220.get(Users.class, identificator);


                                        for (Product product : user2.getProductList()) {
                                            if (product.getCode().equals(art2)) {
                                                zz = product.getId();
                                                v++;
                                                tovarname2 = product.getProduct_name();
                                            }
                                        }
                                        if (v == 0) {
                                            System.out.println("Отсутствует товар с данным индексом в корзине");
                                        }

                                        if (v != 0) {
                                            Product product = session220.get(Product.class, zz);
                                            product.getUsersList().remove(user2);
                                        }

                                        session220.getTransaction().commit();

                                    } finally {
                                        session220.close();
                                        factory220.close();
                                    }
                                    // Если товар в корзине есть
                                    if (v != 0) {
                                        System.out.println("Товар с артикулом " + art2 + " и названием " + tovarname2 + " удален из корзины");
                                    }

                                    break;


                                case "7"://для оформления заказа
                                    System.out.println("Оформить заказ");
                                    boolean cartnotnull = true; // т.е. корзина не пуста

                                    Configuration configuration250 = new Configuration()
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);

                                    SessionFactory factory250 = configuration250.buildSessionFactory();
                                    Session session250 = null;
                                    try {
                                        session250 = factory250.getCurrentSession();
                                        session250.beginTransaction();
                                        user1 = session250.get(Users.class, identificator);

                                        if (user1.getProductList().isEmpty()) {
                                            cartnotnull = false; // т.е. корзина пуста
                                        }

                                        if (cartnotnull == false) { // если корзина пуста

                                            System.out.println("Заказ не может быть сделан т.к. в корзине нет товаров");
                                        } else if (cartnotnull) { // если корзина не пуста

                                            // Получение уникальной строки - она будет номером заказа
                                            String uuid = UUID.randomUUID().toString();

                                            // Получение даты и времени
                                            LocalDate date = LocalDate.now();
                                            LocalTime time = LocalTime.now();
                                            LocalDateTime current = LocalDateTime.of(date, time);

                                            //Создаем лист заказа
                                            List<Product> productorderList = new ArrayList<>();

                                            Users user543;

                                            Configuration configuration260 = new Configuration()
                                                    .addAnnotatedClass(Product.class)
                                                    .addAnnotatedClass(Category.class)
                                                    .addAnnotatedClass(Users.class)
                                                    .addAnnotatedClass(Order.class)
                                                    .addAnnotatedClass(Status.class);
                                            SessionFactory factory260 = configuration260.buildSessionFactory();
                                            Session session260 = null;

                                            try {
                                                session260 = factory260.getCurrentSession();
                                                session260.beginTransaction();
                                                user543 = session260.get(Users.class, identificator);

                                                //Получаем товары из корзины пользователя...
                                                for (Product product : user543.getProductList()) {
                                                    //...и добавляем их в лист заказа
                                                    productorderList.add(product);

                                                    //... и удаляем товары из корзины пользователя
                                                    product.getUsersList().remove(user543);
                                                }

                                                for (Product productorder : productorderList) {
                                                    Order newOrder = new Order(uuid, user543, productorder, current, Status.Оформлен);
                                                    session260.persist(newOrder);
                                                }

                                                session260.getTransaction().commit();

                                            } finally {
                                                session260.close();
                                                factory260.close();
                                            }

                                            Configuration configuration270 = new Configuration()
                                                    .addAnnotatedClass(Product.class)
                                                    .addAnnotatedClass(Category.class)
                                                    .addAnnotatedClass(Users.class)
                                                    .addAnnotatedClass(Order.class)
                                                    .addAnnotatedClass(Status.class);

                                            SessionFactory factory270 = configuration270.buildSessionFactory();

                                            Session session270 = null;
                                            try {
                                                session270 = factory270.getCurrentSession();
                                                session270.beginTransaction();

                                                double price = 0;
                                                List<Order> orderList = new ArrayList<>();
                                                orderList = session270.createQuery("from Order").getResultList();
                                                System.out.println("Информация о заказе:");
                                                System.out.println("Номер заказа: " + uuid);

                                                //дата и время
                                                DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd.MM.yy, HH:mm");
                                                String text = dtf1.format(current);
                                                System.out.println("Дата и время заказа: " + text);

                                                // Получение статуса заказа
                                                for (Order order : orderList) {
                                                    if (order.getNumber().equals(uuid)) {
                                                        System.out.println("Статус заказа: " + order.getStatus());
                                                        break;
                                                    }
                                                }

                                                System.out.println("Список товаров заказа:");

                                                for (Order order : orderList) {
                                                    if (order.getNumber().equals(uuid)) {

                                                        System.out.println("id товара - " + order.getProduct().getId() + " , артикул товара - " + order.getProduct().getCode() + ", наименование товара - " + order.getProduct().getProduct_name() + ", цена товара - " + order.getProduct().getProduct_price());
                                                        price = order.getProduct().getProduct_price() + price;
                                                    }
                                                }

                                                System.out.println("Итоговая цена: " + price);
                                                price = 0;


                                                session270.getTransaction().commit();

                                            } finally {
                                                session270.close();
                                                factory270.close();
                                            }
                                            System.out.println();
                                        }
                                    } finally {
                                        session250.close();
                                        factory250.close();
                                    }

                                    break;

                                case "8":// для просмотра списка заказов

                                    Configuration configuration280 = new Configuration()
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);

                                    SessionFactory factory280 = configuration280.buildSessionFactory();
                                    Session session280 = null;

                                    try {
                                        session280 = factory280.getCurrentSession();
                                        session280.beginTransaction();
                                        double price = 0;
                                        List<Order> orderList = new ArrayList<>();

                                        orderList = session280.createQuery("from Order").getResultList();

                                        orderList.sort(new Comparator<Order>() {
                                            @Override
                                            public int compare(Order o1, Order o2) {
                                                return (o1.getdAndT().compareTo(o2.getdAndT())); // Сортировка по дате заказа
                                            }
                                        });

                                        System.out.println("Информация о Ваших заказах");
                                        System.out.println();

                                        LinkedHashSet<String> hashList = new LinkedHashSet<>();

                                        for (Order order : orderList) {
                                            if (order.getUser().getId() == identificator) {
                                                hashList.add(order.getNumber());
                                            }
                                        }

                                        for (String hl : hashList) {

                                            for (Order order : orderList) {
                                                if (hl.equals(order.getNumber())) {
                                                    System.out.println("Номер заказа: " + order.getNumber());
                                                    System.out.println("Статус заказа: " + order.getStatus());

                                                    DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd.MM.yy, HH:mm");
                                                    String text = dtf1.format(order.getdAndT());
                                                    System.out.println("Дата и время заказа: " + text);
                                                    System.out.println("id заказчика - " + order.getUser().getId() + ", ФИО заказчика - " + order.getUser().getSurname() + " " + order.getUser().getName() + " " + order.getUser().getPatronymic());

                                                    System.out.println("Список товаров заказа:");
                                                    price = 0;

                                                    for (Order order1 : orderList) {
                                                        if (order1.getNumber().equals(hl)) {
                                                            System.out.println("id товара - " + order1.getProduct().getId() + " , артикул товара - " + order1.getProduct().getCode() + ", наименование товара - " + order1.getProduct().getProduct_name() + ", цена товара - " + order1.getProduct().getProduct_price());
                                                            price = order1.getProduct().getProduct_price() + price;
                                                        }
                                                    }
                                                    System.out.println("Итоговая цена заказа - " + price);

                                                    break;
                                                }
                                            }
                                            System.out.println();

                                        }
                                        System.out.println("Количество Ваших заказов - " + hashList.size());

                                        session280.getTransaction().commit();
                                    } finally {
                                        session280.close();
                                        factory280.close();
                                    }

                                    System.out.println();

                                    break;


                                case "0":
                                    break;
                                default:
                                    System.out.println("Вы ввели некорректное значение");
                                    break;
                            }
                        }
                        while (!z2.equals("0"));
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static boolean smenaRoli(int id, String role, List<Users> users) {

        System.out.println("Введите id пользователя, которому хотите поменять роль");

        Scanner inp2 = new Scanner(System.in);

        while (!inp2.hasNextInt()) {
            inp2.next();
            System.out.println("Вы ввели не значение типа int, попробуйте еще раз");
        }

        int f = inp2.nextInt();

        Configuration configuration290 = new Configuration().
                addAnnotatedClass(Users.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(Status.class);

        SessionFactory factory290 = configuration290.buildSessionFactory();

        Session session290 = null;
        try {
            session290 = factory290.getCurrentSession();
            session290.beginTransaction();

            List<Users> users3 = new ArrayList<>();

            users3 = session290.createQuery("from Users").getResultList();
            for (Users smenaRoli : users3) {
                if (smenaRoli.getId() == f) {
                    Users users31 = session290.get(Users.class, f);

                    if (users31.getRole().equals("пользователь")) {
                        users31.setRole("администратор");
                        session290.getTransaction().commit();
                    } else if (users31.getRole().equals("администратор")) {
                        users31.setRole("пользователь");
                        session290.getTransaction().commit();
                    }

                    System.out.println("Роль пользователя с id - " + f + " изменена. Новая роль пользователя с id " + f + " - " + users31.getRole());

                    return true;
                }
            }

        } finally {
            session290.close();
            factory290.close();
        }
        return false;
    }

    public static boolean deleteProdArtikul(String code) {

        Configuration configuration300 = new Configuration().
                addAnnotatedClass(Product.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Users.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(Status.class);

        SessionFactory factory300 = configuration300.buildSessionFactory();

        Session session300 = null;
        try {

            session300 = factory300.getCurrentSession();
            session300.beginTransaction();
            System.out.println("Удаление товара по его артикулу(со списком товаров (который в т.ч. содержит артикул товара) можно ознакомиться, если нажать 5 в меню администратора)");
            System.out.println("Введите артикул товара, который хотите удалить");

            Scanner inp3 = new Scanner(System.in);
            String artikul = inp3.nextLine();
            // int id_;

            List<Product> productList = new ArrayList<>();
            productList = session300.createQuery("from Product").getResultList();
            for (Product prod : productList) {
                if (prod.getCode().equals(artikul)) {
                    //id_ = prod.getId();
                    Product productForDelete = session300.get(Product.class, prod.getId());
                    session300.delete(productForDelete);
                    System.out.println("Товар с артикулом " + artikul + " удален");
                    session300.getTransaction().commit();
                    return true;
                }
            }

            return false;

        } finally {
            session300.close();
            factory300.close();
        }
    }
}











