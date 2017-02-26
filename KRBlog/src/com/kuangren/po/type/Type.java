package com.kuangren.po.type;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.kuangren.controller.validation.DeepValidation;
import com.kuangren.po.BasePo;

public class Type extends BasePo {

	private static final long serialVersionUID = 8392600319823277768L;
    /**
	 * 
	 */

	@Size(min = 1, max = 16, 
			message = "{type.length.error}",
			groups = {DeepValidation.class})
	@NotEmpty(message="{type.is.null}")
	/** 类别名称 */
	private String type;

    private String mark;

    private Integer isSecret;

    private Integer used;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    public Integer getIsSecret() {
        return isSecret;
    }

    public void setIsSecret(Integer isSecret) {
        this.isSecret = isSecret;
    }

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }
}