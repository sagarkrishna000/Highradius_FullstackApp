import React from 'react'
import Link from '@material-ui/core/Link';


function Footer() {
  return (
    <div className='footer'>
     <Link
      component="button"
      variant="body2"
      onClick={() => {
        console.info("I'm a button.");
      }}
    >
      Privacy Policy |  © 2023 HighRadius Corporation. All rights reserved

    </Link>
   
    </div>
  )
}

export default Footer