package dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class CreatePlanResult {
    @SerializedName("id")
    @Expose
    private Integer id;
}
