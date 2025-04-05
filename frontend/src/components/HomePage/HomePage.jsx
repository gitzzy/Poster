import { Grid} from '@mui/material';
import React from 'react';
import NavigationMenu from '../Navigation/NavigationMenu';
import HomeSection from '../HomeSection/HomeSection';

export default function HomePage() {
  return (
   <div className='flex items-start min-h-screen w-screen'>
  <Grid container spacing={2} className='px-5 lg:px-10'>
    <Grid item xs={0} lg={2.5} className='hidden lg:block relative'>
      <NavigationMenu />
    </Grid>
    <Grid item xs={12} lg={6} className='flex flex-col h-full overflow-auto'>
      <HomeSection />
    </Grid>
    <Grid item xs={0} lg={3} className='hidden lg:block relative'>
      <p className='text-center'>right</p>
    </Grid>
  </Grid>
</div>

  );
}
