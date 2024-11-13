/* NOTES:
		Seat Number in VARCHAR form
        >> A/B/C/D/E/F/G/H + 1-2 digit numbers
        
		Member ID, Flight ID and Employee ID in VARCHAR form
        >> Member ID: GST001
        >> Flight ID: PAL001, QTR001 (ICAO Code + Flight Number)
        >> Employee ID: EMP001
        
        Departure and Arrival Time in DATETIME form
        >> YYYY-MM-DD hh:mm:ss
        
        Origin and Destination in VARCHAR form
        >> Use Country Codes (limit to 3 characters)
        
        Passport Number in VARCHAR form
        >> most passports will have 1 letter and 8 numbers
        
        Contact Number in INT form
        >> Country Code + Phone Number
        >> longest phone number contains 15 digits
        
        VIP Status: Silver, Gold, Platinum, Diamond
*/

/* Booking Records:
		Booking Reference (INT 8), Member ID (VARCHAR 6), Flight ID(VARCHAR 6), 
        Check-In Date (DATE), Seat Number (VARCHAR3), Class (VARCHAR 8), 
        Food Order (VARCHAR 20), Number of Check-In Baggage (INT 2), Total Cost (INT 10)
        
        PRIMARY KEY: Booking Reference
        FOREIGN KEYS: Member ID (to Passenger Table), Flight ID (to Flight Table)
*/

CREATE Table bookings (
	ref_id INT(8) NOT NULL,
    PRIMARY KEY (ref_id),
    CONSTRAINT FOREIGN KEY (member_id) REFERENCES passengers(member_id),
    CONSTRAINT FOREIGN KEY (flight_id) REFERENCES flights(flight_id));

/* Flight Records:
		Flight ID (VARCHAR 6), Origin (VARCHAR 3), Destination (VARCHAR 3), 
        Gate Number (INT 2), Departure Time (DATETIME), Arrival Time (DATETIME), 
        Pilot ID (VARCHAR 6), Co-Pilot ID (VARCHAR 6), Lead Attendant (VARCHAR 6), 
        Flight Attendant (VARCHAR 6)
        
        PRIMARY KEY: Flight ID
        FOREIGN KEYS: Pilot ID (to Employees Table), Co-Pilot ID (to Employees Table),
				Lead Attendant (to Employees Table), Flight Attendant (to Employees Table)
*/

CREATE Table flights (
	flight_id VARCHAR(6) NOT NULL,
    PRIMARY KEY (flight_id),
    CONSTRAINT FOREIGN KEY (pilot_id) REFERENCES employees(employee_ID),
    CONSTRAINT FOREIGN KEY (copilot_id) REFERENCES employees(employee_ID),
    CONSTRAINT FOREIGN KEY (lead_attendant) REFERENCES employees(employee_ID),
    CONSTRAINT FOREIGN KEY (flight_attendant) REFERENCES employees(employee_ID));
    
/* Passenger Records:
		Member ID (VARCHAR 6), Passport Number (VARCHAR 9), Last Name (VARCHAR 20),
        First Name (VARCHAR 30), Date of Birth (DATE), Contact Number (INT 15),
        E-Mail (VARCHAR 320), VIP Status (VARCHAR )
*/

CREATE Table passengers (
	passenger_id VARCHAR(6) NOT NULL,
    passport_number VARCHAR(9) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    first_name VARCHAR(30) NOT NULL,
    birthdate DATE,
    contact_no INT(15) NOT NULL,
    email_address VARCHAR(320),
    vip_status VARCHAR(8),
    PRIMARY KEY (passenger_id));
    
/* Employee Records:
		Employee ID (VARCHAR 6), Last Name (VARCHAR 20), First Name (VARCHAR 30),
		Job Title (VARCHAR 20), Hire Date (DATE), Salary (FLOAT 10, 2),
        Department (VARCHAR 20)
*/

CREATE Table employees (
	employee_id VARCHAR(6) NOT NULL,
    PRIMARY KEY (employee_id));