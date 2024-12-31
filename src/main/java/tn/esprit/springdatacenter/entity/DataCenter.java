package tn.esprit.springdatacenter.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DataCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String region;
    private Date dateFabrication;
    private int CapaciteDisque;
    private int espaceLibreDisque;

    @OneToMany(mappedBy = "dataCenter")
    List<VirtualMachine> virtualMachineslist;

}
