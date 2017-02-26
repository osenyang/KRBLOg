package com.kuangren.po.album;

import java.util.List;

import com.kuangren.po.photo.PhotoCustom;

public class AlbumCustom extends Album {

	private static final long serialVersionUID = 3987505015089994147L;
	/**
	 * 
	 */

	public String imgPath;
	
	public List<PhotoCustom> photos;
	
	public Integer typeId;


	public AlbumCustom() {
		super();
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public List<PhotoCustom> getPhotos() {
		return photos;
	}

	public void setPhotos(List<PhotoCustom> photos) {
		this.photos = photos;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

}