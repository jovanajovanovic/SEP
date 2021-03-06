package rs.ac.uns.ftn.authentication_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import rs.ac.uns.ftn.authentication_service.converter.MerchantConverter;
import rs.ac.uns.ftn.authentication_service.converter.SubmissionConverter;
import rs.ac.uns.ftn.authentication_service.dto.MerchantDTO;
import rs.ac.uns.ftn.authentication_service.dto.SubmissionDTO;
import rs.ac.uns.ftn.authentication_service.dto.SubmissionManipulationDTO;
import rs.ac.uns.ftn.authentication_service.dto.SubmitionDecisionDTO;
import rs.ac.uns.ftn.authentication_service.exceptions.BadRequestException;
import rs.ac.uns.ftn.authentication_service.model.Client;
import rs.ac.uns.ftn.authentication_service.model.Submission;
import rs.ac.uns.ftn.authentication_service.model.SubmissionState;
import rs.ac.uns.ftn.authentication_service.service.RegistrationService;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RegistrationController {

    @Autowired
    private SubmissionConverter submissionConverter;

    @Autowired
    private MerchantConverter merchantConverter;
    @Autowired
    private RegistrationService registrationService;

    @PostMapping(
            value = "/registerCompany",
            produces = MediaType.TEXT_PLAIN_VALUE,
            consumes = "multipart/form-data"
    )
    public ResponseEntity register(@RequestPart("informations") @Validated SubmissionDTO submissionDTO,
                                   @RequestPart("file") @NotNull MultipartFile file,
                                   BindingResult bindingResult) {
    	System.out.println(submissionDTO.getCompanyName() + " tu <<<<<");

        if(bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getFieldError().getDefaultMessage());
        }

        this.registrationService.submit(this.submissionConverter.convert(submissionDTO), file);

        return new ResponseEntity<>("Successful submission.", HttpStatus.OK);
    }

    @GetMapping(
            value = "/getSubmissions/{state}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity getCompanies(@PathVariable("state") SubmissionState state) {

        List<Submission> submissions = this.registrationService.getSubmissions(state);

        List<SubmissionDTO> retval = new ArrayList<>();
        for(Submission s : submissions) {
            retval.add(this.submissionConverter.convert(s));
        }

        return new ResponseEntity<>(retval, HttpStatus.OK);
    }

    @PostMapping(
            value = "/acceptCompany"
    )
    public ResponseEntity<SubmissionManipulationDTO> acceptCompany(@RequestBody SubmitionDecisionDTO decision) {
        this.registrationService.acceptSubmission(decision.getCompanyName());

        return new ResponseEntity<SubmissionManipulationDTO>(new SubmissionManipulationDTO("Registration accepted!"), HttpStatus.OK);
    }

    @PostMapping(
            value = "/declineCompany"
    )
    public ResponseEntity<SubmissionManipulationDTO> rejectCompany(@RequestBody SubmitionDecisionDTO decision) {

        this.registrationService.declineSubmission(decision.getMessage(), decision.getCompanyName());

        return new ResponseEntity<SubmissionManipulationDTO>(new SubmissionManipulationDTO("Company " + decision.getCompanyName() + " is rejected!"), HttpStatus.OK);
    }

    @PostMapping(
            value = "/registerMerchant",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public ResponseEntity registerMerchant(@RequestBody MerchantDTO mdto) {
        this.registrationService.registerMerchant(this.merchantConverter.convert(mdto), mdto.getCompanySecretId());
        return new ResponseEntity<>("Successful merchant registration", HttpStatus.OK);
    }

//    @GetMapping(
//            value = "/getMerchants",
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    public ResponseEntity getMerchants() {
//        String username = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
//        List<Client> users = this.registrationService.getMerchants(username);
//
//        List<MerchantDTO> merchants = new ArrayList<>();
//        for (Client u : users) {
//            merchants.add(this.merchantConverter.convert(u));
//        }
//
//        return new ResponseEntity<>(merchants, HttpStatus.OK);
//    }

}
