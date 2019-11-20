package ru.job4j.model.part;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import ru.job4j.model.AbstactCarSpecific;

import javax.persistence.*;


@Data
@Entity
@EqualsAndHashCode(of = {"id", "name"})
@Table(name="car_engine")
public class Engine extends AbstactCarSpecific {

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="type_id")
    private EngineType type;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="volume_id")
    private EngineVolum volum;
}
