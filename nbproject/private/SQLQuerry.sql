CREATE TABLE Account (
AccountID int NOT NULL IDENTITY,
AccountNumber nvarchar(18),
AccountName nvarchar(20),
OwnerName nvarchar(20),
BankName nvarchar(20),
Currency nchar(3),
CONSTRAINT PK_ACCOUNT PRIMARY KEY (AccountId)
);

CREATE TABLE TransactionType(
TypeID int NOT NULL IDENTITY PRIMARY KEY,
TypeName nvarchar(20),
TypeInfo nvarchar(30)
);

CREATE TABLE AccountTransaction(
TransactionID int NOT NULL IDENTITY,
Amount decimal(12,2),
TransactionDate datetime,
AccountID int NOT NULL,
IncomeOutcome bit,
TransactionInfo nvarchar(20),
TypeID int,
CONSTRAINT PK_AccountTransaction PRIMARY KEY(TransactionID),
CONSTRAINT FK_AccountTransaction_Account FOREIGN KEY (AccountID) REFERENCES Account(AccountID) ON UPDATE CASCADE,
CONSTRAINT FK_AccountTransaction_TransactionType FOREIGN KEY (TypeID) REFERENCES TransactionType(TypeID) ON UPDATE CASCADE,
);



drop table ACCOUNT;