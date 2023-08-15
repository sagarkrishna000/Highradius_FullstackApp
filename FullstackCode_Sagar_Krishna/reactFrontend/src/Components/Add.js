import React, { useState } from 'react';
import TextField from '@material-ui/core/TextField';
import { makeStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';
import DateFnsUtils from '@date-io/date-fns';
import { DatePicker, MuiPickersUtilsProvider } from "@material-ui/pickers";
//import EventIcon from '@material-ui/icons/Event';
import EventIcon from '@mui/icons-material/Event';

const useStyles = makeStyles(() => ({
  root: {
    backgroundColor: '#666666',
    padding: '20px',
  },
  input: {
    color: '#666',
    background:'#fff',
    '& .MuiInputBase-input': {
      caretColor: '#ffffff',
      '&[type="number"]::-webkit-inner-spin-button, &[type="number"]::-webkit-outer-spin-button': {
        '-webkit-appearance': 'none',
        margin: 0,
      },
    },
  },
}));

const AddDataForm = () => {
  const [customerOrderID, setCustomerOrderID] = useState('');
  const [salesOrg, setSalesOrg] = useState('');
  const [distributionChannel, setDistributionChannel] = useState('');
  const [customerNumber, setCustomerNumber] = useState('');
  const [companyCode, setCompanyCode] = useState('');
  const [orderCurrency, setOrderCurrency] = useState('');
  const [amountInUSD, setAmountInUSD] = useState('');
  const [orderCreationDate, setOrderCreationDate] = useState(null);

  const handleSubmit = async (e) => {
    e.preventDefault();
  
    const formData = new FormData();
    formData.append('customerOrderID', customerOrderID);
    formData.append('salesOrg', salesOrg);
    formData.append('distributionChannel', distributionChannel);
    formData.append('customerNumber',customerNumber);
    formData.append('companyCode',companyCode);
    formData.append('orderCurrency',orderCurrency);
    formData.append('amountInUSD',amountInUSD);
    formData.append('orderCreationDate',orderCreationDate);
  
    try {
      const response = await fetch('http://localhost:8080/h2h_milestone_3/AddInvoice', {
        method: 'POST',
        body: formData,
      });
  
      if (response.ok) {
        // Reset the form after successful submission
        resetForm();
      } else {
        // Handle error cases if needed
        console.log('Error:', response.statusText);
      }
    } catch (error) {
      // Handle network errors if needed
      console.log('Error:', error);
    }
  };
const resetForm = () => {
    setCustomerOrderID('');
    setSalesOrg('');
    setDistributionChannel('');
    setCustomerNumber('');
    setCompanyCode('');
    setOrderCurrency('');
    setAmountInUSD('');
    setOrderCreationDate(null);
  };

  const classes = useStyles();

  return (
    <form onSubmit={handleSubmit} className={classes.root}>
      <TextField
        placeholder="Customer Order ID"
        value={customerOrderID}
        onChange={(e) => setCustomerOrderID(e.target.value)}
        variant="outlined"
        margin="normal"
        style={{ width: '350px',marginRight: '20px'}}
        
        InputProps={{
          className: classes.input,
          inputProps: {
            type: 'number',
          },
        }}
      />
      <TextField
        placeholder="Sales Org"
        value={salesOrg}
        onChange={(e) => setSalesOrg(e.target.value)}
        variant="outlined"
        margin="normal"
        style={{ width: '350px',marginRight: '20px' }}
        InputProps={{
          className: classes.input,
          inputProps: {
            type: 'number',
          },
        }}
      />
      <TextField
        placeholder="Distribution Channel"
        value={distributionChannel}
        onChange={(e) => setDistributionChannel(e.target.value)}
        variant="outlined"
        margin="normal"
        style={{ width: '700px',marginRight: '20px' }}
        InputProps={{
          className: classes.input,
        }}
      />
      <TextField
        placeholder="Customer Number"
        value={customerNumber}
        onChange={(e) => setCustomerNumber(e.target.value)}
        variant="outlined"
        margin="normal"
        style={{ width: '350px',marginRight: '20px' }}
        InputProps={{
          className: classes.input,
          inputProps: {
            type: 'number',
          },
        }}
      />
      <TextField
        placeholder="Company Code"
        value={companyCode}
        onChange={(e) => setCompanyCode(e.target.value)}
        variant="outlined"
        margin="normal"
        style={{ width: '350px',marginRight: '20px' }}
        InputProps={{
          className: classes.input,
          inputProps: {
            type: 'number',
          },
        }}
      />
      <TextField
        placeholder="Order Currency"
        value={orderCurrency}
        onChange={(e) => setOrderCurrency(e.target.value)}
        variant="outlined"
        margin="normal"
        style={{marginRight: '20px' }}
        InputProps={{
          className: classes.input,
        }}
      />
      <TextField
        placeholder="Amount in USD"
        value={amountInUSD}
        onChange={(e) => setAmountInUSD(e.target.value)}
        variant="outlined"
        margin="normal"
        style={{marginRight: '20px' }}
        InputProps={{
          className: classes.input,
          inputProps: {
            type: 'number',
          },
        }}
      /><MuiPickersUtilsProvider utils={DateFnsUtils}>
      <DatePicker
        placeholder="Order Creation Date"
        value={orderCreationDate}
        onChange={setOrderCreationDate}
        format="dd/MM/yyyy"
        variant="outlined"
        margin="normal"
        style={{ padding: '10px',marginRight: '20px' }}
        className={classes.input}
        InputLabelProps={{
            shrink: true,
            className: classes.input,
          }}
          InputProps={{
            endAdornment: (
              <EventIcon
                color="primary"
                style={{ position: 'absolute', right: '10px', top: 'calc(50% - 12px)' }}
                />
                 ),
              }}renderInput={(props) => (
                <TextField {...props} placeholder="dd-MM-yyyy"/>
              )}
              TextFieldComponent={TextField}
           />   
      </MuiPickersUtilsProvider>
      <Button type="submit" variant="contained" style={{ padding:'10px',marginTop:'10px', marginRight:'10px',width:'725px', color:'#ffff', backgroundColor: '#fc7500' }} className={classes.button}>
        Submit
      </Button>
      <Button
        variant="contained"
        style={{ padding:'10px',marginTop:'10px',width:'725px', color:'#fff', backgroundColor: '#db4437' }}
        className={classes.button}
        onClick={resetForm}
      >
        Clear
      </Button>
    </form>
  );
    };

export default AddDataForm;