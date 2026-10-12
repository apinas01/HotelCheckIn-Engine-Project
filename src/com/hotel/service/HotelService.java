package com.hotel.service;

import com.hotel.model.*;
import java.util.ArrayList;
import java.util.List;

public class HotelService {
    private List<Room> rooms = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    // ค้นหาห้องจากเลขห้อง
    public Room findRoom(String roomNumber) {
        for (Room r : rooms) {
            if (r.getRoomNumber().equals(roomNumber)) {
                return r;
            }
        }
        return null; // หาห้องไม่เจอ
    }

    // ขั้นตอนที่ 1: จองห้องพัก
    public boolean bookRoom(String roomNumber) {
        Room room = findRoom(roomNumber);
        
        // Guard Clause: ต้องมีห้อง และสถานะต้องว่างเท่านั้นถึงจะจองได้
        if (room != null && room.getStatus() == RoomStatus.VACANT) {
            room.setStatus(RoomStatus.BOOKED);
            System.out.println("[Hotel] จองห้อง " + roomNumber + " สำเร็จ!");
            return true;
        }
        System.out.println("[Hotel] จองห้อง " + roomNumber + " ไม่สำเร็จ (ห้องไม่ว่าง หรือไม่มีห้องนี้)");
        return false;
    }

    // ขั้นตอนที่ 2: Check-in และคำนวณเงิน
    public double checkIn(String roomNumber, int nights) {
        Room room = findRoom(roomNumber);

        // ต้องจองไว้ก่อน (BOOKED) ถึงจะ Check-in ได้
        if (room != null && room.getStatus() == RoomStatus.BOOKED) {
            room.setStatus(RoomStatus.OCCUPIED);
            double price = room.calculateTotalPrice(nights); // Polymorphism ทำงานตรงนี้!
            System.out.println("[Hotel] Check-in ห้อง " + roomNumber + " เรียบร้อย (" + nights + " คืน) | ยอดรวม: " + price + " บาท");
            return price;
        }
        System.out.println("[Hotel] Check-in ไม่สำเร็จ: ห้องไม่ได้อยู่ในสถานะที่จองไว้");
        return 0;
    }

    // ขั้นตอนที่ 3: Check-out คืนห้อง
    public void checkOut(String roomNumber) {
        Room room = findRoom(roomNumber);

        if (room != null && room.getStatus() == RoomStatus.OCCUPIED) {
            room.setStatus(RoomStatus.VACANT); // คืนสถานะให้เป็นห้องว่างพร้อมรับลูกค้าใหม่
            System.out.println("[Hotel] Check-out ห้อง " + roomNumber + " เรียบร้อย คืนสถานะเป็นห้องว่าง");
        } else {
            System.out.println("[Hotel] ไม่สามารถ Check-out ได้");
        }
    }
}
