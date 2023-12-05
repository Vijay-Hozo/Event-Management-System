# Event Management System

An application for managing events, including registrations,
schedules, and ticket sales. Event organizers can create, update, and delete
event information.

## User Classes and Characteristics:

The system caters to distinct user roles – Organizers and Attendees. Organizers, as central administrators, wield comprehensive privileges for effective event management. Attendees, participants in events, access a user-friendly interface for seamless registration and participation. This ensures a streamlined and personalized experience for both within the Event Management System.

**The features that are available to the Organizer are :**

- Organizer can create and schedule an event.
- Organizer can update or edit event information.
- Organizers can use the system to scan tickets and facilitate event check-ins.
- Organizers can manage attendee information for effective event coordination

**The features that are available to the Attendees are :**

- Attendees can access event details, schedules, and promotional information.
- Attendees can sign up for events and purchase tickets through the system.
- Attendees can give rating and review for an event

## Operating Environment

The Event Management System is an application will be operating in all operating system like Linux, MacOS.The
only requirement to use this online product would be the internet connection.The hardware configuration include Hard Disk: 40 GB, Monitor: 15” Color monitor, Keyboard:
122 keys. The basic input devices required are keyboard, mouse and output devices are monitor,
printer etc.

## Assumptions and Dependencies :

**The Assumptions are :**

- The coding should be error free
- The information of all attendees, events and events organizer must be stored in a database that is accessible by the website.
- The system should provide search facility and support quick transactions.
- Users may access from any computer that has internet browsing capabilities and an Internet connection.

**The Dependencies are :**

- Any update regarding the event is to be recorded to the database and the data entered should be correct.
- The information of all users must be stored in a database that is accessible by the Event Management System.
- The system should have the general report stored.
- On the basis of listing requirements and specification the project will be developed and run.

# ER Diagram


```mermaid

---
title: EVENT MANAGEMENT SYSTEM
---

erDiagram
    NEW_EVENT 
    TICKET 
    ATTENDEE ||--o{ NEW_EVENT : Attends
    ATTENDEE ||--o{ TICKET : Buys
    ORGANIZER ||--o{NEW_EVENT : Organizes
    NEW_EVENT ||--o{TICKET : Provides


    NEW_EVENT{
        Varchar Event_ID PK
        Varchar Organizer_ID FK
        Varchar Event_Name
        Varchar Event_Description
        Varchar Venue
        int Duration
        DateTime Event_Date
        timestamp Created_At
        bigint Organizer_Mobile_number
        Varchar Guest
        int Ticket_Fare
    }

    ATTENDEE{
        Varchar Attendee_ID PK
        Varchar Attendee_Name
        Varchar Email
        Varchar Password
        bigint Mobile_Number
        Varchar Events_registered
    }

    ORGANIZER{
        Varchar Organizer_ID PK
        Varchar Organizer_Name
        Varchar Email
        Password Password
    }

    TICKET{
        Varchar Ticket_ID PK
        Varchar Attendee_ID FK
        Varchar Event_ID FK
        Varchar Event_Name 
        DateTime Event_Date 
        image QR_Code
        int Ticket_Fare
    }


```