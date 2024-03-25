package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("John", "Doe", "john.doe@example.com");
        Car car1 = new Car("Toyota", 2020);
        user1.setCar(car1);

        User user2 = new User("Jane", "Smith", "jane.smith@example.com");
        Car car2 = new Car("Honda", 2018);
        user2.setCar(car2);

        userService.add(user1);
        userService.add(user2);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car Model = " + user.getCar().getModel());
            System.out.println("Car Series = " + user.getCar().getSeries());
            System.out.println();
        }

        System.out.println("--------------");
        System.out.println(userService.getUserByCar("Honda", 2018));
        System.out.println("--------------");


        context.close();
    }
}