package ru.job4j.model.dictionary;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import ru.job4j.model.AbstactCarSpecific;

import javax.persistence.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "name"})
@Entity
@Table(name = "years")
public class Year extends AbstactCarSpecific {

}