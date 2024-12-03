let rawData = `Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green`;

class Game {
  constructor(ID, draws) {
    this.ID = ID;
    this.draws = draws;
  }
}

function parseData(rawData) {
  const gamesArray = rawData.replace(/Game \d+: /g, "").split("\n");
  let Objects = [];

  for (let i = 0; i < gamesArray.length; i++) {
    gamesArray[i] = gamesArray[i].split(";");
  }

  for (let i = 0; i < gamesArray.length; i++) {
    Objects.push(new Game(parseInt(i + 1), gamesArray[i]));
  }

  console.log(Objects);
  return Objects;
}

function analyzeGames(gameArr) {
  const redCount = 12;
  const blueCount = 14;
  const greenCount = 13;

  gameArr.forEach((game) => {
    game.draws.forEach((element) => {
      const currentDrawCubes = element.split(",");
      currentDrawCubes;
    });
  });
}

let gameArr = parseData(rawData);
////////////////////////////////////
/*
function analyzeData(rawData) {
  // Define the constraints
  const maxCubes = { red: 12, green: 13, blue: 14 };

  // Split the raw data into games
  const games = rawData.split(/Game \d+: /).filter(Boolean);

  // Function to parse a draw string into an object
  function parseDraw(draw) {
    const colors = draw.match(/\d+ (red|green|blue)/g) || [];
    return colors.reduce((acc, color) => {
      const [count, type] = color.split(" ");
      acc[type] = (acc[type] || 0) + parseInt(count, 10);
      return acc;
    }, {});
  }

  // Analyze each game
  let sumOfPossibleGameIds = 0;
  games.forEach((game) => {
    const draws = game.split("; ").map(parseDraw);
    const gameId = parseInt(game.match(/\d+/)[0], 10);

    // Check if the game is possible
    let isPossible = true;
    for (const draw of draws) {
      for (const color in draw) {
        if (draw[color] > maxCubes[color]) {
          isPossible = false;
          break;
        }
      }
      if (!isPossible) break;
    }

    // Sum the IDs of possible games
    if (isPossible) {
      sumOfPossibleGameIds += gameId;
    }
  });

  return sumOfPossibleGameIds;
}

// Example usage
const rawData =
  "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green\nGame 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue\nGame 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red\nGame 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red\nGame 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green";
const result = analyzeData(rawData);
console.log(result); // Output will be the sum of IDs of the possible games
*/
