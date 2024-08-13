import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";
import reportWebVitals from "./reportWebVitals";
import Component1 from "./components/component1";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <>
    <h1>Monocept</h1>
    <App />
    <Component1 shankar={"Hello Bro"} monocept={1} />
  </>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
