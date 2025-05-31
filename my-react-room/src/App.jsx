import "./App.css";
import React, { useEffect, useState } from "react";

const API_BASE = "http://localhost:8081/rest/room";

function App() {
  const [rooms, setRooms] = useState([]);
  const [isEditing, setIsEditing] = useState([]);
  const [form, setForm] = useState({
    roomId: "",
    roomName: "",
    roomSize: "",
  });

  useEffect(() => {
    console.log("檢查所有房間");
    fetchRooms();
  }, []);

  const fetchRooms = async () => {
    try {
      const response = await fetch(API_BASE, { credentials: "include" });
      const data = await response.json();
      console.log("取得房間資料:", data);
      setRooms(data.data);
    } catch (err) {
      console.log("無法取得房間資料:", err.message);
      alert("無法取得房間資料:" + err.message);
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const method = isEditing ? "PUT" : "POST";
      const url = isEditing ? `${API_BASE}/${form.roomId}` : API_BASE;
      const res = await fetch(url, {
        method: method,
        credentials: "include",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(form),
      });
      if (!res.ok) {
        throw new Error(res);
      }

      const resData = await res.json();
      console.log(resData.status);
      console.log(resData.message);
      if (resData.status == 200) {
        setForm({
          roomId: "",
          roomName: "",
          roomSize: "",
        });
        fetchRooms();
        setIsEditing(false); //解除編輯模式
      } else {
        alert("新增房間失敗: " + resData.message);
      }
    } catch (err) {
      console.log("表單傳送失敗:", err.message);
      alert("表單傳送失敗:" + err.message);
    }
  };

  const handleDelete = async (roomId) => {
    if (!window.confirm("確定要刪除這個房間嗎?")) {
      return;
    }
    try {
      const method = "DELETE";
      const url = `${API_BASE}/${roomId}`;

      const res = await fetch(url, {
        method,
        credentials: "include",
      });
      if (!res.ok) {
        throw new Error(res);
      }

      const resData = await res.json();

      if (resData.status == 200) {
        fetchRooms();
      } else {
        alert("刪除房間失敗: " + resData.message);
      }
    } catch (err) {
      console.log("刪除房間失敗:", err.message);
      alert("刪除房間失敗:" + err.message);
    }
  };

  const handleEdit = (room) => {
    setForm(room);
    setIsEditing(true);
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  return (
    <div style={{ padding: "20px", fontFamily: "Arial" }}>
      <h1>房間管理系統</h1>

      <form onSubmit={handleSubmit} style={{ marginBottom: "30px" }}>
        <fieldset>
          <legend>{isEditing ? "編輯房間" : "新增房間"}</legend>

          <div>
            <label>房號:</label>
            <input
              type="number"
              name="roomId"
              value={form.roomId}
              onChange={handleChange}
              required
            />
          </div>

          <div>
            <label>房名:</label>
            <input
              type="text"
              name="roomName"
              value={form.roomName}
              onChange={handleChange}
              required
            />
          </div>

          <div>
            <label>人數:</label>
            <input
              type="number"
              name="roomSize"
              value={form.roomSize}
              onChange={handleChange}
              required
            />
          </div>

          <button type="submit">{isEditing ? "編輯房間" : "新增房間"}</button>
          {isEditing && (
            <button
              type="button"
              onClick={() => {
                setForm({ roomId: "", roomName: "", roomSize: "" });
                setIsEditing(false);
              }}
            >
              取消編輯
            </button>
          )}
        </fieldset>
      </form>

      <table border="1" cellPadding="10">
        <thead>
          <tr>
            <th>房號</th>
            <th>房名</th>
            <th>人數</th>
            <th>編輯</th>
            <th>刪除</th>
          </tr>
        </thead>
        <tbody>
          {rooms.map((room) => {
            return (
              <tr key={room.roomId}>
                <td>{room.roomId}</td>
                <td>{room.roomName}</td>
                <td>{room.roomSize}</td>
                <td>
                  <button
                    onClick={() => {
                      handleEdit(room);
                    }}
                  >
                    編輯
                  </button>
                </td>
                <td>
                  <button
                    onClick={() => {
                      handleDelete(room.roomId);
                    }}
                  >
                    刪除
                  </button>
                </td>
              </tr>
            );
          })}
          {rooms.length === 0 && (
            <tr>
              <td colSpan="5">無資料</td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
}

export default App;
