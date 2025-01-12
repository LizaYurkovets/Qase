package dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Case {
    private final String title;
    private final String status;
    private final String suite;
    private final String severity;
    private final String priority;
    private final String type;
    private final String layer;
    private final String isFlaky;
    private final String behavior;
    private final String automationStatus;
}
