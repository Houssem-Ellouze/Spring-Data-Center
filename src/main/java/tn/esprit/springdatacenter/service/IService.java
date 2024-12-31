package tn.esprit.springdatacenter.service;

import tn.esprit.springdatacenter.entity.Utilisateur;
import tn.esprit.springdatacenter.entity.DataCenter;
import tn.esprit.springdatacenter.entity.VirtualMachine;

import java.util.List;

public interface IService {
    void ajouterUser(Utilisateur u);
    void ajouterDC(DataCenter dataCenter);
    VirtualMachine ajouterVm(VirtualMachine vm);
    void affecterVmuser(int idvm, int iduser);
    void affecterVm(int idvm);
    void demarrerInstanceUser(int idvm);
    void arreterInstanceUser(int idvm);
    List<DataCenter> listerDatacenter();
}
