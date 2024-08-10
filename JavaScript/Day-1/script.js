// // alert("hello to js");

// // Variables

// let number = 10;
// console.log(number);
// console.log(typeof number);

// num = "One";
// console.log(num);
// console.log(typeof num);

// num = true;
// console.log(typeof num);

// let person = { name: "Jaya", eamil: "jaya@gmail.com", isActive: true };
// console.log(typeof person);

//number
//string
//boolean
//null
//object
//undefined

// let names = "Jayesh";
// console.log(names);
// console.log(names.toUpperCase());
// console.log(names.charAt(1));
// console.log(names.concat(" Naik"));

// let fullName = "Nitin Patel";

// let employeeName = fullName.split(" ");
// console.log(employeeName);
// console.log(employeeName[0]);

// String template
// let player = "Virat";
// let score = 120;
// let opponent = "Sri Lanka";
// let str1 = player + " scored " + score + " runs against " + opponent;
// console.log(str1);

// let str2 = `Against ${opponent}, ${player} scored ${score}`;
// console.log(str2);

// Arrays
// let students = ["Ajay", "Harshini", "Agraha", "Shankar"];
// students.push("Varish");
// console.log(students);

// students.pop();
// console.log(students);

// console.log(students.indexOf("Shankar"));

// let studentList = ["Pooja", "Nami", "Robin", "Zoro"];
// console.log(studentList);

// let updatedStudentList = students.concat(studentList);
// console.log(updatedStudentList);

// updatedStudentList.splice(2, 1); //starting from index 2 , 1 element will be deleted
// console.log(updatedStudentList);

// Null and Undefined

// let val = null;
// console.log(val + 10);
// console.log(val + "10");

// let vala = undefined;
// console.log(vala + 10); //NaN(Not a Number)
// console.log(vala + "10");

//Loose vs Strict

// let age = 10;
// let val = "10";

// console.log(typeof age);
// console.log(typeof val);

// // loose comparision
// console.log(age == val);

// //Strict comparision
// console.log(age === val);

// Function

// function greet() {
//   console.log("Welcome to Swabhav Techlabs");
// }

// greet();

// function add(num1, num2) {
//   console.log("Addition of " + num1 + " and " + num2 + " is : " + (num1 + num2));
// }

// add(10, 20);

// function add1(num1, num2) {
//   return num1 + num2;
// }

// console.log("Addition is : " + add1(10, 20));

// function greetings(name = "Guest", role = "Intern") {
//   console.log(`Welcome ${name} your role is ${role}`);
// }

// greetings("Disnesh", "Developer");

// greetings("Nitin");

// greetings((role = "Dev")); // Does not work like , name will set as Dev

// Function expression

// const welcomeGreetings = function () {
//   console.log("This is function expression");
// };

// welcomeGreetings();

//Arrow function
// const welcomeGreeting = () => {
//   console.log("This is function expression");
// };
// welcomeGreeting();

// const sum = (num1, num2) => {
//   return num1 + num2;
// };

// const sub = (num1, num2) => num1 - num2;

// console.log(sum(10, 20));
// console.log(sub(20, 10));

// const greetings = (name = "Guest", role = "Intern") => {
//   console.log(`Welcome ${name} your role is ${role}`);
// };

// greetings("Nora", "SWE");

// Callback Function

// const demoGreet = (callback) => {
//   console.log("Callback demo : ");
//   console.log(callback());
// };

// const testFunction = () => {
//   return "This is callback function";
// };

// demoGreet(testFunction);

// forEach

// let players = ["Ahuja", "Nami", "Robin", "Zoro", "Luffy"];

// players.forEach((player, index) => {
//   console.log(player + " " + index);
// });

//Object literals
let person = {
  id: 10,
  ename: "Shankar",
  email: "shankar@gmail.com",
  skills: ["Java", "Spring boot", "AWS"],
  login: function () {
    console.log(this.ename + " logged in");
  },

  logOut: function () {
    console.log(this.ename + " logged out");
  },

  getAllSkills: function () {
    this.skills.forEach((skill) => {
      console.log(skill);
    });
  },
};

console.log(person); // or can use person.email
person.logOut();
// console.log(person.skills);
person.getAllSkills();
