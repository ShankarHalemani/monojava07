import React from "react";

const Table = ({ data, pagination }) => {
  return (
    <>
      {data.length !== 0 && (
        <table className="table mt-3">
          <thead>
            <tr>
              <th>ID</th>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Total Balance</th>
              <th>Status</th>
            </tr>
          </thead>

          <tbody>
            {data.map((customer) => (
              <tr key={customer.id}>
                <td>{customer.id}</td>
                <td>{customer.firstName}</td>
                <td>{customer.lastName}</td>
                <td>{customer.totalBalance}</td>
                <td>{customer.active ? "Active" : "Inactive"}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </>
  );
};

export default Table;
