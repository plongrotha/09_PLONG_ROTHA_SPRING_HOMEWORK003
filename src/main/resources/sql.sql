

CREATE TABLE IF NOT EXISTS venues(
    venues_id SERIAL PRIMARY KEY,
    venues_name VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL
)

CREATE TABLE IF NOT EXISTS events (
    event_id SERIAL PRIMARY KEY,
    event_name VARCHAR(255) NOT NULL,
    event_date DATE NOT NULL,
    venue_id INT NOT NULL,
    CONSTRAINT fk_venue_id FOREIGN KEY (venue_id) REFERENCES venues(venue_id) ON DELETE CASCADE ON UPDATE CASCADE
);`

INSERT INTO events (event_name, event_date, venue_id) VALUES
('Concert', '2023-10-01', 1),
('Art Exhibition', '2023-10-05', 2),
('Theater Play', '2023-10-10', 1),
('Comedy Show', '2023-10-15', 3),
('Music Festival', '2023-10-20', 2);


CREATE TABLE IF NOT EXISTS attendees (
    attendee_id SERIAL PRIMARY KEY,
    attendee_name VARCHAR(255) NOT NULL,
   email VARCHAR(255) NOT NULL UNIQUE
);



--  
CREATE TABLE IF NOT EXISTS event_attendees (
    event_id INT NOT NULL,
    attendee_id INT NOT NULL,
    PRIMARY KEY (event_id, attendee_id),
    CONSTRAINT fk_event_id FOREIGN KEY (event_id) REFERENCES events(event_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_attendee_id FOREIGN KEY (attendee_id) REFERENCES attendees(attendee_id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO event_attendees (event_id, attendee_id) VALUES
(1, 1),
(1, 2),
(2, 3),
(3, 1),
(4, 2),
(5, 3);