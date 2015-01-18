# tut3c-dropwizard

Ultimate Tic-Tac-Toe Challenge Darmstadt - Dropwizard / Atmosphere

17.01.2015 - JUG-Darmstadt

Contributors:
* Falk Sippach
* Alexander Nickol
* Martin Steiger
* Jannik Jochem

## How to play:

1. start the application with arguments `server tut3c.yml`
2. Create a game: `curl -v --data '' http://localhost:9000/games`
3. the location header shows you the URL of the game you just created
4. create two players:
    * `curl -v --data 'Alex' http://localhost:9000/games/1/players`
    * `curl -v --data 'Falk' http://localhost:9000/games/1/players`
5. display the game state: `curl http://localhost:9000/games/1`
6. make a move: `curl --data '{"column":1,"row":2,"mark":"X"}' http://localhost:9000/games/1/moves`
7. repeat until game is finished

Chat protocol:

[10:16] == sippsack [d59d03d2@gateway/web/freenode/ip.213.157.3.210] has joined #tut3c
[10:16] <sippsack> hi
[10:16] <@msteiger> hi
[10:16] <j_jochem> https://github.com/mgutz/dropwizard-atmosphere
[10:17] <j_jochem> http://dropwizard.io/getting-started.html
[10:20] == alexn [~alex@213.157.3.210] has joined #tut3c
[10:20] <alexn> ;_)
[10:20] <j_jochem> https://github.com/mgutz/dropwizard-atmosphere [10:17] <j_jochem> http://dropwizard.io/getting-started.html
[10:24] <j_jochem> http://www.webupd8.org/2012/09/install-oracle-java-8-in-ubuntu-via-ppa.html
[11:17] <sippsack> http://stackoverflow.com/questions/20028451/change-dropwizard-default-ports
[11:31] == msteiger [d59d03d2@gateway/web/freenode/ip.213.157.3.210] has quit [Quit: Page closed]
[11:50] <alexn> http://stackoverflow.com/questions/23329580/bindexception-address-already-in-use-even-with-unique-port
[11:50] <alexn> #
[11:51] <alexn> http://stackoverflow.com/questions/23329580/bindexception-address-already-in-use-even-with-unique-port
[11:51] == msteiger [d59d03d2@gateway/web/freenode/ip.213.157.3.210] has joined #tut3c
[11:51] <alexn> http://stackoverflow.com/questions/23329580/bindexception-address-already-in-use-even-with-unique-port
[11:54] <alexn> http://stackoverflow.com/questions/20028451/change-dropwizard-default-ports
[14:02] <alexn> +-+-+-+
[14:02] <alexn> | | | |
[14:02] <alexn> +-+-+-+
[14:02] <alexn> | | | |
[14:02] <alexn> +-+-+-+
[14:02] <alexn> | | | |
[14:02] <alexn> +-+-+-+
[16:13] <j_jochem> https://www.flickr.com/photos/girliemac/sets/72157628409467125
[16:14] <j_jochem> ± % curl -H "Content-Type: application/json" -H "Accept: application/json" --data '{"column":1,"row":2,"mark":"X"}' http://localhost:9000/games/1/moves
[16:40] == msteiger [d59d03d2@gateway/web/freenode/ip.213.157.3.210] has quit [Quit: Page closed]
[17:12] <sippsack> https://cvwjensen.wordpress.com/2014/08/02/websockets-in-dropwizard/
[17:32] <alexn> https://github.com/Atmosphere/atmosphere/wiki/Getting-BroadcasterFactory-and-AtmosphereResourceFactory-with-2.2-and-newer
[17:40] <sippsack> http://stackoverflow.com/questions/19929175/how-to-design-push-notifications-using-atmosphere
[17:49] <sippsack> https://github.com/Atmosphere/atmosphere/wiki/Getting-Started-with-AtmosphereHandler,-WebSocket-and-Long-Polling