package uk.gov.hmcts.reform.ccd.client.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Event {
    private String id;
    private String summary;
    private String description;
}
