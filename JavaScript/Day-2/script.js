// Array functions

const players = ["Ronaldo", "Mbape", "Messi", "Ozil", "Chetri", "Jay", "Ram"];

// Write a code to get list of names having 4 or less characters

// let newList = [];
// players.forEach((player) => {
//   if (player.length <= 4) newList.push(player);
// });

// console.log(newList);

const newList = players.filter((player) => {
  return player.length <= 4;
});
console.log(newList);

const numbers = [1, 123, 2, 3, 4, 5, 6, 7, 8, 9, 10];

const evenNubers = numbers.filter((number) => {
  if (number % 2 == 0) {
    return number;
  }
});

console.log(evenNubers);

const myOttList = [
  {
    name: "hotstar",
    price: 1500,
    subscription: true,
  },
  {
    name: "sonyLiv",
    price: 700,
    subscription: false,
  },
  {
    name: "zee5",
    price: 500,
    subscription: true,
  },
  {
    name: "jioCinema",
    price: 1000,
    subscription: false,
  },
  {
    name: "prime videos",
    price: 1300,
    subscription: true,
  },
];

const activeUsers = myOttList.filter((myOtt) => {
  if ((myOtt.subscription = "active")) return myOtt;
});

console.log(activeUsers);

const priceList = [200, 100, 300, 500, 1000, 700, 350];

const priceList20 = priceList.map((price) => {
  return price - price * 0.2;
});

console.log(priceList20);

//create sale ott list which should contain all products,
//  if price of ott is  >1000 give 30% discount

const mySellOttList = myOttList.map((myOtt) => {
  let price = myOtt.price > 1000 ? myOtt.price - myOtt.price * 0.3 : myOtt.price;
  return {
    name: myOtt.name,
    price: price,
    subscription: myOtt.subscription,
  };
});

console.log(mySellOttList);

//reduce

// let sum=0;

// myOttList.forEach(ott=>{
//     sum+=ott.price;
// })
// console.log(sum);

// let totalPrice = myOttList.reduce((sum, ott) => {
//   return sum + ott.price;
// }, 0);
// console.log(totalPrice);

// //Find ncount of active subscriptions
// let countSubs = myOttList.reduce((sum, ott) => {
//   return sum + (ott.subscription ? 1 : 0);
// }, 0);

// console.log(countSubs);

// const lessThan800 = myOttList.find((ott) => {
//   return ott.price < 800;
// });
// console.log(lessThan800);

//sort
numbers.sort();
console.log(numbers);

numbers.sort((num1, num2) => {
  return num1 - num2;
});

console.log(numbers);

//sort ott list based on name;

myOttList.sort((ott1, ott2) => {
  return ott1.name.localeCompare(ott2.name);
});

console.log(myOttList);

myOttList.sort((ott1, ott2) => {
  return ott1.price - ott2.price;
});
console.log(myOttList);
