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
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    private String nomUser;
    private String prenomUser;
    private String login;
    private String pwd;
    @OneToMany
    List<VirtualMachine> virtualMachines;
}
