package com.rickywong.ninjaGold;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class NinjaGoldController {
	private int totalGold = 0;
	
	private static int getRandom(int min, int max) {

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	private int collectGold(int gold) {
		totalGold += gold;
		return totalGold;
	}
	@RequestMapping("")
	public String gold() {
		return "gold.jsp";
	}
    @RequestMapping("/find")
    public String find(RedirectAttributes redirectAttributes, HttpSession session, @RequestParam(value = "location", required = true) String location, Model model) {
    	int gold = 0;
        
        switch (location) {
        case "farm":
            gold += getRandom(10,20);
            redirectAttributes.addFlashAttribute("foundGold", "You've entered a farm and found " + gold + " gold!");
        	break;
        case "house":
            gold = getRandom(2,5);
            redirectAttributes.addFlashAttribute("foundGold", "You've entered a house and found " + gold + " gold!");
        	break;
        case "cave":
            gold = getRandom(5,10);
            redirectAttributes.addFlashAttribute("foundGold", "You've entered a cave and found " + gold + " gold!");
        	break;
        case "casino":
            gold = getRandom(-50,50);
            if (gold >= 0) {
            	redirectAttributes.addFlashAttribute("foundGold", "You've entered a casino and won " + gold + " gold!");
            } else {
            	redirectAttributes.addFlashAttribute("foundGold", "You've entered a casino and lost " + gold + " gold!");
            }
        	break;
        default:
        	return "redirect:/";
        }
        
        collectGold(gold);
        session.setAttribute("yourGold", totalGold);
		return "redirect:/";
    }
	
}
