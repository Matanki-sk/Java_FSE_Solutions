-- STEP 1: Create Customers and Loans tables
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(50),
    Age NUMBER,
    InterestRate NUMBER,
    Balance NUMBER,
    IsVIP VARCHAR2(5)
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    DueDate DATE
);

-- STEP 2: Insert sample data into Customers
INSERT INTO Customers VALUES (1, 'Alice', 65, 10.0, 15000, 'FALSE');
INSERT INTO Customers VALUES (2, 'Bob', 45, 11.0, 8000, 'FALSE');
INSERT INTO Customers VALUES (3, 'Carol', 70, 9.5, 12000, 'FALSE');

-- Insert sample data into Loans
INSERT INTO Loans VALUES (101, 1, SYSDATE + 10); -- due in 10 days
INSERT INTO Loans VALUES (102, 2, SYSDATE + 40); -- due in 40 days
INSERT INTO Loans VALUES (103, 3, SYSDATE + 5);  -- due in 5 days

COMMIT;

-- STEP 3: Scenario 1 - Apply 1% interest discount for customers age > 60
BEGIN
    FOR rec IN (SELECT CustomerID, Age FROM Customers)
    LOOP
        IF rec.Age > 60 THEN
            UPDATE Customers
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = rec.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- STEP 4: Scenario 2 - Set IsVIP = TRUE for balance > 10000
BEGIN
    FOR rec IN (SELECT CustomerID, Balance FROM Customers)
    LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = rec.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- STEP 5: Scenario 3 - Show loan reminders for loans due within 30 days

-- Enable DBMS_OUTPUT
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Loan Due Reminders ---');
    FOR rec IN (
        SELECT LoanID, CustomerID, DueDate
        FROM Loans
        WHERE DueDate BETWEEN SYSDATE AND SYSDATE + 30
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Customer ' || rec.CustomerID ||
            ' has loan ' || rec.LoanID ||
            ' due on ' || TO_CHAR(rec.DueDate, 'DD-MON-YYYY')
        );
    END LOOP;
END;
/
