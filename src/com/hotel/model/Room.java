package com.hotel.model;

public abstract class Room {
    private String roomNumber;
    private double basePricePerNight;
    private RoomStatus status;

    public Room(String roomNumber, double basePricePerNight) {
        this.roomNumber = roomNumber;
        this.basePricePerNight = basePricePerNight;
        this.status = RoomStatus.VACANT; // สร้างห้องใหม่ให้สถานะว่างเสมอ
    }

    public String getRoomNumber() { return roomNumber; }
    public double getBasePricePerNight() { return basePricePerNight; }
    public RoomStatus getStatus() { return status; }
    public void setStatus(RoomStatus status) { this.status = status; }

    // Abstract method: ให้คลาสลูกไปคำนวณราคาเองตามสิทธิพิเศษของแต่ละห้อง
    public abstract double calculateTotalPrice(int nights);
}
