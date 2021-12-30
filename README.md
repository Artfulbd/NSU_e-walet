# NSU_e-walet
Now a days, most of the organization, university, company etc. use RFID based card as their ID 
card. In most of the case those RFID card follows LF (low frequency) architecture. Our university 
also use RFID based ID card. We use that card at our university entrance, also on giving 
attendance. Most of the organization also does the same thing.
Our project purpose is to extend the use of those ID cards. Almost on every organization including 
us, have their own canteen, bookshop or print service etc. which requires payment. There we need
to maintain queue, pay on cash, simply all of those procedures are much lengthy and time 
consuming. As a result, queue become larger and larger. Our project is for reduce that time 
consuming part. Inside our workspace we will pay using our RFID card.

1. Services
This is a complete payment system. Almost all of us has one or more Bank ATM card. For our 
workspace, our ID cards will act as our ATM card.

2. Project scopes
Any organization, company, institute or any kind of workspace, which uses RFID card as their ID 
card and has a unique ID number, can use this system.

3. Stakeholders
For our case (university) students, faculties, staffs also our respected BOT members can use this 
system. Now a days our parents are allowed to visit our beloved campus. They don’t have ID card, 
but they are also capable of using this system. In this case they will use their children’s ID card.

4. Product Features
This is a virtual payment system. Pay cash to bank once and keep using the card till amount is 
zero, this is all about the job of user. Means no need to carry cash for making payment inside 
workspace.
During cash payment, calculate money, open wallet, pay, then take changes, count them put it 
back to wallet. It is much time consuming.
On our system, user will punch the card, give pin, rest of the job will be done by the system. It will 
discard the amount from user’s card and gives a complete receipt with transaction id.
As per we are integrating it with our University system, card will be maintained (payment history, 
card lock, change card pin) by our RDS account
To show our system action, we will build a virtual vendor machine for our restaurant and
integrate it with the payment system.

4. User Classes, roles and Characteristics
All of the person of that workspace, has his/her own RFID card, can use the system through the 
services like restaurant, bookshop, print shop etc. build by the workspace.
In our project we are making a virtual vendor machine. Here user punch card for identification, 
choose food items, gives pin then system validates the credentials and printout the receipt.
User’s job is to punch card, choose food item, give pin and collect receipt.
User can monitor card activity using university RDS system. If card is stolen or lost anyhow, user 
can deactivate his/her card immediately from RDS. As a result, no payment can be done using 
that card. System will block the card privileges. 

5. Operating Environment
As per we are using the payment system indirectly via a vendor machine. Our payment system is 
a API, which runs 24/7 on a server, and vendor machine will run on an Embedded system with a 
display, RFID scanner and a receipt printer.
On the other hand, our RDS is a web app.

6. System Features
For end user’s interaction we have a vendor machine and a RDS system. Also have respective 
APIs which are not directly usable for any kind of users.

6.1 Vendor machine
 a) Selecting food item: (Priority High)
 User punch ID card, then a food menu appears. User selects foods from that menu and add quantity. A receipt will be generated automatically.
 b) Giving pin: (Priority High)
 After selecting items, vendor machine invokes user to choose payment option, If user choose e-wallet payment, then machine will as for a pin. User enters his/herpin.
 c) Printing receipt: (Priority High)
 If user choose cash payment then machine simply prints the receipt. Or if choose ewallet payment, then after taking pin and checking credentials It prints the receipt 
 with paid symbol, for a valid case, Else shows the respective reply on the display.

6.2 RDS
This just a web app. For this project it will used only for maintaining user’s own payment system.
 a) Giving new pin: (Priority medium)
 At the very beginning a user won’t have any registered payment account. At that point 
 user will log in to RDS and request for a new account and gives a 4-digit pin. 
 b) Change pin: (Priority High)
 User can change his/her PIN for payment system for RDS account while needed.
 c) Show payment history: (Priority High)
 User can check payment history together with receipt from RDS.
 d) Block Card: (Priority High)
 If anyhow user lost his/her card or stolen by someone, user immediately can block his/her card from RDS, so card cannot be usable anymore. If found or needed user 
 can unlock their card whenever they want. 

7. Performance Requirements
As per we wanted to reduce time consumption of payment, the whole payment system together 
with the vendor machine need to be very fast. We will a good server having enough bandwidth.

8. Security Requirements
This is a pure payment system, if must requires some safety protection. Our API must be much
secure. We have an encryption and decryption algorithm, developed by us. Here it can encrypt a 
character differently at different time, spouse if we encrypt a word “hi” and if it generates “31 316 
84” then again if we encrypt “hi” it may generate “96 3354 1189 13”. Means it never generates 
same code for same message. We will use this kind of algorithm for API’s communication.
There are many other safety measurements. For security we cannot share it here.
For our web app we will use MVC to hiding business logic and other mechanism we use.

