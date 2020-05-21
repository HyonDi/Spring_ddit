package com.groupware.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupware.service.board.KakaoPay;

import lombok.Setter;
import lombok.extern.java.Log;
 
@Log
@Controller
public class SampleController {
    
    @Setter(onMethod_ = @Autowired)
    private KakaoPay kakaopay;
    
    
    @RequestMapping(value = "/kakaoPay", method = RequestMethod.GET)
    public void kakaoPayGet(HttpServletRequest request, HttpServletResponse response) {
        
    }
    
    @RequestMapping(value = "/kakaoPay", method = RequestMethod.POST)
    public String kakaoPay(HttpServletRequest request, HttpServletResponse response) {
        log.info("kakaoPay post............................................");
        
        return "redirect:" + kakaopay.kakaoPayReady();
 
    }
    
    @RequestMapping(value = "/kakaoPaySuccess", method = RequestMethod.GET)
    public void kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model) {
        log.info("kakaoPaySuccess get............................................");
        log.info("kakaoPaySuccess pg_token : " + pg_token);
        
        model.addAttribute("info", kakaopay.kakaoPayInfo(pg_token));
        
    }
    
}
