package com.hotel.model;

public class StandardRoom extends Room {
    public StandardRoom(String roomNumber, double basePricePerNight) {
        super(roomNumber, basePricePerNight);
    }

    @Override
    public double calculateTotalPrice(int nights) {
        // ห้อง Standard คิดราคาปกติตามจำนวนคืน
        return getBasePricePerNight() * nights;
    }
}