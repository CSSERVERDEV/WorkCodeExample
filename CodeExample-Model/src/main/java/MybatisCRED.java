import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class MybatisCRED {
    @ApiModelProperty(position = 1, dataType = "Long", value = "唯一ID标识")
    private Long id;

}
