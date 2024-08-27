import React from "react";
import { useSelector } from "react-redux";

const String = () => {
  const stringData = useSelector((state) => state.stringData);
  return <>stringData: {stringData}</>;
};

export default String;
