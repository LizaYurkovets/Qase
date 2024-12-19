package dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {
    private final String projectName;
    private final String projectCode;
    private final String description;
    private final String projectAccessType;
    private final String memberAccess;
}
