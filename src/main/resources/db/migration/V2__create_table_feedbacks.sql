CREATE TABLE IF NOT EXISTS feedbacks (
      id bigint not null auto_increment,
      feeling varchar(255),
      feedback_date datetime,
      company varchar(255),
      primary key(id)
);

INSERT INTO feedbacks (feeling, feedback_date, company) VALUES
      ('Happy', '2024-09-01', 'Company A'),
      ('Sad', '2024-09-02', 'Company B'),
      ('Excited', '2024-09-03', 'Company C'),
      ('Nervous', '2024-09-04', 'Company D'),
      ('Content', '2024-09-05', 'Company E');
