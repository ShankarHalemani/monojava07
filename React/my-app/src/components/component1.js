import axios from "axios";
import React, { useState } from "react";

const Component1 = (props) => {
  const [data, setData] = useState([]);

  const handleSubmit = async (e) => {
    e.preventDefault();
    const response = await axios.get(`https://jsonplaceholder.typicode.com/posts`, {});
    console.log(response.data);
    setData(response.data);
  };
  return (
    <>
      <button onClick={handleSubmit}>Submit</button>
    </>
  );
};

export default Component1;
