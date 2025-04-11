import React, { useState } from "react";
import Tab from '@mui/material/Tab';
import Box from '@mui/material/Box';
import TabContext from '@mui/lab/TabContext';
import TabList from '@mui/lab/TabList';
import TabPanel from '@mui/lab/TabPanel';
import TweetCard from "../HomeSection/TweetCard";

export default function TabsComp() {

    const [tabValue,setTabValue] = useState("1");
    const handleTabChange = (event,newValue) => {
        setTabValue(newValue);
        if(newValue === 4){
            console.log("Likes");
        }else if(newValue === 1){
            console.log("User's Posts");
        }
    }

  return (
    <div className="ml-10 mr-10 py-5">
       <Box sx={{ width: '100%', typography: 'body1' }}>
      <TabContext value={tabValue}>
        <Box sx={{ borderBottom: 1, borderColor: 'divider' }}>
          <TabList onChange={handleTabChange} aria-label="lab API tabs example">
            <Tab label="Posts" value="1" />
            <Tab label="Replies" value="2" />
            <Tab label="Media" value="3" />
            <Tab label="Likes" value="4" />
          </TabList>
        </Box>
        <TabPanel value="1">
          {[1,1,1,1].map(item => <TweetCard/>) }
        </TabPanel>
        <TabPanel value="2">Replies</TabPanel>
        <TabPanel value="3">Media</TabPanel>
        <TabPanel value="4">Likes</TabPanel>
      </TabContext>
    </Box>
    </div>
  );
}
