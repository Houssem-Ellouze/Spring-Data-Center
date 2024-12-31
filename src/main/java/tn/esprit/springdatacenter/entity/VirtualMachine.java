package tn.esprit.springdatacenter.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class VirtualMachine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVm;
    private String os;
    private int tailleDisque;
    @Enumerated(EnumType.STRING)
    private Etat etat;

    @ManyToOne
    private DataCenter dataCenter;


}
