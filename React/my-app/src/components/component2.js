import React, { useRef } from "react";

function Component2() {
  const formRef = useRef();

  function validateForm(inputs) {
    let isValid = true;

    const email = inputs.emailInput.value;
    if (!email) {
      alert("Email cannot be null");
      isValid = false;
    } else if (email.length < 6) {
      alert("Email cannot be less than 6 characters");
      isValid = false;
    } else if (!email.includes("@") || !email.includes(".")) {
      alert("Email must contain '@' and '.'");
      isValid = false;
    }

    if (!inputs.passwordInput.value) {
      alert("Password cannot be null");
      isValid = false;
    } else if (inputs.passwordInput.value.length < 6) {
      alert("Password must be at least 6 characters long");
      isValid = false;
    }

    if (!inputs.addressInput.value) {
      alert("Address cannot be null");
      isValid = false;
    }

    if (!inputs.cityInput.value) {
      alert("City cannot be null");
      isValid = false;
    }

    if (inputs.stateInput.value === "Choose...") {
      alert("Please select a state");
      isValid = false;
    }

    if (!inputs.zipInput.value) {
      alert("Zip code cannot be null");
      isValid = false;
    } else if (!/^\d{5}$/.test(inputs.zipInput.value)) {
      alert("Zip code must be a 5-digit number");
      isValid = false;
    }

    return isValid;
  }

  const handleSubmit = (e) => {
    e.preventDefault();

    const inputs = {
      emailInput: formRef.current.querySelector('input[id="inputEmail4"]'),
      passwordInput: formRef.current.querySelector('input[id="inputPassword4"]'),
      addressInput: formRef.current.querySelector('input[id="inputAddress"]'),
      adress2Input: formRef.current.querySelector('input[id="inputAddress2"]'),
      cityInput: formRef.current.querySelector('input[id="inputCity"]'),
      stateInput: formRef.current.querySelector('select[id="inputState"]'),
      zipInput: formRef.current.querySelector('input[id="inputZip"]'),
    };

    if (validateForm(inputs)) {
      console.log(inputs.emailInput.value);
      console.log(inputs.passwordInput.value);
      console.log(inputs.addressInput.value);
      console.log(inputs.adress2Input.value);
      console.log(inputs.cityInput.value);
      console.log(inputs.stateInput.value);
      console.log(inputs.zipInput.value);
    }
  };

  return (
    <form ref={formRef}>
      <br />
      <br />
      <br />
      <div className="form-row">
        <div className="form-group col-md-6">
          <label htmlFor="inputEmail4">Email</label>
          <input type="email" className="form-control" id="inputEmail4" placeholder="Email" />
        </div>
        <div className="form-group col-md-6">
          <label htmlFor="inputPassword4">Password</label>
          <input type="password" className="form-control" id="inputPassword4" placeholder="Password" />
        </div>
      </div>
      <div className="form-group">
        <label htmlFor="inputAddress">Address</label>
        <input type="text" className="form-control" id="inputAddress" placeholder="1234 Main St" />
      </div>
      <div className="form-group">
        <label htmlFor="inputAddress2">Address 2</label>
        <input type="text" className="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor" />
      </div>
      <div className="form-row">
        <div className="form-group col-md-6">
          <label htmlFor="inputCity">City</label>
          <input type="text" className="form-control" id="inputCity" />
        </div>
        <div className="form-group col-md-4">
          <label htmlFor="inputState">State</label>
          <select id="inputState" className="form-control">
            <option defaultValue>Choose...</option>
            <option>Karnataka</option>
            <option>Maharashtra</option>
          </select>
        </div>
        <div className="form-group col-md-2">
          <label htmlFor="inputZip">Zip</label>
          <input type="text" className="form-control" id="inputZip" />
        </div>
      </div>
      <div className="form-group">
        <div className="form-check">
          <input className="form-check-input" type="checkbox" id="gridCheck" />
          <label className="form-check-label" htmlFor="gridCheck">
            Check me out
          </label>
        </div>
      </div>
      <button type="submit" className="btn btn-primary" onClick={handleSubmit}>
        Sign in
      </button>
    </form>
  );
}

export default Component2;
