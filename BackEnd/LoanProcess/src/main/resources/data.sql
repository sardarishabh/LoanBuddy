--insert into loan_application(application_id, member_id, loan_id, mode_of_payment, loan_amount, loan_duration, purpose, loan_status) 
--values(1001, 5, 101, 1, 1000000, 60, 'For Home Loan', 1);
--insert into loan_application(application_id, member_id, loan_id, mode_of_payment, loan_amount, loan_duration, purpose, loan_status) 
--values(1002, 6, 102, 1, 500000, 36, 'For Personal Care', 1);
--insert into loan_application(application_id, member_id, loan_id, mode_of_payment, loan_amount, loan_duration, purpose, loan_status) 
--values(1003, 7, 105, 1, 800000, 48, 'For Vehicle Loan', 1);
--insert into loan_application(application_id, member_id, loan_id, mode_of_payment, loan_amount, loan_duration, purpose, loan_status) 
--values(1004, 8, 103, 1, 650000, 60, 'For Medical Loan', 1);
--insert into loan_application(application_id, member_id, loan_id, mode_of_payment, loan_amount, loan_duration, purpose, loan_status) 
--values(1005, 11, 104, 1, 300000, 36, 'For Education Loan', 1);

insert into loan_application(application_id, member_id, loan_id, mode_of_payment, loan_amount, loan_duration, purpose, loan_status) 
values(1001, 5, 101, 'NEFT', 1000000, 60, 'For Home Loan', 'Approved');
insert into loan_application(application_id, member_id, loan_id, mode_of_payment, loan_amount, loan_duration, purpose, loan_status) 
values(1002, 6, 102, 'Net Banking', 500000, 36, 'For Personal Care', 'Approved');
insert into loan_application(application_id, member_id, loan_id, mode_of_payment, loan_amount, loan_duration, purpose, loan_status) 
values(1003, 7, 105, 'Cash', 800000, 48, 'For Vehicle Loan', 'Approved');
insert into loan_application(application_id, member_id, loan_id, mode_of_payment, loan_amount, loan_duration, purpose, loan_status) 
values(1004, 8, 103, 'NEFT', 650000, 60, 'For Medical Loan', 'Approved');
insert into loan_application(application_id, member_id, loan_id, mode_of_payment, loan_amount, loan_duration, purpose, loan_status) 
values(1005, 11, 104, 'Net Banking', 300000, 36, 'For Education Loan', 'Denied');

insert into loan_payment(payment_id, application_id, date_of_payment, amount, interest_paid, principal_paid, balance) 
values(10001, 1001, '31/01/2023', 100000, 20000, 80000, 920000);
insert into loan_payment(payment_id, application_id, date_of_payment, amount, interest_paid, principal_paid, balance) 
values(10002, 1002, '31/01/2023', 100000, 20000, 80000, 420000);
insert into loan_payment(payment_id, application_id, date_of_payment, amount, interest_paid, principal_paid, balance) 
values(10003, 1003, '31/01/2023', 100000, 20000, 80000, 720000);
insert into loan_payment(payment_id, application_id, date_of_payment, amount, interest_paid, principal_paid, balance) 
values(10004, 1004, '31/01/2023', 100000, 20000, 80000, 570000);
insert into loan_payment(payment_id, application_id, date_of_payment, amount, interest_paid, principal_paid, balance) 
values(10005, 1005, '31/01/2023', 100000, 20000, 80000, 220000);