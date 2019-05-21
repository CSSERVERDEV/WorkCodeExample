import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class DeviceModelsRequest extends BaseRequest{
    private Integer type;//1:element hub models 2:element bulb models 3:snap models
    private String modelName;//模型名称,如snap
    private String[] model;//模型名称,如snap
}
