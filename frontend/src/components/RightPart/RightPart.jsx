import React from 'react'
import SearchIcon from '@mui/icons-material/Search';
import LightModeIcon from '@mui/icons-material/LightMode';
import { Button } from '@mui/material';
import MoreHorizIcon from '@mui/icons-material/MoreHoriz';

export default function RightPart() {

  const handleChangeTheme = () => {
    console.log('Changed to dark');
  }

  const handleTrends = () => {
    console.log('Trendings');
  }

  return (
    <div className='py-5 sticky top-0'>
      <div className='relative flex items-center'>
        <input type='text' className='py-3 rounded-full text-gray-500 w-full pl-12'></input>
        <div className='absolute top-0 left-0 pl-3 pt-3'>
          <SearchIcon/>
        </div>
          <LightModeIcon onClick={handleChangeTheme}
          className='ml-3 cursor-pointer'/>
      </div>
      <section className='my-5 '>
        <h1 className='text-xl font-bold'>Get Verified</h1>
        <h1 className='font-bold my-2'>Subscribe to get more feature</h1>
        <Button variant='contained' sx={{padding:"10px",paddingX:"20px",borderRadius:"25px"}}>
            Get Verified
        </Button>
      </section>
      <section className='mt-7 space-y-5'>
          <h1 className='font-bold text-xl py-1'>What's happening</h1>
          <div >
            <p className='text-sm'>Something is happening • LIVE</p>
            <p className='font-bold'>DC vs CSK</p>
            <p className='text-sm'>Dhoni's CSK lost another battle</p>
          </div>
          {[1,1,1,1].map((items) => 
            <div className='flex justify-between w-full'>
            <div>
              <p>Sports • Trending</p>
              <p className='font-bold'>#IPL</p>
              <p>189k.9 Posts</p>
            </div>
            <MoreHorizIcon onClick={handleTrends}/>
          </div>
          )}
          
      </section>
      
    </div>
  )
}
