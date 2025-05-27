package com.example.demo.model.dto;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
	private Integer roomId;
	private String roomName;
	
	@NotNull(message = "房間人數不可為空")
	@Range(min = 0, max = 20, message = "房間人數須介於{min}~{max}")
	private Integer roomSize;	

}
