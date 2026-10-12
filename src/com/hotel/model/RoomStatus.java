package com.hotel.model;

// Enum สำหรับควบคุมสถานะห้องพัก ไม่ให้ใส่ค่ามั่วๆ
public enum RoomStatus {
    VACANT,   // ห้องว่าง
    BOOKED,   // จองแล้ว (รอ Check-in)
    OCCUPIED  // เข้าพักอยู่
}