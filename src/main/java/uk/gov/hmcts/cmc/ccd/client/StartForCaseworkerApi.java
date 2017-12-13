package uk.gov.hmcts.cmc.ccd.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uk.gov.hmcts.cmc.ccd.client.model.StartEventResponse;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(name = "core-case-data-api", url = "${core_case_data.api.url}")
public interface StartForCaseworkerApi {

    @RequestMapping(
        method = RequestMethod.GET,
        value = "/caseworkers/{userId}/jurisdictions/{jurisdictionId}/case-types/{caseType}/event-triggers/"
            + "{eventId}/token",
        headers = CONTENT_TYPE + "=" + APPLICATION_JSON_VALUE
    )
    ResponseEntity<StartEventResponse> start(@RequestHeader(AUTHORIZATION) String authorisation,
                                             @RequestHeader("ServiceAuthorization") String serviceAuthorization,
                                             @PathVariable String userId,
                                             @PathVariable String jurisdictionId,
                                             @PathVariable String caseType,
                                             @PathVariable String eventId
    );

}