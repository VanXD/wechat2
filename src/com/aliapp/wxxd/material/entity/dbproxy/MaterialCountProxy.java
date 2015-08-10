package com.aliapp.wxxd.material.entity.dbproxy;

import com.aliapp.wxxd.material.entity.db.MaterialCount;

public class MaterialCountProxy extends MaterialCount {

	@Override
	public String toString() {
		return "MaterialCountProxy [getId()=" + getId() + ", getVoice_count()="
				+ getVoice_count() + ", getVideo_count()=" + getVideo_count()
				+ ", getImage_count()=" + getImage_count()
				+ ", getNews_count()=" + getNews_count() + "]";
	}

}
