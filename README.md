# 🏨 Hotelify - Simple Hotel Booking System

> A minimalist, Java-based Hotel Property Management System (PMS) designed for practicing Object-Oriented Programming (OOP) concepts, code tracing, and design patterns.

---

## 📌 Project Overview
**Hotelify** เป็นระบบจำลองการจองและจัดการห้องพักโรงแรมที่พัฒนาด้วยภาษา Java โดยเน้นโครงสร้างโค้ดแบบ **Clean Architecture** แบ่งโมดูลชัดเจน เหมาะสำหรับการฝึกไล่โค้ด (Code Tracing) และทำความเข้าใจการเชื่อมโยงของวัตถุในรูปแบบ OOP

### Key Features
- 🛏️ **Room State Management:** ควบคุมสถานะห้องพักด้วย Enum (`VACANT`, `BOOKED`, `OCCUPIED`) ป้องกันการจองซ้ำ
- 💰 **Dynamic Price Calculation:** คำนวณราคาห้องพักตามประเภทห้อง (Standard / Suite) และบริการเสริมผ่าน Polymorphism
- 🔐 **Validation & Guard Clauses:** ตรวจสอบความถูกต้องก่อนทำรายการทุกครั้ง (เช่น ต้องจองก่อนจึงจะ Check-in ได้)
- 📦 **Modular Architecture:** แยกส่วน Data (Model), Management (Repository/Service) และ Execution (Main) ชัดเจน

---

## 🏗️ Project Structure

```text
src/
└── com/
    └── hotel/
        ├── model/              # [Data Layer] Data Structures & Room Models
        │   ├── RoomStatus.java # Enum: VACANT, BOOKED, OCCUPIED
        │   ├── Room.java       # Abstract Base Class
        │   ├── StandardRoom.java
        │   └── SuiteRoom.java
        │
        ├── service/            # [Business Logic] Booking & Check-in Control
        │   └── HotelService.java
        │
        └── Main.java           # [Entry Point] Test Scenarios & Execution