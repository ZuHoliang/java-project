package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Room;

//Spring JPA
@Repository
public interface RoomRepository extends JpaRepository<Room, Integer>{
	
	//查詢roomSize大於指定值的房間(自動產生SQL)
	List<Room> findByRoomSizeGreaterThan(Integer size);
	
	//查詢roomSize大於指定值的房間(自動產生T-SQL**欄位名要符合資料表中的設定)
	@Query(value = "select room_id, room_name, room_size from room where room_size > :roomSize", nativeQuery = true)
	List<Room> findRooms(Integer roomSize);
	
	//查詢roomSize大於指定值的房間(自動產生PQL**欄位名要符合entity中的設定)
	@Query(value = "select r from Room r where r.roomSize > :roomSize")
	List<Room> readRooms(Integer roomSize);
}
