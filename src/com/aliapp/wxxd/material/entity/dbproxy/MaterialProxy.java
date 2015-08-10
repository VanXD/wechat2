package com.aliapp.wxxd.material.entity.dbproxy;

import org.springframework.web.multipart.MultipartFile;

import com.aliapp.wxxd.material.entity.db.Material;
import com.aliapp.wxxd.material.entity.outputmessage.mass.ArticlesMassOutputMessage;

import bsh.This;
import interfaces.EntityWrapperInterface;

public class MaterialProxy extends Material implements EntityWrapperInterface {
	private MultipartFile file;
	private ArticlesMassOutputMessage[] articles;
	private Integer index;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public ArticlesMassOutputMessage[] getArticles() {
		return articles;
	}

	public void setArticles(ArticlesMassOutputMessage[] articles) {
		this.articles = articles;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	@Override
	public void wrap(Object o) {
		if (o instanceof Material) {
			Material material = (Material) o;
			setMedia_id(material.getMedia_id());
			setUrl(material.getUrl());
		}
	}

	@Override
	public String toString() {
		return "MaterialProxy [file=" + file + ", getFile()=" + getFile()
				+ ", getMedia_id()=" + getMedia_id() + ", getTitle()="
				+ getTitle() + ", getIntroduction()=" + getIntroduction()
				+ ", getUrl()=" + getUrl() + "]";
	}

}
