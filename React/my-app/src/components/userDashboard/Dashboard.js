import React from "react";
import { useNavigate, useSearchParams } from "react-router-dom";

function Dashboard() {

  const [uRLSearchParams, setURLSearchParams]=useSearchParams();

  const navigation = useNavigate();

  const handleSubmit = () => {
    // const id =10;
    // navigation(`/dashboard/${id}`);
    setURLSearchParams({
      firstName : "Shankar" ,
      lastName : "Halemani" 
    })

    console.log(uRLSearchParams.get("lastName"));
    console.log(uRLSearchParams.getAll("firstName"));
    
  };


  return (
    <>
      <button type="button" onClick={handleSubmit}>
        Back to Dashboard
      </button>
      <h1>User Dashboard </h1>
    </>
  );
}

export default Dashboard;
