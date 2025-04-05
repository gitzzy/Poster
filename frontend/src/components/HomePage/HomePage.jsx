import { Grid} from '@mui/material';
import React from 'react';
import NavigationMenu from '../Navigation/NavigationMenu';
import HomeSection from '../HomeSection/HomeSection';
import RightPart from '../RightPart/RightPart';

export default function HomePage() {
  return (
    <Grid container spacing={2} className='px-5 lg:px-10'>
    <Grid item xs={0} lg={3} className='hidden lg:block relative'>
      <NavigationMenu />
    </Grid>
    <Grid item xs={12} lg={6} className='flex flex-col h-full overflow-auto ml-5'>
      <HomeSection />
    </Grid>
    <Grid item xs={0} lg={3} className='hidden lg:block relative ml-15'>
      <RightPart />
    </Grid>
  </Grid>
  

  );
}
