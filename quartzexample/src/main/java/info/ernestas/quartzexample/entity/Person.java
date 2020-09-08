package info.ernestas.quartzexample.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
@Data
public class Person {

    @Id
    private Integer id;

    private String name;

}
