package com.hotel;

import com.hotel.model.*;
import com.hotel.service.HotelService;

public class Main {
    public static void main(String[] args) {
        HotelService hotel = new HotelService();

        // 1. ตระเตรียมห้องพัก
        hotel.addRoom(new StandardRoom("101", 1000.0));
        hotel.addRoom(new SuiteRoom("201", 2500.0, true)); // รวมอาหารเช้า

        System.out.println("=== เคสที่ 1: โฟลว์การทำงานปกติ (Standard Room) ===");
        hotel.bookRoom("101");               // สถานะเปลี่ยน VACANT -> BOOKED
        hotel.checkIn("101", 2);             // สถานะเปลี่ยน BOOKED -> OCCUPIED, ยอด 2000
        hotel.checkOut("101");              // สถานะเปลี่ยน OCCUPIED -> VACANT

        System.out.println("\n=== เคสที่ 2: ลองจองห้องซ้ำที่กำลังโดนจองอยู่ ===");
        hotel.bookRoom("201");               // จองรอบแรก สำเร็จ (VACANT -> BOOKED)
        hotel.bookRoom("201");               // จองซ้ำ! ต้องล้มเหลว เพราะสถานะตอนนี้เป็น BOOKED

        System.out.println("\n=== เคสที่ 3: Check-in ห้อง Suite ที่รวมอาหารเช้า ===");
        hotel.checkIn("201", 3);             // คำนวณราคารวม: (2500*3) + (500*3) = 9000 บาท
        hotel.checkOut("201");
    }
}
