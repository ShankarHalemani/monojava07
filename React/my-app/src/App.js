import { useState } from "react";

function App() {
  const [form, setForm] = useState({
    email: "",
    password: "",
    address: "",
    address2: "",
    city: "",
    state: "",
    zip: "",
    checkBox: true,
  });

  return (
    <form>
      <div className="row">
        <div className="col-md-6 mb-3">
          <label htmlFor="inputEmail4" className="form-label">
            Email
          </label>
          <input
            type="email"
            className="form-control"
            id="inputEmail4"
            placeholder="Email"
            onChange={(e) => {
              setForm((prev) => {
                return { ...prev, email: e.target.value };
              });
            }}
            value={form.email}
          />
        </div>
        <div className="col-md-6 mb-3">
          <label htmlFor="inputPassword4" className="form-label">
            Password
          </label>
          <input
            type="password"
            className="form-control"
            id="inputPassword4"
            placeholder="Password"
            onChange={(e) => {
              setForm((prev) => {
                return { ...prev, password: e.target.value };
              });
            }}
            value={form.password}
          />
        </div>
      </div>
      <div className="mb-3">
        <label htmlFor="inputAddress" className="form-label">
          Address
        </label>
        <input
          type="text"
          className="form-control"
          id="inputAddress"
          placeholder="1234 Main St"
          onChange={(e) => {
            setForm((prev) => {
              return { ...prev, address: e.target.value };
            });
          }}
          value={form.address}
        />
      </div>
      <div className="mb-3">
        <label htmlFor="inputAddress2" className="form-label">
          Address 2
        </label>
        <input
          type="text"
          className="form-control"
          id="inputAddress2"
          placeholder="Apartment, studio, or floor"
          onChange={(e) => {
            setForm((prev) => {
              return { ...prev, address2: e.target.value };
            });
          }}
          value={form.address2}
        />
      </div>
      <div className="row">
        <div className="col-md-6 mb-3">
          <label htmlFor="inputCity" className="form-label">
            City
          </label>
          <input
            type="text"
            className="form-control"
            id="inputCity"
            onChange={(e) => {
              setForm((prev) => {
                return { ...prev, city: e.target.value };
              });
            }}
            value={form.city}
          />
        </div>
        <div className="col-md-4 mb-3">
          <label htmlFor="inputState" className="form-label">
            State
          </label>
          <input
            type="text"
            className="form-control"
            id="inputState"
            onChange={(e) => {
              setForm((prev) => {
                return { ...prev, state: e.target.value };
              });
            }}
            value={form.state}
          />
        </div>
        <div className="col-md-2 mb-3">
          <label htmlFor="inputZip" className="form-label">
            Zip
          </label>
          <input
            type="text"
            className="form-control"
            id="inputZip"
            onChange={(e) => {
              setForm((prev) => {
                return { ...prev, zip: e.target.value };
              });
            }}
            value={form.zip}
          />
        </div>
      </div>
      <div className="form-group">
        <div className="form-check">
          <input
            className="form-check-input"
            type="checkbox"
            id="gridCheck"
            checked={form.checkBox}
            onChange={(e) => {
              setForm((prev) => {
                return { ...prev, checkBox: !prev };
              });
            }}
          />
          <label className="form-check-label" htmlFor="gridCheck">
            Check me out
          </label>
        </div>
      </div>
      <button type="submit" className="btn btn-primary">
        Sign in
      </button>
      <br />
      Email : {form.email}
      <br />
      Password : {form.password}
      <br />
      Adress : {form.address}
      <br />
      Address 2 : {form.address2}
      <br />
      City : {form.city}
      <br />
      State : {form.state}
      <br />
      Zip : {form.zip}
    </form>
  );
}

export default App;
