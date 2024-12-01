const fs = require("fs");

function calibrationValues(lines) {
  let sum = 0;

  lines.forEach((line) => {
    let first = null;
    let last = null;

    for (let i = 0; i < line.length; i++) {
      if (isDigit(line[i])) {
        last = line[i];
        if (first === null) {
          first = line[i];
        }
      }
    }

    if (first !== null && last !== null) {
      sum += parseInt(first + last, 10);
    }
  });

  return sum;
}

function isDigit(char) {
  return char >= "0" && char <= "9";
}

///////////////////////////////////////////////////////

const inputText = fs.readFileSync("input.txt", "utf8");
const lines = inputText.split("\n");

console.log(calibrationValues(lines));
