import { configureStore } from "@reduxjs/toolkit";
import { amountSlice } from "../state/slice/amountSlice";
import { stringSlice } from "../state/slice/stringSlice";

export const Store = configureStore({
  reducer: {
    amount: amountSlice.reducer,
    stringData: stringSlice.reducer,
  },
});
