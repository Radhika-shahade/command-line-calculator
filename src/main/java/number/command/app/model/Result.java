package number.command.app.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;
@Data
@Builder
@ToString
public class Result {
    private String message;
    private Double value;

}
