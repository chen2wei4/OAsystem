package com.woniuxy.oasystem.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AnnouncementFile {

	private Integer afId;
	private Integer afAnId;
	private String afName;
	private String afAddress;
	private Boolean afFlag;
}
