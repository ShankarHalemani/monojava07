import React from "react";
import { useNavigate, useParams } from "react-router-dom";

function Dashboard() {
  const navigation = useNavigate();
  const routeParams = useParams();
  const handleSubmit = () => {
    navigation("/user-dashboard");
  };

  return (
    <>
      <h1>dashboard - Route Params : {routeParams.id}</h1>
      <button type="button" onClick={handleSubmit}>
        Go!
      </button>
    </>
  );
}

export default Dashboard;
