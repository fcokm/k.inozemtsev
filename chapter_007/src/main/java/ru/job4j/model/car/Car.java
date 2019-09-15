package ru.job4j.model.car;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.apache.commons.codec.binary.Base64;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Type;
import ru.job4j.model.*;
import ru.job4j.model.dictionary.Colour;
import ru.job4j.model.dictionary.Status;
import ru.job4j.model.dictionary.Year;
import ru.job4j.model.part.*;
import javax.persistence.*;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Timestamp;


@Data
@NoArgsConstructor
@ToString(exclude = {"carBody", "colour", "engineType", "engineVolum", "carCategory"
        ,"markCar", "carModel","transmission","user"})
@EqualsAndHashCode (of = {"id", "registrationtime" })
@JsonIgnoreProperties({"sales", "hibernateLazyInitializer", "handler"})
@Entity
@Table(name="cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "mileage")
    private int mileage;

    @ManyToOne
    @JoinColumn(name = "year_id", nullable = false)
    private Year year;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "body_id", nullable = false)
    private CarBody carBody;
    @ManyToOne
    @JoinColumn(name = "colour_id", nullable = false)
    private Colour colour;
    @ManyToOne
    @JoinColumn(name = "engine_type_id", nullable = false)
    private EngineType engineType;

    @ManyToOne
    @JoinColumn(name = "engine_vol_id", nullable = false)
    private EngineVolum engineVolum;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CarCategory carCategory;

    @ManyToOne
    @JoinColumn(name = "mark_id", nullable = false)
    private MarkCar markCar;

    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private CarModel carModel;

    @ManyToOne
    @JoinColumn(name = "transmission_id", nullable = false)
    private Transmission transmission;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "registration_time")
    @JsonFormat(timezone = "UTC", pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Timestamp registrationtime;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    @Column(name = "photo", length = 1000000)
    private byte[] photo;

    @Column(name = "status")
    private Status status;

    @Transient
    private String base64DataString;

    @Enumerated(EnumType.STRING)
    public Status getStatus() {
        return status;
    }

    @Transient
    public String getBase64DataString() {
        if (photo != null) {
            byte[] encodeBase64 = Base64.encodeBase64(this.photo);
            try {
                base64DataString = new String(encodeBase64, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return base64DataString;
    }

    public Car(int id, Status status) {
        this.id = id;
        this.status = status;
    }
}














