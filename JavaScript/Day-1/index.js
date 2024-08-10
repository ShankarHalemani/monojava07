// const div = document.querySelector("div");
// const para = document.querySelectorAll("p")[2];
// console.log(div);
// console.log(para);

// // FInd reference for third P tag
// const para3 = document.getElementById("para3");
// console.log(para3);

// //Find all para tags
// const paras = document.querySelectorAll("p");
// paras.forEach((para) => {
//   console.log(para);
// });

// //FInd reference for third P tag using queryselector
// const parathree = document.querySelector("#para3");
// console.log(parathree);
// parathree.innerHTML = "Para 3 updated";

// // Find all tags with test class
// const testPtag = document.querySelectorAll(".test");
// testPtag.forEach((para) => {
//   para.innerHTML += " : Updated";
//   console.log(para);
// });

// //get element reference by tag name
// const div1 = document.getElementsByTagName("div");
// console.log(div1);

// //Get element by clasname
// const paraElement = document.getElementsByClassName("test");
// console.log(paraElement);

// get div with test class
// const divTest = document.querySelectorAll("div.test");
// console.log(divTest);

// const para4 = document.querySelectorAll("p")[3];
// console.log(para4);

// const paraFour = document.querySelector("body > div:nth-child(2) > p:nth-child(4)");
// console.log(paraFour);

//get reference of anchor tag
// const link = document.querySelector("a");
// console.log(link.getAttribute("href"));
// setTimeout(() => {
//   link.setAttribute("href", "https://facebook.com");
//   link.innerHTML = "Link to facebook";
//   console.log(link);
// }, 4000);

//nodelements, dom, innerhtml, innertext, htmlcollection,

// setInterval(() => {
//   console.log("Hello");
// }, 2000);

// const heading = document.querySelector("h2");
// console.log(heading.getAttribute("class"));
// heading.classList.add("success");
// heading.classList.remove("two");
// heading.classList.toggle("one"); // if class present removes if not adds that class
// console.log(heading.getAttribute("class"));
// heading.classList.toggle("one");
// // heading.setAttribute("class", "success"); //dont use it overrides
// console.log(heading.getAttribute("class"));

//event handling
// heading.addEventListener("click", (e) => {
//   heading.classList.toggle("error");
// });

// const div = document.querySelector("div");
// const children = div.children;

// Array.from(children).forEach((child) => {
//   if (child.localName == "p") {
//     child.classList.add("para");
//   } else {
//     child.classList.add("header");
//   }
// });

// const para2 = document.querySelector("#para3");
// const parent = para2.parentElement;
// console.log(parent);

// const nextSibling = para2.nextElementSibling;
// console.log(nextSibling);

// const input = document.querySelector("input");

// const button = document.querySelector("button");
// button.addEventListener("click", (e) => {
//   console.log(input.value);
//   input.value = "";
// });

// function submiFucn() {
//   console.log(input.value);
//   input.value = "";
// }
