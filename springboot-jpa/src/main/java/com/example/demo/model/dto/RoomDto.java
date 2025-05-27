package com.example.demo.model.dto;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
	@NotNull(message = "房號不可為空")
	@Range(min = 0, max = 9999, message = "房號須介於{min}~{max}")
	private Integer roomId;
	
	@NotNull(message = "房間名稱不可為空")
	@Size(min = 2, message = "房名至少要有{min}字")
	private String roomName;
	
	@NotNull(message = "房間人數不可為空")
	@Range(min = 0, max = 20, message = "房間人數須介於{min}~{max}")
	private Integer roomSize;	

}
