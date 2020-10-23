package com.revature.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name="app_entities")
public class AppEntity {

    @Id
    @Column(name="entity_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long entity_Id;

    @Column(name = "entity_time")
    private String time;

    @Column(name = "entity_event")
    private String event;

}
