package com.anime.bean;

import java.io.Serializable;
import java.util.Date;

public class Ani implements Serializable{

	private static final long serialVersionUID = -143293185117591800L;

	private Integer id;
	
	private Date createTime;
	
	private Integer episodeNum;
	
	private String info;
	
	private String name;
	
	private String period;
	
	private Integer state;
	
	private String url;
	
	private Integer flag;

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getEpisodeNum() {
		return episodeNum;
	}

	public void setEpisodeNum(Integer episodeNum) {
		this.episodeNum = episodeNum;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Ani [id=" + id + ", createTime=" + createTime + ", episodeNum=" + episodeNum + ", info=" + info
				+ ", name=" + name + ", period=" + period + ", state=" + state + ", url=" + url + ", flag=" + flag
				+ "]";
	}
	
	
}
