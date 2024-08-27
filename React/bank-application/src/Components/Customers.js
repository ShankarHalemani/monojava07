import React, { useEffect, useRef, useState } from "react";
import Table from "./sharedComponents/Table/Table";
import axios from "axios";
import Pagination from "./sharedComponents/Table/Pagination/Pagination";

const Customers = () => {
  const [message, setMessage] = useState("");
  const [tableData, setTableData] = useState([]);
  const [pageSize, setPageSize] = useState(5);
  const [pageNumber, setPageNumber] = useState(0);
  const [totalPages, setTotalPages] = useState(5);
  const [searchActive, setSearchActive] = useState(false);
  const searchRef = useRef();

  const accessToken = localStorage.getItem("Authorization");

  useEffect(() => {
    if (searchActive) {
      searchCustomers();
    }
    getCustomers();
  }, [pageSize, pageNumber]);

  const getCustomers = async () => {
    try {
      const response = await axios.get("http://localhost:8080/api/customers", {
        headers: {
          Authorization: `Bearer ${accessToken}`,
        },
        params: {
          size: pageSize,
          page: pageNumber,
        },
      });

      setTableData(response.data.content);
      setTotalPages(response.data.totalPages);
    } catch (error) {
      setMessage(error.response?.data?.message || "Unknown error");
      alert(message);
    }
  };

  const searchCustomers = async (e) => {
    if (e) e.preventDefault();
    const searchParams = {
      customerId: searchRef.current.querySelector("#id").value,
      fName: searchRef.current.querySelector("#fname").value,
      lName: searchRef.current.querySelector("#lname").value,
      activeStatus: searchRef.current.querySelector("#status").value,
    };

    try {
      const response = await axios.get("http://localhost:8080/api/customers/search", {
        headers: {
          Authorization: `Bearer ${accessToken}`,
        },
        params: {
          customerId: searchParams.customerId,
          firstName: searchParams.fName,
          lastName: searchParams.lName,
          active: searchParams.activeStatus,
          size: pageSize,
          page: pageNumber,
        },
      });

      setTableData(response.data.content);
      setTotalPages(response.data.totalPages);
      setSearchActive(true);
    } catch (error) {
      setMessage(error.response?.data?.message || "Unknown error");
      alert(message);
    }
  };

  const pageObject = {
    pageSize,
    pageNumber,
    setPageNumber,
    setPageSize,
    totalPages,
  };

  return (
    <>
      <div>
        <form className="d-flex" role="search" ref={searchRef} onSubmit={searchCustomers}>
          <input id="id" className="form-control me-2" type="search" placeholder="Customer ID" aria-label="Search" />
          <input id="fname" className="form-control me-2" type="search" placeholder="First Name" aria-label="Search" />
          <input id="lname" className="form-control me-2" type="search" placeholder="Last Name" aria-label="Search" />
          <select id="status" className="form-select" aria-label="Default select example">
            <option value="">Customer Status</option>
            <option value={true}>Active</option>
            <option value={false}>Inactive</option>
          </select>
          <button className="btn btn-secondary ms-2" type="submit">
            Search
          </button>
          <button
            type="reset"
            className="btn btn-warning ms-2"
            onClick={() => {
              searchRef.current.reset();
              setPageNumber(0);
              setSearchActive(false);
              getCustomers();
            }}
          >
            Reset
          </button>
        </form>
      </div>

      <div className="d-flex align-items-center mt-5 mb-5">
        <button
          type="button"
          className="btn btn-primary me-5 col-3"
          onClick={() => {
            setPageNumber(0);
            getCustomers();
          }}
        >
          Get All Customers
        </button>
        <Pagination pager={pageObject} />
      </div>

      {tableData.length > 0 && <Table data={tableData} pagination={pageObject} />}
    </>
  );
};

export default Customers;
