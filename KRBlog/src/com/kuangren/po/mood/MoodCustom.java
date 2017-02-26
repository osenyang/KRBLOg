package com.kuangren.po.mood;

import com.kuangren.po.type.Type;
import com.kuangren.service.system.TypeService;

public class MoodCustom extends Mood {

	private static final long serialVersionUID = 3987505015089994147L;
	/**
	 * 
	 */

	/** 判断是不是置顶 */
	public Boolean isTop;

	/** 存储着好多标签id */
	public Integer[] tagIds;

	public Boolean getIsTop() {
		return isTop;
	}

	public void setIsTop(Boolean isTop) {
		this.isTop = isTop;
	}

	public Integer[] getTagIds() {
		return tagIds;
	}

	public void setTagIds(Integer[] tagIds) {
		this.tagIds = tagIds;
	}

	/** 返回真实的标签tag。把tagList 用“，”分割 
	 * @throws Exception */
	public String getTag(Integer[] ids, TypeService typeService) throws Exception {
		StringBuilder stringBuilder = new StringBuilder();
		
		for (int i = 0; i < ids.length; i++) {
			Integer id = ids[i];
			// 根据id 找出type 实体
			Type type = typeService.getById(id);
			stringBuilder.append(type.getType());
			stringBuilder.append("，");
			
			typeService.usedPlus1(id);//被应用 + 1
		}
		
		return stringBuilder.substring(0, stringBuilder.length() - 1).toString();
	}

}