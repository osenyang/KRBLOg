package com.kuangren.po.album;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.kuangren.controller.validation.DeepValidation;
import com.kuangren.po.BasePo;

public class Album extends BasePo {

	private static final long serialVersionUID = -3399211194069536078L;
    /**
	 * 
	 */

	@Size(min = 1, max = 36, 
			message = "{album.name.length.error}",
			groups = {DeepValidation.class})
	@NotEmpty(message="{album.name.is.null}")
	private String name;

    private String description;

    private Integer isSecret;

    private Integer seeCount;

    private Integer replyCount;

    private String coverPath;

    private String type;

    private Integer favor;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getIsSecret() {
        return isSecret;
    }

    public void setIsSecret(Integer isSecret) {
        this.isSecret = isSecret;
    }

    public Integer getSeeCount() {
        return seeCount;
    }

    public void setSeeCount(Integer seeCount) {
        this.seeCount = seeCount;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath == null ? null : coverPath.trim();
    }

    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getFavor() {
        return favor;
    }

    public void setFavor(Integer favor) {
        this.favor = favor;
    }
}