import { Box, Button, Pagination, Tab, Tabs, Typography } from "@mui/material";
import {
  DataGrid,
  GridToolbarQuickFilter,
  gridPageCountSelector,
  gridPaginationModelSelector,
  useGridSelector,
} from "@mui/x-data-grid";
import React, { useState, useEffect } from "react";
import "./Section.css";
import Modal from "@mui/material/Modal";
import { useGridApiContext } from "@mui/x-data-grid";
import { Input } from "@mui/base";
import axios from "axios";
import AddDataForm from "./Add";
//import { Input } from '@material-ui/core';
function a11yProps(index) {
  return {
    id: `simple-tab-${index}`,
    "aria-controls": `simple-tabpanel-${index}`,
  };
}

const modleStyle = {
  position: "absolute",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  width: 400,
  bgcolor: "background.paper",
  border: "4px solid #fc7500",
  borderRadius: "8px",
  boxShadow: 24,
  p: 1,
};

const Section02 = () => {
  const [value, setValue] = useState(0); // not in use
  const [rowSelectionModel, setRowSelectionModel] = useState([]);

  const [editableid, setEditableid] = useState([]);
  const [firstName, setFirstName] = useState([]);
  const [lastname, setLastname] = useState([]);
  const [open, setOpen] = React.useState(false);
  const handleOpen = () => {

    const foundObject = rows.find((obj) => obj.id === rowSelectionModel[0]);
    setEditableid(foundObject.id);
    setFirstName(foundObject.firstName);
    setLastname(foundObject.lastName);
    setOpen(true);
  };

  const handleClose = () => setOpen(false);

  const columns = [
    {
      field: 'SlNo', headerName: 'Sl No', width: 150,
      headerClassName: 'white-text',
      cellClassName: 'white-text'
    },

    {
      field: 'COI',
      headerName: 'CUSTOMER ORDER ID',
      width: 300,
      editable: true,
      //headerClassName: classes.hideRightSeparator,
      hideable: false,
      headerClassName: 'white-text',
      cellClassName: 'white-text'
    },
    {
      field: 'SO',
      headerName: 'SALES ORG',
      width: 300,
      editable: true,
      headerClassName: 'white-text',
      cellClassName: 'white-text'
    },
    {
      field: 'DC',
      headerName: 'DISTRIBUTION CHANNEL',
      width: 300,
      editable: true,
      headerClassName: 'white-text',
      cellClassName: 'white-text'
    },
    {
      field: 'CC',
      headerName: 'COMPANY CODE',
      //description: 'This column has a value getter and is not sortable.',
      sortable: false,
      width: 300,
      headerClassName: 'white-text',
      cellClassName: 'white-text'
    },
    {
      field: 'OCD',
      headerName: 'ORDER CREATION DATE',
      //description: 'This column has a value getter and is not sortable.',
      sortable: false,
      width: 300,
      headerClassName: 'white-text',
      cellClassName: 'white-text'
    },
    {
      field: 'OA',
      headerName: 'ORDER AMOUNT',
      //description: 'This column has a value getter and is not sortable.',
      sortable: false,
      width: 300,
      headerClassName: 'white-text',
      cellClassName: 'white-text'
    },
    {
      field: 'OC',
      headerName: 'ORDER CURRENCY',
      //description: 'This column has a value getter and is not sortable.',
      sortable: false,
      width: 300,
      headerClassName: 'white-text',
      cellClassName: 'white-text'
    },
    {
      field: 'CN',
      headerName: 'CUSTOMER NUMBER',
      //description: 'This column has a value getter and is not sortable.',
      sortable: false,
      width: 300,
      headerClassName: 'white-text',
      cellClassName: 'white-text'
    },

  ];
  const [pageSize, setPageSize] = React.useState(5);
  const [data, setData] = useState([]);
  const getData = async () => {
    await axios.get('http://localhost:8080/h2h_milestone_3/DataLoadingServerlet').then((res) => {
      setData(res.data);
    })
  }
  useEffect(() => {
    getData()
  }, []);
  const rows = data.map((row) => (
    {
      SlNo: row.SlNo,
      //AmountInUsd
      CC: row.CompanyCode,
      CN: row.CustomerNo,
      COI: row.CustomerOrderId,
      DC: row.DistributionChannel,
      OA: row.OrderAmount,
      OCD: row.OrderCreationDate,
      OC: row.OrderCurrency,
      SO: row.SalesOrg
    }
  ));
  const handleChange = (event, newValue) => {
    setValue(newValue); // not in use
  };

  const handleDelete = () => {
    let updatedRows = rows.filter((rows) => !rowSelectionModel.includes(rows.SlNo));
    //setrows(updatedRows);
    setRowSelectionModel([]);
  };

  function Toolbar() {
    return (
      <Box
        className='container'
        sx={{ padding: "0 7px", color: "white", "& .MuiTab-root": { color: "white" } }}
        display="flex"
        justifyContent="space-between"
        alignItems="center"
      >
        <Box sx={{ borderBottom: 1, borderColor: "divider" }}>
          <Tabs
            value={value}
            onChange={handleChange}
            aria-label="basic tabs example"
          >
            <Tab
              label="HOME PAGE"
              {...a11yProps(0)}
              sx={{ color: "inherit", "&.Mui-selected": { color: "inherit" } }}
            />
            <Tab
              label="ADD DATA"
              {...a11yProps(1)}
              sx={{ color: "inherit", "&.Mui-selected": { color: "inherit" } }}
            />
            <Tab
              label="ANALYTICS VIEW"
              {...a11yProps(2)}
              sx={{ color: "inherit", "&.Mui-selected": { color: "inherit" } }}
            />
          </Tabs>
        </Box>
        <GridToolbarQuickFilter
          quickFilterParser={(searchInput) =>
            searchInput
              .split(",")
              .map((value) => value.trim())
              .filter((value) => value !== "")
          }
        />
      </Box>
    );
  }

  function CustomPagination() {
    const apiRef = useGridApiContext();
    const paginationModel = useGridSelector(
      apiRef,
      gridPaginationModelSelector
    );
    const pageCount = useGridSelector(apiRef, gridPageCountSelector);

    return (
      <Pagination
        count={pageCount}
        page={paginationModel.page + 1}
        onChange={(event, value) => apiRef.current.setPage(value - 1)}
      />
    );
  }

  const Footer = () => {
    return (
      <div
        style={{
          display: "flex",
          justifyContent: "space-between",
          alignItems: "center",
          backgroundColor: "#696868",
          marginTop: "8px",
        }}
      >
        <Box pb={2}>
          <Button
            sx={{ margin: "0px 0px 0px 15px", backgroundColor: "#fc7500" }}
            variant="contained"
          >
            REFRESH DATA
          </Button>
          <Button
            sx={{ margin: "0px 0px 0px 8px", backgroundColor: "#fc7500" }}
            variant="contained"
            disabled={rowSelectionModel.length !== 1}
            onClick={handleOpen}
          >
            EDIT
          </Button>
          <Button
            sx={{ margin: "0px 0px 0px 8px", backgroundColor: "#fc7500" }}
            variant="contained"
            onClick={() => handleDelete()}
            disabled={rowSelectionModel.length !== 1}
          >
            DELETE
          </Button>
          <Button
            sx={{ margin: "0px 0px 0px 8px", backgroundColor: "#fc7500" }}
            variant="contained"
            disabled={rowSelectionModel.length !== 1}
          >
            PREDICT
          </Button>
        </Box>
        {CustomPagination()}
      </div>
    );
  };

  const dynamicEditInput = () => {
    return (
      <>
        <Input value={editableid} onChange={(e) => setEditableid(e.value)}></Input>
        <Input value={firstName} onChange={(e) => setFirstName(e.value)}></Input>
        <Input value={lastname} onChange={(e) => setLastname(e.value)}></Input>
        <Input value={"COMPANY_CODE"}></Input>
        <Button variant="contained">SUBMIT</Button>
        <Button onClick={handleClose} variant="contained">
          CANCEL
        </Button>
      </>
    );
  };

  return (
    <Box height={"90vh"} width={"100vw"} sx={{ padding: "0 7px" }}>
      <div>
        <Modal
          open={open}
          onClose={handleClose}
          aria-labelledby="modal-modal-title"
          aria-describedby="modal-modal-description"
        >
          <Box sx={modleStyle}>
            <Typography variant="h5">EDIT</Typography>
            {rowSelectionModel.length > 0
              ? dynamicEditInput()
              : console.log("first")}
          </Box>
        </Modal>
      </div>
      <DataGrid
        className="container"
        rows={rows}
        columns={columns}
        getRowId={(row) => row.SlNo}
        initialState={{
          filter: {
            filterModel: {
              items: [],
              quickFilterValues: [""],
            },
          },
          pagination: {

            paginationModel: { pageSize: 15 },
          },
          //pagination
        }}
        pageSizeOptions={[5, 10, 25]}
        checkboxSelection
        onRowSelectionModelChange={(newRowSelectionModel) => {
          setRowSelectionModel(newRowSelectionModel);
        }}
        rowSelectionModel={rowSelectionModel}
        slots={{ toolbar: Toolbar, footer: Footer }}
        pagination
      />
    </Box>
  );
};

export default Section02;
