package com.capcom.monitoring.web;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.capcom.monitoring.model.MonitorRequest;

@Component
public class MonitorRequestValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return MonitorRequest.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("In VALIDATOR :: MonitorRequestValidator");
		MonitorRequest monitorRequest = (MonitorRequest) target;
		System.out.println(monitorRequest);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "chgGroup", "NotEmpty.MonitorRequest.changeGroup");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "escalGroup", "NotEmpty.MonitorRequest.escalGroup");
		
		if(StringUtils.isEmpty(monitorRequest.getCondition())) {
			errors.rejectValue("condition","NotEmpty.MonitorRequest.condition");
		} else if (!StringUtils.isNumeric(monitorRequest.getCondition())) {
			errors.rejectValue("condition","CPU.NonNumeric.condition");
		} else {
			int condition = Integer.parseInt(monitorRequest.getCondition());
			if(condition > 100 || condition < 70) {
				errors.rejectValue("condition","CPU.NonNumeric.condition");
			}
		}
	}

}
