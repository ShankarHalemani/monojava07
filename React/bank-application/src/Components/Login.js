import axios from "axios";
import React, { useRef, useState } from "react";
import Customers from "./Customers";

function Login() {
  const formRef = useRef();
  const [isLoggedIn, setLoggedIn] = useState(false);
  const [message, setMessage] = useState("");

  //   Login
  const handleSubmit = async (e) => {
    e.preventDefault();
    const userInput = formRef.current.querySelector("input[id='username']");
    const passwordInput = formRef.current.querySelector("input[id='password']");

    try {
      const response = await axios.post("http://localhost:8080/api/auth/login", {
        username: userInput.value,
        password: passwordInput.value,
      });

      console.log(response.data.accessToken);
      localStorage.setItem("Authorization", response.data.accessToken);

      if (response.data.accessToken != null) {
        setLoggedIn(true);
      }
    } catch (error) {
      if (error.response && error.response.data && error.response.data.message) {
        setMessage(error.response.data.message);
        alert(message);
      } else {
        setMessage("Unknown error");
        alert(message);
      }
    }
  };

  // Return
  return (
    <div>
      <div className="d-flex justify-content-center">
        <form ref={formRef}>
          <div className="mb-3">
            <label htmlFor="exampleInputEmail1" className="form-label">
              Username
            </label>
            <input type="text" className="form-control" id="username" aria-describedby="emailHelp" />
          </div>
          <div className="mb-3">
            <label htmlFor="exampleInputPassword1" className="form-label">
              Password
            </label>
            <input type="password" className="form-control" id="password" />
          </div>
          <button type="submit" className="btn btn-primary" onClick={handleSubmit}>
            Submit
          </button>
        </form>
      </div>

      <br />

      {isLoggedIn && <Customers />}
    </div>
  );
}

export default Login;
