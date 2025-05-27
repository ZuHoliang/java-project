package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.dto.RoomDto;
import com.example.demo.service.RoomService;

import jakarta.validation.Valid;

@Controller
@RequestMapping(value = {"/room","/rooms"})
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@GetMapping
	public String getRooms(Model model,@ModelAttribute RoomDto roomDto) {
		
		List<RoomDto> roomDtos = roomService.findAllRooms();
		model.addAttribute("roomDtos", roomDtos);
		return "room/room";
	}
	
	@GetMapping("/{roomId}")
	public String getRoom(@PathVariable Integer roomId, Model model) {
		RoomDto roomDto = roomService.getRoomById(roomId);
		model.addAttribute("roomDto", roomDto);
		return "room/room_update";
	}
	
	@PostMapping
	public String addRoom(@ModelAttribute @Valid RoomDto roomDto, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("roomDtos", roomService.findAllRooms());
			return "room/room";
		}
		
		roomService.addRoom(roomDto);
		return "redirect:/rooms";
	}
	
	@PutMapping("/update/{roomId}")
	public String updateRoom(@PathVariable Integer roomId, @Valid RoomDto roomDto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "room/room_update";
		}
		
		roomService.updateRoom(roomId, roomDto);
		return "redirect:/rooms";
	}

}
