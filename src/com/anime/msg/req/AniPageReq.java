package com.anime.msg.req;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.anime.bean.Ani;
import com.anime.bean.Tag;
import com.anime.msg.common.PageRequest;

public class AniPageReq extends PageRequest<Ani> implements Serializable{

	private static final long serialVersionUID = 2450343769738765139L;

	private Ani ani;
	
	private List<Tag> tags;
	
	private Date startTime;
	
	private Date endTime;

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Ani getAni() {
		return ani;
	}

	public void setAni(Ani ani) {
		this.ani = ani;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "QueryAniPageReq [ani=" + ani + ", tags=" + tags + "]";
	}
	
	public Integer addTag(Tag tag){
		this.tags.add(tag);
		return this.tags.size();
	}
}
