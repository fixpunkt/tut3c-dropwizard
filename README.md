# tut3c-dropwizard
Ultimate Tic-Tac-Toe Challenge Darmstadt - Dropwizard (/ Atmosphere)

Contributors:

* Falk Sippach
* Alexander Nickol
* Martin Steiger
* Jannik Jochem

17.01.2015 - JUG-Darmstadt

## How to play:

1. start the application with arguments `server tut3c.yml`
2. Create a game: `curl -v --data '' http://localhost:9000/games`
3. the location header shows you the URL of the game you just created
4. create two players:
4.1 `curl -v --data 'Alex' http://localhost:9000/games/1/players`
4.2 `curl -v --data 'Falk' http://localhost:9000/games/1/players`
5. display the game state: `curl http://localhost:9000/games/1`
6. make a move: `curl --data '{"column":1,"row":2,"mark":"X"}' http://localhost:9000/games/1/moves`
7. repeat until game is finished
