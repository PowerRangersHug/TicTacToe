# Design Report

## Requirement List

|  No  |Requirement  | Status  |   
|---|---|---|---|---|
|  1  |  Player chooses mode (1 player or 2 player)  |  Done | 
|  2  |  Players can register their names | Done   |  
|  3  |  Players can make a move |  Done  |  
|  4  |  Players can view the score  |  Done  |   
|  5  |  Players can view the game board | Done   |   
|  6  |  Players take turns making their moves | Done   |  
|  7  |  Players can see who wins/looses/draw  | Done   |   
|  8  |  Computer makes a move automatically | Done   |   
|  9  |  Players can play many games in a row | Done   |   

## Classes
### Model classes
#### Player
The player class stores information about the players. The players can either be Human or a Computer and have their own symbol.
#### Board
The board class stores information about the TicTacToe board and keeps track of it's state. It handles checking if the board is full, if someone has won and restores the board between games. 
#### Game
The game class handles the game instance. The game stores the players, the TicTacToe board and the score of the players. The Board class updates it's table and the scor board.

#### GameInfoViewModel
The GameInfoViewModel stores information about the game instance for the web application.

### Domain Layer

#### TicTacToeService
The Service class handles the communication between the presentation layer and the underlying model classes. It sends information from the user down to the model classes who update their information and fetches information to present to the users. 

#### GreetingController
The Controller class handles the communication between the web user interface and service layer. It mappes the user inteface events to the TicTacToeService.

#### Application
Starts up the web application.

### Presentation Layer

#### TicTacToePresentation
The presentation class handles asking for input from user and sending it down to the service. It also handles displaying the game. This class is onæy used in the console application.

## Web Design
Welcome Page 
![alt text][welcomepage]

[welcomepage]: https://github.com/PowerRangersHug/TicTacToe/blob/Documentation/docs/Images/Honnun1.png "Welcome Page"

Game Page 
![alt text][gamepage]

[gamepage]: https://github.com/PowerRangersHug/TicTacToe/blob/Documentation/docs/Images/honnun2.png "Game Page"


## Coding Rules

### General rules
- No lines should be longer than 80 characters

### Naming Conventions
- All names should be descriptive and in English.
- Class and function names should use Pascal casing.  
 * Example:
   * public void SomeFunction() 
- Variable names should use Camel casing.
 * Example:
   * int myInt
- Constants name should be all upper case.
 * Example:
   * final int SIZE

### Brackets and Spacing
- tab = 4 spaces.
- Curly brackets should open and close on separate lines.
- At least one empty line should be between method definitions and property definitions.
- One space should be on either side of an operator.

### Comments
- Comments should be descriptive, in English and as short as possible.
- All comments should start with a capital letter and end with a dot.
- Comments should be written above the code being commented.
- If comments are more than one line use multiline comments /* ... */

### Java
- Every function should be commented according to JavaDoc standards.

### Javascript
- Curly brackets open inline and close on a separate line.

### HTML and CSS
- Classes and IDs should have descriptive names and written in lower case letters with hyphens ("-") between words.
 * Example:
    * class="my-class"
    * id="my-id"





