package dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UpdatePlanRq {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("cases")
    @Expose
    private List<Integer> cases;
}
