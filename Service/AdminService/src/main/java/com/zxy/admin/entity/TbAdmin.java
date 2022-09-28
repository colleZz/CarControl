package com.zxy.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2022-09-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_admin")
@ApiModel(value="TbAdmin对象", description="")
public class TbAdmin implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "身份证号")
    @TableId(value = "IdCard", type = IdType.ID_WORKER)
    private Long IdCard;

    @ApiModelProperty(value = "密码")
    @TableField("PassWord")
    private String PassWord;

    @TableField("Name")
    private String Name;

    @TableField("Avatar")
    private String Avatar;


}
