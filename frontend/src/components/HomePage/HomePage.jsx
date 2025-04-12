import { Grid} from '@mui/material';
import React from 'react';
import NavigationMenu from '../Navigation/NavigationMenu';
import HomeSection from '../HomeSection/HomeSection';
import RightPart from '../RightPart/RightPart';
import { Route, Routes } from 'react-router-dom';
import Profile from '../Profile/Profile';
import TwitDetails from '../TwitDetails/TwitDetails';

export default function HomePage() {
  return (
    <div className="flex w-full px-5 lg:px-10 ">
      
    {/* Left Navigation */}
    <div className="hidden lg:block w-[20%]">
      <NavigationMenu />
    </div>

    {/* Center Content */}
    <div className="w-full lg:w-[55%] overflow-y-auto ml-5">
      <Routes>
        <Route path="/" element={<HomeSection />} />
        <Route path="/home" element={<HomeSection />} />
        <Route path="/profile/:id" element={<Profile />} />
        <Route path="/twit/:id" element={<TwitDetails />} />
      </Routes>
    </div>

    {/* Right Part */}
    <div className="hidden lg:block w-[20%]">
      <div className="sticky top-0 h-screen overflow-y-auto">
        <RightPart />
      </div>
    </div>

  </div>
  

  );
}
