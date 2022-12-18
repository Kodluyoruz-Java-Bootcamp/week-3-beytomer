package com.emlakcepte.controller;

import com.emlakcepte.model.Realty;
import com.emlakcepte.service.RealtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/realties")
public class RealtyController {

    @Autowired
    private RealtyService realtyService;



    @GetMapping
    public List<Realty> getAll(){
        return realtyService.getAll();
    }

    @PostMapping
    public ResponseEntity<Realty> create(@RequestBody Realty realty){
        realtyService.createRealty(realty);
        return new ResponseEntity<>(realty, HttpStatus.CREATED);
    }
    // Şehir  bazlı ilan arama.
    @GetMapping(value = "/{province}")
    public List<Realty> getProvinceRealties(@PathVariable String province){
        return realtyService.getAllByProvince(province);
    }

    // Şehir ve ilçe bazlı ilan arama.
    @GetMapping(value = "/{province}/{county}")
    public List<Realty> getProvinceCountyRealties(@PathVariable String province, @PathVariable String county){
        return realtyService.getAllByProvinceAndCountyList(province,county);
    }

    // İstanbul, Ankara, İzmir şehirlerindeki ilanlarının sayısını bulun
    @GetMapping(value = "/count/{province}")
    public long countByRealtyOnProvince(@PathVariable String province){
        return realtyService.getnumberOfAdvertisments(province);
    }
    // istanbul, Ankara, İzmir şehirlerindeki satılık konut ilanlarının sayısını bulun.
    @GetMapping(value = "/count/{house}")
    public long countHouseForSale(@PathVariable String house){
        return realtyService.countHouseForSale(house);
    }



}
