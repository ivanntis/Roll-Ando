/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gizmoideas.roll_ando.controller;

import com.gizmoideas.roll_ando.controller.utils.FacesUtils;
import com.gizmoideas.roll_ando.model.UserRoller;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import net.tanesha.recaptcha.ReCaptcha;
import net.tanesha.recaptcha.ReCaptchaFactory;
import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

/**
 *
 * @author ipena
 */
//@CustomScoped(value = "#{window}")
@ManagedBean(name = "NewAccount")
@ViewScoped
public class NewAccount implements Serializable {

    private ReCaptcha captcha;
    private String confirmPass;
    private UserRoller user;
    private String captchaHtml;
    private int step = 1;
    private String codeValidation;

    /**
     * Creates a new instance of NewAccount
     */
    public NewAccount() {
        System.out.println("Construct");
    }

    @PostConstruct
    public void init() {
        user = new UserRoller();
        user.setType(1);
        captcha = ReCaptchaFactory.newReCaptcha("6LdCLfUSAAAAAAE9kCd-XG01aBAo36QNOJH2PnBe",
                "6LdCLfUSAAAAAPsnt4b1Fm7R8Z061qDtdayXuYLG", false);
        captchaHtml = captcha.createRecaptchaHtml(null, null);
        System.out.println("PostConstruct");

    }

    @PreDestroy
    public void clean() throws Exception {
        System.out.println("PreDestroy");
    }

    public void saveUserData(ActionEvent ae) {
        if (user.validatePassword(confirmPass) && validateCaptcha()) {
            step = 2;
        } else {
            System.out.println("las contraseñas o el captcha no coiciden");
        }
    }

    public void confirmRegiter(ActionEvent ae) {
        step = 3;
    }

    public void saveDataAdditional(ActionEvent ae) {
        step = 3;
    }

    public void skipData(ActionEvent ae) {
        step = 3;
    }

    private boolean validateCaptcha() {
        HttpServletRequest request = FacesUtils.getServletRequest();
        String remoteAddr = request.getRemoteAddr();
        ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
        reCaptcha.setPrivateKey("6LdCLfUSAAAAAPsnt4b1Fm7R8Z061qDtdayXuYLG");

        String challenge = request.getParameter("recaptcha_challenge_field");
        String uresponse = request.getParameter("recaptcha_response_field");
        ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);

        return reCaptchaResponse.isValid();

    }

    public String getCaptchaHtml() {
        return captchaHtml;
    }

    public void setCaptchaHtml(String captchaHtml) {
        this.captchaHtml = captchaHtml;
    }

    public UserRoller getUser() {
        return user;
    }

    public void setUser(UserRoller user) {
        this.user = user;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public String getCodeValidation() {
        return codeValidation;
    }

    public void setCodeValidation(String codeValidation) {
        this.codeValidation = codeValidation;
    }

}
