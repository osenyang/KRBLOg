package com.kuangren.po.inform;

import com.kuangren.po.BasePo;

public class Inform extends BasePo {
	private static final long serialVersionUID = -1034278097458113285L;
    /**
	 * 
	 */

    private String title;

    private String mark;

    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}