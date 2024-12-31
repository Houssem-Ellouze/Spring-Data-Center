package tn.esprit.springdatacenter.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.springdatacenter.entity.DataCenter;
import tn.esprit.springdatacenter.entity.Etat;
import tn.esprit.springdatacenter.entity.Utilisateur;
import tn.esprit.springdatacenter.entity.VirtualMachine;
import tn.esprit.springdatacenter.repository.DataCenterRepository;
import tn.esprit.springdatacenter.repository.UtilisateurRepository;
import tn.esprit.springdatacenter.repository.VirtualMachineRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ServiceImpl implements IService{

    private DataCenterRepository dataCenterRepository;
    private UtilisateurRepository utilisateurRepository;
    private VirtualMachineRepository virtualMachineRepository;

    public void ajouterUser(Utilisateur u) {
        utilisateurRepository.save(u);
    }

    public void ajouterDC(DataCenter dataCenter) {
        dataCenterRepository.save(dataCenter);
    }


    public VirtualMachine ajouterVm(VirtualMachine vm) {
        return virtualMachineRepository.save ( vm );
    }

    public void affecterVmuser(int idvm, int iduser) {

        Utilisateur user = utilisateurRepository.findById ( iduser ).orElse(null);
        VirtualMachine vm = virtualMachineRepository.findById ( idvm ).orElse(null);

        user.getVirtualMachines ().add (vm);
        utilisateurRepository.save(user);
    }


    public void affecterVm(int idvm) {

        VirtualMachine vm = virtualMachineRepository.findById ( idvm ).orElse(null);

        for (DataCenter dataCenter : dataCenterRepository.findAll ()) {
            if(dataCenter.getEspaceLibreDisque() > vm.getTailleDisque()){
                int nouveauEspaceLibreDisque = dataCenter.getEspaceLibreDisque() - vm.getTailleDisque();
                dataCenter.setEspaceLibreDisque(nouveauEspaceLibreDisque);
                vm.setDataCenter(dataCenter);
            }
        }

    }

    public void demarrerInstanceUser(int idvm) {

        VirtualMachine vm = virtualMachineRepository.findById ( idvm ).orElse(null);
        vm.setEtat ( Etat.RUNNING );
        virtualMachineRepository.save(vm);
    }

    public void arreterInstanceUser(int idvm) {
        VirtualMachine vm = virtualMachineRepository.findById ( idvm ).orElse(null);
        vm.setEtat ( Etat.STOPPED );
        virtualMachineRepository.save(vm);
    }

    public List<DataCenter> listerDatacenter() {
        return dataCenterRepository.findAll ();
    }
    @Scheduled(cron = "* * * 01 11 1")
    public void getDataCenter() {
        for (DataCenter dataCenter : listerDatacenter ()) {
            log.info ("Data center :" + dataCenter.getRegion ());
            for (VirtualMachine vm : dataCenter.getVirtualMachineslist ()){
                log.info ( "OS :" + vm.getOs () );
            }
        }
    }


}
