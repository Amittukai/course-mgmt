package com.course.management.controllers.base;

import com.course.management.models.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {

	protected ResponseEntity sendSuccessApiResponse(Object payload) {
		return new ResponseEntity(new ApiResponse<>(Boolean.TRUE, 200, "Successful", payload), HttpStatus.OK);
	}

	protected ResponseEntity sendAcceptedApiResponse(Object payload, String message) {
		return new ResponseEntity(buildApiResponse(true, payload, message), HttpStatus.ACCEPTED);
	}

	protected ResponseEntity sendFailedApiResponse(Object payload, String message) {
		return new ResponseEntity(buildApiResponse(false, payload, message), HttpStatus.OK);
	}

	private ApiResponse buildApiResponse(boolean status, Object payload, String message) {
		ApiResponse response = new ApiResponse(payload);
		response.setStatus(status);
		response.setMessage(message);
		return response;
	}
}
