package com.sap.bookshop;

import java.net.MalformedURLException;
import java.net.URL;
import com.sap.cloud.sdk.service.prov.rt.multitenant.annotations.BeforeOnboarding;
import com.sap.cloud.sdk.service.prov.rt.multitenant.api.BeforeOnboardingResponse;
import com.sap.cloud.sdk.service.prov.rt.multitenant.SubscriptionPayload;
import com.sap.cloud.sdk.service.prov.rt.multitenant.annotations.AfterOnboarding;
import com.sap.cloud.sdk.service.prov.rt.multitenant.api.AfterOnboardingResponse;
import com.sap.cloud.sdk.service.prov.rt.multitenant.TenantCallbackRequestContext;
import com.sap.cloud.sdk.service.prov.rt.multitenant.AfterOnboardingResponseImpl;
import com.sap.cloud.sdk.service.prov.rt.multitenant.annotations.BeforeOffboarding;
import com.sap.cloud.sdk.service.prov.rt.multitenant.api.BeforeOffboardingResponse;
import com.sap.cloud.sdk.service.prov.rt.multitenant.BeforeOffboardingResponseImpl;

public class MTExits {

	/*
	@BeforeOnboarding
	public String getAppUrl(String tenantId, SubscriptionPayload requestPayload) {
		System.out.println("MTExits: BeforeOnboarding for tenant: " + tenantId + " subdomain: " + requestPayload.getSubscribedSubdomain());
		return "https://" + requestPayload.getSubscribedSubdomain() + "-dev-bookshop-app.cfapps.eu10.hana.ondemand.com";
	}
	*/

	@BeforeOnboarding
	public BeforeOnboardingResponse beforeOnboarding (String tenantId, SubscriptionPayload requestPayload) throws MalformedURLException {
		System.out.println("MTExits: BeforeOnboardingResponse for tenant: " + tenantId + " subdomain: " + requestPayload.getSubscribedSubdomain());
		BeforeOnboardingResponse response = BeforeOnboardingResponse.getInstance();
		response.setUrl(new URL("https://" + requestPayload.getSubscribedSubdomain() + "-dev-bookshop-app.cfapps.eu10.hana.ondemand.com"));
		response.setManagedOnboarding(true); 
		return response;
	}

	@AfterOnboarding
	public AfterOnboardingResponse afterOffboarding(String tenantId, boolean isOnboardingSuccessful, TenantCallbackRequestContext rCtx) {
		if (isOnboardingSuccessful) {
			System.out.println("MTExits: AfterOnboardingResponse successful for tenant: " + tenantId);
		} else {
			System.out.println("MTExits: AfterOnboardingResponse failed for tenant: " + tenantId);
		}
		return new AfterOnboardingResponseImpl();
	}
	
	@BeforeOffboarding
	public BeforeOffboardingResponse beforeOffboarding(String tenantId, TenantCallbackRequestContext rCtx) {
		System.out.println("MTExits: BeforeOffboardingResponse for tenant: " + tenantId);
		BeforeOffboardingResponse response = new BeforeOffboardingResponseImpl();
		response.setManagedOffboarding(true);
		return response;
	}

}
