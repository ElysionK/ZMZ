package com.tianwen.common.util;

import java.util.Comparator;

import com.tianwen.common.entity.Dict;

/**
 * 字典表的排放比较器。
 * @author Administrator
 *
 */
public class DictVOComparator implements Comparator<Dict>{

	private final Boolean isDesc;

	public DictVOComparator(Boolean isDesc) {
		this.isDesc = isDesc;
	}

	public DictVOComparator() {
		this.isDesc = false;
	}

	public int compare(Dict o1, Dict o2) {
		if (isDesc) {
			if (o2.getSortNo() > o1.getSortNo()) {
				return 1;
			} else if ( o2.getSortNo() .equals(o1.getSortNo()) ) {
				return 0;
			} else {
				return -1;
			}
		} else {
			if (o1.getSortNo() > o2.getSortNo()) {
				return 1;
			} else if ( o1.getSortNo() .equals(o2.getSortNo()) ) {
				return 0;
			} else {
				return -1;
			}
		}
	}

}
