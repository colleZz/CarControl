package com.zxy.user.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
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
@ApiModel(value="TbTenant对象", description="")
public class TbTenant implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "身份证号")
    @TableId(value = "IdCard", type = IdType.ID_WORKER)
    private Long IdCard;

    @ApiModelProperty(value = "车牌号")
    @TableField("CarId")
    private String CarId;

    @ApiModelProperty(value = "本人名称")
    @TableField("Name")
    private String Name;

    @ApiModelProperty(value = "所绑定的微信的id")
    @TableField("WechatId")
    private String WechatId;

    @ApiModelProperty(value = "1代表是小区户主，0代表是租车位者")
    @TableField("UserIdentify")
    private Integer UserIdentify;

    @ApiModelProperty(value = "余额，余额不足以支付的话则跳转微信支付")
    @TableField("Balance")
    private BigDecimal Balance;


}
