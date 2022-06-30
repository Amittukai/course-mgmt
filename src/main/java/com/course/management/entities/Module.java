package com.course.management.entities;

import com.course.management.entities.shared.BaseEntity;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "module")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Module extends BaseEntity {

    @NotNull
    private String name;
    private String code;
    private String shortName;
    private String[] aliases;
    private String outcomes;
    private String objectives;
    @NotNull
    private int numberOfSession;
    @NotNull
    private int totalHours;
}
