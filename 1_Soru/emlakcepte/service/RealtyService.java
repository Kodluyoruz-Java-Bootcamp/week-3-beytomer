package com.emlakcepte.service;

import com.emlakcepte.repository.RealtyRepository;
import com.emlakcepte.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealtyService {
	@Autowired
	private RealtyRepository realtyRepository;
	
	@Autowired //injection
	private UserService userService;
	
	public void createRealty(Realty realty) {	
		
		//userService.printAllUser();
		
		if (UserType.INDIVIDUAL.equals(realty.getUser().getType())&& NoticeType.HOUSING.equals(realty.getNoticeType()) && getAllByUserName(realty.getUser()).size()<3) {
			realtyRepository.saveRealty(realty);

		} else if (UserType.CORPARETE.equals(realty.getUser().getType())) {
			realtyRepository.saveRealty(realty);
		}else{
			System.out.println(realty.getUser().getName()+" bireysel kullanıcılar Konut tipinde en fazla 3 ilan yayınlayabilir. Son ilan yayınlanamamıştır !!");
		}


		//--System.out.println("createRealty :: " + realty.getTitle());
	}
	
	public List<Realty> getAll(){
		return realtyRepository.findAll();
	}
	
	public void printAll(List<Realty> realtList) {
		realtList.forEach(realty -> System.out.println(realty));
	}

	public List<Realty> getAllByProvince(String province) {
		
		return getAll().stream()
		.filter(realty -> realty.getProvince().equals(province)).toList();
		
	}
	public void getAllByCounty(String county) {

		getAll().stream()
				.filter(realty -> realty.getCounty().equals(county))
				//.count();
				.forEach(System.out::println);

	}
	public void getAllByProvinceAndCounty(String province, String county) {

		getAll().stream()  // stream ler ile koşul kontrolü yapıp istenilen il ve ilçeyi sağlayan ilanları bulduk.
				.filter(realty -> realty.getCounty().equals(county) && realty.getProvince().equals(province))
				.forEach(System.out::println);

	}
	public List<Realty> getAllByProvinceAndCountyList(String province, String county) {


			return getAll().stream().filter(realty ->realty.getProvince().equals(province)&& realty.getCounty().equals(county)).toList();

	}

	
	public List<Realty> getAllByUserName(User user){	
		return getAll().stream()
		.filter(realty -> realty.getUser().getMail().equals(user.getMail()))
		.toList();		
	}

	public List<Realty> getActiveRealtyByUserName(User user) {
		
		return getAll().stream()
		.filter(realty -> realty.getUser().getName().equals(user.getName()))
		.filter(realty -> RealtyType.ACTIVE.equals(realty.getStatus()))
		.toList();

	}
	public List<Realty> getProvinceWindow(String province){
		return getAll().stream().filter(it ->it.getProvince().equals(province)).limit(10L).toList();
	}

	public long getnumberOfAdvertisments(String province){
		long count = getAll().stream().filter(it -> it.getProvince().equals(province)).count();
		return count;
	}

	public long countHouseForSale(String province){
		 return getAll().stream()
				.filter(it ->it.getProvince().equals(province) && it.getStatus().equals(RealtyType.SALE))
				.count();
	}

}
