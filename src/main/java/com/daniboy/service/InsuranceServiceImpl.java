package com.daniboy.service;

import com.daniboy.spring_ws_app.*;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
public class InsuranceServiceImpl implements InsuranceService{
    @Override
    public void writeInsuranceApplication(InsuranceRequest insuranceRequest) {
        System.out.println("Insurance Application : " + insuranceRequest);

        ApplicantType applicantType = insuranceRequest.getApplicant();
        System.out.println("Insurance Applicant: First Name " + applicantType.getFirstName() );
        System.out.println("Insurance Applicant: Last Name " + applicantType.getLastName() );
        System.out.println("Insurance Applicant: SSN " + applicantType.getSsn() );


        WidgetInfoType widgetInfo = insuranceRequest.getWidgetInfo();
        System.out.println("Widget Information: Contract Number " + widgetInfo.getWgtContractNumber());
        System.out.println("Widget Information: Amount " + widgetInfo.getWgtAmount());


        InsuranceInfoType insuranceInfo = insuranceRequest.getInsuranceInfo();
        System.out.println("Insurance Information: Coverage Option " + insuranceInfo.getCoverageOption());
        System.out.println("Insurance Information: Coverage Type " + insuranceInfo.getCoverageType());
        System.out.println("Insurance Information: Product " + insuranceInfo.getProduct());
    }

    @Override
    public InsuranceResponse processInsuranceApplication(InsuranceRequest insuranceRequest) {
        InsuranceResponse insuranceResponse = new InsuranceResponse();

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(calendar.getTime());
        System.out.println(formattedDate);
        
        //persiste o seguro e retorna pro usuário a data e valor do processo

        insuranceResponse.setConfirmationId("1");
        insuranceResponse.setAmount(insuranceRequest.getWidgetInfo().getWgtAmount());
        insuranceResponse.setOrderDate(formattedDate);
        return insuranceResponse;
    }
}
