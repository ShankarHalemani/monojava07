import { createSlice } from "@reduxjs/toolkit";

export const stringSlice = createSlice({
  initialState: "Shankar",
  name: "stringSlice",
  reducers: {
    modifyString(state, action) {
      return action.payload;
    },
  },
});
