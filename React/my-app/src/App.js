import React from "react";
import { Provider } from "react-redux";
import { Store } from "./Store/Store";
import Navbar from "./components/Navbar";
import Amount from "./components/Amount";
import String from "./components/String";

function App() {
  return (
    <Provider store={Store}>
      <Navbar />
      <Amount /><br />
      <String />
    </Provider>
  );
}

export default App;
