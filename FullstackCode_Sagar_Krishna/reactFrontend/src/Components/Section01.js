import React from "react";
import abc from "../Assets/abclogo.svg";
import hrc from "../Assets/hrclogo.svg";
import { Box } from "@mui/material";


const Section01 = () => {
  return (

    <>
      <Box
        display="flex"
        justifyContent="space-between"
        sx={{ padding: "16px 12px" }}
        width={'100vw'}
      >
        <img src={abc} alt="abc logo" />
        <img src={hrc} alt="abc logo" />
        <img style={{ visibility: "hidden" }} src={abc} alt="abc logo" />
      </Box>

      <p className ="Invoice_List">Invoice List</p>

      </>
  );
};

export default Section01;
