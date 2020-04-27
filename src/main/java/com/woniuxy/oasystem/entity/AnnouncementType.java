package com.woniuxy.oasystem.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AnnouncementType {

	private Integer atId;
	private Boolean atFlag;
	private String atName;
	private String atDescription;
	private List<Announcement> ans;
}
