import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author:ZengSong
 * @Description:
 * @Date:Created in 18:07 2018/5/15
 * @Modified By:
 */
@Data
@ApiModel
public class BaseRequest implements Serializable{
    @ApiModelProperty(position = 1, dataType = "String", value = "开始日期(yyyy-MM-dd)", example = "2017-09-27")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String beginDate;

    @ApiModelProperty(position = 2, dataType = "String", value = "结束日期(yyyy-MM-dd)", example = "2017-09-27")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String endDate;

    @ApiModelProperty(position = 3, required = true, dataType = "String", value = "数据中心地址")
    private String dataCenter;

    @ApiModelProperty(position = 4, required = true, dataType = "Long", value = "用户分群id")
    private Integer userGroupId;

    @ApiModelProperty(position = 5, dataType = "String", value = "设备编码", example = "snap")
    private String productCode;

    @ApiModelProperty(position = 6, dataType = "String", value = "排序字段", example = "date,0,1,2,3,4....23")
    private String sortField;
    @ApiModelProperty(position = 7, dataType = "String", value = "排序字段", example = "asc,desc")
    private String sortBy;
    @ApiModelProperty(position = 8, dataType = "Long", value = "每页显示条数", example = "asc,desc")
    private Integer pageSize;
    @ApiModelProperty(position = 9, dataType = "Long", value = "当前页码", example = "asc,desc")
    private Integer pageNo;

    @ApiModelProperty(position = 10, hidden = true, dataType = "Long", value = "sql查询开始位置, 默认0")
    private Integer start = 0;

    public Integer getStart() {
        if (this.pageNo == null) {
            return null;
        }
        if(this.pageSize==null){
            return null;
        }
        return (this.pageNo < 1) ? 0 : (this.pageNo - 1) * this.getPageSize();
    }

    private Integer allowPaging;
}
