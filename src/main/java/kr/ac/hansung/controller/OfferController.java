package kr.ac.hansung.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.DividedGrade;
import kr.ac.hansung.model.Offer;
import kr.ac.hansung.model.TotalGrade;
import kr.ac.hansung.model.TypeGrade;
import kr.ac.hansung.service.OfferService;

@Controller
public class OfferController {

	@Autowired
	private OfferService offerService;
	
	@RequestMapping("/offers")
	public String showOffers(Model model) {
		List<Offer> offers = offerService.getCurrent();
		List<TotalGrade> grades = new ArrayList<TotalGrade>();
		TotalGrade total;
		float sum=0;
		for(Offer a:offers) {
			if(a.getYear()==2013) {
				if(a.getSemester()==1) {
					sum+=a.getCredit();
				}
			}	
		}
		grades.add(new TotalGrade(2013,1,sum));
		sum=0;
		
		for(Offer a:offers) {
			if(a.getYear()==2013) {
				if(a.getSemester()==2) {
					sum+=a.getCredit();
				}
			}	
		}
		grades.add(new TotalGrade(2013,2,sum));
		sum=0;
		
		for(Offer a:offers) {
			if(a.getYear()==2016) {
				if(a.getSemester()==1) {
					sum+=a.getCredit();
				}
			}	
		}
		grades.add(new TotalGrade(2016, 1,sum));
		sum=0;
		
		for(Offer a:offers) {
			if(a.getYear()==2016) {
				if(a.getSemester()==2) {
					sum+=a.getCredit();
				}
			}	
		}
		grades.add(new TotalGrade(2016,2,sum));
		sum=0;
		
		for(Offer a:offers) {
			if(a.getYear()==2017) {
				if(a.getSemester()==1) {
					sum+=a.getCredit();
				}
			}	
		}
		grades.add(new TotalGrade(2017,1,sum));
		sum=0;
		
		model.addAttribute("grades", grades);
		return "offers";
	}
	
	@RequestMapping("/detail")
	public String classList(Model model) {
		List<Offer> offers = offerService.getCurrent();
		List<DividedGrade> grades = new ArrayList<DividedGrade>();
		String classname;
		
		for(Offer a:offers) {
			if(a.getYear()==2013) {
				if(a.getSemester()==1) {
					grades.add(new DividedGrade(2013, 1, a.getCredit(), a.getClassname()));
				}
			}
		}
		for(Offer a:offers) {
			if(a.getYear()==2013) {
				if(a.getSemester()==2) {
					grades.add(new DividedGrade(2013,2, a.getCredit(), a.getClassname()));
				}
			}
		}
		for(Offer a:offers) {
			if(a.getYear()==2016) {
				if(a.getSemester()==1) {
					grades.add(new DividedGrade(2016,1, a.getCredit(), a.getClassname()));
				}
			}
		}
		for(Offer a:offers) {
			if(a.getYear()==2016) {
				if(a.getSemester()==2) {
					grades.add(new DividedGrade(2016,2, a.getCredit(), a.getClassname()));
				}
			}
		}
		for(Offer a:offers) {
			if(a.getYear()==2017) {
				if(a.getSemester()==1) {
					grades.add(new DividedGrade(2017,1, a.getCredit(), a.getClassname()));
				}
			}
		}

		
		model.addAttribute("grades", grades);
		
		return "detail";
	}
	
	@RequestMapping("/typegrade")
	public String typeGrade(Model model) {
		List<Offer> offers = offerService.getCurrent();
		List<TypeGrade> typeGrades = new ArrayList<TypeGrade>();
		float totalcredit=0;
		float sum=0;
		
		for(Offer a: offers) {
			if(a.getType().equals("교필")) {
				totalcredit += a.getCredit();				
			}
		}
		typeGrades.add(new TypeGrade("교필", totalcredit));
		totalcredit=0;
		
		for(Offer a: offers) {
			if(a.getType().equals("핵교A")) {
				totalcredit += a.getCredit();				
			}
		}
		typeGrades.add(new TypeGrade("핵교A", totalcredit));
		sum += totalcredit;
		totalcredit=0;
		
		for(Offer a: offers) {
			if(a.getType().equals("전기")) {
				totalcredit += a.getCredit();				
			}
		}
		typeGrades.add(new TypeGrade("전기", totalcredit));
		sum += totalcredit;
		totalcredit=0;
		
		for(Offer a: offers) {
			if(a.getType().equals("일교")) {
				totalcredit += a.getCredit();				
			}
		}
		typeGrades.add(new TypeGrade("일교", totalcredit));
		sum += totalcredit;
		totalcredit=0;
		
		for(Offer a: offers) {
			if(a.getType().equals("전선")) {
				totalcredit += a.getCredit();				
			}
		}
		typeGrades.add(new TypeGrade("전선", totalcredit));
		sum += totalcredit;
		totalcredit=0;
		
		for(Offer a: offers) {
			if(a.getType().equals("인재")) {
				totalcredit += a.getCredit();				
			}
		}
		typeGrades.add(new TypeGrade("인재", totalcredit));
		sum += totalcredit;
		totalcredit=0;
		
		for(Offer a: offers) {
			if(a.getType().equals("자율")) {
				totalcredit += a.getCredit();				
			}
		}
		typeGrades.add(new TypeGrade("자율", totalcredit));
		sum += totalcredit;
		totalcredit=0;
		
		for(Offer a: offers) {
			if(a.getType().equals("전지")) {
				totalcredit += a.getCredit();				
			}
		}
		typeGrades.add(new TypeGrade("전지", totalcredit));
		sum += totalcredit;
		totalcredit=0;
		
		typeGrades.add(new TypeGrade("총 학점", sum));
		
		model.addAttribute("typegrades", typeGrades);
		
		return "typegrade";
	}
	
	@RequestMapping("/createoffer")
	public String createOffer(Model model) {
		
		model.addAttribute("offer", new Offer());
		
		return "createoffer";
	}
	
	@RequestMapping("/docreate")
	public String doCreate(Model model, @Valid Offer offer, BindingResult result) {//�떎�젣 諛붿씤�뵫�씠 �씠猷⑥뼱吏�
		
		if(result.hasErrors()) {
			System.out.println("===Form data does not validated");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error:errors) {
				System.out.println(error.getDefaultMessage());
			}
			
			return "createoffer";
		}
		
		offerService.insert(offer);
		
		return "offercreated";
	}
	
	@RequestMapping("/registerhistory")
	public String registerHistory(Model model) {
		List<Offer> offers = offerService.getCurrent();
		List<Offer> offersHistory = new ArrayList<Offer> ();
		
		for(Offer a: offers) {
			if(a.getYear()==2018)
			{
				offersHistory.add(a);
			}
		}
		model.addAttribute("offers", offersHistory);
		
		return "registerhistory";
	}
	
}
