const input = document.querySelector("input");
const button = document.querySelector("button");
const ul = document.querySelector("ul");

console.log(ul);

button.addEventListener("click", (e) => {
  if (input.value.trim() != "") {
    const li = document.createElement("li");
    li.innerText = input.value;

    ul.appendChild(li);
    input.value = "";
  } else {
    alert("Enter a valid task");
  }
});

// const lis = document.querySelectorAll("li");
// lis.forEach((li) => {
//   li.addEventListener("click", (e) => {
//     ul.removeChild(li);
//   });
// });

// Event bubbling
ul.addEventListener("click", (e) => {
  console.log(e.target);
  if (e.target.tagName == "LI") e.target.remove();
});
