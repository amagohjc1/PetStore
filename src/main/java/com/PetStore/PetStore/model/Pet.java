package com.PetStore.PetStore.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name ="pets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    @Id
    private long id;
    private String name;
    private String breed;
    private String color;
    private String type;

}
