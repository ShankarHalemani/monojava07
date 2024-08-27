import axios from "axios";
import React, { useRef } from "react";

function Component3() {
  const formRef = useRef();

  const handleSubmit = async (e) => {
    e.preventDefault();

    // Access the input elements and their values
    const usernameInput = formRef.current.querySelector("input[id='exampleInputEmail1']");
    const passwordInput = formRef.current.querySelector("input[id='exampleInputPassword1']");

    // Sending the extracted values to the backend with CSRF token
    const response = await axios.post("http://localhost:8080/api/auth/login", {
      username: usernameInput.value,
      password: passwordInput.value,
    });

    console.log(response.data.accessToken);
    localStorage.setItem("Auth", response.data.accessToken);
    console.log(localStorage.getItem("Auth"));
  };

  return (
    <form ref={formRef}>
      <div className="mb-3">
        <label htmlFor="exampleInputEmail1" className="form-label">
          Username
        </label>
        <input type="text" className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" />
        <div id="emailHelp" className="form-text">
          We'll never share your email with anyone else.
        </div>
      </div>
      <div className="mb-3">
        <label htmlFor="exampleInputPassword1" className="form-label">
          Password
        </label>
        <input type="password" className="form-control" id="exampleInputPassword1" />
      </div>
      <button type="submit" className="btn btn-primary" onClick={handleSubmit}>
        Submit
      </button>
    </form>
  );
}

export default Component3;
