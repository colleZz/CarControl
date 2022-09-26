package com.zxy.log.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zxy
 * @since 2022-09-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TbLog对象", description="")
public class TbLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "日志id")
    @TableId(value = "LogId", type = IdType.ID_WORKER)
    private String LogId;

    @ApiModelProperty(value = "车牌号")
    @TableField("CarId")
    private String CarId;

    @ApiModelProperty(value = "车主名称")
    @TableField("Name")
    private String Name;

    @ApiModelProperty(value = "进入停车场时间")
    @TableField("InputTime")
    private Date InputTime;

    @ApiModelProperty(value = "离开停车场时间")
    @TableField("OutputTime")
    private Date OutputTime;

    @ApiModelProperty(value = "停车位置")
    @TableField("ParkingLocation")
    private String ParkingLocation;

    @ApiModelProperty(value = "停车费")
    @TableField("ParkingFee")
    private BigDecimal ParkingFee;

    @ApiModelProperty(value = "1代表已结算，2代表待结算")
    @TableField("Status")
    private Integer Status;


}
