package tn.esprit.springdatacenter.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springdatacenter.entity.DataCenter;
import tn.esprit.springdatacenter.entity.Utilisateur;
import tn.esprit.springdatacenter.entity.VirtualMachine;
import tn.esprit.springdatacenter.service.IService;

import java.util.List;

@RestController
@RequestMapping("/ctrl")
@AllArgsConstructor
public class DataCenterController {
    private IService service;

    @PostMapping("/addUser")
    public void ajouterUser(@RequestBody Utilisateur u){
        service.ajouterUser(u);
    }
    @PostMapping("/addDC")
    public void ajouterDC(@RequestBody DataCenter dataCenter){
        service.ajouterDC(dataCenter);
    }
    @PostMapping("/vm")
    public VirtualMachine ajouterVm(@RequestBody VirtualMachine vm){
        return service.ajouterVm(vm);
    }
    @PutMapping("/affecterVmUser/{id-vm}/{id-user}")
    public void affecterVmuser(@PathVariable("id-vm") int idvm,@PathVariable("id-user") int iduser){
        service.affecterVmuser(idvm,iduser);
    }
    @PutMapping("/affecterVm/{id-vm}")
    public void affecterVm(@PathVariable("id-vm") int idvm){
        service.affecterVm(idvm);
    }
    @PutMapping("/demarrerInstanceUser/{id-vm}")
    public void demarrerInstanceUser(@PathVariable("id-vm") int idvm){
        service.demarrerInstanceUser(idvm);
    }
    @PutMapping("/arreterInstanceUser/{id-vm}")
    public void arreterInstanceUser(@PathVariable("id-vm") int idvm){
        service.arreterInstanceUser(idvm);
    }
    @GetMapping("/getDataCenters")
    public List<DataCenter> getDataCenters(){
        return service.listerDatacenter ();
    }

}
