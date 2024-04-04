SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS Likes;
DROP TABLE IF EXISTS Board;
DROP TABLE IF EXISTS Reply;
DROP TABLE IF EXISTS Rereply;
DROP TABLE IF EXISTS Schedule;
DROP TABLE IF EXISTS UserFemale;
DROP TABLE IF EXISTS UserMale;




/* Create Tables */

CREATE TABLE Board
(
	bid int NOT NULL AUTO_INCREMENT,
	title varchar(32),
	isDeleted int DEFAULT 0,
	viewCount int DEFAULT 0,
	likeCount int DEFAULT 0,
	replyCount int DEFAULT 0,
	img varchar(256),
	rid int DEFAULT 1 NOT NULL,
	mid varchar(32) NOT NULL,
	fid varchar(32) NOT NULL,
	PRIMARY KEY (bid),
	UNIQUE (mid)
);


CREATE TABLE Likes
(
	lid int NOT NULL AUTO_INCREMENT,
	value int DEFAULT 1,
	bid int DEFAULT 0 NOT NULL,
	PRIMARY KEY (lid)
);


CREATE TABLE Reply
(
	rid int NOT NULL AUTO_INCREMENT,
	comment varchar(256) NOT NULL,
	regTime date,
	isMine int,
	rrid int NOT NULL,
	PRIMARY KEY (rid)
);


CREATE TABLE Rereply
(
	rrid int NOT NULL,
	comment varchar(256) NOT NULL,
	regTime date,
	isMine int,
	PRIMARY KEY (rrid)
);


CREATE TABLE Schedule
(
	sid int NOT NULL AUTO_INCREMENT,
	sDate date NOT NULL,
	title varchar(32) NOT NULL,
	place varchar(64) NOT NULL,
	startTime date NOT NULL,
	endTime date NOT NULL,
	isImportant int DEFAULT 0 NOT NULL,
	memo varchar(256),
	PRIMARY KEY (sid)
);


CREATE TABLE UserFemale
(
	fid varchar(32) NOT NULL,
	pwd char(60) NOT NULL,
	fName varchar(32) NOT NULL,
	fEmail varchar(32),
	regDate date,
	isDeleted int,
	fProfile varchar(200),
	loveDate date NOT NULL,
	fStatusMessage varchar(64),
	fSNS varchar(32),
	fBirth date NOT NULL,
	verifyCode varchar(32) NOT NULL,
	PRIMARY KEY (fid)
);


CREATE TABLE UserMale
(
	mid varchar(32) NOT NULL,
	pwd char(60) NOT NULL,
	mName varchar(32) NOT NULL,
	mEmail varchar(32),
	regDate date,
	isDeleted int,
	mProfile varchar(200),
	loveDate date NOT NULL,
	mStatusMessage varchar(64),
	mSNS varchar(32),
	mBirth date NOT NULL,
	verifyCode varchar(32) NOT NULL,
	PRIMARY KEY (mid),
	UNIQUE (mid)
);



/* Create Foreign Keys */

ALTER TABLE Likes
	ADD FOREIGN KEY (bid)
	REFERENCES Board (bid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Board
	ADD FOREIGN KEY (rid)
	REFERENCES Reply (rid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Reply
	ADD FOREIGN KEY (rrid)
	REFERENCES Rereply (rrid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Board
	ADD FOREIGN KEY (fid)
	REFERENCES UserFemale (fid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Board
	ADD FOREIGN KEY (mid)
	REFERENCES UserMale (mid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



