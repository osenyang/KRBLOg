package com.kuangren.po.photo;

import com.kuangren.enumerate.TypeEnum;
import com.kuangren.po.BasePo;

public class Photo extends BasePo{
	private static final long serialVersionUID = -2950444102752757084L;
    /**
	 * 
	 */


    private String name;

    private String imgPath;

    private String mark;

    private Integer parent_id;

    private Integer favor;


    public Photo(){}
    
    public Photo(String originalFilename, String imgPath, Integer albumId) {
    	this.name = originalFilename;
		this.imgPath = imgPath;
		this.mark = TypeEnum.ALBUM;//如果不传递mark 值，那么默认为相册album
		this.parent_id = albumId;
	}
    
	public Photo(String name, String imgPath, String mark, Integer parent_id) {
		super();
		this.name = name;
		this.imgPath = imgPath;
		this.mark = mark;
		this.parent_id = parent_id;
	}




	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath == null ? null : imgPath.trim();
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public Integer getFavor() {
        return favor;
    }

    public void setFavor(Integer favor) {
        this.favor = favor;
    }
}