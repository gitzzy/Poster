import React from "react";
import KeyboardBackspaceIcon from "@mui/icons-material/KeyboardBackspace";
import { useNavigate } from "react-router-dom";
import TweetCard from "../HomeSection/TweetCard";
import { Divider, ListItem } from "@mui/material";

export default function TwitDetails() {
  const navigate = useNavigate();
  const handleBack = () => navigate(-1);

  return (
    <React.Fragment>
      <section className=" bg-white sticky top-0 z-50 bg-white bg-opacity-95 flex items-center">
        <KeyboardBackspaceIcon
          className="cursor-pointer"
          onClick={handleBack}
        />
        <h1 className="py-5 text-xl font-bold opacity-90 ml-5">Posts</h1>
      </section>

      <section>
        <TweetCard />
        <Divider sx={{margin:"2rem 0rem",width:"35rem"}} />
      </section>

      <section>
        {[1, 1, 1].map((item) => (
          <TweetCard />
        ))}
      </section>
    </React.Fragment>
  );
}
