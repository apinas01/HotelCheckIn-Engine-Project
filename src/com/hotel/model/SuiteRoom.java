package com.hotel.model;

public class SuiteRoom extends Room {
    private boolean includeBreakfast;

    public SuiteRoom(String roomNumber, double basePricePerNight, boolean includeBreakfast) {
        super(roomNumber, basePricePerNight);
        this.includeBreakfast = includeBreakfast;
    }

    @Override
    public double calculateTotalPrice(int nights) {
        double total = getBasePricePerNight() * nights;
        if (includeBreakfast) {
            total += (500 * nights); // คิดค่าอาหารเช้าเพิ่มคืนละ 500
        }
        return total;
    }
}
