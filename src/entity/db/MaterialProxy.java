package entity.db;

import org.springframework.web.multipart.MultipartFile;

import bsh.This;
import interfaces.EntityWrapperInterface;

public class MaterialProxy extends Material implements EntityWrapperInterface {
	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public void wrap(Object o) {
		if (o instanceof MaterialProxy) {
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
