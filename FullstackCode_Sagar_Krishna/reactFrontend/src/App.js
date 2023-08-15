import React from "react";
import { Box } from "@mui/material";
import "./Styles/App.css";
import Section01 from "./Components/Section01";
import Section02 from "./Components/Section02";
import Footer from "./Components/Footer";

const App = () => {
  return (
    <Box height="100vh">
      <Section01 />
      <Section02 />
      <Footer />
    </Box>
  );
};

export default App;
