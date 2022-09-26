package com.zxy.order.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("tb_order")
@ApiModel(value="TbOrder对象", description="")
public class TbOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单id")
    @TableId(value = "OrderId", type = IdType.ID_WORKER)
    private Long OrderId;

    @ApiModelProperty(value = "车牌号")
    @TableField("CarId")
    private String CarId;

    @ApiModelProperty(value = "户主身份证")
    @TableField("OwnerId")
    private Integer OwnerId;

    @ApiModelProperty(value = "租户身份证")
    @TableField("TenantId")
    private Integer TenantId;

    @ApiModelProperty(value = "停车费用")
    @TableField("ParkingFee")
    private BigDecimal ParkingFee;

    @ApiModelProperty(value = "订单日期")
    @TableField("OrderTime")
    private Date OrderTime;

    @ApiModelProperty(value = "订单状态")
    @TableField("OrderStatus")
    private Integer OrderStatus;


}
