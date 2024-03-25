package hiber.model;

import javax.persistence.*;

@Entity
@Table(name="cars")
public class Car {

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userID;

    @Column
    private String model;

    @Column
    private int series;

    public Car() {
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public int getSeries() {
        return series;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long id) {
        this.userID = id;
    }

    public void setUser(User userCar) {
        this.user = userCar;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "model = " + model + '\'' +
                ", series=" + series;
    }
}
