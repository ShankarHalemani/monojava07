import { createSlice } from "@reduxjs/toolkit";

export const amountSlice = createSlice({
  initialState: 400,
  name: "amountSlice",
  reducers: {
    addToAmount(state, action) {
      return parseInt(state) + parseInt(action.payload);
    },
    subToAmount(state, action) {
      return parseInt(state) - parseInt(action.payload);
    },
  },
});
